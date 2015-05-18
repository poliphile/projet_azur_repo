/**
 *
 */
package mywebapp.java.main.presentation.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author matthieu
 *
 */
@XmlRootElement
public class Serie {

	private String numSerie;

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @param numSerie
	 *            the numSerie to set
	 */
	public void setNumSerie(final String numSerie) {
		this.numSerie = numSerie;
	}

}
