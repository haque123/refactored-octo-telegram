package com.covid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.error.validator.Author;

import java.math.BigDecimal;

@Entity
public class Covid {

    @Id
    @GeneratedValue
    private Long id;
   

    
    @Override
	public String toString() {
		return "Covid [id=" + id + ", TotalTestResult=" + TotalTestResult + ", positive=" + positive + ", engative="
				+ engative + ", deths=" + deths + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalTestResult() {
		return TotalTestResult;
	}

	public void setTotalTestResult(Double totalTestResult) {
		TotalTestResult = totalTestResult;
	}

	public Double getPositive() {
		return positive;
	}

	public void setPositive(Double positive) {
		this.positive = positive;
	}

	public Double getEngative() {
		return engative;
	}

	public void setEngative(Double engative) {
		this.engative = engative;
	}

	public Double getDeths() {
		return deths;
	}

	public void setDeths(Double deths) {
		this.deths = deths;
	}

	private Double TotalTestResult;
 
    private Double positive;

  
    private Double engative;


    private Double deths;
    
    // avoid this "No default constructor for entity"
    public Covid() {
    }

	public Covid(Long id, Double totalTestResult, Double positive, Double engative, Double deths) {
		super();
		this.id = id;
		TotalTestResult = totalTestResult;
		this.positive = positive;
		this.engative = engative;
		this.deths = deths;
	}

	public Covid(Double totalTestResult, Double positive, Double engative, Double deths) {
	
		TotalTestResult = totalTestResult;
		this.positive = positive;
		this.engative = engative;
		this.deths = deths;
	}
    
   
   

  
}
