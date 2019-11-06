package de.hska.ContentService;

import de.hska.ContentService.data.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryClient categoryClient;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getCategories() {
        return new ResponseEntity<Iterable<Category>>(categoryClient.getCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
        return new ResponseEntity<Category>(categoryClient.getCategoryById(id), HttpStatus.OK);
    }




    public ResponseEntity<Long> createCategory(@RequestBody Category category) {
        long categoryId = categoryClient.addCategory(category);
        return new ResponseEntity<Long>(categoryId, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        categoryClient.deleteCategory(id);
        // TODO
       // productClient.deleteProductsByCategoryId(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
