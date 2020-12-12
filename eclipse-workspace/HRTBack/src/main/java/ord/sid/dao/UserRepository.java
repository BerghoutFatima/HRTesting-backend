package ord.sid.dao;




import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ord.sid.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {  
	@Query("select e from User e where e.username = :x or e.email = :c ")
	public List<User> findByUsernameOrEmail(@Param("x")String un,@Param("c")String email );
	
	@Query("select e from User e where e.email = :x and e.password = :c ")
	public List<User> findByUsernameAndPwd(@Param("x")String email,@Param("c")String password );
	
	@Query("select e from User e where e.username = :x ")
	public List<User> findByUsername(@Param("x")String username);
}






