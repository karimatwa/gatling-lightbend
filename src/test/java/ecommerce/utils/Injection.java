package ecommerce.utils;

import static ecommerce.utils.Config.*;
import static io.gatling.javaapi.core.CoreDsl.*;

import io.gatling.javaapi.core.*;

public class Injection {

  public static final PopulationBuilder populate(ScenarioBuilder scn) {

    return switch (testType) {
      case "capacity" ->
          scn.injectOpen(
              incrementUsersPerSec(users)
                  .times(4)
                  .eachLevelLasting(duration)
                  .separatedByRampsLasting(4)
                  .startingFrom(10));
      case "soak" -> scn.injectOpen(constantUsersPerSec(users).during(duration));
      case "stress" -> scn.injectOpen(stressPeakUsers(users).during(duration));
      case "breakpoint" -> scn.injectOpen(rampUsers(users).during(duration));
      case "ramp-hold" ->
          scn.injectOpen(
              rampUsersPerSec(0).to(users).during(ramp_duration),
              constantUsersPerSec(users).during(duration));
      case "smoke" -> scn.injectOpen(atOnceUsers(1));
      default -> scn.injectOpen(atOnceUsers(users));
    };
  }
}
