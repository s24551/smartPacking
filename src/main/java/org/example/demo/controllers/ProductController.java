package org.example.demo.controllers;

import org.example.demo.models.Location;
import org.example.demo.models.Product;
import org.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam(name = "productId", required = false) String productId,
                                @RequestParam(name = "productName", required = false) String productName,
                                Model model) {
        Product product = null;

        if (productId != null && !productId.isEmpty()) {
            product = productService.findProductById(productId);
        } else if (productName != null && !productName.isEmpty()) {
            product = productService.findProductByName(productName);
        }

        if (product != null) {
            model.addAttribute("product", product);
            return "productDetails"; // Nazwa widoku Thymeleaf z detalami produktu
        } else {
            model.addAttribute("message", "Produkt nie został znaleziony.");
            return "niceProduct"; // Powrót do formularza wyszukiwania z komunikatem
        }
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/findProduct")
    public String showFindProductForm() {
        return "niceProduct"; // Nazwa szablonu Thymeleaf
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    // Metoda do wyszukiwania produktu po lokalizacji, jeśli potrzebna
    @GetMapping("/add")
    public String showAddProductForm() {
        return "addProduct"; // Nazwa szablonu Thymeleaf
    }


    @GetMapping("/all")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "listProducts"; // Nazwa szablonu Thymeleaf
    }
    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("aisle") String aisle, @RequestParam("shelf") String shelf, @RequestParam("position") String position, Model model) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);

        // Utwórz i ustaw obiekt Location dla produktu
        Location location = new Location(aisle, shelf, position);
        product.setLocation(location);

        productService.save(product); // Zapisz produkt za pomocą serwisu

        return "redirect:/products/add"; // Przekieruj do listy produktów
    }


}

