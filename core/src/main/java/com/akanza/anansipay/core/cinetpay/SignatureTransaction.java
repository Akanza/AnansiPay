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
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Represents {@link Transaction} information for obtaining a signature.</p>
 *
 * @author Christian Amani 2021-02-14
 */
class SignatureTransaction implements Transaction {

  public static final String DEFAULT_VERSION = "1";
  public static final String DEFAULT_LANGUAGE = "fr";
  public static final String DEFAULT_ACTION = "PAYMENT";

  public static final String FIELD_AMOUNT = "cpm_amount";
  public static final String FIELD_CURRENCY = "cpm_currency";
  public static final String FIELD_SITE_ID = "cpm_site_id";
  public static final String FIELD_TRANSACTION_ID = "cpm_trans_id";
  public static final String FIELD_TRANSACTION_DATE = "cpm_trans_date";
  public static final String FIELD_PAYMENT_CONFIG = "cpm_payment_config";
  public static final String FIELD_PAGE_ACTION = "cpm_page_action";
  public static final String FIELD_LANGUAGE = "cpm_language";
  public static final String FIELD_DESIGNATION = "cpm_designation";
  public static final String FIELD_ACTION = "cpm_page_action";
  public static final String FIELD_VERSION = "cpm_version";
  public static final String FIELD_PHONE_PREFIX = "cpm_phone_prefixe";
  public static final String FIELD_CUSTOM = "cpm_custom";
  public static final String FIELD_API_KEY = "apikey";

  private final String siteId;
  private final String apiKey;
  private final SignatureTransactionBuilder signatureTransactionBuilder;

  public SignatureTransaction(String siteId, String apiKey,
      SignatureTransactionBuilder signatureTransactionBuilder) {
    this.siteId = siteId;
    this.apiKey = apiKey;
    this.signatureTransactionBuilder = signatureTransactionBuilder;
  }

  public String getSiteId() {
    return siteId;
  }

  public String getApiKey() {
    return apiKey;
  }

  @Override
  public Money amount() {
    return this.signatureTransactionBuilder.getAmount();
  }

  @Override
  public String reference() {
    return this.signatureTransactionBuilder.getTransactionId();
  }

  @Override
  public String accountReference() {
    return null;
  }

  @Override
  public LocalDateTime date() {
    return this.signatureTransactionBuilder.getDate();
  }

  @Override
  public String designation() {
    return this.signatureTransactionBuilder.getDesignation();
  }

  @Override
  public String clientReference() {
    return null;
  }

  @Override
  public Operator operator() {
    throw new UnsupportedOperationException("operator is not supported");
  }

  @Override
  public PaymentCategory category() {
    return this.signatureTransactionBuilder.getPaymentType();
  }

  @Override
  public String successfulPaymentUrl() {
    return this.signatureTransactionBuilder.getNotifyUrl();
  }

  @Override
  public String failedPaymentUrl() {
    throw new UnsupportedOperationException("failedPaymentUrl is not supported");
  }

  @Override
  public String language() {
    return this.signatureTransactionBuilder.getLanguage();
  }

  @Override
  public Map<String, String> metadata() {
    return this.signatureTransactionBuilder.getCustomField();
  }


  /**
   * <p>Builds a dictionary with values that are the data of the {{@link SignatureTransaction}.</p>
   *
   * @return The data dictionary
   */
  public Map<String, Object> formData() {
    Map<String, Object> formData = new HashMap<>();
    var amount = this.amount();
    double amountValue = 0.0;
    if (amount != null) {
      var amountNumber = amount.getNumber();
      amountValue = amountNumber.doubleValueExact();
    }
    formData.put(FIELD_AMOUNT, amountValue);
    Map<String, String> metadata = this.metadata();
    var currency = metadata.get(FIELD_CURRENCY);
    formData.put(FIELD_CURRENCY, currency);
    formData.put(FIELD_SITE_ID, this.siteId);
    formData.put(FIELD_TRANSACTION_ID, this.reference());
    formData.put(FIELD_TRANSACTION_DATE, this.date());
    var paymentConfig = this.category();
    formData.put(FIELD_PAYMENT_CONFIG, paymentConfig.toString());
    var action = metadata.get(SignatureTransaction.FIELD_ACTION);
    formData.put(FIELD_PAGE_ACTION, action);
    formData.put(FIELD_VERSION, metadata.get(FIELD_VERSION));
    formData.put(FIELD_LANGUAGE, this.language());
    formData.put(FIELD_DESIGNATION, this.designation());
    formData.put(FIELD_API_KEY, this.apiKey);
    formData.put(FIELD_CUSTOM, metadata);
    return formData;
  }
}
