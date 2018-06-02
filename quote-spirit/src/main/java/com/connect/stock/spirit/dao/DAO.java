package com.connect.stock.spirit.dao;

import com.connect.stock.spirit.model.future.FutureQuote;
import com.connect.stock.spirit.model.product.ProductQuote;
import com.connect.stock.spirit.model.stock.StockQuote;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	public void addStockQuote(StockQuote quote) throws SQLException;
	
	public List<StockQuote> getStockQuoteByStockId(String stockId, int offset, int pageSize) throws SQLException;

	public void addFutureQuote(FutureQuote quote) throws SQLException;
	
	public List<FutureQuote> getFutureQuoteByFutureId(String futureId, int offset, int pageSize) throws SQLException;
	                         
	public void addProductQuote(ProductQuote quote) throws SQLException;
	
	public List<ProductQuote> getProductQuoteByProductId(String productId, int offset, int pageSize) throws SQLException;
}
