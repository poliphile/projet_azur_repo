/**
 * 
 */
package mywebapp.java.main.presentation.serie.action;

import java.io.File;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.services.SerieService;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author matthieu
 *
 */
public class ModificationSerieAction {

	/**
	 * @author matthieu
	 *
	 */

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
	private String enonce3;
	private String reponseE;
	private String reponseF;
	private String reponseG;
	private String reponseH;
	private String reponse3;

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
	public void setIsDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	private SerieService serieService = SerieService.getInstance();

	public String execute() {
		final QuestionDO question = new QuestionDO();
		final ActionContext context = ActionContext.getContext();
		question.setId_serie(Integer.parseInt(numeroSerie));
		if (file != null) {
			byte[] b = extractImage(file);
			question.setImage(b);
		}

		if (isDouble) {
			question.setEnonce(removeUnecessaryToken(enonce2));
			question.setEnonce2(removeUnecessaryToken(enonce3));
			question.setQuestion_double(1);
			question.setReponseA(removeUnecessaryToken(reponseE));
			question.setReponseB(removeUnecessaryToken(reponseF));
			question.setReponseC(removeUnecessaryToken(reponseG));
			question.setReponseD(removeUnecessaryToken(reponseH));
			question.setTemps(temps);
			question.setNum_question(numeroQuestion);
			question.setReponse1(removeUnecessaryToken(reponse2));
			question.setReponse2(removeUnecessaryToken(reponse3));
		} else {

			question.setEnonce(removeUnecessaryToken(enonce1));
			question.setQuestion_double(0);
			question.setQuestion_double(0);
			question.setReponseA(removeUnecessaryToken(reponseA));
			question.setReponseB(removeUnecessaryToken(reponseB));
			question.setReponseC(removeUnecessaryToken(reponseC));
			question.setReponseD(removeUnecessaryToken(reponseD));
			question.setTemps(temps);
			question.setNum_question(numeroQuestion);
			question.setReponse1(removeUnecessaryToken(reponse1));
			question.setReponse2(null);
		}
		serieService.ajouterQuestion(question);
		final int numQuestionSuivante = Integer.parseInt(question
				.getNum_question()) + 1;
		context.getSession().put("numeroQuestion",
				Integer.toString(numQuestionSuivante));
		context.getSession().put("numeroSerie",
				Integer.toString(question.getId_serie()));
		if (numQuestionSuivante > 40) {
			return "FAIL";
		}
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

	public void reset() {
		this.setIsDouble(false);
		this.setEnonce1(null);
		this.setEnonce2(null);
		this.setFile(null);
		this.setFilename(null);
		this.setReponse1(null);
		this.setReponse2(null);
		this.setReponseB(null);
		this.setReponseA(null);
		this.setReponseC(null);
		this.setReponseD(null);
		this.setTemps(null);
	}

	public String removeUnecessaryToken(String object) {
		if (null == object) {
			return object;
		}
		if (object.startsWith("'")) {
			return object.replaceFirst("'", "");
		} else if (object.endsWith("'")) {
			return object.substring(0, object.length() - 1);
		}
		return object;
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
		this.numeroSerie = null;
		this.numeroSerie = numeroSerie;
	}

	public void setUpload(File file) {
		this.file = null;
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = null;
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = null;
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
		this.file = null;
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
		this.filename = null;
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
		this.enonce1 = null;
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
		this.enonce2 = null;
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
		this.reponseA = null;
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
		this.reponseB = null;
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
		this.reponseC = null;
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
		this.reponseD = null;
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

	/**
	 * @return the enonce3
	 */
	public String getEnonce3() {
		return enonce3;
	}

	/**
	 * @param enonce3
	 *            the enonce3 to set
	 */
	public void setEnonce3(String enonce3) {
		this.enonce3 = enonce3;
	}

	/**
	 * @return the reponseE
	 */
	public String getReponseE() {
		return reponseE;
	}

	/**
	 * @param reponseE
	 *            the reponseE to set
	 */
	public void setReponseE(String reponseE) {
		this.reponseE = reponseE;
	}

	/**
	 * @return the reponseF
	 */
	public String getReponseF() {
		return reponseF;
	}

	/**
	 * @param reponseF
	 *            the reponseF to set
	 */
	public void setReponseF(String reponseF) {
		this.reponseF = reponseF;
	}

	/**
	 * @return the reponseG
	 */
	public String getReponseG() {
		return reponseG;
	}

	/**
	 * @param reponseG
	 *            the reponseG to set
	 */
	public void setReponseG(String reponseG) {
		this.reponseG = reponseG;
	}

	/**
	 * @return the reponseH
	 */
	public String getReponseH() {
		return reponseH;
	}

	/**
	 * @param reponseH
	 *            the reponseH to set
	 */
	public void setReponseH(String reponseH) {
		this.reponseH = reponseH;
	}

	/**
	 * @return the reponse3
	 */
	public String getReponse3() {
		return reponse3;
	}

	/**
	 * @param reponse3
	 *            the reponse3 to set
	 */
	public void setReponse3(String reponse3) {
		this.reponse3 = reponse3;
	}
}
