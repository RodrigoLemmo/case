package br.com.catapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties
public class RacaRetornoBean {
	
	
	@JsonProperty("weight")
	private RacaPeso weight;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("cfa_url")
	private String cfaUrl;
	
	@JsonProperty("vetstreet_url")
	private String vetStreetUrl;

	@JsonProperty("vcahospitals_url")
	private String vcaHopistalsUrl;
	
	@JsonProperty("temperament")
	private String temperament;
	
	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("country_codes")
	private String countryCodes;
	

	@JsonProperty("country_code")
	private String countryCode;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("life_span")
	private String lifeSpan;
	
	@JsonProperty("indoor")
	private String indoor;
	
	@JsonProperty("lap")
	private String lap;
	
	@JsonProperty("alt_names")
	private String altNames;
	
	@JsonProperty("adaptability")
	private String adaptability;
	
	@JsonProperty("affection_level")
	private String affectionLevel;
	
	@JsonProperty("child_friendly")
	private String childFriendly;
	
	@JsonProperty("dog_friendly")
	private String dogFriendly;
	
	@JsonProperty("energy_level")
	private String energyLevel;
	
	@JsonProperty("grooming")
	private String grooming;
	
	@JsonProperty("health_issues")
	private String healthIssues;
	
	@JsonProperty("intelligence")
	private String intelligence;
	
	@JsonProperty("shedding_level")
	private String sheddingLevel;
	
	@JsonProperty("social_needs")
	private String socialNeeds;
	
	@JsonProperty("stranger_friendly")
	private String strangerFriendly;
	
	@JsonProperty("vocalisation")
	private String vocalisation;
	
	@JsonProperty("experimental")
	private String experimental;
	
	@JsonProperty("hairless")
	private String hairless;
	
	@JsonProperty("natural")
	private String natural;

	@JsonProperty("rare")
	private String rare;
	
	@JsonProperty("rex")
	private String rex;
	
	@JsonProperty("suppressed_tail")
	private String suppressedTail;
	
	@JsonProperty("short_legs")
	private String shortLegs;
	
	@JsonProperty("wikipedia_url")
	private String wikipediaUrl;

	@JsonProperty("hypoallergenic")
	private String hypoallergenic;
	
	
	@JsonProperty("cat_friendly")
	private String catFriendly;
	
	@JsonProperty("bidability")
	private String bidability;
	
	

	public RacaPeso getWeight() {
		return weight;
	}

	public void setWeight(RacaPeso weight) {
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCfaUrl() {
		return cfaUrl;
	}

	public void setCfaUrl(String cfaUrl) {
		this.cfaUrl = cfaUrl;
	}

	public String getVetStreetUrl() {
		return vetStreetUrl;
	}

	public void setVetStreetUrl(String vetStreetUrl) {
		this.vetStreetUrl = vetStreetUrl;
	}

	public String getVcaHopistalsUrl() {
		return vcaHopistalsUrl;
	}

	public void setVcaHopistalsUrl(String vcaHopistalsUrl) {
		this.vcaHopistalsUrl = vcaHopistalsUrl;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(String countryCodes) {
		this.countryCodes = countryCodes;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getIndoor() {
		return indoor;
	}

	public void setIndoor(String indoor) {
		this.indoor = indoor;
	}

	public String getLap() {
		return lap;
	}

	public void setLap(String lap) {
		this.lap = lap;
	}

	public String getAltNames() {
		return altNames;
	}

	public void setAltNames(String altNames) {
		this.altNames = altNames;
	}

	public String getAdaptability() {
		return adaptability;
	}

	public void setAdaptability(String adaptability) {
		this.adaptability = adaptability;
	}

	public String getAffectionLevel() {
		return affectionLevel;
	}

	public void setAffectionLevel(String affectionLevel) {
		this.affectionLevel = affectionLevel;
	}

	public String getChildFriendly() {
		return childFriendly;
	}

	public void setChildFriendly(String childFriendly) {
		this.childFriendly = childFriendly;
	}

	public String getDogFriendly() {
		return dogFriendly;
	}

	public void setDogFriendly(String dogFriendly) {
		this.dogFriendly = dogFriendly;
	}

	public String getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(String energyLevel) {
		this.energyLevel = energyLevel;
	}

	public String getGrooming() {
		return grooming;
	}

	public void setGrooming(String grooming) {
		this.grooming = grooming;
	}

	public String getHealthIssues() {
		return healthIssues;
	}

	public void setHealthIssues(String healthIssues) {
		this.healthIssues = healthIssues;
	}

	public String getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}

	public String getSheddingLevel() {
		return sheddingLevel;
	}

	public void setSheddingLevel(String sheddingLevel) {
		this.sheddingLevel = sheddingLevel;
	}

	public String getSocialNeeds() {
		return socialNeeds;
	}

	public void setSocialNeeds(String socialNeeds) {
		this.socialNeeds = socialNeeds;
	}

	public String getStrangerFriendly() {
		return strangerFriendly;
	}

	public void setStrangerFriendly(String strangerFriendly) {
		this.strangerFriendly = strangerFriendly;
	}

	public String getVocalisation() {
		return vocalisation;
	}

	public void setVocalisation(String vocalisation) {
		this.vocalisation = vocalisation;
	}

	public String getExperimental() {
		return experimental;
	}

	public void setExperimental(String experimental) {
		this.experimental = experimental;
	}

	public String getHairless() {
		return hairless;
	}

	public void setHairless(String hairless) {
		this.hairless = hairless;
	}

	public String getNatural() {
		return natural;
	}

	public void setNatural(String natural) {
		this.natural = natural;
	}

	public String getRare() {
		return rare;
	}

	public void setRare(String rare) {
		this.rare = rare;
	}

	public String getRex() {
		return rex;
	}

	public void setRex(String rex) {
		this.rex = rex;
	}

	public String getSuppressedTail() {
		return suppressedTail;
	}

	public void setSuppressedTail(String suppressedTail) {
		this.suppressedTail = suppressedTail;
	}

	public String getShortLegs() {
		return shortLegs;
	}

	public void setShortLegs(String shortLegs) {
		this.shortLegs = shortLegs;
	}

	public String getWikipediaUrl() {
		return wikipediaUrl;
	}

	public void setWikipediaUrl(String wikipediaUrl) {
		this.wikipediaUrl = wikipediaUrl;
	}

	public String getHypoallergenic() {
		return hypoallergenic;
	}

	public void setHypoallergenic(String hypoallergenic) {
		this.hypoallergenic = hypoallergenic;
	}

	public String getCatFriendly() {
		return catFriendly;
	}

	public void setCatFriendly(String catFriendly) {
		this.catFriendly = catFriendly;
	}

	public String getBidability() {
		return bidability;
	}

	public void setBidability(String bidability) {
		this.bidability = bidability;
	}


	
	
	
	

}
