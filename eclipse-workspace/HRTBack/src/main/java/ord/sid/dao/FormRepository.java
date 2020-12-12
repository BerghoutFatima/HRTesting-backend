package ord.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ord.sid.entities.Form;

public interface FormRepository extends JpaRepository<Form,Long> {

	@Query("select p from Form p where p.name like :x ")
	public List<Form> chercher(@Param("x")String mc);
	
	
	
	
	
}

