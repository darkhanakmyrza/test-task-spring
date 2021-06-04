package springboottesttask.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboottesttask.demo.entity.Lord;
import springboottesttask.demo.repository.LordRepository;

import java.util.List;

@Service
public class LordService {

    private LordRepository lordRepository;

    @Autowired
    public LordService(LordRepository lordRepository) {
        this.lordRepository = lordRepository;
    }

    public void createNewLord(Lord lord){
        lordRepository.save(lord);
    }

    public List<Lord> findSlackerLords(){
        return lordRepository.findSlackerLords();
    }

    public List<Lord> findTop10YoungLords(){
        return lordRepository.findTop10YoungLords();
    }

}
