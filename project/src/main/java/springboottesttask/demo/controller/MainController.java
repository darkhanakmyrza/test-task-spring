package springboottesttask.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboottesttask.demo.entity.Lord;

@RestController
@RequestMapping("/api")
public class MainController {

    @PostMapping("/lord/add")
    public void addNewLord(@RequestBody Lord lord){
        //add
    }
}
