package com.gdmn.ugarden.mapper;

import com.gdmn.ugarden.dto.ProductDTO;
import com.gdmn.ugarden.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ProductMapper implements UgardenMapper<ProductDTO, Product> {
    private static final ModelMapper MAPPER = new ModelMapper();

    public ProductMapper() {
        MAPPER.addMappings(new PropertyMap<ProductDTO, Product>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
    }

    @Override
    public ProductDTO mapToDto(Product product) {
        return MAPPER.map(product, ProductDTO.class);
    }

    @Override
    public Product mapFromDTO(ProductDTO productDTO) {
        return MAPPER.map(productDTO, Product.class);
    }

    @Override
    public List<ProductDTO> mapToDTO(List<Product> list) {
        Type listType = new TypeToken<List<ProductDTO>>() {
        }.getType();
        return MAPPER.map(list, listType);
    }

    @Override
    public List<Product> mapFromDTO(List<ProductDTO> list) {
        Type listType = new TypeToken<List<Product>>() {
        }.getType();
        return MAPPER.map(list, listType);
    }
}

