package springboottesttask.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboottesttask.demo.entity.Lord;
import springboottesttask.demo.entity.Planet;
import springboottesttask.demo.repository.LordRepository;
import springboottesttask.demo.service.LordService;
import springboottesttask.demo.service.PlanetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    private LordService lordService;
    private PlanetService planetService;

    @Autowired
    private LordRepository lordRepository;

    @Autowired
    public MainController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @PostMapping("/lord/add")
    public String addNewLord(@RequestBody Lord lord){
        System.out.println("LORD");
        lordService.createNewLord(lord);
        return "New lord created";
    }

    @PostMapping("/planet/add")
    public String addNewPlanet(@RequestBody Planet planet){
        planetService.createNewPlanet(planet);
        return "New planet created";
    }

    @PostMapping("/update/planet/{planetId}/{lordId}")
    public String updatePlanetLord(@PathVariable("planetId") Long planetId,
                                 @PathVariable("lordId") Long lordId){
        planetService.assignLordToPlanet(planetId, lordId);
        return "Lord for the planet assigned";
    }

    @DeleteMapping("/planet/{planetId}")
    public String deletePlanet(@PathVariable("planetId") Long planetId){
        planetService.deletePlanet(planetId);
        return "planet deleted";
    }

    @GetMapping("/lords/slacker")
    public List<Lord> getSlackerLords(){
        List<Lord> lordList =  lordService.findSlackerLords();
        return lordList;
    }

    @GetMapping("/lords/young")
    public List<Lord> getTop10YoungLords(){
        List<Lord> lordList = lordService.findTop10YoungLords();
        return lordList;
    }

    @GetMapping("/lord/{lordId}")
    public Lord getLordById(@PathVariable("lordId") Long lordId){
        Lord lord = lordRepository.findById(lordId).get();
        return lord;
    }
}
