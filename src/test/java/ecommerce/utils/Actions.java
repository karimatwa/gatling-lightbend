package ecommerce.utils;

public class Actions {
    
    record Product(
        int id,
        String name,
        String color,
        String price,
        int quantity,
        String imageSrc,
        String imageAlt) {}
        
}
