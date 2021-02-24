/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.cinetpay;

import com.akanza.anansipay.core.MerchantAccount;

/**
 * <p>Merchant account for a customer of the CinetPay platform.</p>
 *
 * @author Christian Amani 2021-02-14
 */
public class MerchantCinetPay implements MerchantAccount {

  private final String siteId;
  private final String apiKey;

  public MerchantCinetPay(String siteId, String apiKey) {
    this.siteId = siteId;
    this.apiKey = apiKey;
  }

  @Override
  public String key() {
    return this.apiKey;
  }

  @Override
  public void authentification(String username, String password) {
    throw new UnsupportedOperationException("authentification is not supported");
  }

  @Override
  public String name() {
    return "";
  }

  @Override
  public String information() {
    return "";
  }

  /**
   * <p>Building a {@link PaymentFormTransaction}.</p>
   *
   * @return A transaction payment form
   */
  public PaymentFormTransaction paymentForm(
      final SignatureTransactionBuilder signatureTransactionBuilder) {
    var signatureTransaction = new SignatureTransaction(this.siteId, this.apiKey,
        signatureTransactionBuilder);
    var httpPostSignature = new HttpPostSignature();
    var signature = httpPostSignature.post(signatureTransaction);
    return new PaymentFormTransaction(signature,
        signatureTransaction);
  }
}
