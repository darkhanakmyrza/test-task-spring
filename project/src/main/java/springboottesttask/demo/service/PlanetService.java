package springboottesttask.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboottesttask.demo.entity.Lord;
import springboottesttask.demo.entity.Planet;
import springboottesttask.demo.repository.LordRepository;
import springboottesttask.demo.repository.PlanetRepository;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;
    private LordRepository lordRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository, LordRepository lordRepository) {
        this.planetRepository = planetRepository;
        this.lordRepository = lordRepository;
    }

    public void createNewPlanet(Planet planet){
        planetRepository.save(planet);
    }

    public void assignLordToPlanet(Long planetId, Long lordId){
        Planet planet =  planetRepository.findById(planetId).get();
        Lord lord = lordRepository.findById(lordId).get();
        planet.setLord(lord);
        planetRepository.save(planet);
    }

    public void deletePlanet(Long planetId){
        planetRepository.deleteById(planetId);
    }



}
