package com.kb.quanlysanpham.controller;

import com.kb.quanlysanpham.modal.Category;
import com.kb.quanlysanpham.modal.Product;
import com.kb.quanlysanpham.service.CategoryService;
import com.kb.quanlysanpham.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("admin/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showTableProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "product-add";
    }


    @PostMapping("/confirmAdd")
    public String addProduct(@RequestParam("file") MultipartFile file,
                             @ModelAttribute("product") Product product,
                             BindingResult result, RedirectAttributes redirectAttributes) throws IOException {

        if (result.hasErrors()) {
            return "product-add";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            redirectAttributes.addFlashAttribute("message", "File name contains invalid path sequence " + fileName);
            return "redirect:/admin/product/add";
        }

        // Lưu hình ảnh
        String uploadDir = System.getProperty("user.dir") + "/uploads";
        Path path = Paths.get(uploadDir + "/" + fileName);
        // Check if the directory exists, if not, create it
        if (!Files.exists(Paths.get(uploadDir))) {
            try {
                Files.createDirectories(Paths.get(uploadDir));
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute("message", "Could not create the directory where the uploaded files will be stored.");
                return "redirect:/admin/product/add";
            }
        }

        // Check if the file already exists
        if (Files.exists(path)) {
            // If the file already exists, set the image field to the name of the existing file
            product.setImage(fileName);
        } else {
            // If the file does not exist, store the new file and set the image field to the name of the new file
            Files.copy(file.getInputStream(), path);
            product.setImage(fileName);
        }

        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product saved successfully");

        return "redirect:/admin/product";
    }
    @GetMapping("/update/{id}")
    public String showUpdateProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProductById(id);
        if (product == null) {
            return "redirect:admin/product";
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "product-add";
    }


    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,
                                @RequestParam("file") MultipartFile file,
                                @ModelAttribute("product") Product product,
                                BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if (result.hasErrors()) {
            return "product-add";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            redirectAttributes.addFlashAttribute("message", "File name contains invalid path sequence " + fileName);
            return "redirect:/admin/product/edit/" + id;
        }

        // Lưu hình ảnh
        String uploadDir = System.getProperty("user.dir") + "/uploads";
        Path path = Paths.get(uploadDir + "/" + fileName);
        // Check if the directory exists, if not, create it
        if (!Files.exists(Paths.get(uploadDir))) {
            try {
                Files.createDirectories(Paths.get(uploadDir));
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute("message", "Could not create the directory where the uploaded files will be stored.");
                return "redirect:/admin/product/edit/" + id;
            }
        }

        // Check if the file already exists
        if (Files.exists(path)) {
            // If the file already exists, set the image field to the name of the existing file
            product.setImage(fileName);
        } else {
            // If the file does not exist, store the new file and set the image field to the name of the new file
            Files.copy(file.getInputStream(), path);
            product.setImage(fileName);
        }

        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully");

        return "redirect:admin/product";
    }
    // Phương thức xóa
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        if (product == null) {
            return "product";
        }
        productService.deleteProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/admin/product";
    }
}
