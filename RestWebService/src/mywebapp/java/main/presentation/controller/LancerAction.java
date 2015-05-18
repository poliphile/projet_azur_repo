/**
 *
 */
package mywebapp.java.main.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mywebapp.java.main.persistance.daoimpl.QuestionDAO;
import mywebapp.java.main.persistance.daoimpl.SerieDAOImpl;
import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.presentation.strutsAction.LancerForm;
import mywebapp.java.main.utils.CloseConnexion;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.hibernate.Session;

import com.sun.research.ws.wadl.Request;

/**
 * @author matthieu
 *
 */
public class LancerAction extends Action {
	@Override
	public ActionForward execute(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		final String numSerie = ((LancerForm) form).getNumeroSerie();
		final String tempsBeforeStar = ((LancerForm) form).getTempsDepart();
		final int tempsDepart = Integer.parseInt(tempsBeforeStar);
		final int numeroSerie = Integer.parseInt(numSerie);
		final SerieDAOImpl dao = new SerieDAOImpl();
		final String result = dao.lancerSerie(numeroSerie);

		final CloseConnexion connectThread = new CloseConnexion();
		CloseConnexion.timeToCount = tempsDepart;
		connectThread.setNumeroSerie(numSerie);
		connectThread.start();
		final QuestionDAO daoQuestion = new QuestionDAO();
		final QuestionDO question = daoQuestion.recupererQuestion(1,
				numeroSerie);
//		req.setAttribute("enonce", question.getEnonce());
//		req.setAttribute("image", question.getImage());
//		req.setAttribute("numQuestion", "1");
//		req.setAttribute("numSerie", numSerie);
		//final int time = question.getTemps();
	//	req.setAttribute("time", Integer.toString(time));
		 HttpSession mySession = req.getSession();
		 mySession.setAttribute("enonce", question.getEnonce());
		 mySession.setAttribute("image", question.getImage());
		 mySession.setAttribute("numQuestion", "1");
		 mySession.setAttribute("numSerie", numSerie);
			final int time = question.getTemps();
			mySession.setAttribute("time", Integer.toString(time));
		boolean redirect = false;
		while (!redirect) {
			Thread.sleep(1000);
			if (CloseConnexion.timeToCount <= 0) {
				redirect = true;
				return mapping.findForward(result);
			}

		}
		return null;

	}
}
