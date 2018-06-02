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
			String sql = "INSERT INTO STOCK_QUOTE(ID,NAME,OPENINGPRICE,CLOSINGPRICE,"
					+ "CURRENTPRICE,HIGHESTPRICE,LOWESTPRICE,COMPETITIVEBUYPRICE,COMPETITIVESALEPRICE,"
					+ "NUMBEROFSHARETRADED,MONEYOFSHARETRADED,AMOUNTOFBUY1,"
					+ "PRICEOFBUY1,AMOUNTOFBUY2,PRICEOFBUY2,AMOUNTOFBUY3,PRICEOFBUY3,"
					+ "AMOUNTOFBUY4,PRICEOFBUY4,AMOUNTOFBUY5,PRICEOFBUY5,AMOUNTOFSALE1,"
					+ "PRICEOFSALE1,AMOUNTOFSALE2,PRICEOFSALE2,AMOUNTOFSALE3,PRICEOFSALE3,"
					+ "AMOUNTOFSALE4,PRICEOFSALE4,AMOUNTOFSALE5,PRICEOFSALE5,DATE,TIME) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			String sql = "INSERT INTO FUTURE_QUOTE(NAME,OPENINGPRICE,CLOSINGPRICE,CURRENTPRICE,"
					+ "HIGHESTPRICE,LOWESTPRICE,COMPETITIVEBUYPRICE,COMPETITIVESALEPRICE,"
					+ "NUMBEROFHELD,NUMBEROFTRADED,AMOUNTOFBUY,PRICEOFBUY1,PRICEOFBUY2,"
					+ "PRICEOFBUY3,PRICEOFBUY4,PRICEOFBUY5,AMOUNTOFSALE,PRICEOFSALE1,PRICEOFSALE2,"
					+ "PRICEOFSALE3,PRICEOFSALE4,PRICEOFSALE5,DATE,TIME,ID,SETTLEMENTPRICE,"
					+ "LASTSETTLEMENTPRICE,MARKET,CATEGORY) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProductQuote(ProductQuote quote) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			String sql = "INSERT INTO PRODUCT_QUOTE(NAME,OPENINGPRICE,CLOSINGPRICE,CURRENTPRICE,"
					+ "HIGHESTPRICE,LOWESTPRICE,COMPETITIVEBUYPRICE,COMPETITIVESALEPRICE,"
					+ "NUMBEROFHELD,NUMBEROFTRADED,AMOUNTOFBUY,PRICEOFBUY1,PRICEOFBUY2,PRICEOFBUY3,"
					+ "PRICEOFBUY4,PRICEOFBUY5,AMOUNTOFSALE,PRICEOFSALE1,PRICEOFSALE2,PRICEOFSALE3,"
					+ "PRICEOFSALE4,PRICEOFSALE5,DATE,TIME,ID,SETTLEMENTPRICE,LASTSETTLEMENTPRICE,"
					+ "MARKET,CATEGORY) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
	public List<ProductQuote> getProductQuoteByProductId(String productId, int offset, int pageSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
