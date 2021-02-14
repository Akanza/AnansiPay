/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

/**
 * <p>Personal data from an {@link Organisation}'s merchant account.</p>
 *
 * @author Christian Amani 2021-02-07
 */
public interface MerchantAccount extends Account {

  /**
   * <p>Account name.</p>
   *
   * @return Name of the merchant
   */
  String name();

  /**
   * <p>Account information.</p>
   *
   * @return Merchant information
   */
  String information();
}
