package model;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 2906642554793891381L;
	private String street;
	private String number;
	private String city;
	private String country;

	public Address() {
	}

	public Address(String street, String number, String city, String country) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Address generateAddress(int br){
		switch(br){
			case 1:
				//Address address = new Address("\u0160afarikova","2","Novi Sad","Srbija");
				return new Address("\u0160afarikova","2","Novi Sad","Srbija");
			case 2:
				return new Address("Nikole Tesle","56","Novi Sad","Srbija");

			case 3:
				return new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija");

			case 4:
				return new Address("Stra\u017Eilovska","6a","Novi Sad","Srbija");

			case 5:
				return new Address("Nikole Pa\u0161i\u0107a","2d","Kikinda","Srbija");

			case 6:
				return new Address("Bulevar Kralja Petra","22", "Ni\u0161","Srbija");

			case 7:
				return new Address("Tolstojeva","31","Novi Sad","Srbija");

			case 8:
				return new Address("Mari\u0107eva","11","Kragujevac","Srbija");

			case 9:
				return new Address("Stra\u017Eilovska","3","Beograd","Srbija");

			case 10:
				return new Address("Nikole Pa\u0161i\u0107a","6a","Novi Sad","Srbija");

			case 11:
				return new Address("Bulevar Kralja Petra","2d","Ni\u0161","Srbija");

			case 12:
				return new Address("Knez Mihajlova","22","Beograd","Srbija");
			default:
				return new Address("N","N","N","N");
		}
	}

}
