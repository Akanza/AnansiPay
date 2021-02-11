/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.adjemin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Christian Amani 2021-02-11
 */
class MerchantAdjeminTest {

  @Test
  @DisplayName("Tests the authentication of an Adjemin account and verifies the existence of the obtained key.")
  void authentificationAndGetKey() {
    // Given
    final var username = "username";
    final var password = "password";

    // When
    var httpAuthenticationException = Assertions
        .assertThrows(HttpAuthenticationException.class, () -> {
          new MerchantAdjemin(username, password);
        });

    // Then
    var message = httpAuthenticationException.getMessage();
    Assertions.assertEquals(
        "An error occurred during account authentication ! \n The code status of the response is : 500",
        message);
  }
}
