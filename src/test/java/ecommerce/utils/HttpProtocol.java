package ecommerce.utils;

import static ecommerce.utils.Config.baseUrl;
import static ecommerce.utils.Keys.ACCESS_TOKEN;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.http.*;

public class HttpProtocol {

  static final HttpProtocolBuilder httpProtocolBase =
      http.baseUrl(baseUrl)
          .acceptHeader("application/json")
          .userAgentHeader(
              "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0");

  public static HttpProtocolBuilder httpProtocolAuth =
      httpProtocolBase.header("Authorization", "#{%s}".formatted(ACCESS_TOKEN));
}
