package com.nimapinfotech.ecommerce.nEcommerce.repository;

import com.nimapinfotech.ecommerce.nEcommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}

