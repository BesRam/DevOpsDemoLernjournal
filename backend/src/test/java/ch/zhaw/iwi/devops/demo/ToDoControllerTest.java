package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoControllerTest {

    private ToDoController controller;

    @BeforeEach
    void setUp() {
        controller = new ToDoController();
        controller.init(); // Manuell die Initialisierung aufrufen, um die Todos zu laden
    }

    @Test
    void testCreate() {
        ToDo todo = new ToDo(0, "t", "d");
        controller.createTodo(todo);
        assertEquals(6, controller.count());
    }

    @Test
    void testUpdateTodo() {
        ToDo updatedTodo = new ToDo(1, "Update", "Updated Description");
        controller.createTodo(1, updatedTodo);
        ToDo result = controller.getTodo(1);
        assertNotNull(result);
        assertEquals("Update", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
    }

    @Test
    void testDeleteTodo() {
        ToDo deletedTodo = controller.deleteTodo(1);
        assertNotNull(deletedTodo);
        assertNull(controller.getTodo(1));
    }

    @Test
    void testGetTodoById() {
        ToDo result = controller.getTodo(1);
        assertNotNull(result);
        assertEquals("Neuer Job", result.getTitle());
    }

    @Test
    void testListTodos() {
        List<PathListEntry<Integer>> todos = controller.todo();
        assertNotNull(todos);
        assertFalse(todos.isEmpty());
        assertEquals(5, todos.size()); // 5 todos are initialized
    }

    @Test
    void testInit() {
        assertEquals(5, controller.count());
    }

    @Test
    void testServiceStatus() {
        String status = controller.test();
        assertEquals("ToDo app is up and running!", status);
    }

    @Test
    void testPing() {
        String pingResponse = controller.ping();
        assertTrue(pingResponse.contains("\"status\": \"ok\""));
        assertTrue(pingResponse.contains("\"userId\": \"admin\""));
        assertTrue(pingResponse.contains("\"languageCode\": \"de\""));
        assertTrue(pingResponse.contains("\"version\": \"0.0.1\""));
    }

}