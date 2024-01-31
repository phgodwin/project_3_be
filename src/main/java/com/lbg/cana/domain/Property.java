package com.lbg.cana.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String sellnme;

	private String prc;

	private String loc;

	private String pcod;

	private String beds;

	private String bath;

	private String grdn;

	private String status;

	public Property() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSellnme() {
		return sellnme;
	}

	public void setSellnme(String sellnme) {
		this.sellnme = sellnme;
	}

	public String getPrc() {
		return prc;
	}

	public void setPrc(String prc) {
		this.prc = prc;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getPcod() {
		return pcod;
	}

	public void setPcod(String pcod) {
		this.pcod = pcod;
	}

	public String getBeds() {
		return beds;
	}

	public void setBeds(String beds) {
		this.beds = beds;
	}

	public String getBath() {
		return bath;
	}

	public void setBath(String bath) {
		this.bath = bath;
	}

	public String getGrdn() {
		return grdn;
	}

	public void setGrdn(String grdn) {
		this.grdn = grdn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Property: id=" + id + ", Seller Name" + sellnme + ", Price" + prc + ", Location" + loc + ", Postcode"
				+ pcod + ", bedrooms=" + beds + ", bathrooms=" + bath + ", garden=" + grdn + ", status=" + status + "]";
	}

}
