package com.gdmn.ugarden.repository;

import com.gdmn.ugarden.model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    default List<Product> findAll(int page, int count) {
        return findAll(PageRequest.of(page, count, Sort.by(Sort.DEFAULT_DIRECTION,"name"))).getContent();
    }
}
