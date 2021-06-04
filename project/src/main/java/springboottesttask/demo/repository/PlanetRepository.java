package springboottesttask.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboottesttask.demo.entity.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
}
