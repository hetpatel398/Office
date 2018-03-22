package abc.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tempfilebse")

public class tempfilebseVO {
	@Id
	@Column(name="tempbtradeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tempbtradeId;
	
	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	@Column(name="mydate")
	private String mydate;

	@Column(name="ScripCode")
	private String ScripCode;
	
	@Column(name="Symbol")
	private String Symbol;

	@Column(name="TradeNo")
	private String TradeNo;

	@Column(name="Price")
	private String Price;

	@Column(name="TradedQty")
	private String TradedQty;

	@Column(name="BrokerId")
	private String BrokerId;

	@Column(name="Reserved")
	private String Reserved;

	@Column(name="TradeEntryTime")
	private String TradeEntryTime;

	@Column(name="TradeEntryDate")
	private String TradeEntryDate;

	@Column(name="ClientId")
	private String ClientId;

	@Column(name="BuySell")
	private String BuySell;

	@Column(name="TransactionType")
	private String TransactionType;

	@Column(name="OrderNumber")
	private String OrderNumber;

	@Column(name="CAClass")
	private String CAClass;

	@Column(name="ISIN")
	private String ISIN;

	@Column(name="ClientAC")
	private String ClientAC;

	@Column(name="NewClient")
	private String NewClient;

	@Column(name="Remarks")
	private String Remarks;

	@Column(name="ISIN1")
	private String ISIN1;

	@Column(name="SecuritySeries")
	private String SecuritySeries;

	@Column(name="SettlementNo")
	private String SettlementNo;

	@Column(name="ProductType")
	private String ProductType;

	@Column(name="OrderModifyTime")
	private String OrderModifyTime;

	@Column(name="OrderEntryTime")
	private String OrderEntryTime;

	@Column(name="DealerCode")
	private String DealerCode;

	@Column(name="PreOpen")
	private String PreOpen;

	@Column(name="SPPreOpen")
	private String SPPreOpen;
	
	@Column(name="Blank")
	private String Blank;
	

	public String getBlank() {
		return Blank;
	}

	public void setBlank(String blank) {
		Blank = blank;
	}

	
	public int getTempbtradeId() {
		return tempbtradeId;
	}

	public void setTempbtradeId(int tempbtradeId) {
		this.tempbtradeId = tempbtradeId;
	}

	public String getScripCode() {
		return ScripCode;
	}

	public void setScripCode(String scripCode) {
		ScripCode = scripCode;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getTradeNo() {
		return TradeNo;
	}

	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getTradedQty() {
		return TradedQty;
	}

	public void setTradedQty(String tradedQty) {
		TradedQty = tradedQty;
	}

	public String getBrokerId() {
		return BrokerId;
	}

	public void setBrokerId(String brokerId) {
		BrokerId = brokerId;
	}

	public String getReserved() {
		return Reserved;
	}

	public void setReserved(String reserved) {
		Reserved = reserved;
	}

	public String getTradeEntryTime() {
		return TradeEntryTime;
	}

	public void setTradeEntryTime(String tradeEntryTime) {
		TradeEntryTime = tradeEntryTime;
	}

	public String getTradeEntryDate() {
		return TradeEntryDate;
	}

	public void setTradeEntryDate(String tradeEntryDate) {
		TradeEntryDate = tradeEntryDate;
	}

	public String getClientId() {
		return ClientId;
	}

	public void setClientId(String clientId) {
		ClientId = clientId;
	}

	public String getBuySell() {
		return BuySell;
	}

	public void setBuySell(String buySell) {
		BuySell = buySell;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getCAClass() {
		return CAClass;
	}

	public void setCAClass(String cAClass) {
		CAClass = cAClass;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public String getClientAC() {
		return ClientAC;
	}

	public void setClientAC(String clientAC) {
		ClientAC = clientAC;
	}

	public String getNewClient() {
		return NewClient;
	}

	public void setNewClient(String newClient) {
		NewClient = newClient;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getISIN1() {
		return ISIN1;
	}

	public void setISIN1(String iSIN1) {
		ISIN1 = iSIN1;
	}

	public String getSecuritySeries() {
		return SecuritySeries;
	}

	public void setSecuritySeries(String securitySeries) {
		SecuritySeries = securitySeries;
	}

	public String getSettlementNo() {
		return SettlementNo;
	}

	public void setSettlementNo(String settlementNo) {
		SettlementNo = settlementNo;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public String getOrderModifyTime() {
		return OrderModifyTime;
	}

	public void setOrderModifyTime(String orderModifyTime) {
		OrderModifyTime = orderModifyTime;
	}

	public String getOrderEntryTime() {
		return OrderEntryTime;
	}

	public void setOrderEntryTime(String orderEntryTime) {
		OrderEntryTime = orderEntryTime;
	}

	public String getDealerCode() {
		return DealerCode;
	}

	public void setDealerCode(String dealerCode) {
		DealerCode = dealerCode;
	}

	public String getPreOpen() {
		return PreOpen;
	}

	public void setPreOpen(String preOpen) {
		PreOpen = preOpen;
	}

	public String getSPPreOpen() {
		return SPPreOpen;
	}

	public void setSPPreOpen(String sPPreOpen) {
		SPPreOpen = sPPreOpen;
	}
	

}
