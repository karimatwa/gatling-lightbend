package ecommerce.endpoints;

import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static ecommerce.utils.Config.*;

public class WebEndpoints {

  public static final HttpRequestActionBuilder homePage =
      http("HomePage").get(pageUrl).check(status().in(200, 304));
}
