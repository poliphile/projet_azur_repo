/**
 *
 */
package mywebapp.java.main.persistance.daointerface;

import mywebapp.java.main.persistance.object.UtilisateurSerieDO;

/**
 * @author Sekioa
 *
 */
public interface IUtilisateurSerieDAO {

	boolean creerUtilisateurSerieDO(final UtilisateurSerieDO utilisateurSerieDO);

	boolean modifierUtilisateurSerieDO(
			final UtilisateurSerieDO utilisateurSerieDO);

	boolean supprimerUtilisateurSerieDO(
			final UtilisateurSerieDO utilisateurSerieDO);

	void updateUtilisateurSerieDO(String numeroSerie, String user, int score);

}
