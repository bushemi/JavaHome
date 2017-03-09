package _04_xml.dom_example.entities;

public class Address {

    private String _country;
    private String _city;
    private String _street;

	public Address(String country, String city, String street) {
		setCountry(country);
		setCity(city);
		setStreet(street);
	}

	public Address() {
	}

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String street) {
        _street = street;
    }

	@Override
	public String toString() {
		return "Address{" +
				"country='" + _country + '\'' +
				", city='" + _city + '\'' +
				", street='" + _street + '\'' +
				'}';
	}
}
