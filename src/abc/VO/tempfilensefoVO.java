package abc.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tempfilensefo")

public class tempfilensefoVO {
	
	@Id
	@Column(name="tempftradeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tempftradeId;
	
	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	@Column(name="mydate")
	private String mydate;
	
	@Column(name="TradeNo")
	private String TradeNo;

	@Column(name="TradeStatus")
	private String TradeStatus;

	@Column(name="InstrumentName")
	private String InstrumentName;
	
	@Column(name="Symbol")
	private String Symbol;

	@Column(name="ExpiryDate")
	private String ExpiryDate;

	@Column(name="StrikePrice")
	private String StrikePrice;
	
	@Column(name="OptionType")
	private String OptionType;
	
	@Column(name="SecurityName")
	private String SecurityName;
	
	@Column(name="BookType")
	private String BookType;

	@Column(name="BookTypeName")
	private String BookTypeName;
	
	@Column(name="MarketType")	
	private String MarketType;
	
	@Column(name="UserID")
	private String UserID;
	
	@Column(name="BranchID")
	private String BranchID;
	
	@Column(name="BuySell")
	private String BuySell;
	
	@Column(name="QtyTraded")
	private String QtyTraded;
	
	@Column(name="Price")
	private String Price;
	
	@Column(name="ProCli")
	private String ProCli;
	
	@Column(name="ClientAC")
	private String ClientAC;
	
	@Column(name="ParticipantCode")
	private String ParticipantCode;
	
	@Column(name="OpenClose")
	private String OpenClose;
	
	@Column(name="CoverUncover")
	private String CoverUncover;
	
	@Column(name="EntryTime")
	private String EntryTime;
	
	@Column(name="ModifyDateTime")
	private String ModifyDateTime;
	
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

	@Column(name="OrderTime")
	private String OrderTime;
	
	@Column(name="OrderEntryTime")
	private String OrderEntryTime;
	
	@Column(name="ProductType")
	private String ProductType;
	
	@Column(name="LegIndicator")
	private String LegIndicator;

	
	public int getTempftradeId() {
		return tempftradeId;
	}

	public void setTempftradeId(int tempftradeId) {
		this.tempftradeId = tempftradeId;
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

	public String getInstrumentName() {
		return InstrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		InstrumentName = instrumentName;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public String getStrikePrice() {
		return StrikePrice;
	}

	public void setStrikePrice(String strikePrice) {
		StrikePrice = strikePrice;
	}

	public String getOptionType() {
		return OptionType;
	}

	public void setOptionType(String optionType) {
		OptionType = optionType;
	}

	public String getSecurityName() {
		return SecurityName;
	}

	public void setSecurityName(String securityName) {
		SecurityName = securityName;
	}

	public String getBookType() {
		return BookType;
	}

	public void setBookType(String bookType) {
		BookType = bookType;
	}

	public String getBookTypeName() {
		return BookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		BookTypeName = bookTypeName;
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

	public String getQtyTraded() {
		return QtyTraded;
	}

	public void setQtyTraded(String qtyTraded) {
		QtyTraded = qtyTraded;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
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

	public String getOpenClose() {
		return OpenClose;
	}

	public void setOpenClose(String openClose) {
		OpenClose = openClose;
	}

	public String getCoverUncover() {
		return CoverUncover;
	}

	public void setCoverUncover(String coverUncover) {
		CoverUncover = coverUncover;
	}

	public String getEntryTime() {
		return EntryTime;
	}

	public void setEntryTime(String entryTime) {
		EntryTime = entryTime;
	}

	public String getModifyDateTime() {
		return ModifyDateTime;
	}

	public void setModifyDateTime(String modifyDateTime) {
		ModifyDateTime = modifyDateTime;
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

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public String getLegIndicator() {
		return LegIndicator;
	}

	public void setLegIndicator(String legIndicator) {
		LegIndicator = legIndicator;
	}


}
