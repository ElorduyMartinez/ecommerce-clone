package com.itesm.ecommerce.infrastructure.dto.category;

import com.itesm.ecommerce.domain.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDTO {
    private String name;

    public Category toDomain() {
        Category category = new Category();
        category.setName(this.name);
        return category;
    }
}
