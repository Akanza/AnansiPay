/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.adjemin;

import com.akanza.anansipay.core.MerchantAccount;
import java.net.URI;
import java.util.Map;

/**
 * <p>Merchant account for a customer of the Adjemin platform.</p>
 *
 * @author Christian Amani 2021-02-10
 */
public class MerchantAdjemin implements MerchantAccount {

  private static final String URL_CHECK_CREDENTIAL = "https://dev.adjeminpay.adjemincloud.com/v1/checkCredential";

  private final String username;
  private final String password;
  private String key;

  /**
   * <p>Authenticate using the {@link #username} and {@link #password} during instantiation.</p>
   */
  public MerchantAdjemin(String username, String password) {
    this.username = username;
    this.password = password;
    authentification(this.username, this.password);
  }

  @Override
  public String key() {
    return this.key;
  }

  @Override
  public void authentification(String username, String password) {
    final var uri = URI.create(URL_CHECK_CREDENTIAL);
    var authenticate = new HttpAuthentication(uri, username, password);
    Map<String, String> auth = authenticate.auth();
    this.key = auth.get("token");
  }

  @Override
  public String name() {
    return "";
  }

  @Override
  public String information() {
    return "";
  }


  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
