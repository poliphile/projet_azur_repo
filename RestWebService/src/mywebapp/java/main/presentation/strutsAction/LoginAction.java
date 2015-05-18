/**
 * 
 */
package mywebapp.java.main.presentation.strutsAction;

import mywebapp.java.main.persistance.object.UtilisateurDO;
import mywebapp.java.main.services.LoginService;

/**
 * @author matthieu
 *
 */
public class LoginAction {

	/**
	 * 
	 */
	private String username;

	private String password;

	private LoginService utilisateurService = LoginService.getInstance();

	public String execute() {
		final UtilisateurDO utilisateur = utilisateurService.seConnecter(
				username, password);
		if (utilisateur.getLogin() != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}

	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
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

}
