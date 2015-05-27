/**
 *
 */
package mywebapp.java.main.presentation.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import mywebapp.java.main.persistance.object.UtilisateurDO;
import mywebapp.java.main.presentation.pojo.Utilisateur;
import mywebapp.java.main.services.LoginService;

/**
 * @author Sekioa
 *
 */
@Path("/login_user")
public class UtilisateurResource {

	private final static String USER = "user";
	private final static String PASSWORD = "password";

	private final Utilisateur user = new Utilisateur(1, "sample", "sample");

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
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Demo service is ready you fucking bastards!";
	}

	// Use data from the client source to create a new Person object, returned
	// in JSON format.
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur postPerson(@FormParam("user") final String user,
			@FormParam("password") final String password) {

		final LoginService utilisateurService = LoginService.getInstance();

		System.out.println("Storing posted " + user + " " + password);
		final UtilisateurDO utilisateurDO = utilisateurService.seConnecter(
				user, password);
		if (utilisateurDO.getLogin() != null) {
			this.user.setUser(utilisateurDO.getLogin());
			this.user.setPassword(utilisateurDO.getPassword());
			if (utilisateurDO.getPassword().equals(password)) {
				this.user.setIsConnect("true");
			}
		}
		System.out.println("user info: " + this.user.getUser() + " "
				+ this.user.getPassword() + this.user.getIsConnect());

		return this.user;

	}
}
