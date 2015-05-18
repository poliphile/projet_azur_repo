/**
 *
 */
package mywebapp.java.main.presentation.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Sekioa
 *
 */
@XmlRootElement
public class Person {

	private long id;
	private String firstName;
	private String lastName;
	private String email;

	public Person() {

		id = -1;
		firstName = "";
		lastName = "";
		email = "";

	}

	public Person(final long id, final String firstName, final String lastName,
			final String email) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

}
