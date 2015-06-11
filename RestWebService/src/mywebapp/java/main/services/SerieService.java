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

		final SerieDTO serieDTO = serieDOtoDTO(serieDAO.recupererSerieEnCours());

		return serieDTO;
	}

	public String closeConnexion(final String numSerie) {
		return serieDAO.closeConnexion(numSerie);
	}

	public QuestionDTO recupererQuestion(final String numeroSerie,
			final int numeroQuestion) {

		final QuestionDTO questionDTO = questionDOtoDTO(serieDAO
				.recupererQuestionDO(numeroSerie, numeroQuestion));

		return questionDTO;
	}

	public boolean activerQuestion(final QuestionDTO questionDTO) {

		final QuestionDO questionDO = questionDTOtoDO(questionDTO);

		return serieDAO.activerQuestionDO(questionDO);
	}

	public String ajouterQuestion(final QuestionDO question) {
		return serieDAO.ajoutQuestion(question);
	}

	public static SerieService getInstance() {
		if (instance == null) {
			return new SerieService();
		} else {
			return instance;
		}
	}

	private SerieDTO serieDOtoDTO(final SerieDO serieDO) {
		final SerieDTO serieDTO = new SerieDTO();

		serieDTO.setId(serieDO.getId());
		serieDTO.setNum_serie(serieDO.getNum_serie());
		serieDTO.setScore_moyen(serieDO.getScore_moyen());
		serieDTO.setDate_creation(serieDO.getDate_creation());
		serieDTO.setDate_passage(serieDO.getDate_passage());

		return serieDTO;
	}

	private QuestionDTO questionDOtoDTO(final QuestionDO questionDO) {
		final QuestionDTO questionDTO = new QuestionDTO();

		questionDTO.setId(questionDO.getId());
		questionDTO.setId_serie(questionDO.getId_serie());
		questionDTO.setEnonce(questionDO.getEnonce());
		questionDTO.setEnonce2(questionDO.getEnonce2());
		questionDTO.setImage(questionDO.getImage());
		questionDTO.setNum_question(questionDO.getNum_question());
		questionDTO.setQuestion_double(questionDO.isQuestion_double());
		questionDTO.setReponse1((questionDO.getReponse1()));
		questionDTO.setReponse2(questionDO.getReponse2());
		questionDTO.setReponseA(questionDO.getReponseA());
		questionDTO.setReponseB(questionDO.getReponseB());
		questionDTO.setReponseC(questionDO.getReponseC());
		questionDTO.setReponseD(questionDO.getReponseD());
		questionDTO.setTemps(questionDO.getTemps());
		questionDTO.setIsReady(questionDO.getIs_ready());

		return questionDTO;
	}

	private QuestionDO questionDTOtoDO(final QuestionDTO questionDTO) {
		final QuestionDO questionDO = new QuestionDO();

		questionDO.setId(questionDTO.getId());
		questionDO.setId_serie(questionDTO.getId_serie());
		questionDO.setEnonce(questionDTO.getEnonce());
		questionDO.setEnonce2(questionDTO.getEnonce2());
		questionDO.setImage(questionDTO.getImage());
		questionDO.setNum_question(questionDTO.getNum_question());
		questionDO.setQuestion_double(questionDTO.getQuestion_double());
		questionDO.setReponse1(questionDTO.getReponse1());
		questionDO.setReponse2(questionDTO.getReponse2());
		questionDO.setReponseA(questionDTO.getReponseA());
		questionDO.setReponseB(questionDTO.getReponseB());
		questionDO.setReponseC(questionDTO.getReponseC());
		questionDO.setReponseD(questionDTO.getReponseD());
		questionDO.setTemps(questionDTO.getTemps());
		questionDO.setIs_ready((questionDTO.getIsReady()));

		return questionDO;
	}

}
