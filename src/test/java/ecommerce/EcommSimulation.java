package ecommerce;

import static ecommerce.utils.HttpProtocol.*;
import static ecommerce.utils.Injection.*;

import ecommerce.scenarios.Scenario1;
import io.gatling.javaapi.core.*;

public class EcommSimulation extends Simulation {
  {
    setUp(populate(Scenario1.steps)).protocols(httpProtocolAuth);
  }
}
