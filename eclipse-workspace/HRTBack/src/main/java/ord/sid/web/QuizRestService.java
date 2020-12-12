package ord.sid.web;

import ord.sid.entities.User;


import ord.sid.entities.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ord.sid.dao.QuizController;
import ord.sid.dao.QuizRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@RestController
@CrossOrigin("*") // pour autoriser les requettes http de n'importe quelle domaine(*) de recuperer les donnees

public class QuizRestService {

	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private QuizController quizController;

	//les methodes a utiliser // @RequestMapping pour acceder a la methode via une requete http
	
	//lister quizs
	@RequestMapping(value="/listquizs",method=RequestMethod.GET)
	public List<Quiz> listquiz() {
		return  quizRepository.findAll();
	}
	
	
	
	
		
	
	
		//Chercher 1 quiz 
		@RequestMapping(value="/chercherQuiz",method=RequestMethod.GET)
			public List<Quiz> cherCher(
					@RequestParam(name="mc", defaultValue="") String mc)
					 {
				return quizRepository.chercher("%"+ mc +"%");
			}
		
	
	
	//consulter quiz
	@RequestMapping(value="/detailsQuiz/{id}",method=RequestMethod.GET)
	public Optional<Quiz> detailsQuiz(@PathVariable Long id){
		return quizRepository.findById(id);
	}
	
	//ajouter quiz
	@RequestMapping(value="/addQuiz",method=RequestMethod.POST)
	public Quiz addQuiz(@RequestBody Quiz p) {
		return quizRepository.save(p);
	}
	
	
	//supprimer quiz
	/*@RequestMapping(value="/supprimerProjets/{id}",method=RequestMethod.DELETE)
	public boolean supprimerProjet(@PathVariable Long id) {
		formRepository.deleteById(id);
		return true;
	}*/
	
	//modifier quiz
	@RequestMapping(value="/updateQuiz/{id}",method=RequestMethod.PUT)
	public Quiz modifierQuiz(@PathVariable(name="id") Long id,@RequestBody Quiz p) {
		p.setId(id);
		return quizRepository.save(p);
	}
	
	
}
