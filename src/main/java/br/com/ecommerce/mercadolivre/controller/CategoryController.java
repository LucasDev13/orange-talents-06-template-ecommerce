package br.com.ecommerce.mercadolivre.controller;

import br.com.ecommerce.mercadolivre.controller.request.CategoryRequest;
import br.com.ecommerce.mercadolivre.model.Category;
import br.com.ecommerce.mercadolivre.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    @Transactional
    public String saveCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        Category category = categoryRequest.toModel(categoryRepository);
        categoryRepository.save(category);
        return category.toString();
//        return ResponseEntity.ok().build();
    }
}
