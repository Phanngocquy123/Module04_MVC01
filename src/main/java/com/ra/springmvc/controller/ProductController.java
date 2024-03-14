package com.ra.springmvc.controller;

import com.ra.springmvc.model.Product;
import com.ra.springmvc.model.StorageDatabase;
import jdk.internal.module.IllegalAccessLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ServletContext context;
    public  ProductController(ServletContext context){
        this.context = context;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("data", StorageDatabase.products);
        return "products/index";
    }

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping(value = "/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
        // kiểm tra dữ liệu DB
        // kiểm tra trùng id
        boolean check = true;
        if (check){
            bindingResult.addError(new FieldError("product", "id", "Mã sản phẩm đã tồn tại"));
        }

        if (bindingResult.hasErrors()){
            return "products/create";
        }

        Product pro = new Product();
        pro.setId(product.getId());
        pro.setName(product.getName());
        pro.setPrice(product.getPrice());
        pro.setCreated(product.getCreated());
        pro.setStatus(product.isStatus());

        // tạo thư mục file
        String pathFolder = "/uploads/";
        String path = context.getRealPath("/WEB-INF/") + pathFolder;

        File folder = new File(path);
        // tạo thư mục nếu chưa có
        if (!folder.exists())
            folder.mkdir();

        // lưu file
//        if (!product.getImage().isEmpty()) {
//
//            Path fileUpload = Paths.get(path + product.getImage().getOriginalFilename()); // => /WEB-INF/uploads/abc.jpg
//            try {
//                Files.write(fileUpload, product.getImage().getBytes());
//                pro.setImage(pathFolder + product.getImage().getOriginalFilename());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
        StorageDatabase.products.add(pro);
        return "redirect:/products/index";
    }
}
