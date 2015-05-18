/**
 * 
 */
package mywebapp.java.main.presentation.strutsAction;

import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.services.SerieService;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author matthieu
 *
 */
public class AfficherQuestionAction {

	private SerieService serieService = SerieService.getInstance();

	public String execute() {
		final String numSerie = serieService.recupererSerieEnCours();
		final String resut = serieService.closeConnexion(numSerie);
		final QuestionDO question = serieService.recupererQuestion(numSerie, 1);
		ActionContext context = ActionContext.getContext();
		context.getSession().put("Question", question);
		context.getSession().put("time", question.getTemps());
		return "SUCCESS";
	}

}
