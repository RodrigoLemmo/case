package br.com.catapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representação do Raça Gato para consulta de API https://thecatai.com
 * */
@JsonIgnoreProperties
public class RacaPeso {

	@JsonProperty("imperial")
	private String imperial;

	@JsonProperty("metric")
	private String metric;


	public String getImperial() {
		return imperial;
	}

	public void setImperial(String imperial) {
		this.imperial = imperial;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}


	
	
	

}
