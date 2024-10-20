package ecommerce.groups;

import static ecommerce.endpoints.APIendpoints.*;
import static ecommerce.endpoints.WebEndpoints.*;
import static ecommerce.utils.Actions.*;
import static io.gatling.javaapi.core.CoreDsl.*;

import io.gatling.javaapi.core.*;

public class UsersGroups {

  public static final ChainBuilder homeAnonymous =
      group("homeAnonymous").on(homePage, session, products);

  public static final ChainBuilder authenticate =
      group("authenticate").on(loginPage, pause(10), login);

  public static final ChainBuilder homeAuthenticated =
      group("homeAuthenticated").on(homePage, products);

  public static final ChainBuilder addRandomProductToCart =
      group("addRandomProductToCart").on(addRandomProductToCartItems(), cart);
}
