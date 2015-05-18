/**
 *
 */
package mywebapp.java.main.presentation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;

/**
 * @author matthieu
 *
 */
public class AffichageQuestionAction extends Action {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("toto");
	}
}
