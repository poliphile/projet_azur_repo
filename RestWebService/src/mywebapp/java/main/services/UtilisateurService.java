/**
 *
 */
package mywebapp.java.main.services;

import mywebapp.java.main.persistance.daoimpl.UtilisateurDAOImpl;
import mywebapp.java.main.persistance.object.UtilisateurDO;
import mywebapp.java.main.presentation.utilisateur.bean.UtilisateurDTO;

/**
 * @author matthieu
 *
 */
public class UtilisateurService {

	private static UtilisateurService instance;

	private final UtilisateurDAOImpl utilisateurDAO = new UtilisateurDAOImpl();

	private UtilisateurService() {
		// empty Method
	}

	public UtilisateurDTO rechercherUtilisateur(final String login,
			final String password) {
		final UtilisateurDO utilisateur = utilisateurDAO
				.recupererUtilisateurDO(login, password);
		return utilisateurDOtoDTO(utilisateur);
	}

	public static UtilisateurService getInstance() {
		if (instance == null) {
			return new UtilisateurService();
		} else {
			return instance;
		}
	}

	private UtilisateurDTO utilisateurDOtoDTO(final UtilisateurDO utilisateurDO) {
		final UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

		utilisateurDTO.setId(utilisateurDO.getId());
		utilisateurDTO.setLogin(utilisateurDO.getLogin());
		utilisateurDTO.setPassword(utilisateurDO.getPassword());
		utilisateurDTO.setDateNaiss(utilisateurDO.getDateNaiss());
		utilisateurDTO.setNom(utilisateurDO.getNom());
		utilisateurDTO.setPrenom(utilisateurDO.getPrenom());

		return utilisateurDTO;
	}
}
