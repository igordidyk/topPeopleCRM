package cz.topPeople.dao;


import cz.topPeople.entity.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoordinatorDAO  extends JpaRepository<Coordinator,Integer>{
    @Query(value = "from  Coordinator c where c.username=:username ")
    public Coordinator findByUserName(@Param("username") String username);

}
