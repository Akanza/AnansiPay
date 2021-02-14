/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

import java.time.LocalDateTime;

/**
 * <p>Interface representing an organisation's response to the processing of a transaction.</p>
 *
 * @author Christian Amani 2021-02-07
 */
public interface NotificationTransaction extends Transaction {

  /**
   * <p>Transaction status.</p>
   *
   * @return Transaction status
   */
  String status();

  /**
   * <p>Transaction created date.</p>
   *
   * @return Date of creation of the transaction notification
   */
  LocalDateTime createdDate();

  /**
   * <p>Transaction updated date.</p>
   *
   * @return Date of update of the transaction notification
   */
  LocalDateTime updatedDate();

  /**
   * <p>Transaction cancel date.</p>
   *
   * @return Date of cancel of the transaction notification
   */
  LocalDateTime canceledDate();
}
