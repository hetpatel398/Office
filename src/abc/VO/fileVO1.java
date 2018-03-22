package abc.VO;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filense")
public class fileVO1 {

	@Id
	@Column(name="tradeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tradeId;
	
	@Column(name="TradeNo")
	private String TradeNo;
	
	@Column(name="mydate")
	private String mydate;
	
	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	@Column(name="TradeStatus")
	private String TradeStatus;

	@Column(name="Symbol")
	private String Symbol;
	
	@Column(name="Series")
	private String Series;
	
	@Column(name="SecurityName")
	private String SecurityName;
	
	@Column(name="InstrumentType")
	private String InstrumentType;
	
	@Column(name="BookType")
	private String BookType;
	
	@Column(name="MarketType")	
	private String MarketType;
	
	@Column(name="UserID")
	private String UserID;
	
	@Column(name="BranchID")
	private String BranchID;
	
	@Column(name="BuySell")
	private String BuySell;
	
	@Column(name="TradeQty")
	private String TradeQty;
	
	@Column(name="TradePrice")
	private String TradePrice;
	
	@Column(name="ProCli")
	private String ProCli;
	
	@Column(name="ClientAC")
	private String ClientAC;
	
	@Column(name="ParticipantCode")
	private String ParticipantCode;
	
	@Column(name="AuctionPartType")
	private String AuctionPartType;
	
	@Column(name="AuctionNo")
	private String AuctionNo;
	
	@Column(name="SettPeriod")
	private String SettPeriod;
	
	@Column(name="TradeEntryDateTime")
	private String TradeEntryDateTime;
	
	@Column(name="TradeModifyDateTime")
	private String TradeModifyDateTime;
	
	@Column(name="OrderNo")
	private String OrderNo;
	
	@Column(name="CPId")
	private String CPId;
	
	@Column(name="ExchangeSegment")
	private String ExchangeSegment;
	
	@Column(name="ClientCode")
	private String ClientCode;
	
	@Column(name="Alias")
	private String Alias;
	
	@Column(name="Remarks")
	private String Remarks;
	
	@Column(name="ProductType")
	private String ProductType;
	
	@Column(name="OrderTime")
	private String OrderTime;
	
	@Column(name="OrderEntryTime")
	private String OrderEntryTime;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeNo() {
		return TradeNo;
	}

	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}

	public String getTradeStatus() {
		return TradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		TradeStatus = tradeStatus;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getSeries() {
		return Series;
	}

	public void setSeries(String series) {
		Series = series;
	}

	public String getSecurityName() {
		return SecurityName;
	}

	public void setSecurityName(String securityName) {
		SecurityName = securityName;
	}

	public String getInstrumentType() {
		return InstrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		InstrumentType = instrumentType;
	}

	public String getBookType() {
		return BookType;
	}

	public void setBookType(String bookType) {
		BookType = bookType;
	}

	public String getMarketType() {
		return MarketType;
	}

	public void setMarketType(String marketType) {
		MarketType = marketType;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getBranchID() {
		return BranchID;
	}

	public void setBranchID(String branchID) {
		BranchID = branchID;
	}

	public String getBuySell() {
		return BuySell;
	}

	public void setBuySell(String buySell) {
		BuySell = buySell;
	}

	public String getTradeQty() {
		return TradeQty;
	}

	public void setTradeQty(String tradeQty) {
		TradeQty = tradeQty;
	}

	public String getTradePrice() {
		return TradePrice;
	}

	public void setTradePrice(String tradePrice) {
		TradePrice = tradePrice;
	}

	public String getProCli() {
		return ProCli;
	}

	public void setProCli(String proCli) {
		ProCli = proCli;
	}

	public String getClientAC() {
		return ClientAC;
	}

	public void setClientAC(String clientAC) {
		ClientAC = clientAC;
	}

	public String getParticipantCode() {
		return ParticipantCode;
	}

	public void setParticipantCode(String participantCode) {
		ParticipantCode = participantCode;
	}

	public String getAuctionPartType() {
		return AuctionPartType;
	}

	public void setAuctionPartType(String auctionPartType) {
		AuctionPartType = auctionPartType;
	}

	public String getAuctionNo() {
		return AuctionNo;
	}

	public void setAuctionNo(String auctionNo) {
		AuctionNo = auctionNo;
	}

	public String getSettPeriod() {
		return SettPeriod;
	}

	public void setSettPeriod(String settPeriod) {
		SettPeriod = settPeriod;
	}

	public String getTradeEntryDateTime() {
		return TradeEntryDateTime;
	}

	public void setTradeEntryDateTime(String tradeEntryDateTime) {
		TradeEntryDateTime = tradeEntryDateTime;
	}

	public String getTradeModifyDateTime() {
		return TradeModifyDateTime;
	}

	public void setTradeModifyDateTime(String tradeModifyDateTime) {
		TradeModifyDateTime = tradeModifyDateTime;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	public String getCPId() {
		return CPId;
	}

	public void setCPId(String cPId) {
		CPId = cPId;
	}

	public String getExchangeSegment() {
		return ExchangeSegment;
	}

	public void setExchangeSegment(String exchangeSegment) {
		ExchangeSegment = exchangeSegment;
	}

	public String getClientCode() {
		return ClientCode;
	}

	public void setClientCode(String clientCode) {
		ClientCode = clientCode;
	}

	public String getAlias() {
		return Alias;
	}

	public void setAlias(String alias) {
		Alias = alias;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public String getOrderEntryTime() {
		return OrderEntryTime;
	}

	public void setOrderEntryTime(String orderEntryTime) {
		OrderEntryTime = orderEntryTime;
	}	
}
