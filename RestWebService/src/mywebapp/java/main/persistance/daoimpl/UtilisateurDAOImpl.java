/**
 *
 */
package mywebapp.java.main.persistance.daoimpl;

import java.util.Date;

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

	@Override
	public UtilisateurDO recupererUtilisateurDOByNaissance(final String login,
			final Date dateNaissance) {
		final EntityManagerFactory emF = new Persistence()
				.createEntityManagerFactory("my-pu");
		final EntityManager em = emF.createEntityManager();
		final CriteriaBuilder builder = emF.getCriteriaBuilder();

		final CriteriaQuery<UtilisateurDO> criteria = builder
				.createQuery(UtilisateurDO.class);
		final Root<UtilisateurDO> utilisateurRoot = criteria
				.from(UtilisateurDO.class);

		criteria.select(utilisateurRoot);
		criteria.where(builder.equal(utilisateurRoot.get("login"), login),
				builder.equal(utilisateurRoot.get("dateNaiss"), dateNaissance));

		System.out.println("dateNaissanece = " + dateNaissance.toString());
		final UtilisateurDO result = em.createQuery(criteria).getSingleResult();

		em.close();
		emF.close();

		return result;

	}

	@Override
	public UtilisateurDO updateUtilisateurPassword(final String login,
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

		final UtilisateurDO utilisateurDO = em.createQuery(criteria)
				.getSingleResult();

		em.getTransaction().begin();

		final UtilisateurDO utilisateurDOPersist = em.find(UtilisateurDO.class,
				utilisateurDO.getId());

		utilisateurDOPersist.setPassword(password);

		em.getTransaction().commit();

		em.close();
		emF.close();

		return utilisateurDO;
	}
}
