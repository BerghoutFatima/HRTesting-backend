package ord.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import ord.sid.entities.Form;

@Repository
@Transactional
public class FormController implements FormRepo{

	@PersistenceContext
	private EntityManager em;


}





