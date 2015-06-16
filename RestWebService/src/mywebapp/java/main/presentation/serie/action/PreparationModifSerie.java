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
public class PreparationModifSerie {

	/**
	 * 
	 */
	private String numSerie;
	/**
	 * 
	 */
	private final SerieService serieService = SerieService.getInstance();

	public String execute() {
		QuestionDTO question = null;
		if (ActionContext.getContext().getSession().get("numeroQuestion") == null) {
			question = serieService.recupererQuestion(numSerie, 1);
		} else {
			final String numeroSerie = (String) ActionContext.getContext()
					.getSession().get("numeroSerie");
			final int numeroQuestion = Integer.parseInt((String) ActionContext
					.getContext().getSession().get("numeroQuestion"));
			question = serieService.recupererQuestion(numeroSerie,
					numeroQuestion);
			if (question.getId_serie() == 0) {
				question.setId_serie(Integer.parseInt((String) ActionContext
						.getContext().getSession().get("numeroSerie")));
				question.setNum_question((String) ActionContext.getContext()
						.getSession().get("numeroQuestion"));
			}
		}

		final ActionContext context = ActionContext.getContext();
		context.getSession().put("numeroSerie", question.getId_serie());
		context.getSession().put("numeroQuestion", question.getNum_question());
		context.getSession().put("image", question.getImage());
		if (question.getQuestion_double() == 1) {
			// Question Double
			context.getSession().put("isDouble", true);
			context.getSession().put("time", question.getTemps());
			context.getSession().put("Enonce2", question.getEnonce());
			context.getSession().put("Enonce3", question.getEnonce2());
			context.getSession().put("E", question.getReponseA());
			context.getSession().put("F", question.getReponseB());
			context.getSession().put("G", question.getReponseC());
			context.getSession().put("H", question.getReponseD());
			if ("A".equals(question.getReponse1())) {
				context.getSession().put("isE", true);
				context.getSession().put("isF", false);
				context.getSession().put("isG", false);
				context.getSession().put("isH", false);
			} else {
				context.getSession().put("isE", false);
				if ("B".equals(question.getReponse1())) {
					context.getSession().put("isF", true);
					context.getSession().put("isG", false);
					context.getSession().put("isH", false);
				}
				if ("C".equals(question.getReponse1())) {
					context.getSession().put("isF", false);
					context.getSession().put("isG", true);
					context.getSession().put("isH", false);
				} else if ("D".equals(question.getReponse1())) {
					context.getSession().put("isF", false);
					context.getSession().put("isG", false);
					context.getSession().put("isH", true);
				}
			}
			if (question.getReponse2() != null) {
				if ("C".equals(question.getReponse2())) {
					context.getSession().put("isG", true);
				} else {
					context.getSession().put("isH", true);
				}

			}
		} else {
			// Question simple
			context.getSession().put("isDouble", false);
			context.getSession().put("time", question.getTemps());
			context.getSession().put("Enonce1", question.getEnonce());
			context.getSession().put("Enonce2", question.getEnonce2());
			context.getSession().put("A", question.getReponseA());
			context.getSession().put("B", question.getReponseB());
			context.getSession().put("C", question.getReponseC());
			context.getSession().put("D", question.getReponseD());
			if ("A".equals(question.getReponse1())) {
				context.getSession().put("isA", true);
				context.getSession().put("isB", false);
				context.getSession().put("isC", false);
				context.getSession().put("isD", false);
			} else {
				context.getSession().put("isA", false);
				if ("B".equals(question.getReponse1())) {
					context.getSession().put("isB", false);
					context.getSession().put("isC", false);
					context.getSession().put("isD", false);
				}
				if ("C".equals(question.getReponse1())) {
					context.getSession().put("isB", false);
					context.getSession().put("isC", true);
					context.getSession().put("isD", false);
				} else if ("D".equals(question.getReponse1())) {
					context.getSession().put("isB", false);
					context.getSession().put("isC", false);
					context.getSession().put("isD", true);
				} else if (question.getReponse1() == null) {
					context.getSession().put("isA", false);
					context.getSession().put("isB", false);
					context.getSession().put("isC", false);
					context.getSession().put("isD", false);
				}
			}
		}

		return "SUCCESS";

	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @param numSerie
	 *            the numSerie to set
	 */
	public void setNumSerie(final String numSerie) {
		this.numSerie = numSerie;
	}

}
