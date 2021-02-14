/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core.adjemin;

import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Authentication class of an {@link com.akanza.anansipay.core.Account}.</p>
 *
 * @author Christian Amani 2021-02-10
 */
class HttpAuthentication {

  private static final int STATUS_CODE_OK = 200;

  private final HttpClient httpClient;
  private final URI uri;
  private final String username;
  private final String password;

  public HttpAuthentication(URI uri, String username, String password) {
    this.httpClient = HttpClient.newHttpClient();
    this.username = username;
    this.password = password;
    this.uri = uri;
  }

  public Map<String, String> auth() {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("application_id", username);
    parameters.put("apikey", password);
    String form = parameters.keySet().stream()
        .map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
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
      if (statusCode == STATUS_CODE_OK) {
        var objectMapper = new ObjectMapper();
        var body = httpResponse.body();
        return objectMapper
            .readValue(body, new TypeReference<>() {
            });
      } else {
        throw new HttpAuthenticationException(
            "An error occurred during account authentication ! \n The code status of the response is : "
                + statusCode);
      }
    } catch (IOException | InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new HttpAuthenticationException(
          "An error occurred during account authentication !", e);
    }
  }
}
