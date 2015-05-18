/**
 *
 */
package mywebapp.java.main.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.java.main.persistance.daoimpl.UtilisateurDAOImpl;
import mywebapp.java.main.persistance.object.UtilisateurDO;
import mywebapp.java.main.presentation.strutsAction.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author matthieu
 *
 */
public class LoginAction extends Action {
	@Override
	public ActionForward execute(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		String resultat = null;
		final String nomUtilisateur = ((LoginForm) form).getNomUtilisateur();
		final String mdpUtilisateur = ((LoginForm) form).getMdpUtilisateur();

		final UtilisateurDAOImpl dao = new UtilisateurDAOImpl();
		final UtilisateurDO user = dao.recupererUtilisateurDO(nomUtilisateur,
				mdpUtilisateur);
		if (user != null) {
			resultat = "success";
		} else {
			resultat = "echec";
		}

		return mapping.findForward(resultat);
	}
}
