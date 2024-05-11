package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoTest {

    @Test
    public void testToDo() {
        var toDo1 = new ToDo(1, "title", "description");
        assertEquals("title", toDo1.getTitle());
        assertEquals("description", toDo1.getDescription());
        assertEquals(1, toDo1.getId());
    }
    
    @Test
    public void testSetters() {
        var toDo2 = new ToDo();
        toDo2.setId(2);

        assertEquals(2, toDo2.getId());
        assertEquals(null, toDo2.getTitle());
        assertEquals(null, toDo2.getDescription());
    }

    @Test
    public void testDefaultConstructor() {
        var toDo3 = new ToDo();
        assertEquals(0, toDo3.getId());
        assertEquals(null, toDo3.getTitle());
        assertEquals(null, toDo3.getDescription());
    }
}
