/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

import java.util.Optional;

/**
 * <p>Interface for retrieving credentials from an {@link Account}.</p>
 *
 * @author Christian Amani 2021-02-08
 */
public interface CredentialAccess {

  /**
   * <p>A username.</p>
   *
   * @return Username credential
   */
  Optional<String> username();

  /**
   * <p>A password.</p>
   *
   * @return Password credential
   */
  Optional<String> password();
}
