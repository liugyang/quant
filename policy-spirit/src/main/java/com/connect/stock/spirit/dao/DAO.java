package com.connect.stock.spirit.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.connect.stock.spirit.model.future.FutureQuote;
import com.connect.stock.spirit.model.product.ProductQuote;
import com.connect.stock.spirit.model.stock.StockQuote;

public interface DAO {
	public void addStockQuote(StockQuote quote) throws SQLException;
	
	public List<StockQuote> getStockQuoteByStockId(String stockId, int offset, int pageSize) throws SQLException;
	
	public List<StockQuote> getStockQuoteByDate(String stockId, Date startDate, Date endDate, int offset, int pageSize) throws SQLException;

	public void addFutureQuote(FutureQuote quote) throws SQLException;
	
	public List<FutureQuote> getFutureQuoteByFutureId(String futureId, int offset, int pageSize) throws SQLException;
	
	public List<FutureQuote> getClosedFutureQuoteByDate(String futureId, Date startDate, Date endDate, int offset, int pageSize) throws SQLException;
	
	public List<FutureQuote> getClosedFutureQuoteByDays(String futureId, int lastDaysCount) throws SQLException;
	                         
	public void addProductQuote(ProductQuote quote) throws SQLException;
	
	public List<ProductQuote> getProductQuoteByDate(String productId, Date startDate, Date endDate, int offset, int pageSize) throws SQLException;
}
