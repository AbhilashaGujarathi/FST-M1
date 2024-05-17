package Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void addNumbers() {
        Calculator calculator = new Calculator();

        // Assertion
        assertEquals(3, calculator.add(1, 2)); // Passes
        assertNotEquals(3, calculator.add(1, 2)); // Fails
    }

    @Test
    void firstNameStartsWithJ() {
        //Person person = new Person("John", "Doe");

        // Assertion
        //assertTrue(person.getFirstName().startsWith("J")); //Pass
       // assertFalse(person.getFirstName().startsWith("J")); // Fail
    }
}
