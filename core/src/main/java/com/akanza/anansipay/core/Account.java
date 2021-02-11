/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

/**
 * @author Christian Amani 2021-02-07
 */
public interface Account {

  /**
   * @return the key from which the {@link Account} can use to access an {@link Organisation}'s
   * service.
   */
  String key();

  /**
   * <p>Authenticates an {@link Account} with an {@link Organisation}.</p>
   */
  void authentification(String username, String password);
}
