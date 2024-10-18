package ecommerce.utils;

import static ecommerce.utils.Keys.*;
import static io.gatling.javaapi.core.CoreDsl.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gatling.javaapi.core.*;
import java.util.ArrayList;
import java.util.List;
import scala.util.Random;

public class Actions {

  record Product(
      int id,
      String name,
      String color,
      String price,
      int quantity,
      String imageSrc,
      String imageAlt) {}

  static final ObjectMapper mapper = new ObjectMapper();

  public static final ChainBuilder addRandomProductToCartItems() {
    return exec(
        session -> {
          try {
            List<Product> products =
                mapper.readValue(
                    session.getString(PRODUCTS), new TypeReference<List<Product>>() {});

            Random random = new Random();
            int randomIndex = random.nextInt(products.size());

            Product myFirstProduct = products.get(randomIndex);
            List<Product> cartItems = new ArrayList<>();
            cartItems.add(myFirstProduct);

            String cartItemsJsonString = mapper.writeValueAsString(cartItems);
            return session.set(CART_ITEMS, cartItemsJsonString);

          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        });
  }
}
