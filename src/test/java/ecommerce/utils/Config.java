package ecommerce.utils;

import java.time.Duration;

public class Config {
  public static final int users = Integer.getInteger("users", 1);
  public static final String testType = System.getProperty("testType", "smoke");

  public static final Duration duration =
      Duration.ofMinutes(Integer.getInteger("durationMinutes", 1));
  public static final Duration ramp_duration =
      Duration.ofMinutes(Integer.getInteger("rampDurationMinutes", 1));

  public static final String pageUrl = "https://ecomm.gatling.io";
  public static final String baseUrl = "https://api-ecomm.gatling.io";

  public static final String usersFeederFile = "users.json";
}
