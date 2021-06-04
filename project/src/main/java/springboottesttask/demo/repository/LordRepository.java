package springboottesttask.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboottesttask.demo.entity.Lord;

import java.util.List;

@Repository
public interface LordRepository extends CrudRepository<Lord, Long> {

    @Query(value = "select * from lord where lord.id not in (select lord.id from lord join planet on lord.id = planet.lord_id)",nativeQuery = true)
    List<Lord> findSlackerLords();

    @Query(value = "select * from lord order by age limit 10", nativeQuery = true)
    List<Lord> findTop10YoungLords();

}
