package _04_xml.dom_example.entities;

public class Student {

	private String  _name;
	private long    _phone;
	private Address _address;
	private String  _login;
	private String  _faculty;

	public Student() {
	}

	public Student(String name, long phone, Address address, String login, String faculty) {
		setName(name);
		setPhone(phone);
		setAddress(address);
		setLogin(login);
		setFaculty(faculty);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public long getPhone() {
		return _phone;
	}

	public void setPhone(long phone) {
		this._phone = phone;
	}

	public Address getAddress() {
		return _address;
	}

	public void setAddress(Address address) {
		this._address = address;
	}

	public String getLogin() {
		return _login;
	}

	public void setLogin(String login) {
		this._login = login;
	}

	public String getFaculty() {
		return _faculty;
	}

	public void setFaculty(String faculty) {
		this._faculty = faculty;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + _name + '\'' + ", phone=" + _phone + ", address=" + _address + ", login='"
				+ _login + '\'' + ", faculty='" + _faculty + '\'' + '}';
	}
}
