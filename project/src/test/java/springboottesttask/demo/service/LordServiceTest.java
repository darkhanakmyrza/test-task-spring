package springboottesttask.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springboottesttask.demo.entity.Lord;
import springboottesttask.demo.repository.LordRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LordServiceTest {
    private Lord firstLord;
    private Lord secondLord;

    @Mock
    private LordService lordService;
    private LordRepository lordRepository;

    @Before
    public void setUp() {
        firstLord = new Lord(1L, "1 lord", 12);
        secondLord = new Lord(2L, "2 lord", 100);
    }

    @Test
    public void createLordTest(){
        doNothing().when(lordService).createNewLord(firstLord);
        Lord actualLord = firstLord;
        lordService.createNewLord(firstLord);
        //then
        verify(lordService).createNewLord(actualLord);
        assertEquals(firstLord, actualLord);
    }

    @Test
    public void findSlackerLordsTest(){
        List<Lord> expectedSlackerLords = new ArrayList<>();
        expectedSlackerLords.add(firstLord);
        expectedSlackerLords.add(secondLord);

        when(lordService.findSlackerLords()).thenReturn(expectedSlackerLords);

        List<Lord> actualSlackerYoungLords = lordService.findSlackerLords();
        assertEquals(expectedSlackerLords, actualSlackerYoungLords);
        verify(lordService).findSlackerLords();
    }

    @Test
    public void findTop10YoungLordsTest(){
        List<Lord> expectedYoungLords = new ArrayList<>();
        expectedYoungLords.add(firstLord);
        expectedYoungLords.add(secondLord);

        when(lordService.findTop10YoungLords()).thenReturn(expectedYoungLords);

        List<Lord> actualYoungLords = lordService.findTop10YoungLords();
        assertEquals(expectedYoungLords, actualYoungLords);
        verify(lordService).findTop10YoungLords();
    }

}
