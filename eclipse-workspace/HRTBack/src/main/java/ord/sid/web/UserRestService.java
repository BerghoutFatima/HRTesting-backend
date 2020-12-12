package ord.sid.web;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ord.sid.dao.UserController;
import ord.sid.dao.UserRepository;
import ord.sid.entities.User;


@RestController
@CrossOrigin("*")
public class UserRestService  {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserController userController;
	
	
	
	//lister collabs
		@RequestMapping(value="/listerUsers",method=RequestMethod.GET)
		public List<User> listerEtudiants() {
			return userRepository.findAll();
		}
	
	
	//ajouter a collab
		@RequestMapping(value="/ajouterUser",method=RequestMethod.POST)
		public User ajouterEtudiant(@RequestBody User e) {
			return userRepository.save(e);
		}
	
		
		@RequestMapping(value="/trouverUser",method=RequestMethod.GET)
		public List<User> findByUsernameOrEmail(
				@RequestParam(name="un", defaultValue="") String un,@RequestParam(name="email", defaultValue="") String email)
				 {
			return userRepository.findByUsernameOrEmail(un,email);
			
		}
		
		//trouver l collabs by username
		@RequestMapping(value="/trouverUserByUsername",method=RequestMethod.GET)
		public List<User> findByUsername(@RequestParam(name="un", defaultValue="") String un)
				 {
			return userRepository.findByUsername(un);
			
		}
		
		//trouver le collab par son login ( email & pwd)
		
		@RequestMapping(value="/trouverUserParLogin",method=RequestMethod.GET)
		public List<User> findByUsernameAndPwd(
				@RequestParam(name="email", defaultValue="") String email,@RequestParam(name="password", defaultValue="") String password)
				 {
			return userRepository.findByUsernameAndPwd(email,password);
				 }
	//chercher  collab by email
			@RequestMapping(value="/trouverUserByEmail/{val}",method=RequestMethod.GET)
			public List<User> findByEmail(@PathVariable String val) {
				return userController.findByEmail(val);
		}
			
		//modifier collab
			@RequestMapping(value="/updateUser/{id}",method=RequestMethod.PUT)
			public User modifierProjet(@PathVariable(name="id") Long id,@RequestBody User e) {
				e.setId(id);
				return userRepository.save(e);
			}
			
			

}
