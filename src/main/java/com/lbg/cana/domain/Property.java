package com.lbg.cana.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String prc;
	@Column(nullable = false)
	private String loc;
	@Column(nullable = false)
	private String pcod;
	@Column(nullable = false)
	private String beds;
	@Column(nullable = false)
	private String bath;
	@Column(nullable = false)
	private String grdn;

	private String status;

	@JsonBackReference(value = "seller")
	@ManyToOne
	private Seller seller;

	@JsonBackReference(value = "property")
	@OneToMany(mappedBy = "property")
	private List<Booking> bookings;

	public Property() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Property: [ID = " + id + ", Price = " + prc + ", Location = " + loc + ", PostCode = " + pcod
				+ ", Bedrooms = " + beds + ", Bathrooms = " + bath + ", Garden = " + grdn + ", Status = " + status
				+ "]";
	}

}
