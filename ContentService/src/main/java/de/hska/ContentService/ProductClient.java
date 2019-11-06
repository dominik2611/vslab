package de.hska.ContentService;

import de.hska.ContentService.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ProductClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String PRODUCT_URL = "http://localhost:8001/products";

    public Iterable<Product> getProducts() {

        Product[] prods = restTemplate.getForObject(PRODUCT_URL, Product[].class);


        return Arrays.asList(prods);
    }

    public Product getProductById(long productId) {
        Product prod= restTemplate.getForObject(PRODUCT_URL+ "/" + productId, Product.class);

        return prod;
    }

    public Iterable<Product> getProductsByCategoryId(long categoryId) {

        Product[] prods= restTemplate.getForObject(PRODUCT_URL+"/cat/" + categoryId, Product[].class);

        return Arrays.asList(prods);
    }

    public Iterable<Product> searchProducts(SearchRequest searchRequest) {
        Product[] products  = restTemplate.postForObject(PRODUCT_URL+"/search", searchRequest, Product[].class);


        return Arrays.asList(products);
    }

    public long addProduct(Product product) {
        Product prod = restTemplate.postForObject(PRODUCT_URL, product, Product.class);

        return prod.getId();
    }

    public void deleteProduct(long productId) {
        restTemplate.delete(PRODUCT_URL+ "/" + productId);

    }


}
