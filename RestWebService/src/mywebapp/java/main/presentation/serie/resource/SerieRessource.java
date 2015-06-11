/**
 *
 */
package mywebapp.java.main.presentation.serie.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import mywebapp.java.main.presentation.serie.bean.QuestionDTO;
import mywebapp.java.main.presentation.serie.bean.SerieDTO;
import mywebapp.java.main.presentation.serie.bean.UtilisateurSerieDTO;
import mywebapp.java.main.presentation.utilisateur.bean.UtilisateurDTO;
import mywebapp.java.main.services.SerieService;
import mywebapp.java.main.services.UtilisateurSerieService;
import mywebapp.java.main.services.UtilisateurService;

/**
 * @author matthieu
 *
 */
@Path("/get_serie")
public class SerieRessource {
	// TODO merge
	private final SerieService serieService = SerieService.getInstance();
	private final UtilisateurService utilisateurService = UtilisateurService
			.getInstance();
	private final UtilisateurSerieService utilisateurSerieService = UtilisateurSerieService
			.getInstance();

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
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public SerieDTO connexionSerie(@FormParam("user") final String login,
			@FormParam("password") final String password) {

		final SerieDTO serie = serieService.recupererSerieEnCours();
		if (null != serie) {
			final UtilisateurDTO user = utilisateurService
					.rechercherUtilisateur(login, password);
			final UtilisateurSerieDTO utilisateurSerieDTO = new UtilisateurSerieDTO();
			utilisateurSerieDTO.setId_serie(serie.getId());
			utilisateurSerieDTO.setId_utilisateur(user.getId());

			utilisateurSerieService.creerUtilisateurSerie(utilisateurSerieDTO,
					user);
		}
		return serie;
	}

	// TODO merge
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_premiere_question")
	public QuestionDTO postPremiereQuestion(
			@FormParam("numSerie") final String numeroSerie) {

		final int numeroQuestion = 1;

		final QuestionDTO questionDTO = serieService.recupererQuestion(
				numeroSerie, numeroQuestion);

		if (1 == questionDTO.getIsReady()) {
			return questionDTO;
		}

		return new QuestionDTO();
	}

	// TODO merge
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_question")
	public QuestionDTO postReponse(
			@FormParam("numSerie") final String numeroSerie,
			@FormParam("reponse1") final String reponse1,
			@FormParam("reponse2") final String reponse2,
			@FormParam("numQuestion") final String numeroQuestion) {

		final int numeroQuestionInt = Integer.parseInt(numeroQuestion);
		final QuestionDTO result = serieService.recupererQuestion(numeroSerie,
				numeroQuestionInt);
		if (result != null) {
			return result;
		}

		return null;

	}
}
