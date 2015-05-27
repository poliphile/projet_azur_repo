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

	private SerieService serieService = SerieService.getInstance();

	public String execute() {
		final QuestionDO question = new QuestionDO();
		question.setId_serie(2);
		byte[] b = extractImage(file);
		question.setImage(b);
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

}
