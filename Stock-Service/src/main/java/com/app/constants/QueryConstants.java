package com.app.constants;

public class QueryConstants {

	public static final String GET_AVAILABLE_PRODUCTS= "SELECT pst.product_id FROM product_stock_table as pst WHERE pst.product_count > 0  LIMIT 5 OFFSET 0;";
}
