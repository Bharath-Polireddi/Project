package com.finance.PsnlExp.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Expenditure")
public class Expenditure {
 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exp_id")
	private int expid; 
	
	@Column(name ="amount")
	private Double amount; 
	
	@Column(name = "spent_on")
	private Date date;
	
	@Column(name = "descptn")
	private String  description;
	
	@Column(name = "remarks")
	private String  remark;
	
	@Column(name = "tags")
	private String  tag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_name")
	@JsonIgnore
	private Users expuser;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name ="category_code")
	private Category category;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="pay_code")
	@JsonIgnore
	private PaymentMode  paymentMode;

	public int getExpenditureId() {
		return expid;
	}

	public void setExpenditureId(int expenditureId) {
		this.expid = expenditureId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Users getExpuser() {
		return expuser;
	}

	public void setExpuser(Users expuser) {
		this.expuser = expuser;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}


	
}
