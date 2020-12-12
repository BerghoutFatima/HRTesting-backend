package ord.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ord.sid.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

	@Query("select p from Quiz p where p.name like :x ")
	public List<Quiz> chercher(@Param("x")String mc);
	
	
	
	
	
}

