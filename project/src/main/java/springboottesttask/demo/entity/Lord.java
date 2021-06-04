package springboottesttask.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    public Lord(){

    }
    public Lord(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
