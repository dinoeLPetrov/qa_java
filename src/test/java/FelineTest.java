
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        // Проверка, что метод eatMeat возвращает корректный список еды
        assertNotNull(feline.eatMeat()); // Проверка на ненулевое значение
        assertEquals(2, feline.eatMeat().size()); // Ожидаем, что список будет содержать 2 элемента
        assertTrue(feline.eatMeat().contains("Мясо")); // Проверка, что в списке есть "Мясо"
        assertTrue(feline.eatMeat().contains("Рыба")); // Проверка, что в списке есть "Рыба"
    }

    @Test
    public void testGetKittens() {
        // Проверка, что метод getKittens возвращает правильное количество котят
        assertEquals(1, feline.getKittens());
    }
}
