/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

/**
 * <p>Interface representing a financial or telecom service operator.</p>
 *
 * @author Christian Amani 2021-02-07
 */
public interface Operator {

  /**
   * <p>Name of operator.</p>
   *
   * @return Operator name
   */
  String name();

  /**
   * <p>Description of operator.</p>
   *
   * @return Operator description
   */
  String description();
}
