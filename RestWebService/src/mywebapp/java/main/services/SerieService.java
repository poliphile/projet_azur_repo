/**
 *
 */
package mywebapp.java.main.services;

import mywebapp.java.main.persistance.daoimpl.SerieDAOImpl;
import mywebapp.java.main.persistance.object.QuestionDO;
import mywebapp.java.main.persistance.object.SerieDO;
import mywebapp.java.main.presentation.serie.bean.QuestionDTO;
import mywebapp.java.main.presentation.serie.bean.SerieDTO;

/**
 * @author matthieu
 *
 */
public class SerieService {

	private static SerieService instance;

	private SerieService() {
		// empty Method
	}

	/**
	 *
	 */
	private final SerieDAOImpl serieDAO = new SerieDAOImpl();

	public String lancerSerie(final int numserie) {
		final String result = serieDAO.lancerSerie(numserie);
		return result;
	}

	public SerieDTO recupererSerieEnCours() {
		return serieDOToDTO(serieDAO.recupererSerieEnCours());
	}

	public String closeConnexion(final String numSerie) {
		return serieDAO.closeConnexion(numSerie);
	}

	public QuestionDTO recupererQuestion(final String numeroSerie,
			final int numeroQuestion) {
		return questionDOToDTO(serieDAO.recupererQuestionDO(numeroSerie,
				numeroQuestion));
	}

	public String ajouterQuestion(final QuestionDO question) {
		return serieDAO.ajoutQuestion(question);
	}

	public SerieDTO serieDOToDTO(final SerieDO serieDO) {

		final SerieDTO serieDTO = new SerieDTO();

		serieDTO.setId(serieDO.getId());
		serieDTO.setNum_serie((serieDO.getNum_serie()));
		serieDTO.setScore_moyen((serieDO.getScore_moyen()));
		serieDTO.setDate_creation((serieDO.getDate_creation()));
		serieDTO.setDate_passage((serieDO.getDate_passage()));
		serieDTO.setIs_active((serieDO.getId()));

		return serieDTO;
	}

	public QuestionDTO questionDOToDTO(final QuestionDO questionDO) {

		final QuestionDTO questionDTO = new QuestionDTO();

		questionDTO.setId(questionDO.getId());
		questionDTO.setId_serie((questionDO.getId_serie()));
		questionDTO.setNum_question((questionDO.getNum_question()));
		questionDTO.setEnonce((questionDO.getEnonce()));
		questionDTO.setImage((questionDO.getImage()));
		questionDTO.setReponse1((questionDO.getReponse1()));
		questionDTO.setReponse2((questionDO.getReponse2()));
		questionDTO.setQuestion_double((questionDO.getQuestion_double()));
		questionDTO.setTemps((questionDO.getTemps()));
		questionDTO.setEnonce2((questionDO.getEnonce2()));
		questionDTO.setReponseA((questionDO.getReponseA()));
		questionDTO.setReponseB((questionDO.getReponseB()));
		questionDTO.setReponseC((questionDO.getReponseC()));
		questionDTO.setReponseD((questionDO.getReponseD()));
		questionDTO.setIsReady(questionDO.getIsReady());

		return questionDTO;
	}

	public static SerieService getInstance() {
		if (instance == null) {
			return new SerieService();
		} else {
			return instance;
		}
	}

}
