package ecommerce.endpoints;

import static ecommerce.utils.Keys.*;
import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.core.CoreDsl.jmesPath;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

public class APIendpoints {

  public static final HttpRequestActionBuilder session =
      http("Session")
          .get("/session")
          .check(status().is(200))
          .check(jmesPath("sessionId").saveAs(SESSION_ID));

  public static final HttpRequestActionBuilder products =
      http("Products")
          .get("/products")
          .check(status().is(200))
          .check(jmesPath("products").saveAs(PRODUCTS));

  public static final HttpRequestActionBuilder login =
      http("Login")
          .post("/login")
          .asFormUrlEncoded()
          .formParam("username", "#{username}")
          .formParam("password", "#{password}")
          .check(status().is(200))
          .check(jmesPath("accessToken").saveAs(ACCESS_TOKEN));

  public static final HttpRequestActionBuilder cart =
      http("Add to Cart")
          .post("/cart")
          .asJson()
          .body(ElFileBody("bodies/cart.json"))
          .check(status().is(200));

  public static final HttpRequestActionBuilder checkOut =
      http("Checkout")
          .post("/checkout")
          .header("Authorization", "#{%s}".formatted(ACCESS_TOKEN))
          .asJson()
          .body(ElFileBody("bodies/cart.json"))
          .check(status().is(200));
}
