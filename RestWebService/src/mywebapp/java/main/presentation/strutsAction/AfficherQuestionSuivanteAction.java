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
public class AfficherQuestionSuivanteAction {

	private SerieService serieService = SerieService.getInstance();

	public String execute() {
		ActionContext context = ActionContext.getContext();
		final QuestionDO questionActuelle = (QuestionDO) context.getSession()
				.get("Question");
		final int question = Integer.parseInt(questionActuelle
				.getNum_question()) + 1;
		if (question < 40) {
			final QuestionDO questionSuivante = serieService.recupererQuestion(
					Integer.toString(questionActuelle.getId_serie()), question);

			context.getSession().put("Question", questionSuivante);
			context.getSession().put("time", questionSuivante.getTemps());
		}

		return "SUCCESS";
	}

}
