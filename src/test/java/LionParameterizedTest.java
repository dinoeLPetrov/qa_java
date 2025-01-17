
import com.example.Lion;
import com.example.ReproductivePredator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedMane;
    private Lion lion;

    @Mock
    private ReproductivePredator predatorMock;

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false }
        });
    }

    @Before
    public void setUp() throws Exception {
        predatorMock = mock(ReproductivePredator.class);
        when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Мясо", "Рыба"));
        when(predatorMock.getKittens()).thenReturn(1);
        lion = new Lion(sex, predatorMock);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        // Проверка на корректный список еды
        List<String> food = lion.getFood();
        assertNotNull(food);
        assertTrue(food.contains("Мясо"));
        assertTrue(food.contains("Рыба"));
    }
    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        // Проверяем, что выбрасывается исключение при передаче некорректного пола
        new Lion("Неизвестно", predatorMock); // Некорректное значение пола
    }
}
