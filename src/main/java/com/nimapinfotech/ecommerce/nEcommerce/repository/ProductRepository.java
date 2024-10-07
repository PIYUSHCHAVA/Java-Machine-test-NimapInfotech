package com.nimapinfotech.ecommerce.nEcommerce.repository;

import com.nimapinfotech.ecommerce.nEcommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
