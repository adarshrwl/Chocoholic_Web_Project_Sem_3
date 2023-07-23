package com.example.chocoholic.global;

import com.example.chocoholic.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart=new ArrayList<>();
    }
}
