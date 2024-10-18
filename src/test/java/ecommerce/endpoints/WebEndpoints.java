package ecommerce.endpoints;

import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

public class WebEndpoints {

  public static final HttpRequestActionBuilder homePage =
      http("HomePage").get("https://ecomm.gatling.io/").check(status().in(200, 304));
}
