package com.example.demo.response;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jqueiroz
 *
 */

public class Cambio {


	public Cambio() {
	}

	public Cambio(Long id, String from, String to, BigDecimal conversionFactor, Double convertedValue,String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.convertedValue = convertedValue;
		this.environment = environment;
	}


	private Long id;
	private String from;
	

	private String to;
	

	private BigDecimal conversionFactor;

	private Double convertedValue;

	private String environment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public Double getConvertedValue() {
		return convertedValue;
	}
	public void setConvertedValue(Double convertedValue) {
		this.convertedValue = convertedValue;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
