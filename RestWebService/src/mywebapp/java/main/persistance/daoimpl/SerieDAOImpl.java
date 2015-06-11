/**
 *
 */
package mywebapp.java.main.persistance.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mywebapp.java.main.persistance.daointerface.ISerieDAO;
import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.persistance.object.SerieDO;

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

	// TODO merge

	@Override
	public QuestionDO recupererQuestionDO(final String numSerie,
			final int numQuestion) {

		final EntityManager em = emF.createEntityManager();

		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT question.ID, question.ID_SERIE, question.NUM_QUESTION, question.ENONCE, question.IMAGE, question.REPONSE1, question.REPONSE2, question.QUESTION_DOUBLE, question.TEMPS , question.ENONCE2 , question.REPONSEA , question.REPONSEB , question.REPONSEC , question.REPONSED FROM QUESTION question WHERE question.NUM_QUESTION = '"
						+ numQuestion
						+ "' and question.ID_SERIE = '"
						+ numSerie + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		final List<Object[]> results = query.getResultList();
		final QuestionDO questionDO = new QuestionDO();
		for (final Object[] o : results) {
			questionDO.setId((int) o[0]);
			questionDO.setId_serie((int) o[1]);
			questionDO.setNum_question((String) o[2]);
			questionDO.setEnonce((String) o[3]);
			questionDO.setImage((byte[]) o[4]);
			// questionDO.setReponse1((String) results[5]);
			// questionDO.setReponse2((String) results[6]);
			questionDO.setQuestion_double((int) o[7]);
			questionDO.setTemps((String) o[8]);
			questionDO.setEnonce2((String) o[9]);
			questionDO.setReponseA((String) o[10]);
			questionDO.setReponseB((String) o[11]);
			questionDO.setReponseC((String) o[12]);
			questionDO.setReponseD((String) o[13]);
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
		em.persist(questionToADD);
		em.getTransaction().commit();
		return "success";
	}

	@Override
	public SerieDO recupererSerieEnCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean activerQuestionDO(final QuestionDO questionDO) {
		// TODO Auto-generated method stub
		return false;
	}
}
