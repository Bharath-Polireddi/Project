package com.finance.PsnlExp.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "paymentmode")
public class PaymentMode {

	@Id
	@Column(name = "pay_code")
	private String pay_code;

	@Column(name = "user_name")
	private String username;

	@Column(name = "pay_name")
	private String paymentType;

	@Column(name = "remarks")
	private String remarks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "user_name", insertable = false, updatable = false)
	private Users paymentuser;

	@OneToMany(mappedBy = "paymentMode", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Expenditure> expenditures = new ArrayList<Expenditure>();

	public String getPay_code() {
		return pay_code;
	}

	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Users getPaymentuser() {
		return paymentuser;
	}

	public void setPaymentuser(Users paymentuser) {
		this.paymentuser = paymentuser;
	}

	public List<Expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<Expenditure> expenditures) {
		this.expenditures = expenditures;
	}

}
