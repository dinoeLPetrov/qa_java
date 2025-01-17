
import com.example.Cat;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    private Predator predatorMock;

    private Cat cat;

    @Before
    public void setUp() {
        predatorMock = mock(Predator.class);
        cat = new Cat(predatorMock);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));
        List<String> food = cat.getFood();
        assertNotNull(food);
        assertEquals(List.of("Мясо", "Рыба"), food);
    }
}
