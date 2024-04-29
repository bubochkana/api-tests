package org.github.bubochkana.service;

import org.github.bubochkana.service.placeholder.JsonPlaceholderApi;

public class Services {
  public static JsonPlaceholderApi placeholderApi() {
    return new JsonPlaceholderApi();
  }
}
