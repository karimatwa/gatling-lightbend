package ecommerce.scenarios;

import static ecommerce.endpoints.APIendpoints.*;
import static ecommerce.groups.UsersGroups.*;
import static ecommerce.utils.Config.*;
import static ecommerce.utils.Keys.ACCESS_TOKEN;
import static io.gatling.javaapi.core.CoreDsl.*;

import io.gatling.javaapi.core.*;

public class Scenario1 {

  static final FeederBuilder<Object> usersFeeder = jsonFile(usersFeederFile).circular();

  static final ChainBuilder init =
      exec(feed(usersFeeder), exec(session -> session.set(ACCESS_TOKEN, "")));

  public static final ScenarioBuilder steps =
      scenario("scenario 1")
          .exec(
              init,
              homeAnonymous,
              pause(5),
              authenticate,
              homeAuthenticated,
              addRandomProductToCart,
              checkOut);
}
