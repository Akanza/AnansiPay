/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>Interface representing business information between an {@link Account} and an {@link
 * Organisation}.</p>
 *
 * @author Christian Amani 2021-02-07
 */
public interface Transaction {

  /**
   * <p>Transaction amount.</p>
   *
   * @return Transaction amount
   */
  Money amount();

  /**
   * <p>Transaction reference.</p>
   *
   * @return Unique reference for each transaction
   */
  String reference();

  /**
   * <p>Transaction reference of {@link Account}.</p>
   *
   * @return Reference to identify the account uniquely
   */
  String accountReference();

  /**
   * <p>Transaction date.</p>
   *
   * @return Date of transaction
   */
  LocalDateTime date();

  /**
   * <p>Transaction designation.</p>
   *
   * @return Designation of transaction
   */
  String designation();

  /**
   * <p>Transaction reference of client.</p>
   *
   * @return Reference uniquely identifying the customer of an account
   */
  String clientReference();

  /**
   * <p>Operator used for the transaction.</p>
   *
   * @return The operator involved in the transaction
   */
  Operator operator();

  /**
   * <p>Payment category.</p>
   *
   * @return The payment category
   */
  PaymentCategory category();

  /**
   * <p>Successful payment URL.</p>
   *
   * @return <p>The address to which the user will be redirected if the payment is successful. The
   * address must be specified in full including the protocol used.</p>
   */
  String successfulPaymentUrl();

  /**
   * <p>Failed payment URL.</p>
   *
   * @return <p>The address to which the user is to be redirected in case of a failed payment. The
   * address must be specified in full including the protocol used.</p>
   */
  String failedPaymentUrl();

  /**
   * <p>Transaction language.</p>
   *
   * @return Language used for the transaction
   */
  String language();

  /**
   * <p>Other additional data.</p>
   *
   * @return Metadata of the transaction
   */
  Map<String, String> metadata();
}
