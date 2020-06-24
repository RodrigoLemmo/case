package br.com.catapi.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Representação do Objeto Gato para consulta de API https://thecatai.com
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatoRetornoBean {
	
	@JsonProperty("breeds")
	private List<RacaRetornoBean> racaRetornoBean;
	
	@JsonProperty("categories")
	private List<CategoriaRetornoBean> categoria;
	
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("width")
	private String width;

	@JsonProperty("height")
	private String height;

	public List<RacaRetornoBean> getRacaRetornoBean() {
		return racaRetornoBean;
	}

	public void setRacaRetornoBean(List<RacaRetornoBean> racaRetornoBean) {
		this.racaRetornoBean = racaRetornoBean;
	}

	public List<CategoriaRetornoBean> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaRetornoBean> categoria) {
		this.categoria = categoria;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	
}
