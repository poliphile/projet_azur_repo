/**
 *
 */
package mywebapp.java.main.presentation.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import mywebapp.java.main.persistance.daoimpl.SerieDAOImpl;
import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.presentation.pojo.Question;
import mywebapp.java.main.presentation.pojo.Serie;

/**
 * @author matthieu
 *
 */
@Path("/get_serie")
public class SerieRessource {
	// TODO merge
	private final Question question = new Question(0);

	// The @Context annotation allows us to have certain contextual objects
	// injected into this class.
	// UriInfo object allows us to get URI information (no kidding).
	@Context
	UriInfo uriInfo;

	// Another "injected" object. This allows us to use the information that's
	// part of any incoming request.
	// We could, for example, get header information, or the requestor's
	// address.
	@Context
	Request request;

	// Basic "is the service running" test
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Serie respondAsReady() {
		final SerieDAOImpl dao = new SerieDAOImpl();
		final String result = dao.recupererSerieEnCours();
		final Serie serie = new Serie();
		serie.setNumSerie(result);
		return serie;
	}

	// TODO merge
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_premiere_question")
	public Question postPremiereQuestion(
			final MultivaluedMap<String, String> userParams) {

		final String numeroSerie = userParams.getFirst("numSerie");
		final int numeroQuestion = 1;

		final SerieDAOImpl dao = new SerieDAOImpl();
		final QuestionDO questionDO = dao.recupererQuestionDO(numeroSerie,
				numeroQuestion);

		if (null != questionDO) {
			this.question.setNumeroQuestion(1);
		}

		return this.question;

	}

	// TODO merge
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_question")
	public Question postReponse(final MultivaluedMap<String, String> userParams) {

		final String reponse1 = userParams.getFirst("reponse1");
		final String numeroSerie = userParams.getFirst("numSerie");
		final int numeroQuestion = Integer.valueOf(userParams
				.getFirst("numQuestion"));

		final SerieDAOImpl dao = new SerieDAOImpl();
		final QuestionDO result = dao.recupererQuestionDO(numeroSerie,
				numeroQuestion);
		if (result != null) {
			final int questionSuivante = Integer.parseInt(result
					.getNum_question()) + 1;
			this.question.setNumeroQuestion(questionSuivante);
		}

		return this.question;

	}
}
