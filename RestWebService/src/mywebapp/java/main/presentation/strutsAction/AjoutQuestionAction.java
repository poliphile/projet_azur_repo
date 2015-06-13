/**
 * 
 */
package mywebapp.java.main.presentation.strutsAction;

import java.io.File;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.services.SerieService;

/**
 * @author matthieu
 *
 */
public class AjoutQuestionAction {

	private String numeroSerie;
	private File file;
	private String contentType;
	private String filename;
	private String enonce1;
	private String enonce2;
	private String reponseA;
	private String reponseB;
	private String reponseC;
	private String reponseD;
	private boolean isDouble;
	private String temps;
	private String numeroQuestion;
	private String reponse1;
	private String reponse2;

	/**
	 * @return the isDouble
	 */
	public boolean getIsDouble() {
		return isDouble;
	}

	/**
	 * @param isDouble
	 *            the isDouble to set
	 */
	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	private SerieService serieService = SerieService.getInstance();

	public String execute() {
		final QuestionDO question = new QuestionDO();
		question.setId_serie(2);
		byte[] b = extractImage(file);
		question.setImage(b);
		question.setEnonce(enonce1);
		question.setEnonce2(enonce2);
		question.setQuestion_double(0);
		if (enonce2 != null) {
			question.setQuestion_double(1);
		}
		question.setReponseA(reponseA);
		question.setReponseB(reponseB);
		question.setReponseC(reponseC);
		question.setReponseD(reponseD);
		question.setTemps(temps);
		question.setNum_question(numeroQuestion);
		question.setReponse1(reponse1);
		question.setReponse2(reponse2);
		serieService.ajouterQuestion(question);
		return "SUCCESS";
	}

	private byte[] extractImage(final File photo) {
		FileImageInputStream fi = null;
		try {
			fi = new FileImageInputStream(photo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] b = new byte[(int) fi.length()];
		try {
			fi.read(b);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return b;
	}

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

	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the enonce1
	 */
	public String getEnonce1() {
		return enonce1;
	}

	/**
	 * @param enonce1
	 *            the enonce1 to set
	 */
	public void setEnonce1(final String enonce1) {
		this.enonce1 = enonce1;
	}

	/**
	 * @return the enonce2
	 */
	public String getEnonce2() {
		return enonce2;
	}

	/**
	 * @param enonce2
	 *            the enonce2 to set
	 */
	public void setEnonce2(final String enonce2) {
		this.enonce2 = enonce2;
	}

	/**
	 * @return the reponseA
	 */
	public String getReponseA() {
		return reponseA;
	}

	/**
	 * @param reponseA
	 *            the reponseA to set
	 */
	public void setReponseA(final String reponseA) {
		this.reponseA = reponseA;
	}

	/**
	 * @return the reponseB
	 */
	public String getReponseB() {
		return reponseB;
	}

	/**
	 * @param reponseB
	 *            the reponseB to set
	 */
	public void setReponseB(final String reponseB) {
		this.reponseB = reponseB;
	}

	/**
	 * @return the reponseC
	 */
	public String getReponseC() {
		return reponseC;
	}

	/**
	 * @param reponseC
	 *            the reponseC to set
	 */
	public void setReponseC(final String reponseC) {
		this.reponseC = reponseC;
	}

	/**
	 * @return the reponseD
	 */
	public String getReponseD() {
		return reponseD;
	}

	/**
	 * @param reponseD
	 *            the reponseD to set
	 */
	public void setReponseD(final String reponseD) {
		this.reponseD = reponseD;
	}

	/**
	 * @return the serieService
	 */
	public SerieService getSerieService() {
		return serieService;
	}

	/**
	 * @param serieService
	 *            the serieService to set
	 */
	public void setSerieService(final SerieService serieService) {
		this.serieService = serieService;
	}

	/**
	 * @return the temps
	 */
	public String getTemps() {
		return temps;
	}

	/**
	 * @return the numeroQuestion
	 */
	public String getNumeroQuestion() {
		return numeroQuestion;
	}

	/**
	 * @param numeroQuestion
	 *            the numeroQuestion to set
	 */
	public void setNumeroQuestion(String numeroQuestion) {
		this.numeroQuestion = numeroQuestion;
	}

	/**
	 * @param temps
	 *            the temps to set
	 */
	public void setTemps(String temps) {
		this.temps = temps;
	}

	/**
	 * @return the reponse1
	 */
	public String getReponse1() {
		return reponse1;
	}

	/**
	 * @param reponse1
	 *            the reponse1 to set
	 */
	public void setReponse1(String reponse1) {
		this.reponse1 = reponse1;
	}

	/**
	 * @return the reponse2
	 */
	public String getReponse2() {
		return reponse2;
	}

	/**
	 * @param reponse2
	 *            the reponse2 to set
	 */
	public void setReponse2(String reponse2) {
		this.reponse2 = reponse2;
	}

}
