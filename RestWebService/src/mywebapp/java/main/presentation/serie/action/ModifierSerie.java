/**
 * 
 */
package mywebapp.java.main.presentation.serie.action;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author matthieu
 *
 */
public class ModifierSerie {
	
	public String execute(){
		ActionContext.getContext().put("Modification", "modification");
		return "SUCCESS";
	}

}
