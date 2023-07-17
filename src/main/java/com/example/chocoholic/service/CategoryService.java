package com.example.chocoholic.service;

import com.example.chocoholic.model.Category;
import com.example.chocoholic.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository CategoryRepository;
    public void addCategory(Category category){
        CategoryRepository.save(category);
    }
    public List<Category> getAllCategory(){
        return CategoryRepository.findAll();
    }
    public void removeCategoryById(int id) {
        CategoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id){
        return CategoryRepository.findById(id);
    }



}
