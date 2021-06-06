package springboottesttask.demo.service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springboottesttask.demo.entity.Lord;
import springboottesttask.demo.entity.Planet;
import springboottesttask.demo.repository.LordRepository;
import springboottesttask.demo.repository.PlanetRepository;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PlanetServiceTest {

    private Planet firstPlanet;
    private Planet secondPlanet;
    private Lord lord;

    @Mock
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    @Before
    public void setUp() {
        firstPlanet = new Planet(1L,"1 planet",null);
        secondPlanet = new Planet(2L,"2 planet",null);
        lord = new Lord(1L, "lord", 100);
    }

    @Test
    public void createNewPlanetTest(){
        doNothing().when(planetService).createNewPlanet(firstPlanet);
        Planet actualPlanet = firstPlanet;
        planetService.createNewPlanet(firstPlanet);
        verify(planetService).createNewPlanet(actualPlanet);
        assertEquals(firstPlanet, actualPlanet);
    }

    @Test
    public void assignLordToPlanetTest(){

        Planet expectedPlanet = firstPlanet;
        expectedPlanet.setLord(lord);

        when(planetRepository.findById(expectedPlanet.getId())).thenReturn(Optional.of(expectedPlanet));

        Planet actualPlanet = expectedPlanet;
        planetService.assignLordToPlanet(actualPlanet.getId(), lord.getId());
        actualPlanet = planetRepository.findById(actualPlanet.getId()).get();

        assertEquals(actualPlanet, expectedPlanet);


    }
}
