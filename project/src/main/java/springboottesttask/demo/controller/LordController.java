package springboottesttask.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboottesttask.demo.entity.Lord;
import springboottesttask.demo.entity.Planet;
import springboottesttask.demo.service.LordService;
import springboottesttask.demo.service.PlanetService;

@Controller
@RequestMapping("/lord")
public class LordController {

    private LordService lordService;
    private PlanetService planetService;

    @Autowired
    public LordController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/createLord")
    public String createLordPage(){
        return "createLord";
    }

    @PostMapping("/createLord")
    public String saveLord(@ModelAttribute("lordForm") Lord lord){
        lordService.createNewLord(lord);
        return "index";
    }

    @GetMapping("/createPlanet")
    public String createPlanet(){
        return "createPlanet";
    }

    @PostMapping("/createPlanet")
    public String savePlanet(@ModelAttribute("planetForm")Planet planet){
        planetService.createNewPlanet(planet);
        return "index";
    }


}

