/**
 *
 */
package mywebapp.java.main.persistance.daoimpl;

import java.util.Date;
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

		final List<QuestionDO> listQuestionDO = em.createQuery(criteria)
				.getResultList();
		QuestionDO questionDO = null;
		if (listQuestionDO != null && listQuestionDO.size() > 0) {
			questionDO = listQuestionDO.get(0);
		}
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
		if (questionToADD.getImage() != null) {

			em.merge(questionToADD);

		} else {
			final StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("UPDATE question SET ENONCE='"
					+ questionToADD.getEnonce() + "' ,REPONSE1='"
					+ questionToADD.getReponse1() + "' ");
			if (questionToADD.getReponse2() != null) {
				queryBuilder.append(",REPONSE2='" + questionToADD.getReponse2()
						+ "' ,QUESTION_DOUBLE='"
						+ questionToADD.getQuestion_double() + "' ");
			} else {
				queryBuilder.append(",REPONSE2='',QUESTION_DOUBLE='"
						+ questionToADD.getQuestion_double() + "' ");
			}

			queryBuilder.append(",TEMPS='" + questionToADD.getTemps()
					+ "' ,ENONCE2='" + questionToADD.getEnonce2() + "' ");
			queryBuilder.append(",REPONSEA='" + questionToADD.getReponseA()
					+ "' ,REPONSEB='" + questionToADD.getReponseB() + "' ");
			queryBuilder.append(",REPONSEC='" + questionToADD.getReponseC()
					+ "' ,REPONSED='" + questionToADD.getReponseD() + "' ");
			queryBuilder.append("WHERE ID_SERIE='"
					+ questionToADD.getId_serie() + "' AND NUM_QUESTION='"
					+ questionToADD.getNum_question() + "'");

			final Query query = em.createQuery(queryBuilder.toString());
			query.executeUpdate();
		}
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

	@Override
	public String recupererNouvelleSerie() {
		final EntityManager em = emF.createEntityManager();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT COUNT(*) FROM serie");

		final Query query = em.createQuery(queryBuilder.toString());
		final int result = (int) ((long) query.getSingleResult());
		final SerieDO newSerie = new SerieDO();
		newSerie.setDate_creation(new Date());
		newSerie.setNum_serie(result + 1);
		em.getTransaction().begin();
		em.persist(newSerie);
		em.getTransaction().commit();

		return Integer.toString(newSerie.getNum_serie());
	}

	@Override
	public List<String> recupererNumeroSerie() {
		final EntityManager em = emF.createEntityManager();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT serie.id FROM serie as serie");
		final Query query = em.createQuery(queryBuilder.toString());

		final List<String> result = query.getResultList();
		return result;
	}
}
