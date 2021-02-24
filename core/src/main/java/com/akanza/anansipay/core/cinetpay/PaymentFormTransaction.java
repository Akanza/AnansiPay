/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.cinetpay;

import com.akanza.anansipay.core.Money;
import com.akanza.anansipay.core.Operator;
import com.akanza.anansipay.core.PaymentCategory;
import com.akanza.anansipay.core.Transaction;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>Represents a {@link Transaction} for a payment form.</p>
 *
 * @author Christian Amani 2021-02-14
 */
public class PaymentFormTransaction implements Transaction {

  public static final String FIELD_CANCEL_URL = "cancel_url";
  public static final String FIELD_RETURN_URL = "return_url";
  public static final String FIELD_SIGNATURE = "signature";

  private final Transaction transaction;

  public PaymentFormTransaction(String signature, Transaction transaction) {
    this.transaction = transaction;
    this.transaction.metadata()
        .put(FIELD_SIGNATURE, signature);
  }

  @Override
  public Money amount() {
    return this.transaction.amount();
  }

  @Override
  public String reference() {
    return this.transaction.reference();
  }

  @Override
  public String accountReference() {
    return this.transaction.accountReference();
  }

  @Override
  public LocalDateTime date() {
    return this.transaction.date();
  }

  @Override
  public String designation() {
    return this.transaction.designation();
  }

  @Override
  public String clientReference() {
    return this.transaction.clientReference();
  }

  @Override
  public Operator operator() {
    throw new UnsupportedOperationException("operator is not supported");
  }

  @Override
  public PaymentCategory category() {
    return this.transaction.category();
  }

  @Override
  public String successfulPaymentUrl() {
    return this.transaction.successfulPaymentUrl();
  }

  @Override
  public String failedPaymentUrl() {
    throw new UnsupportedOperationException("failedPaymentUrl is not supported");
  }

  @Override
  public String language() {
    return this.transaction.language();
  }

  @Override
  public Map<String, String> metadata() {
    return this.transaction.metadata();
  }
}
