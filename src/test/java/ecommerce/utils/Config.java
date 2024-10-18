package ecommerce.utils;

public class Config {
  public static final int users = Integer.getInteger("users", 1);

  public static final String type = System.getProperty("testType", "smoke");

  public static final String pageUrl = "https://ecomm.gatling.io";
  public static final String baseUrl = "https://api-ecomm.gatling.io";

  public static final String usersFeederFile = "users.json";
}
