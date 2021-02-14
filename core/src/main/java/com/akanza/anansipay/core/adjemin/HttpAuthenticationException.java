/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.adjemin;

/**
 * <p>Thrown when authentication of an {@link com.akanza.anansipay.core.Account} fails for some
 * reason.</p>
 *
 * @author Christian Amani 2021-02-10
 */
class HttpAuthenticationException extends
    RuntimeException {

  public HttpAuthenticationException(String message) {
    super(message);
  }

  HttpAuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }
}
