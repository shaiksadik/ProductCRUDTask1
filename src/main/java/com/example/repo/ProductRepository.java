
package com.example.repo;

import java.awt.print.Pageable;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, BigInteger> {
    
    Page<Product> findAll(Pageable page);
    
    Page<Product> findById(BigInteger productId, Pageable page);

}
