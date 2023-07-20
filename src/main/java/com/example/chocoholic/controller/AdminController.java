package com.example.chocoholic.controller;
import com.example.chocoholic.dto.productDTO;
import com.example.chocoholic.model.Category;
import com.example.chocoholic.service.CategoryService;
import com.example.chocoholic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public  String addCate(Model model){
        model.addAttribute("categories",new Category());
        return "categoriesAdd";
    }
    @PostMapping ("/admin/categories/add")
    public  String postCate(@ModelAttribute("categories")Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/admin/categories/delete/{id}")
    public String deleteCate(@PathVariable int id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }


    @GetMapping("/admin/categories/update/{id}")
    public String updateCate(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("categories", category.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }

    //    -------------------------------Product Section-------------------------------
    @GetMapping ("/admin/product")
    public String getProdducts(Model model) {
        model.addAttribute("products",productService.getAllProduct());
        return "product";
    }
    @GetMapping ("/admin/product/add")
    public String addProducts(Model model) {
        model.addAttribute("productDTO",new productDTO());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productAdd";
    }

}
