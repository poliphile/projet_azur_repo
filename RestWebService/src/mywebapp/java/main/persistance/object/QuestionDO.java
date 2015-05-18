/**
 *
 */
package mywebapp.java.main.persistance.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author matthieu
 *
 */
@Entity(name = "question")
public class QuestionDO {
	@Id
	@GeneratedValue
	private int id;
	private int id_serie;
	private String num_question;
	private String enonce;
	private byte[] image;
	private char reponse1;
	private char reponse2;
	private int question_double;
	private String temps;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the id_serie
	 */
	public int getId_serie() {
		return id_serie;
	}

	/**
	 * @param id_serie
	 *            the id_serie to set
	 */
	public void setId_serie(final int id_serie) {
		this.id_serie = id_serie;
	}

	/**
	 * @return the enonce
	 */
	public String getEnonce() {
		return enonce;
	}

	/**
	 * @param enonce
	 *            the enonce to set
	 */
	public void setEnonce(final String enonce) {
		this.enonce = enonce;
	}

	/**
	 * @param reponse1
	 *            the reponse1 to set
	 */
	public void setReponse1(final char reponse1) {
		this.reponse1 = reponse1;
	}

	/**
	 * @return the reponse2
	 */
	public char getReponse2() {
		return reponse2;
	}

	/**
	 * @param reponse2
	 *            the reponse2 to set
	 */
	public void setReponse2(final char reponse2) {
		this.reponse2 = reponse2;
	}

	/**
	 * @return the question_double
	 */
	public int isQuestion_double() {
		return question_double;
	}

	/**
	 * @param question_double
	 *            the question_double to set
	 */
	public void setQuestion_double(final int question_double) {
		this.question_double = question_double;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(final byte[] image) {
		this.image = image;
	}

	/**
	 * @return the reponse1
	 */
	public char getReponse1() {
		return reponse1;
	}

	public String getBitArrayString() {
		return new String(
				new org.apache.commons.codec.binary.Base64().encode(this.image));
	}

	/**
	 * @return the num_question
	 */
	public String getNum_question() {
		return num_question;
	}

	/**
	 * @param num_question
	 *            the num_question to set
	 */
	public void setNum_question(final String num_question) {
		this.num_question = num_question;
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
