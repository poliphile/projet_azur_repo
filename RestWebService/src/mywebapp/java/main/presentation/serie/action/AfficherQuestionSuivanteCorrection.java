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
public class AfficherQuestionSuivanteCorrection {

	private final SerieService serieService = SerieService.getInstance();

	public String execute() {
		final ActionContext context = ActionContext.getContext();
		QuestionDTO questionSuivante = null;
		QuestionDTO questionActuelle = null;
		if (context.getSession().get("Question") != null) {
			questionActuelle = (QuestionDTO) context.getSession().get(
					"Question");
			final int numQuestionSuivante = Integer.parseInt(questionActuelle
					.getNum_question()) + 1;
			questionSuivante = serieService.recupererQuestion(
					Integer.toString(questionActuelle.getId_serie()),
					numQuestionSuivante);
		} else {
			questionSuivante = serieService.recupererQuestion(Integer
					.toString((int) context.getSession().get("numSerie")), 1);
		}

		if (questionSuivante != null && questionSuivante.getEnonce() != null) {
			questionSuivante.setIsReady(1);
			if (questionActuelle != null) {
				questionActuelle.setIsReady(0);
				serieService.activerQuestion(questionActuelle);
			}

			serieService.activerQuestion(questionSuivante);

			context.getSession().put("Question", questionSuivante);
			context.getSession().put("time", questionSuivante.getTemps());
			context.getSession().put("double",
					questionSuivante.getQuestion_double());
		} else {

			return "FAIL";
		}

		return "SUCCESS";
	}

}
