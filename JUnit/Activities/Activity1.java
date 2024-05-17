package Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {

    static ArrayList<String> list;


    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("Ram"); // at index 0
        list.add("Mohan"); // at index 1
    }

    // Test method to test the insert operation
    @Test
    public void insertTest() {
        // Assertion for size
        assertEquals(2, list.size(), "Wrong size");
        // Add new element
        list.add(2, "Ronaldo");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");

        // Assert individual elements
        assertEquals("Ram", list.get(0), "Wrong element");
        assertEquals("Mohan", list.get(1), "Wrong element");
        assertEquals("Ronaldo", list.get(2), "Wrong element");
    }

    // Test method to test the replace operation
    @Test
    public void replaceTest() {
        // Replace new element
        list.set(1, "Apple");

        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");
        // Assert individual elements
        assertEquals("Ram", list.get(0), "Wrong element");
        assertEquals("Apple", list.get(1), "Wrong element");
    }

}
