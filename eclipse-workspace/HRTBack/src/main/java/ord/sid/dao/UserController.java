package ord.sid.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ord.sid.entities.User;
@Repository
@Transactional
public class UserController implements UserRepo{
	@PersistenceContext
	private EntityManager em;

	
	
	public List<User> findByEmail(String val) {
		Query req = em.createQuery("select u from User u where u.email like :x ");
		req.setParameter("x", val);
		return req.getResultList();
	}
	

}


