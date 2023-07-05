package testingOpencartE2E;

public class informacionUsuario {
	public String firstname;
	public String lastname;
	public String email;
	public String phone;
	public String address;
	public String city;
	public String postalcode;
	public String country;
	public String countryvalue;
	public String state;
	public String statevalue;
	
	public informacionUsuario() {
		// TODO Auto-generated constructor stub
		super();
		this.firstname = "Guest";
		this.lastname = "Test Name";
		this.email = "Guest@g.com";
		this.phone = "0123456789";
		this.address = "GuestHouse";
		this.city = "Quito";
		this.postalcode = "74593E";
		this.country = "Ecuador";
		this.countryvalue = "62";
		this.state = "Pichincha";
		this.statevalue = "997";
	
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public String getCountry() {
		return country;
	}
	public String getCountryvalue() {
		return countryvalue;
	}
	public String getState() {
		return state;
	}
	public String getStatevalue() {
		return statevalue;
	}
}
