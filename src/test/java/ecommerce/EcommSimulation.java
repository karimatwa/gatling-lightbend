package ecommerce;

import static ecommerce.endpoints.APIendpoints.*;
import static ecommerce.endpoints.WebEndpoints.*;
import static ecommerce.utils.Actions.*;
import static ecommerce.utils.Config.*;
import static ecommerce.groups.UsersGroups.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class EcommSimulation extends Simulation {

  static final FeederBuilder<Object> usersFeeder = jsonFile(userFeeder).circular();

  static final HttpProtocolBuilder httpProtocolBase =
      http.baseUrl(baseUrl)
          .acceptHeader("application/json")
          .userAgentHeader(
              "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0");

  static final ScenarioBuilder scn =
      scenario("scenario 1")
          .exec(
              homeAnonymous,
              pause(5),
              feed(usersFeeder),
              loginPage,
              pause(10),
              login,
              homePage,
              products,
              pause(5),
              addRandomProductToCartItems(),
              cart);

  {
    setUp(scn.injectOpen(atOnceUsers(users))).protocols(httpProtocolBase);
  }
}
