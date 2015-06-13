/**
 *
 */
package mywebapp.java.main.persistance.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		final CriteriaBuilder builder = emF.getCriteriaBuilder();

		final CriteriaQuery<UtilisateurDO> criteria = builder
				.createQuery(UtilisateurDO.class);
		final Root<UtilisateurDO> utilisateurRoot = criteria
				.from(UtilisateurDO.class);

		criteria.select(utilisateurRoot);
		criteria.where(builder.equal(utilisateurRoot.get("login"), login));
		criteria.where(builder.equal(utilisateurRoot.get("password"), password));

		final UtilisateurDO result = em.createQuery(criteria).getSingleResult();

		em.close();
		emF.close();

		return result;
	}
}
