/**
 *
 */
package mywebapp.java.main.presentation.strutsAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author matthieu
 *
 */
public class LoginForm extends ActionForm {
	String nomUtilisateur;

	String mdpUtilisateur;

	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	public void setMdpUtilisateur(final String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(final String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	@Override
	public ActionErrors validate(final ActionMapping mapping,
			final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();
		return errors;
	}

	@Override
	public void reset(final ActionMapping mapping,
			final HttpServletRequest request) {
		this.mdpUtilisateur = null;
		this.nomUtilisateur = null;
	}
}
