/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.cinetpay;

/**
 * <p>Thrown when the recovery of a signature fails for any reason.</p>
 *
 * @author Christian Amani 2021-02-23
 */
class HttpPostSignatureException extends
    RuntimeException {

  public HttpPostSignatureException(String message) {
    super(message);
  }

  public HttpPostSignatureException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
