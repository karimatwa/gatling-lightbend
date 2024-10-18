package ecommerce.endpoints;

import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

public class APIendpoints {
  public static final HttpRequestActionBuilder session =
      http("Session").get("/session").check(status().in(200, 304));
}
