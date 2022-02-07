package com.app.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.app.constants.CommonConstants;
import com.app.exceptions.ProductException;
import com.app.iservice.IProductService;
import com.app.model.Product;
import com.app.pojos.ProductDTO;
import com.app.repository.ProductRepository;
import com.app.util.ProductDTOUtil;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements IProductService {
	
	private  static final  Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO getProductById(String id) {
		Product product = productRepository.findById(id)
										   .orElseThrow(()->{
											   throw new NoSuchElementException(CommonConstants.PRODUCT_NOT_FOUND_ERR_MSG+id);
											});
		return ProductDTOUtil.getProductDTO(product);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll()
								.stream()
								.map(ProductDTOUtil::getProductDTO)
								.collect(Collectors.toList());
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product = ProductDTOUtil.getProductEntity(productDTO);
		return ProductDTOUtil.getProductDTO(productRepository.save(product));
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		Product p = productRepository.findByProductId(productDTO.getProductId())
				                     .orElseThrow(()->{
				                    	 	throw new NoSuchElementException(CommonConstants.PRODUCT_NOT_FOUND_ERR_MSG+productDTO.getProductId());
				                     });

		p.setProductName(productDTO.getProductName()!=null?productDTO.getProductName():p.getProductName());
		p.setProductDescription(productDTO.getProductDescription()!=null?productDTO.getProductDescription():p.getProductDescription());
		p.setProductPrice(productDTO.getProductPrice()!=null?productDTO.getProductPrice():p.getProductPrice());
		p.setProductBrandName(productDTO.getProductBrandName()!=null?productDTO.getProductBrandName():p.getProductBrandName());
		p.setProductColor(productDTO.getProductColor()!=null?productDTO.getProductColor():p.getProductColor());
		p.setProductModel(productDTO.getProductModel()!=null?productDTO.getProductModel():p.getProductModel());
		return ProductDTOUtil.getProductDTO(productRepository.save(p));
	}

	@Override
	public void deleteProduct(String id) {
		log.info(" deleting product Id : {}", id);

		String productId = productRepository.findById(id)
						                    .orElseThrow(()-> {
						                           throw new NoSuchElementException(CommonConstants.PRODUCT_NOT_FOUND_ERR_MSG+id);
						                    }).getProductId();
		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDTO> getProductsOnfo(List<String> productIds) {
		try {
			List<Product> products  = (List<Product>)productRepository.findAllById(productIds);
			return products
					.stream()
					.map(ProductDTOUtil::getProductDTO)
					.collect(Collectors.toList());
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException(CommonConstants.PRODUCT_NOT_FOUND_ERR_MSG);
		}catch (Exception e) {
			log.error("#############Error while getting productsinfo#################");
		}
		return Collections.emptyList();
	}

}
