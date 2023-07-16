package com.example.chocoholic.repository;

import com.example.chocoholic.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer > {
}
