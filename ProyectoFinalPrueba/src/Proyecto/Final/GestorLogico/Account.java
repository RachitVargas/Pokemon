package Proyecto.Final.GestorLogico;

public class Account {

	private String user;
	private String password;
	private String account;
	private String age;
	private String country;
	private String gender;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", password=" + password + ", account=" + account + ", age=" + age
				+ ", country=" + country + ", gender=" + gender + "]";
	}

	public String toStringCsv() {
		return user + "," + password + "," + account;
	}

	public String toStringCsvDataAccount() {
		return account + "," + age + "," + country + "," + gender;
	}

}
