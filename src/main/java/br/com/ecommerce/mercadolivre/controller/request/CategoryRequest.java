package br.com.ecommerce.mercadolivre.controller.request;

import br.com.ecommerce.mercadolivre.config.security.ValidationException;
import br.com.ecommerce.mercadolivre.config.validation.UniqueValue;
import br.com.ecommerce.mercadolivre.model.Category;
import br.com.ecommerce.mercadolivre.repository.CategoryRepository;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String nameCategory;
    @Positive
    private Long idCategoryMother;

    @Deprecated
    public CategoryRequest() {
    }

    public CategoryRequest(String nameCategory, Long idCategoryMother) {
        this.nameCategory = nameCategory;
        this.idCategoryMother = idCategoryMother;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public Long getIdCategoryMother() {
        return idCategoryMother;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "nameCategory='" + nameCategory + '\'' +
                ", idCategoryMother=" + idCategoryMother +
                '}';
    }

    public Category toModel(CategoryRepository repository) {
        Category category = new Category(nameCategory);
        if (idCategoryMother != null) {
            Optional<Category> categoryMother = repository.findById(idCategoryMother);
            Assert.notNull(categoryMother, "O id da categoria precisa ser válido!");
            category.setCategoryMother(categoryMother.get());
        }
        return category;
    }
}
