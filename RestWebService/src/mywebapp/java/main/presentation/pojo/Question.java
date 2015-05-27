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
public class Question {
	private int numeroQuestion;
	private String temps = "";

	public Question() {
		numeroQuestion = 0;
	}

	public Question(final int numeroQuestion) {
		this.numeroQuestion = numeroQuestion;
	}

	/**
	 * @return the numeroQuestion
	 */
	public int getNumeroQuestion() {
		return numeroQuestion;
	}

	/**
	 * @param numeroQuestion
	 *            the numeroQuestion to set
	 */
	public void setNumeroQuestion(final int numeroQuestion) {
		this.numeroQuestion = numeroQuestion;
	}

	/**
	 * @return the temps
	 */
	public String getTemps() {
		return temps;
	}

	/**
	 * @param temps
	 *            the temps to set
	 */
	public void setTemps(final String temps) {
		this.temps = temps;
	}

}
