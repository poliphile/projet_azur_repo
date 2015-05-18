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

import org.springframework.transaction.annotation.Transactional;

/**
 * @author matthieu
 *
 */
public class SerieDAOImpl implements ISerieDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mywebapp.java.main.persistance.daointerface.ISerieDAO#lancerSerie(int)
	 */
	@Override
	@Transactional
	public String lancerSerie(final int numeroSerie) {
		final EntityManagerFactory emF = new Persistence()
				.createEntityManagerFactory("my-pu");
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
	public String recupererSerieEnCours() {
		final EntityManagerFactory emF = new Persistence()
				.createEntityManagerFactory("my-pu");
		final EntityManager em = emF.createEntityManager();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT serie.NUM_SERIE FROM serie WHERE serie.IS_ACTIVE = '1'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		final List result = query.getResultList();
		if (result.isEmpty()) {
			return "0";
		}
		return result.get(0).toString();
	}

	@Override
	@Transactional
	public String closeConnexion(final String numeroSerie) {
		final EntityManagerFactory emF = new Persistence()
				.createEntityManagerFactory("my-pu");
		final EntityManager em = emF.createEntityManager();
		em.getTransaction().begin();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("UPDATE serie SET serie.IS_ACTIVE = '0' WHERE serie.NUM_SERIE =' "
						+ numeroSerie + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		query.executeUpdate();
		em.getTransaction().commit();
		return "success";
	}

	// TODO merge

	@Override
	public QuestionDO recupererQuestionDO(final String numSerie,
			final int numQuestion) {

		final EntityManagerFactory emf = new Persistence()
		.createEntityManagerFactory("my-pu");
		final EntityManager em = emf.createEntityManager();

		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
		.append("SELECT question.ID, question.ID_SERIE, question.NUM_QUESTION, question.ENONCE, question.IMAGE, question.REPONSE1, question.REPONSE2, question.QUESTION_DOUBLE, question.TEMPS FROM QUESTION question WHERE question.NUM_QUESTION = '"
				+ numQuestion
				+ "' and question.ID_SERIE = '"
				+ numSerie + "'");
		final Query query = em.createNativeQuery(queryBuilder.toString());
		final Object[] results = (Object[]) query.getSingleResult();
		final QuestionDO questionDO = new QuestionDO();
		if (results != null && results.length != 0) {
			questionDO.setId((int) results[0]);
			questionDO.setId_serie((int) results[1]);
			questionDO.setNum_question((int) results[2]);
			questionDO.setEnonce((String) results[3]);
			questionDO.setImage((byte[]) results[4]);
//			questionDO.setReponse1((String) results[5]);
//			questionDO.setReponse2((String) results[6]);
		//	questionDO.setQuestion_double((int) results[7]);
			questionDO.setTemps((int) results[8]);
		}
		return questionDO;
	}

	@Override
	public String repondreQuestion(final String reponse1,
			final String numeroSerie, final int numeroQuestion) {
		final EntityManagerFactory emF = new Persistence()
				.createEntityManagerFactory("my-pu");
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

}
