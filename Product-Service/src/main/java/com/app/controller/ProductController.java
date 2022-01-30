
package com.app.controller;

import java.util.List;

import com.app.iservice.IProductService;
import com.app.model.Product;
import com.app.pojos.ProductDTO;
import com.app.pojos.Response;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;


    @PostMapping(value="/add", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Response<ProductDTO> addProduct(@RequestBody ProductDTO product) {
         ProductDTO p = productService.addProduct(product);
         log.info("SeavedDTO : {}", p);
         return new Response<>(HttpStatus.OK,p,"Product added Successfully!");
    }


    @RequestMapping("/all")
    public Response<List<Product>> getAll() {
      List<Product> result =  productService.getAllProducts();
      return new Response<>(HttpStatus.OK, result, "Success");
    }

    @GetMapping("/{id}")
    public Response<Product> getById(@PathVariable String id) {
      Product result =  productService.getProductById(id);
      return new Response<>(HttpStatus.OK, result, "Success");
    }

/*
    ./gradlew sonarqube \
     -Dsonar.projectKey=Product-Service \
     -Dsonar.host.url=http://localhost:9000 \
     -Dsonar.login=f1d69daa5b3512fbe3d6383097852681f308039f
*/

}
