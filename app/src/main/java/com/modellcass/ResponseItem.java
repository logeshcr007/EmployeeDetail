package com.modellcass;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("website")
	private String website;

	@SerializedName("address")
	private Address address;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("company")
	private Company company;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCompany(Company company){
		this.company = company;
	}

	public Company getCompany(){
		return company;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public static class Company{

		@SerializedName("bs")
		private String bs;

		@SerializedName("catchPhrase")
		private String catchPhrase;

		@SerializedName("name")
		private String name;

		public void setBs(String bs){
			this.bs = bs;
		}

		public String getBs(){
			return bs;
		}

		public void setCatchPhrase(String catchPhrase){
			this.catchPhrase = catchPhrase;
		}

		public String getCatchPhrase(){
			return catchPhrase;
		}

		public void setName(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}
	}

	public  static class Address{

		@SerializedName("zipcode")
		private String zipcode;

		@SerializedName("geo")
		private Geo geo;

		@SerializedName("suite")
		private String suite;

		@SerializedName("city")
		private String city;

		@SerializedName("street")
		private String street;

		public void setZipcode(String zipcode){
			this.zipcode = zipcode;
		}

		public String getZipcode(){
			return zipcode;
		}

		public void setGeo(Geo geo){
			this.geo = geo;
		}

		public Geo getGeo(){
			return geo;
		}

		public void setSuite(String suite){
			this.suite = suite;
		}

		public String getSuite(){
			return suite;
		}

		public void setCity(String city){
			this.city = city;
		}

		public String getCity(){
			return city;
		}

		public void setStreet(String street){
			this.street = street;
		}

		public String getStreet(){
			return street;
		}
	}
}