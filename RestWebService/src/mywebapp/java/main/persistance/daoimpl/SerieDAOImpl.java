/**
 *
 */
package mywebapp.java.main.persistance.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mywebapp.java.main.persistance.daointerface.ISerieDAO;
import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.persistance.object.SerieDO;
import mywebapp.java.main.persistance.object.UtilisateurQuestionDO;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author matthieu
 *
 */
public class SerieDAOImpl implements ISerieDAO {

	final EntityManagerFactory emF = new Persistence()
			.createEntityManagerFactory("my-pu");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mywebapp.java.main.persistance.daointerface.ISerieDAO#lancerSerie(int)
	 */
	@Override
	@Transactional
	public String lancerSerie(final int numeroSerie) {
		final EntityManager em = emF.createEntityManager();
		em.getTransaction().begin();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("UPDATE serie SET serie.IS_ACTIVE = '1' WHERE serie.NUM_SERIE =' "
						+ numeroSerie + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		query.executeUpdate();
		em.getTransaction().commit();
		return "success";

	}

	@Override
	@Transactional
	public String closeConnexion(final String numeroSerie) {
		final EntityManager em = emF.createEntityManager();
		em.getTransaction().begin();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("UPDATE serie SET serie.IS_ACTIVE = '0' WHERE serie.NUM_SERIE =' "
						+ numeroSerie + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		query.executeUpdate();
		em.getTransaction().commit();
		return "SUCCESS";
	}

	@Override
	public QuestionDO recupererQuestionDO(final String numSerie,
			final int numQuestion) {

		final EntityManager em = emF.createEntityManager();

		final CriteriaBuilder builder = emF.getCriteriaBuilder();
		final CriteriaQuery<QuestionDO> criteria = builder
				.createQuery(QuestionDO.class);
		final Root<QuestionDO> questionRoot = criteria.from(QuestionDO.class);
		criteria.select(questionRoot);
		criteria.where(
				builder.equal(questionRoot.get("num_question"), numQuestion),
				builder.equal(questionRoot.get("id_serie"),
						Integer.parseInt(numSerie)));

		final QuestionDO questionDO = em.createQuery(criteria).getResultList()
				.get(0);

		return questionDO;
	}

	@Override
	public String repondreQuestion(final String reponse1,
			final String numeroSerie, final int numeroQuestion) {
		final EntityManager em = emF.createEntityManager();
		em.getTransaction().begin();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("UPDATE question SET question.REPONSE1 = '"
				+ reponse1 + "' WHERE question.ID_SERIE =' " + numeroSerie
				+ "' AND question.NUM_QUESTION = '" + numeroQuestion + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		query.executeUpdate();
		em.getTransaction().commit();
		return "success";
	}

	@Override
	public String ajoutQuestion(final QuestionDO questionToADD) {

		final EntityManager em = emF.createEntityManager();
		em.getTransaction().begin();
		em.persist(questionToADD);
		em.getTransaction().commit();
		return "success";
	}

	@Override
	public SerieDO recupererSerieEnCours() {
		final EntityManager em = emF.createEntityManager();
		final SerieDO serieDO = new SerieDO();

		final CriteriaBuilder builder = emF.getCriteriaBuilder();
		final CriteriaQuery<SerieDO> criteria = builder
				.createQuery(SerieDO.class);
		final Root<SerieDO> serieRoot = criteria.from(SerieDO.class);
		criteria.select(serieRoot);
		criteria.where(builder.equal(serieRoot.get("is_active"), 1));
		final List<SerieDO> serieDOs = em.createQuery(criteria).getResultList();

		return serieDOs.get(0);
	}

	@Override
	public List<UtilisateurQuestionDO> getAllReponse(final String numeroSerie,
			final String reponse1, final String reponse2,
			final String numeroQuestion, final String user) {

		final EntityManager em = emF.createEntityManager();
		final UtilisateurQuestionDO utilisateurQuestionDO = new UtilisateurQuestionDO();

		final CriteriaBuilder builder = emF.getCriteriaBuilder();
		final CriteriaQuery<UtilisateurQuestionDO> criteria = builder
				.createQuery(UtilisateurQuestionDO.class);
		final Root<UtilisateurQuestionDO> utilisateurQuestionRoot = criteria
				.from(UtilisateurQuestionDO.class);
		criteria.select(utilisateurQuestionRoot);
		criteria.where(builder.equal(
				utilisateurQuestionRoot.get("id_question"), numeroQuestion));
		criteria.where(builder.equal(
				utilisateurQuestionRoot.get("id_utilisateur"), user));

		final List<UtilisateurQuestionDO> utilisateurQuestionDOs = em
				.createQuery(criteria).getResultList();

		return utilisateurQuestionDOs;
	}
}
