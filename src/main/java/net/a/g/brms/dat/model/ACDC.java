package net.a.g.brms.dat.model;

import java.math.BigDecimal;

public class ACDC {

	private int id;
	private String contract;
	private String type;
	private String currency;
	private boolean status;
	private BigDecimal amount;
	private String garant;
	private String garantType;

	public ACDC() {
		super();
	}

	public ACDC(String contract) {
		super();
		this.contract = contract;

	}

	public ACDC(String contract, String type) {
		super();
		this.contract = contract;
		this.type = type;

	}

	public ACDC(String contract, String type, String currency) {
		super();
		this.contract = contract;
		this.type = type;
		this.currency = currency;

	}

	public ACDC(String contract, String type, String currency, boolean status) {
		super();
		this.contract = contract;
		this.type = type;
		this.currency = currency;
		this.status = status;

	}

	public ACDC(String contract, String type, String currency, boolean status, BigDecimal amount) {
		super();
		this.contract = contract;
		this.type = type;
		this.currency = currency;
		this.status = status;
		this.amount = amount;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getGarant() {
		return garant;
	}

	public void setGarant(String garant) {
		this.garant = garant;
	}

	public String getGarantType() {
		return garantType;
	}

	public void setGarantType(String garantType) {
		this.garantType = garantType;
	}

}
