package com.srikar.spring.controller;

import com.srikar.spring.domain.Product;
import com.srikar.spring.form.ProductForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vedantas on 2/4/2018.
 */
@Controller
public class ProductController {

    @RequestMapping(value = "/product_input", method = RequestMethod.GET)
    public String getProductForm() {
        return "productInput";
    }

    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public String saveProductForm(ProductForm productForm, Model model) {
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }
        catch(NumberFormatException ex){

        }
        model.addAttribute("product", product);
        return "saveProduct";
    }

}
