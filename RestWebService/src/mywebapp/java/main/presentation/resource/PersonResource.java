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

import mywebapp.java.main.presentation.pojo.Person;

/**
 * @author Sekioa
 *
 */
@Path("/person")
public class PersonResource {

	private final static String FIRST_NAME = "firstName";
	private final static String LAST_NAME = "lastName";
	private final static String EMAIL = "email";

	private final Person person = new Person(1, "Sample", "Person",
			"sample_person@jerseyrest.com");

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
		return "Demo service is ready!";
	}

	@GET
	@Path("id_response")
	@Produces(MediaType.APPLICATION_JSON)
	public String doIdResponse() {
		final String response = "OK";

		return response;
	}

	@GET
	@Path("sample")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getSamplePerson() {

		System.out.println("Returning sample person: " + person.getFirstName()
				+ " " + person.getLastName());

		return person;
	}

	// Use data from the client source to create a new Person object, returned
	// in JSON format.
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Person postPerson(final MultivaluedMap<String, String> personParams) {

		final String firstName = personParams.getFirst(FIRST_NAME);
		final String lastName = personParams.getFirst(LAST_NAME);
		final String email = personParams.getFirst(EMAIL);

		System.out.println("Storing posted " + firstName + " " + lastName
				+ "  " + email);

		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);

		System.out.println("person info: " + person.getFirstName() + " "
				+ person.getLastName() + " " + person.getEmail());

		return person;

	}

}
