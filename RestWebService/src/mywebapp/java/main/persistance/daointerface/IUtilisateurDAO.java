/**
 *
 */
package mywebapp.java.main.persistance.daointerface;

import mywebapp.java.main.persistance.object.UtilisateurDO;

/**
 * @author matthieu
 *
 */
public interface IUtilisateurDAO {

	/**
	 *
	 * Permet de récupérer un utilisateur en base
	 *
	 * @param login
	 * @param password
	 * @return UtilisateurDO
	 */
	public UtilisateurDO recupererUtilisateurDO(final String login,
			final String password);

}
