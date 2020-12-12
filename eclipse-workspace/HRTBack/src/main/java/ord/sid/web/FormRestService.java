package ord.sid.web;

import ord.sid.entities.User;

import ord.sid.entities.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ord.sid.dao.FormController;
import ord.sid.dao.FormRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@RestController
//@CrossOrigin("*") // pour autoriser les requettes http de n'importe quelle domaine(*) de recuperer les donnees

public class FormRestService {

	@Autowired
	private FormRepository formRepository;
	@Autowired
	private FormController formController;

	//les methodes a utiliser // @RequestMapping pour acceder a la methode via une requete http
	
	//lister forms
	@RequestMapping(value="/listforms",method=RequestMethod.GET)
	public List<Form> listforms() {
		return  formRepository.findAll();
	}
	
	
	
		
	
		
		//Chercher 1 form
		@RequestMapping(value="/chercherForm",method=RequestMethod.GET)
			public List<Form> cherCher(
					@RequestParam(name="mc", defaultValue="") String mc)
					 {
				return formRepository.chercher("%"+ mc +"%");
			}
		
	
	
	
	//consulter form
		@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/detailsForm/{id}",method=RequestMethod.GET)
	public Optional<Form> detailsForm(@PathVariable Long id){
		return formRepository.findById(id);
	}
	
	//ajouter form
	@RequestMapping(value="/addForm",method=RequestMethod.POST)
	public Form addForm(@RequestBody Form p) {
		return formRepository.save(p);
	}
	
	
	//supprimer form
	@RequestMapping(value="/supprimerForm/{id}",method=RequestMethod.DELETE)
	public boolean supprimerForm(@PathVariable Long id) {
		formRepository.deleteById(id);
		return true;
	}
	
	//modifier form
	@RequestMapping(value="/updateForm/{id}",method=RequestMethod.PUT)
	public Form modifierForm(@PathVariable(name="id") Long id,@RequestBody Form p) {
		p.setId(id);
		return formRepository.save(p);
	}
	
	
}
