package com.itesm.ecommerce.infrastructure.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignCategoryToProductDTO {
    private int productId;
    private int categoryId;
}
