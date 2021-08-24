package br.com.ecommerce.mercadolivre.controller;

import br.com.ecommerce.mercadolivre.controller.request.ProductRequest;
import br.com.ecommerce.mercadolivre.model.Product;
import br.com.ecommerce.mercadolivre.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    private CategoryRepository repository;
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        Product product = productRequest.toModel(repository);
        return ResponseEntity.ok(product.toString());
    }
}
