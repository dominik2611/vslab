package de.hska.ContentService;

import de.hska.ContentService.data.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CategoryClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String CATEGORY_URL = "http://categoryservice:8002/categories";

    public Iterable<Category> getCategories() {

        Category[] cats = restTemplate.getForObject(CATEGORY_URL, Category[].class);

       return Arrays.asList(cats);
    }

    public Category getCategoryById(long categoryId) {
        Category cat= restTemplate.getForObject(CATEGORY_URL +"/"+ categoryId,
                Category.class);

        return cat;
    }

    public Category addCategory(Category category) {
        Category cat = restTemplate.postForObject(CATEGORY_URL, category,
                Category.class);

        return cat;
    }

    public void deleteCategory(long categoryId) {
        restTemplate.delete(CATEGORY_URL+"/" + categoryId);

    }


}
