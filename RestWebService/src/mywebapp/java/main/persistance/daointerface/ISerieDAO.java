/**
 *
 */
package mywebapp.java.main.persistance.daointerface;

import mywebapp.java.main.persistance.object.QuestionDO;

/**
 * @author matthieu
 *
 */
public interface ISerieDAO {

	public String lancerSerie(final int numeroSerie);

	public String recupererSerieEnCours();

	public String closeConnexion(final String numeroSerie);

	public QuestionDO recupererQuestionDO(final String numeroSerie,
			final int numeroQuestion);

	public String repondreQuestion(final String reponse1,
			final String numeroSerie, final int numeroQuestion);

}
