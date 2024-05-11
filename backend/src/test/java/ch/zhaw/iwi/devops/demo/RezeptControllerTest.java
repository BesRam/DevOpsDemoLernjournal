package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RezeptControllerTest {
    private RezeptController controller;

    @BeforeEach
    public void setUp() {
        controller = new RezeptController();
        controller.init();
    }

    @Test
    public void testInit() {
        assertEquals(5, controller.count());
    }

    @Test
    public void testTest() {
        assertEquals("Recipe app is up and running!", controller.test());
    }

    @Test
    public void testCount() {
        assertEquals(5, controller.count());
    }

    @Test
    public void testGetRecipe() {
        Rezept result = controller.getRecipe(1);
        assertNotNull(result);
        assertEquals("Pizza", result.getTitle());
    }

    @Test
    public void testCreateRecipe() {
        Rezept newRecipe = new Rezept(0, "Sushi", "Japan", "Traditionelles japanisches Sushi");
        controller.createRecipe(newRecipe);
        assertEquals(6, controller.count());
        assertEquals("Sushi", controller.getRecipe(6).getTitle());
    }

    @Test
    public void testUpdateRecipe() {
        Rezept updatedRecipe = new Rezept(1, "Pizza", "Italien", "Verbesserte italienische Pizza");
        controller.createRecipe(1, updatedRecipe);
        assertEquals("Verbesserte italienische Pizza", controller.getRecipe(1).getDescription());
    }

    @Test
    public void testDeleteRecipe() {
        controller.deleteRecipe(1);
        assertNull(controller.getRecipe(1));
        assertEquals(4, controller.count());
    }

    @Test
    public void testRecipe() {
        assertEquals(5, controller.recipe().size());
    }

    @Test
    public void testDeleteNonExistingRecipe() {
        assertNull(controller.deleteRecipe(10));
        assertEquals(5, controller.count());
    }
}
