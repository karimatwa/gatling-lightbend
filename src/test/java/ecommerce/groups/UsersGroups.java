package ecommerce.groups;

import static ecommerce.endpoints.APIendpoints.products;
import static ecommerce.endpoints.APIendpoints.session;
import static ecommerce.endpoints.WebEndpoints.homePage;
import static io.gatling.javaapi.core.CoreDsl.*;

import io.gatling.javaapi.core.*;

public class UsersGroups {

    public static final ChainBuilder homeAnonymous = group("homeAnonymous").on(homePage, session, products);

    
}
