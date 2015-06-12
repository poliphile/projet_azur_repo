/**
 *
 */
package mywebapp.java.main.presentation.serie.action;

import mywebapp.java.main.presentation.serie.bean.QuestionDTO;
import mywebapp.java.main.services.SerieService;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author matthieu
 *
 */
public class AfficherQuestionSuivanteAction {

	private final SerieService serieService = SerieService.getInstance();

	public String execute() {
		final ActionContext context = ActionContext.getContext();
		final QuestionDTO questionActuelle = (QuestionDTO) context.getSession()
				.get("Question");
		final int question = Integer.parseInt(questionActuelle
				.getNum_question()) + 1;
		if (question < 40) {
			final QuestionDTO questionSuivante = serieService
					.recupererQuestion(
							Integer.toString(questionActuelle.getId_serie()),
							question);
			questionSuivante.setIsReady(1);
			questionActuelle.setIsReady(0);
			serieService.activerQuestion(questionActuelle);
			serieService.activerQuestion(questionSuivante);

			context.getSession().put("Question", questionSuivante);
			context.getSession().put("time", questionSuivante.getTemps());
			context.getSession().put("double",
					questionSuivante.getQuestion_double());
		}

		return "SUCCESS";
	}

}
