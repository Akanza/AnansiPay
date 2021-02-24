/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.cinetpay;

import com.akanza.anansipay.core.Money;
import com.akanza.anansipay.core.PaymentCategory;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Builder of {@link SignatureTransaction}.</p>
 *
 * @author Christian Amani 2021-02-14
 */
public class SignatureTransactionBuilder {

  private final Map<String, String> customField;

  private final String siteId;
  private final String apiKey;
  private Money amount;
  private String currency;
  private String transactionId;
  private LocalDateTime date;
  private PaymentCategory paymentType;
  private String action;
  private String version;
  private String language;
  private String designation;
  private String clientReference;
  private String clientReferencePrefix;
  private String notifyUrl;
  private String returnUrl;
  private String cancelUrl;


  /**
   * <p>
   * Instantiate by adding default values to the fields below.
   * <li>{@link #version}</li>
   * <li>{@link #language}</li>
   * <li>{@link #action}</li>
   * </p>
   */
  public SignatureTransactionBuilder(String siteId, String apiKey) {
    this.siteId = siteId;
    this.apiKey = apiKey;
    this.customField = new HashMap<>();
    this.version = SignatureTransaction.DEFAULT_VERSION;
    this.language = SignatureTransaction.DEFAULT_LANGUAGE;
    this.action = SignatureTransaction.DEFAULT_ACTION;
  }

  /**
   * <p>Adds the amount of the transaction.</p>
   */
  public SignatureTransactionBuilder withAmount(Money amount) {
    this.amount = amount;
    return this;
  }

  /**
   * <p>Adds the currency of the transaction.</p>
   */
  public SignatureTransactionBuilder withCurrency(String currency) {
    this.currency = currency;
    this.customField.put(SignatureTransaction.FIELD_CURRENCY, this.currency);
    return this;
  }

  /**
   * <p>Adds the unique identifiant of the transaction.</p>
   */
  public SignatureTransactionBuilder withTransactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * <p>Adds the date of the transaction.</p>
   */
  public SignatureTransactionBuilder withDate(LocalDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * <p>Adds the payment type of the transaction.</p>
   */
  public SignatureTransactionBuilder withPaymentType(PaymentCategory paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * <p>Adds the type of the action page of the transaction.</p>
   */
  public SignatureTransactionBuilder withAction(String action) {
    this.action = action;
    this.customField.put(SignatureTransaction.FIELD_ACTION, this.action);
    return this;
  }

  /**
   * <p>Adds the version used for the transaction.</p>
   */
  public SignatureTransactionBuilder withVersion(String version) {
    this.version = version;
    this.customField.put(SignatureTransaction.FIELD_VERSION, this.version);
    return this;
  }


  /**
   * <p>Adds the language used for the transaction.</p>
   */
  public SignatureTransactionBuilder withLanguage(String language) {
    this.language = language;
    return this;
  }

  /**
   * <p>Adds the designation of the transaction.</p>
   */
  public SignatureTransactionBuilder withDesignation(String designation) {
    this.designation = designation;
    return this;
  }

  /**
   * <p>Adds the customer reference used for the transaction.</p>
   */
  public SignatureTransactionBuilder withClientReference(String clientReference) {
    this.clientReference = clientReference;
    return this;
  }

  /**
   * <p>Adds the prefix of the customer's phone number.</p>
   */
  public SignatureTransactionBuilder withClientReferencePrefix(String clientReferencePrefix) {
    this.clientReferencePrefix = clientReferencePrefix;
    this.customField.put(SignatureTransaction.FIELD_PHONE_PREFIX, clientReferencePrefix);
    return this;
  }

  /**
   * <p>Adds the notification url used in case of success or failure of the transaction.</p>
   */
  public SignatureTransactionBuilder withNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
    return this;
  }

  /**
   * <p>Adds the first redirection url used in case of success or failure of the transaction.</p>
   */
  public SignatureTransactionBuilder withReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
    this.customField.put(PaymentFormTransaction.FIELD_RETURN_URL, clientReferencePrefix);
    return this;
  }

  /**
   * <p>Adds the second redirection url used in case of success or failure of the transaction.</p>
   */
  public SignatureTransactionBuilder withCancelUrl(String cancelUrl) {
    this.cancelUrl = cancelUrl;
    this.customField.put(PaymentFormTransaction.FIELD_CANCEL_URL, clientReferencePrefix);
    return this;
  }

  /**
   * <p>Build a new {@link SignatureTransaction}.</p>
   */
  public SignatureTransaction build() {
    return new SignatureTransaction(this.siteId, this.apiKey, this);
  }

  public Map<String, String> getCustomField() {
    return customField;
  }

  public Money getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public PaymentCategory getPaymentType() {
    return paymentType;
  }

  public String getAction() {
    return action;
  }

  public String getVersion() {
    return version;
  }

  public String getLanguage() {
    return language;
  }

  public String getDesignation() {
    return designation;
  }

  public String getClientReference() {
    return clientReference;
  }

  public String getClientReferencePrefix() {
    return clientReferencePrefix;
  }

  public String getNotifyUrl() {
    return notifyUrl;
  }

  public String getReturnUrl() {
    return returnUrl;
  }

  public String getCancelUrl() {
    return cancelUrl;
  }
}
