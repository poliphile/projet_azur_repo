/**
 * 
 */
package mywebapp.java.main.services;

import mywebapp.java.main.persistance.daoimpl.SerieDAOImpl;
import mywebapp.java.main.persistance.object.QuestionDO;

/**
 * @author matthieu
 *
 */
public class SerieService {

	private static SerieService instance;

	private SerieService() {
		// empty Method
	}

	/**
	 * 
	 */
	private SerieDAOImpl serieDAO = new SerieDAOImpl();

	public String lancerSerie(final int numserie) {
		final String result = serieDAO.lancerSerie(numserie);
		return result;
	}

	public String recupererSerieEnCours() {
		return serieDAO.recupererSerieEnCours();
	}

	public String closeConnexion(final String numSerie) {
		return serieDAO.closeConnexion(numSerie);
	}

	public QuestionDO recupererQuestion(final String numeroSerie,
			final int numeroQuestion) {
		return serieDAO.recupererQuestionDO(numeroSerie, numeroQuestion);
	}

	public static SerieService getInstance() {
		if (instance == null) {
			return new SerieService();
		} else {
			return instance;
		}
	}

}
