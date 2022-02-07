package com.app.stockserviceimpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.constants.BaseUrlConstants;
import com.app.entity.ProductStock;
import com.app.entity.Stock;
import com.app.enums.Status;
import com.app.pojos.ProductDTO;
import com.app.pojos.StockDTO;
import com.app.repository.ProductStockRepository;
import com.app.repository.StockRepository;
import com.app.stockservice.IStockService;
import com.app.utils.StockDTOUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class StockServiceImpl implements IStockService {

	private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);
	
	
	@Autowired
	private StockRepository stockRepository;
	
	
	@Autowired
	private ProductStockRepository productStockRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public StockDTO addStock(StockDTO stockDTO) {
		Stock stock= StockDTOUtil.getStockEntity(stockDTO);
		stock.setImportedDate(LocalDateTime.now());
		List<ProductStock> ps = stock.getStockProducts();
		ps.stream().forEach(p->{p.setProductSoldCount(0);p.setProductStatus(Status.AVAILABLE);});
		stock.setStockProducts(ps);
		return StockDTOUtil.getStockDTO(stockRepository.save(stock));
	}

	@Override
	public JsonArray getStockProducts() {
		List<String> availableProductIds= productStockRepository.getAvailableProducts();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<List<String>> entity = new HttpEntity<>(availableProductIds,headers);
		
		ResponseEntity<String> response  =  restTemplate.exchange( BaseUrlConstants.PRODUCT_SERVICE_BASE_URL+"getproductsinfo",HttpMethod.POST,entity,String.class);
		
		if(response.getStatusCode()==HttpStatus.OK) {
		    return JsonParser.parseString(response.getBody())
		    		                   .getAsJsonObject()
		    		                   .getAsJsonArray("data");
		}
		return null;
	}

}
