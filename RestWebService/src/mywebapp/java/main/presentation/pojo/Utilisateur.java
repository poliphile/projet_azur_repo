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
public class Utilisateur {

	private long id;
	private String user;
	private String password;
	private String isConnect;

	public Utilisateur() {

		id = -1;
		user = "";
		password = "";

	}

	public Utilisateur(final long id, final String user, final String password) {

		this.id = id;
		this.user = user;
		this.password = password;
		this.isConnect = "false";
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
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the isConnect
	 */
	public String getIsConnect() {
		return isConnect;
	}

	/**
	 * @param isConnect
	 *            the isConnect to set
	 */
	public void setIsConnect(final String isConnect) {
		this.isConnect = isConnect;
	}

}
