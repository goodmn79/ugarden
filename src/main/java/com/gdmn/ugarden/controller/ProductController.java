package com.gdmn.ugarden.controller;

import com.gdmn.ugarden.dto.ProductDTO;
import com.gdmn.ugarden.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping("{id}")
    public ProductDTO getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer count) {
        return productService.getAllProducts(page, count);
    }

    @PutMapping
    public String updateProduct(@RequestBody ProductDTO productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
