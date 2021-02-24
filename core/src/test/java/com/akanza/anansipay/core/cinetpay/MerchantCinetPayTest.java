/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.cinetpay;

import com.akanza.anansipay.core.MerchantAccount;
import com.akanza.anansipay.core.PaymentCategory;
import com.akanza.anansipay.core.VirtualMonney;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Christian Amani 2021-02-24
 */
class MerchantCinetPayTest {

  final String fakeApiKey = "3c6cd976-6edf-488f";
  final String fakeSiteId = "Merchant Lambda";
  MerchantAccount merchantAccount;

  @BeforeEach
  void setUp() {
    this.merchantAccount = new MerchantCinetPay(this.fakeApiKey);
  }

  @Test
  void key() {
    var key = this.merchantAccount.key();
    Assertions.assertEquals(fakeApiKey, key);
  }

  @Test
  @DisplayName("Tests the capture of the HttpPostSignatureException in case of failure of a request to obtain a signature.")
  void paymentFormFailure() {
    // Given
    var merchantCinetPay = new MerchantCinetPay(this.fakeApiKey);
    double amountValue = 200;
    var xof = Monetary.getCurrency("USD");
    MonetaryAmount monetaryAmount = Monetary.getDefaultAmountFactory()
        .setCurrency(xof).setNumber(amountValue).create();

    var transactionDate = LocalDateTime.of(2020, 5, 1, 10, 0);
    var designation = "Bersek Tome 3";
    var monney = new VirtualMonney(Money.of(BigDecimal.valueOf(amountValue), "XOF"));
    var reference = UUID.randomUUID().toString();

    var signatureTransaction = new SignatureTransactionBuilder(this.fakeSiteId, this.fakeApiKey)
        .withAmount(monney)
        .withCurrency("XOF")
        .withTransactionId(reference)
        .withDate(transactionDate)
        .withPaymentType(defaultPaymentType())
        .withAction(SignatureTransaction.DEFAULT_ACTION)
        .withVersion(SignatureTransaction.DEFAULT_VERSION)
        .withLanguage(SignatureTransaction.DEFAULT_LANGUAGE)
        .withDesignation(designation)
        .build();

    // When
    var httpPostSignatureException = Assertions
        .assertThrows(HttpPostSignatureException.class, () -> merchantCinetPay
            .paymentForm(signatureTransaction));

    // Then
    var message = httpPostSignatureException.getMessage();
    Assertions.assertEquals("An error occurred while retrieving the signature ! \n"
        + " The error response is : {\n"
        + "\t\"status\":{\n"
        + "\t\t\"code\":\"609\",\n"
        + "\t\t\"message\":\"AUTH_NOT_FOUND\"\n"
        + "\t}\n"
        + "}", message);
  }

  private PaymentCategory defaultPaymentType() {
    return new PaymentCategory() {
      @Override
      public String toString() {
        return "SINGLE";
      }
    };
  }
}
