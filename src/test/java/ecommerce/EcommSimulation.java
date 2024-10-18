package ecommerce;

import static ecommerce.endpoints.APIendpoints.*;
import static ecommerce.endpoints.WebEndpoints.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class EcommSimulation extends Simulation {

  static final String baseUrl = "https://api-ecomm.gatling.io";

  static final HttpProtocolBuilder httpProtocolBase =
      http.baseUrl(baseUrl)
          .acceptHeader("application/json")
          .userAgentHeader(
              "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0");

  static final ScenarioBuilder scn = scenario("scenario 1").exec(homePage, session);

  {
    setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocolBase);
  }
}
