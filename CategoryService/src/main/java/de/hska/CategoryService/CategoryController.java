package de.hska.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;


    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Category>> getCategories() {

        Category testcat = categoryRepo.save(new Category("TESTCAT"));
        System.out.println("TESTCAT CREATED "+testcat);

        return new ResponseEntity<Iterable<Category>>(categoryRepo.findAll(), HttpStatus.OK);
    }

}
