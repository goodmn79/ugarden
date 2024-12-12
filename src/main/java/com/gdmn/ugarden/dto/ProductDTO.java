package com.gdmn.ugarden.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductDTO {
    private long id;
    private String species;
    private String name;
    private String size;
    private String description;
    private BigDecimal price;
    private int count;
}
