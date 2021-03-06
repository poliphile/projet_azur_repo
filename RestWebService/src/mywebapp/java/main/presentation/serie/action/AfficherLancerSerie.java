/**
 * 
 */
package mywebapp.java.main.presentation.serie.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import mywebapp.java.main.services.SerieService;

/**
 * @author matthieu
 *
 */
public class AfficherLancerSerie {

	private final SerieService serieService = SerieService.getInstance();

	private List<String> listSerie;

	public String execute() {
		listSerie = serieService.recupererIDSerie();
		if(ActionContext.getContext().get("Modification") != null){
			return "FAIL";
		}
		return "SUCCESS";
	}

	/**
	 * @return the listSerie
	 */
	public List<String> getListSerie() {
		return listSerie;
	}

	/**
	 * @param listSerie
	 *            the listSerie to set
	 */
	public void setListSerie(final List<String> listSerie) {
		this.listSerie = listSerie;
	}
}
