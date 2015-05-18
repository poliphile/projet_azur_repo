/**
 *
 */
package mywebapp.java.main.presentation.strutsAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author matthieu
 *
 */
public class LancerForm extends ActionForm {
	private String numeroSerie;
	private String tempsDepart;

	/**
	 * @return the numeroSerie
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}

	/**
	 * @param numeroSerie
	 *            the numeroSerie to set
	 */
	public void setNumeroSerie(final String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	/**
	 * @return the tempsDepart
	 */
	public String getTempsDepart() {
		return tempsDepart;
	}

	/**
	 * @param tempsDepart
	 *            the tempsDepart to set
	 */
	public void setTempsDepart(final String tempsDepart) {
		this.tempsDepart = tempsDepart;
	}

	@Override
	public void reset(final ActionMapping mapping,
			final HttpServletRequest request) {
		this.numeroSerie = null;
	}

}
