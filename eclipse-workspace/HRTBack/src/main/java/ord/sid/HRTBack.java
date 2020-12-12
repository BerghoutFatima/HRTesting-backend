package ord.sid;




import javax.annotation.Resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ord.sid.dao.UserRepository;
import ord.sid.entities.User;
 

@SpringBootApplication
public class HRTBack  implements CommandLineRunner  {
	
	//pour l'ijection des dependances ==> @Autowired
	
	@Autowired
	private UserRepository userRepository;
	

	
	public static void main(String[] args) {
		SpringApplication.run(HRTBack.class, args);
	}
	
	 @Override
	  public void run(String... arg) throws Exception {
	    
	  }

	
}
	




