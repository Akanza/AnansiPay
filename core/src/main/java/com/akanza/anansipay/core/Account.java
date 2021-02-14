/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

/**
 * <p>Personal data of a user from an {@link Organisation}.</p>
 *
 * @author Christian Amani 2021-02-07
 */
public interface Account {

  /**
   * <p>The key/token that authenticates the account with an {@link Organisation}.</p>
   *
   * @return <p>the key from which the {@link Account} can use to access an {@link Organisation}'s
   * service.</p>
   */
  String key();

  /**
   * <p>Authenticates an {@link Account} with an {@link Organisation}.</p>
   */
  void authentification(String username, String password);
}
