package com.connect.stock.spirit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.connect.stock.spirit.model.future.FutureQuote;
import com.connect.stock.spirit.model.product.ProductQuote;
import com.connect.stock.spirit.model.stock.StockQuote;
/**
 * 使用H2 Database实现数据存储访问
 * @author liugy
 *
 */
@ComponentScan
@Component("DAOforMySQL")
public class DAOforMySQL implements DAO{
	
	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource dataSource;
	
	public void addStockQuote(StockQuote quote) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			String sql = "INSERT INTO STOCK_QUOTE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, quote.getID());
			stmt.setString(2, quote.getName());
			stmt.setDouble(3, quote.getOpeningPrice());
			stmt.setDouble(4, quote.getClosingPrice());
			stmt.setDouble(5, quote.getCurrentPrice());
			stmt.setDouble(6, quote.getHighestPrice());
			stmt.setDouble(7, quote.getLowestPrice());
			stmt.setDouble(8, quote.getCompetitiveBuyPrice());
			stmt.setDouble(9, quote.getCompetitiveSalePrice());
			stmt.setLong(10, quote.getNumberOfShareTraded());
			stmt.setDouble(11, quote.getMoneyOfShareTraded());
			stmt.setLong(12, quote.getAmountOfBuy1());
			stmt.setDouble(13, quote.getPriceOfBuy1());
			stmt.setLong(14, quote.getAmountOfBuy2());
			stmt.setDouble(15, quote.getPriceOfBuy2());
			stmt.setLong(16, quote.getAmountOfBuy3());
			stmt.setDouble(17, quote.getPriceOfBuy3());
			stmt.setLong(18, quote.getAmountOfBuy4());
			stmt.setDouble(19, quote.getPriceOfBuy4());
			stmt.setLong(20, quote.getAmountOfBuy5());
			stmt.setDouble(21, quote.getPriceOfBuy5());
			stmt.setLong(22, quote.getAmountOfSale1());
			stmt.setDouble(23, quote.getPriceOfSale1());
			stmt.setLong(24, quote.getAmountOfSale2());
			stmt.setDouble(25, quote.getPriceOfSale2());
			stmt.setLong(26, quote.getAmountOfSale3());
			stmt.setDouble(27, quote.getPriceOfSale3());
			stmt.setLong(28, quote.getAmountOfSale4());
			stmt.setDouble(29, quote.getPriceOfSale4());
			stmt.setLong(30, quote.getAmountOfSale5());
			stmt.setDouble(31, quote.getPriceOfSale5());
			stmt.setDate(32, new java.sql.Date(quote.getDate().getTime()));
			stmt.setTime(33, new java.sql.Time(quote.getTime().getTime()));
			stmt.executeUpdate();
		} finally {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
	}
	
	@Override
	public List<StockQuote> getStockQuoteByStockId(String stockId, int offset,
			int pageSize) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<StockQuote> list = new ArrayList<StockQuote>();
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM STOCK_QUOTE WHERE ID=? LIMIT ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stockId);
			stmt.setInt(2, offset);
			stmt.setInt(3, offset+pageSize);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				StockQuote q = new StockQuote();
				q.setID(rs.getString("ID"));
				q.setName(rs.getString("name"));
				q.setOpeningPrice(rs.getDouble("openingPrice"));
				q.setClosingPrice(rs.getDouble("closingPrice"));
				q.setCurrentPrice(rs.getDouble("currentPrice"));
				q.setHighestPrice(rs.getDouble("highestPrice"));
				q.setLowestPrice(rs.getDouble("lowestPrice"));
				q.setCompetitiveBuyPrice(rs.getDouble("competitiveBuyPrice"));
				q.setCompetitiveSalePrice(rs.getDouble("competitiveSalePrice"));
				q.setNumberOfShareTraded(rs.getLong("NumberOfShareTraded"));
				q.setMoneyOfShareTraded(rs.getDouble("moneyOfShareTraded"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy1"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy1"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy2"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy2"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy3"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy3"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy4"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy4"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy5"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy5"));
				q.setAmountOfSale1(rs.getLong("amountOfSale1"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale1"));
				q.setAmountOfSale1(rs.getLong("amountOfSale2"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale2"));
				q.setAmountOfSale1(rs.getLong("amountOfSale3"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale3"));
				q.setAmountOfSale1(rs.getLong("amountOfSale4"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale4"));
				q.setAmountOfSale1(rs.getLong("amountOfSale5"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale5"));
				q.setDate(rs.getDate("date"));
				q.setTime(rs.getDate("time"));
				list.add(q);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}finally{
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		return list;
	}

	@Override
	public void addFutureQuote(FutureQuote quote) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			String sql = "INSERT INTO FUTURE_QUOTE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,quote.getName());
			stmt.setDouble(2,quote.getOpeningPrice());
			stmt.setDouble(3,quote.getClosingPrice());
			stmt.setDouble(4,quote.getCurrentPrice());
			stmt.setDouble(5,quote.getHighestPrice());
			stmt.setDouble(6,quote.getLowestPrice());
			stmt.setDouble(7,quote.getCompetitiveBuyPrice());
			stmt.setDouble(8,quote.getCompetitiveSalePrice());
			stmt.setLong(9,quote.getNumberOfHeld());
			stmt.setLong(10,quote.getNumberOfTraded());
			stmt.setLong(11,quote.getAmountOfBuy());
			stmt.setDouble(12,quote.getPriceOfBuy1());
			stmt.setDouble(13,quote.getPriceOfBuy2());
			stmt.setDouble(14,quote.getPriceOfBuy3());
			stmt.setDouble(15,quote.getPriceOfBuy4());
			stmt.setDouble(16,quote.getPriceOfBuy5());
			stmt.setLong(17,quote.getAmountOfSale());
			stmt.setDouble(18,quote.getPriceOfSale1());
			stmt.setDouble(19,quote.getPriceOfSale2());
			stmt.setDouble(20,quote.getPriceOfSale3());
			stmt.setDouble(21,quote.getPriceOfSale4());
			stmt.setDouble(22,quote.getPriceOfSale5());
			stmt.setDate(23,new Date(quote.getDate().getTime()));
			stmt.setTime(24,new Time(quote.getTime().getTime()));
			stmt.setString(25,quote.getID());
			stmt.setDouble(26,quote.getSettlementPrice());
			stmt.setDouble(27,quote.getLastSettlementPrice());
			stmt.setString(28,quote.getMarket());
			stmt.setString(29,quote.getCategoryName());
			stmt.executeUpdate();
		} finally {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public List<FutureQuote> getFutureQuoteByFutureId(String futureId, int offset, int pageSize) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<FutureQuote> list = new ArrayList<FutureQuote>();
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM FUTURE_QUOTE WHERE ID=? ORDER BY SNO DESC LIMIT ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, futureId);
			stmt.setInt(2, offset);
			stmt.setInt(3, offset+pageSize);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				FutureQuote q = new FutureQuote();
				q.setName(rs.getString("NAME"));
				q.setOpeningPrice(rs.getDouble("OPENINGPRICE"));
				q.setClosingPrice(rs.getDouble("CLOSINGPRICE"));
				q.setCurrentPrice(rs.getDouble("CURRENTPRICE"));
				q.setHighestPrice(rs.getDouble("HIGHESTPRICE"));
				q.setLowestPrice(rs.getDouble("LOWESTPRICE"));
				q.setCompetitiveBuyPrice(rs.getDouble("COMPETITIVEBUYPRICE"));
				q.setCompetitiveSalePrice(rs.getDouble("COMPETITIVESALEPRICE"));
				q.setNumberOfHeld(rs.getLong("NUMBEROFHELD"));
				q.setNumberOfTraded(rs.getLong("NUMBEROFTRADED"));
				q.setAmountOfBuy(rs.getLong("AMOUNTOFBUY"));
				q.setPriceOfBuy1(rs.getDouble("PRICEOFBUY1"));
				q.setPriceOfBuy2(rs.getDouble("PRICEOFBUY2"));
				q.setPriceOfBuy3(rs.getDouble("PRICEOFBUY3"));
				q.setPriceOfBuy4(rs.getDouble("PRICEOFBUY4"));
				q.setPriceOfBuy5(rs.getDouble("PRICEOFBUY5"));
				q.setAmountOfSale(rs.getLong("AMOUNTOFSALE"));
				q.setPriceOfSale1(rs.getDouble("PRICEOFSALE1"));
				q.setPriceOfSale2(rs.getDouble("PRICEOFSALE2"));
				q.setPriceOfSale3(rs.getDouble("PRICEOFSALE3"));
				q.setPriceOfSale4(rs.getDouble("PRICEOFSALE4"));
				q.setPriceOfSale5(rs.getDouble("PRICEOFSALE5"));
				q.setDate(rs.getDate("DATE"));
				q.setTime(rs.getTime("TIME"));
				q.setID(rs.getString("ID"));
				q.setSettlementPrice(rs.getDouble("SETTLEMENTPRICE"));
				q.setLastSettlementPrice(rs.getDouble("LASTSETTLEMENTPRICE"));
				q.setMarket(rs.getString("MARKET"));
				q.setCategoryName(rs.getString("CATEGORY"));
				list.add(q);
			}
			
		} finally {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		return list;
	}

	@Override
	public void addProductQuote(ProductQuote quote) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			String sql = "INSERT INTO PRODUCT_QUOTE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,quote.getName());
			stmt.setDouble(2,quote.getOpeningPrice());
			stmt.setDouble(3,quote.getClosingPrice());
			stmt.setDouble(4,quote.getCurrentPrice());
			stmt.setDouble(5,quote.getHighestPrice());
			stmt.setDouble(6,quote.getLowestPrice());
			stmt.setDouble(7,quote.getCompetitiveBuyPrice());
			stmt.setDouble(8,quote.getCompetitiveSalePrice());
			stmt.setLong(9,quote.getNumberOfHeld());
			stmt.setLong(10,quote.getNumberOfTraded());
			stmt.setLong(11,quote.getAmountOfBuy());
			stmt.setDouble(12,quote.getPriceOfBuy1());
			stmt.setDouble(13,quote.getPriceOfBuy2());
			stmt.setDouble(14,quote.getPriceOfBuy3());
			stmt.setDouble(15,quote.getPriceOfBuy4());
			stmt.setDouble(16,quote.getPriceOfBuy5());
			stmt.setLong(17,quote.getAmountOfSale());
			stmt.setDouble(18,quote.getPriceOfSale1());
			stmt.setDouble(19,quote.getPriceOfSale2());
			stmt.setDouble(20,quote.getPriceOfSale3());
			stmt.setDouble(21,quote.getPriceOfSale4());
			stmt.setDouble(22,quote.getPriceOfSale5());
			stmt.setDate(23,new Date(quote.getDate().getTime()));
			stmt.setTime(24,new Time(quote.getTime().getTime()));
			stmt.setString(25,quote.getID());
			stmt.setDouble(26,quote.getSettlementPrice());
			stmt.setDouble(27,quote.getLastSettlementPrice());
			stmt.setString(28,quote.getMarket());
			stmt.setString(29,quote.getCategoryName());
			stmt.executeUpdate();
		} finally {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public List<StockQuote> getStockQuoteByDate(String stockId, java.util.Date startDate, java.util.Date endDate, int offset,
			int pageSize) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<StockQuote> list = new ArrayList<StockQuote>();
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM STOCK_QUOTE sq WHERE sq.ID=? AND ? <= CONCAT(sq.DATE, sq.TIME) AND ? >= CONCAT(sq.DATE, sq.TIME) ORDER BY sq.SNO ASC LIMIT ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stockId);
			stmt.setDate(2, new java.sql.Date(startDate.getTime()));
			stmt.setDate(3, new java.sql.Date(endDate.getTime()));
			stmt.setInt(4, offset);
			stmt.setInt(5, offset+pageSize);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				StockQuote q = new StockQuote();
				q.setID(rs.getString("ID"));
				q.setName(rs.getString("name"));
				q.setOpeningPrice(rs.getDouble("openingPrice"));
				q.setClosingPrice(rs.getDouble("closingPrice"));
				q.setCurrentPrice(rs.getDouble("currentPrice"));
				q.setHighestPrice(rs.getDouble("highestPrice"));
				q.setLowestPrice(rs.getDouble("lowestPrice"));
				q.setCompetitiveBuyPrice(rs.getDouble("competitiveBuyPrice"));
				q.setCompetitiveSalePrice(rs.getDouble("competitiveSalePrice"));
				q.setNumberOfShareTraded(rs.getLong("NumberOfShareTraded"));
				q.setMoneyOfShareTraded(rs.getDouble("moneyOfShareTraded"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy1"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy1"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy2"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy2"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy3"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy3"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy4"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy4"));
				q.setAmountOfBuy1(rs.getLong("amountOfBuy5"));
				q.setPriceOfBuy1(rs.getDouble("priceOfBuy5"));
				q.setAmountOfSale1(rs.getLong("amountOfSale1"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale1"));
				q.setAmountOfSale1(rs.getLong("amountOfSale2"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale2"));
				q.setAmountOfSale1(rs.getLong("amountOfSale3"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale3"));
				q.setAmountOfSale1(rs.getLong("amountOfSale4"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale4"));
				q.setAmountOfSale1(rs.getLong("amountOfSale5"));
				q.setPriceOfSale1(rs.getDouble("priceOfSale5"));
				q.setDate(rs.getDate("date"));
				q.setTime(rs.getDate("time"));
				list.add(q);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}finally{
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		return list;
	}

	@Override
	public List<FutureQuote> getClosedFutureQuoteByDate(String futureId, java.util.Date startDate, java.util.Date endDate, int offset,
			int pageSize) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<FutureQuote> list = new ArrayList<FutureQuote>();
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM FUTURE_QUOTE sq WHERE sq.ID=? AND ? <= CONCAT(sq.DATE, sq.TIME) AND ? >= CONCAT(sq.DATE, sq.TIME) GROUP BY sq.DATE ORDER BY sq.SNO DESC LIMIT ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, futureId);
			stmt.setDate(2, new java.sql.Date(startDate.getTime()));
			stmt.setDate(3, new java.sql.Date(endDate.getTime()));
			stmt.setInt(4, offset);
			stmt.setInt(5, offset+pageSize);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				FutureQuote q = new FutureQuote();
				q.setName(rs.getString("NAME"));
				q.setOpeningPrice(rs.getDouble("OPENINGPRICE"));
				q.setClosingPrice(rs.getDouble("CLOSINGPRICE"));
				q.setCurrentPrice(rs.getDouble("CURRENTPRICE"));
				q.setHighestPrice(rs.getDouble("HIGHESTPRICE"));
				q.setLowestPrice(rs.getDouble("LOWESTPRICE"));
				q.setCompetitiveBuyPrice(rs.getDouble("COMPETITIVEBUYPRICE"));
				q.setCompetitiveSalePrice(rs.getDouble("COMPETITIVESALEPRICE"));
				q.setNumberOfHeld(rs.getLong("NUMBEROFHELD"));
				q.setNumberOfTraded(rs.getLong("NUMBEROFTRADED"));
				q.setAmountOfBuy(rs.getLong("AMOUNTOFBUY"));
				q.setPriceOfBuy1(rs.getDouble("PRICEOFBUY1"));
				q.setPriceOfBuy2(rs.getDouble("PRICEOFBUY2"));
				q.setPriceOfBuy3(rs.getDouble("PRICEOFBUY3"));
				q.setPriceOfBuy4(rs.getDouble("PRICEOFBUY4"));
				q.setPriceOfBuy5(rs.getDouble("PRICEOFBUY5"));
				q.setAmountOfSale(rs.getLong("AMOUNTOFSALE"));
				q.setPriceOfSale1(rs.getDouble("PRICEOFSALE1"));
				q.setPriceOfSale2(rs.getDouble("PRICEOFSALE2"));
				q.setPriceOfSale3(rs.getDouble("PRICEOFSALE3"));
				q.setPriceOfSale4(rs.getDouble("PRICEOFSALE4"));
				q.setPriceOfSale5(rs.getDouble("PRICEOFSALE5"));
				q.setDate(rs.getDate("DATE"));
				q.setTime(rs.getTime("TIME"));
				q.setID(rs.getString("ID"));
				q.setSettlementPrice(rs.getDouble("SETTLEMENTPRICE"));
				q.setLastSettlementPrice(rs.getDouble("LASTSETTLEMENTPRICE"));
				q.setMarket(rs.getString("MARKET"));
				q.setCategoryName(rs.getString("CATEGORY"));
				list.add(q);
			}
			
		} finally {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		return list;
	}

	@Override
	public List<ProductQuote> getProductQuoteByDate(String productId, java.util.Date startDate, java.util.Date endDate, int offset,
			int pageSize) throws SQLException {
		//TODO
		return null;
	}

	@Override
	public List<FutureQuote> getClosedFutureQuoteByDays(String futureId, int lastDaysCount) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<FutureQuote> list = new ArrayList<FutureQuote>();
		try{
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM FUTURE_QUOTE a WHERE a.ID=? AND a.DATE IN (SELECT * FROM (SELECT DISTINCT fq.DATE FROM FUTURE_QUOTE fq ORDER BY fq.DATE DESC LIMIT 0, ?) AS t) group by a.DATE ORDER BY a.DATE ASC";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, futureId);
			stmt.setInt(2, lastDaysCount);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				FutureQuote q = new FutureQuote();
				q.setName(rs.getString("NAME"));
				q.setOpeningPrice(rs.getDouble("OPENINGPRICE"));
				q.setClosingPrice(rs.getDouble("CLOSINGPRICE"));
				q.setCurrentPrice(rs.getDouble("CURRENTPRICE"));
				q.setHighestPrice(rs.getDouble("HIGHESTPRICE"));
				q.setLowestPrice(rs.getDouble("LOWESTPRICE"));
				q.setCompetitiveBuyPrice(rs.getDouble("COMPETITIVEBUYPRICE"));
				q.setCompetitiveSalePrice(rs.getDouble("COMPETITIVESALEPRICE"));
				q.setNumberOfHeld(rs.getLong("NUMBEROFHELD"));
				q.setNumberOfTraded(rs.getLong("NUMBEROFTRADED"));
				q.setAmountOfBuy(rs.getLong("AMOUNTOFBUY"));
				q.setPriceOfBuy1(rs.getDouble("PRICEOFBUY1"));
				q.setPriceOfBuy2(rs.getDouble("PRICEOFBUY2"));
				q.setPriceOfBuy3(rs.getDouble("PRICEOFBUY3"));
				q.setPriceOfBuy4(rs.getDouble("PRICEOFBUY4"));
				q.setPriceOfBuy5(rs.getDouble("PRICEOFBUY5"));
				q.setAmountOfSale(rs.getLong("AMOUNTOFSALE"));
				q.setPriceOfSale1(rs.getDouble("PRICEOFSALE1"));
				q.setPriceOfSale2(rs.getDouble("PRICEOFSALE2"));
				q.setPriceOfSale3(rs.getDouble("PRICEOFSALE3"));
				q.setPriceOfSale4(rs.getDouble("PRICEOFSALE4"));
				q.setPriceOfSale5(rs.getDouble("PRICEOFSALE5"));
				q.setDate(rs.getDate("DATE"));
				q.setTime(rs.getTime("TIME"));
				q.setID(rs.getString("ID"));
				q.setSettlementPrice(rs.getDouble("SETTLEMENTPRICE"));
				q.setLastSettlementPrice(rs.getDouble("LASTSETTLEMENTPRICE"));
				q.setMarket(rs.getString("MARKET"));
				q.setCategoryName(rs.getString("CATEGORY"));
				list.add(q);
			}
		} finally {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		return list;
	}
	
}
