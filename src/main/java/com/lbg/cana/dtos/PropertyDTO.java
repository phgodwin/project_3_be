package com.lbg.cana.dtos;

public class PropertyDTO {

	private Integer id;

	private String prc;

	private String loc;

	private String pcod;

	private String beds;

	private String bath;

	private String grdn;

	private String status;

	private String sellerName;

//	private List<Booking> booking;

	public PropertyDTO() {
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

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
}
