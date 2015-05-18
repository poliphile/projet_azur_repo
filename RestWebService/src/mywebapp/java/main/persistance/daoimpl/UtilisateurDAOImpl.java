/**
 *
 */
package mywebapp.java.main.persistance.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mywebapp.java.main.persistance.daointerface.IUtilisateurDAO;
import mywebapp.java.main.persistance.object.UtilisateurDO;

/**
 * @author matthieu
 *
 */
public class UtilisateurDAOImpl implements IUtilisateurDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see mywebapp.java.main.persistance.daointerface.IUtilisateurDAO#
	 * recupererUtilisateurDO(java.lang.String, java.lang.String)
	 */
	@Override
	public UtilisateurDO recupererUtilisateurDO(final String login,
			final String password) {

		final EntityManagerFactory emF = new Persistence()
		.createEntityManagerFactory("my-pu");
		final EntityManager em = emF.createEntityManager();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT util.ID , util.NOM , util.PRENOM , util.LOGIN , util.PASSWORD, util.DATE_NAISS , util.IS_ADMIN FROM utilisateur util ");
		queryBuilder.append("WHERE util.LOGIN ='" + login
				+ "' AND util.PASSWORD='" + password + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		final Object[] results = (Object[]) query.getSingleResult();
		final UtilisateurDO utilisateur = new UtilisateurDO();
		if (results != null && results.length != 0) {
			utilisateur.setId((int) results[0]);
			utilisateur.setNom((String) results[1]);
			utilisateur.setPrenom((String) results[2]);
			utilisateur.setLogin((String) results[3]);
			utilisateur.setPassword((String) results[4]);
			utilisateur.setDateNaiss((java.util.Date) results[5]);
			// utilisateur.setIsAdmin((int) results[6]);
		}

		return utilisateur;
	}

}
