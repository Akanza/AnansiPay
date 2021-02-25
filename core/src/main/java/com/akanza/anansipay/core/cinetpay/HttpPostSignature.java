/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.cinetpay;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * <p>Make a POST request to retrieve a signature provided by {@link MerchantCinetPay}.</p>
 *
 * @author Christian Amani 2021-02-21
 */
class HttpPostSignature {

  private static final int STATUS_CODE_OK = 200;
  private static final int STATUS_CODE_CREATED = 201;

  private final HttpClient httpClient;
  private final URI uri;

  public HttpPostSignature() {
    this.httpClient = HttpClient.newHttpClient();
    this.uri = URI.create("https://api.cinetpay.com/v1/?method=getSignatureByPost");
  }


  public String post(SignatureTransaction transaction) {
    var parameters = transaction.formData();
    var form = parameters.keySet().stream()
        .filter(
            key -> parameters.get(key) instanceof String || parameters.get(key) instanceof Number)
        .map(key -> {
          var parameter = parameters.get(key);
          if (parameter instanceof String) {
            return key + "=" + URLEncoder.encode((String) parameter, StandardCharsets.UTF_8);
          } else {
            return key + "=" + URLEncoder.encode(parameter.toString(), StandardCharsets.UTF_8);
          }
        })
        .collect(Collectors.joining("&"));

    var httpRequest = HttpRequest.newBuilder(uri)
        .header("Content-Type", "application/x-www-form-urlencoded")
        .header("Accept", "application/json")
        .POST(BodyPublishers.ofString(form))
        .build();

    try {
      HttpResponse<String> httpResponse;
      httpResponse = this.httpClient.send(httpRequest, BodyHandlers.ofString());
      var statusCode = httpResponse.statusCode();
      if (statusCode == STATUS_CODE_OK || statusCode == STATUS_CODE_CREATED) {
        var body = httpResponse.body();
        var isJsonValid = isJsonValid(body);
        if (isJsonValid) {
          throw new HttpPostSignatureException(
              "An error occurred while retrieving the signature ! \n The error response "
                  + "is : " + body);
        } else {
          return body;
        }
      } else {
        throw new HttpPostSignatureException(
            "An error occurred while retrieving the signature ! \n The code status of the response "
                + "is : " + statusCode);
      }
    } catch (IOException | InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new HttpPostSignatureException(
          "An error occurred during retrieving the signature !", e);
    }
  }

  private boolean isJsonValid(String content) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      mapper.readTree(content);
      return true;
    } catch (IOException e) {
      return false;
    }
  }
}
