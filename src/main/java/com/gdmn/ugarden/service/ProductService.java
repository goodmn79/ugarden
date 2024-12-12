package com.gdmn.ugarden.service;

import com.gdmn.ugarden.dto.ProductDTO;
import com.gdmn.ugarden.exception.ProductNotFoundException;
import com.gdmn.ugarden.mapper.ProductMapper;
import com.gdmn.ugarden.model.Product;
import com.gdmn.ugarden.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public String addProduct(ProductDTO productDTO) {
        Product product = productRepository.save(mapper.mapFromDTO(productDTO));
        return String.format("Product 'id=%s' successfully added", product.getId());
    }

    public ProductDTO getProductById(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return mapper.mapToDto(product.orElseThrow(ProductNotFoundException::new));
    }

    public List<ProductDTO> getAllProducts(Integer numOfPage, Integer quantityPerPage) {
        int page = numOfPage == null ? 0 : numOfPage;
        int count = quantityPerPage == null ? 10 : quantityPerPage;
        List<Product> products = productRepository.findAll(page, count);
        if (products.isEmpty()) throw new ProductNotFoundException();
        return mapper.mapToDTO(products);
    }

    public String updateProduct(ProductDTO productDTO) {
        long id = productDTO.getId();
        productRepository.findById(id).ifPresentOrElse(product -> {
            product
                    .setSpecies(productDTO.getSpecies())
                    .setName(productDTO.getName())
                    .setSize(productDTO.getSize())
                    .setDescription(productDTO.getDescription())
                    .setPrice(productDTO.getPrice())
                    .setCount(productDTO.getCount());
            productRepository.save(product);
        }, ProductNotFoundException::new);
        return String.format("Product 'id=%s' successfully updated", id);
    }

    public String deleteProduct(long productId) {
        productRepository
                .findById(productId)
                .ifPresentOrElse(entity -> {
                    productRepository.delete(entity);
                    logger.info("Product with 'id={}' was deleted.", productId);
                }, () -> {
                    logger.info("Product with 'id={}' not found", productId);
                    throw new ProductNotFoundException();
                });
        return String.format("Product 'id=%s' successfully deleted", productId);
    }
}
