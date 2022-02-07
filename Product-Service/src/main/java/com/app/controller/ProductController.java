
package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.iservice.IProductService;
import com.app.pojos.ProductDTO;
import com.app.pojos.Response;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

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
	public Response<List<ProductDTO>> getAll() {
		List<ProductDTO> result =  productService.getAllProducts();
		return new Response<>(HttpStatus.OK, result, "Success");
	}

	@GetMapping("/{id}")
	public Response<ProductDTO> getById(@PathVariable String id) {
		ProductDTO result =  productService.getProductById(id);
		return new Response<>(HttpStatus.OK, result, "Success");
	}

	@PutMapping("/update")
	public Response<ProductDTO> updateProduct(@RequestBody ProductDTO product){
		if(product.getProductId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST, product, "Productid is required to update");
		}
		return new Response<>(HttpStatus.OK,productService.updateProduct(product), "Productid is updated");

	}

	@DeleteMapping("/delete")
	public Response<ProductDTO> deleteProduct(@RequestParam String productId){
		log.info("Enter into deleting product with id : {}", productId);
		if(productId==null) {
			return new Response<>(HttpStatus.BAD_REQUEST, null, "Product id is required to delete");
		}
		productService.deleteProduct(productId);
		return new Response<>(HttpStatus.OK,null, "Product is Deleted");

	}
	
	@PostMapping("/getproductsinfo")
	public Response<List<ProductDTO>> getProductsInfo(@RequestBody List<String> productIds){
		 List<ProductDTO>  products =  productService.getProductsOnfo(productIds);
		return new Response<>(HttpStatus.OK,products, "Success");

	}
	
	



	/*
    ./gradlew sonarqube \
     -Dsonar.projectKey=Product-Service \
     -Dsonar.host.url=http://localhost:9000 \
     -Dsonar.login=f1d69daa5b3512fbe3d6383097852681f308039f
	 */

}
