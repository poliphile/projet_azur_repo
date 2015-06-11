/**
 *
 */
package mywebapp.java.main.persistance.daointerface;

import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.persistance.object.SerieDO;

/**
 * @author matthieu
 *
 */
public interface ISerieDAO {

	public String lancerSerie(final int numeroSerie);

	public SerieDO recupererSerieEnCours();

	public String closeConnexion(final String numeroSerie);

	public QuestionDO recupererQuestionDO(final String numeroSerie,
			final int numeroQuestion);

	public String repondreQuestion(final String reponse1,
			final String numeroSerie, final int numeroQuestion);

	boolean activerQuestionDO(final QuestionDO questionDO);

	public String ajoutQuestion(final QuestionDO questionToADD);
}
