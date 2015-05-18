/**
 * 
 */
package mywebapp.java.main.services;

import mywebapp.java.main.persistance.daoimpl.UtilisateurDAOImpl;
import mywebapp.java.main.persistance.object.UtilisateurDO;

/**
 * @author matthieu
 *
 */
public class LoginService {

	private static LoginService instance;

	private UtilisateurDAOImpl utilisateurDAO = new UtilisateurDAOImpl();

	private LoginService() {
		// empty Method
	}

	public UtilisateurDO seConnecter(final String login, final String password) {
		final UtilisateurDO utilisateur = utilisateurDAO
				.recupererUtilisateurDO(login, password);
		return utilisateur;

	}

	public static LoginService getInstance() {
		if (instance == null) {
			return new LoginService();
		} else {
			return instance;
		}
	}
}
