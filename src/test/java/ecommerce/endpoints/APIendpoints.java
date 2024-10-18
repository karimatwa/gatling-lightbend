package ecommerce.endpoints;

import static io.gatling.javaapi.core.CoreDsl.jmesPath;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

public class APIendpoints {
  public static final HttpRequestActionBuilder session =
      http("Session").get("/session").check(status().in(200));

  public static final HttpRequestActionBuilder products =
      http("Products").get("/products").check(status().in(200));

  public static final HttpRequestActionBuilder login =
      http("Login")
          .post("/login")
          .asFormUrlEncoded()
          .formParam("username", "#{username}")
          .formParam("password", "#{password}")
          .check(status().is(200));
}
