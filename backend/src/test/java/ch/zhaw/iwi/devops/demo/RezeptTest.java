package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RezeptTest {
    private Rezept rezept;

    @BeforeEach
    public void setUp() {
        rezept = new Rezept();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, rezept.getId());
        assertEquals(null, rezept.getTitle());
        assertEquals(null, rezept.getOrigin());
        assertEquals(null, rezept.getDescription());
    }

    @Test
    public void testConstructorWithParameters() {
        Rezept rezept = new Rezept(1, "Schokoladenkuchen", "Schweiz", "Leckerer Kuchen mit viel Schokolade.");
        assertEquals(1, rezept.getId());
        assertEquals("Schokoladenkuchen", rezept.getTitle());
        assertEquals("Schweiz", rezept.getOrigin());
        assertEquals("Leckerer Kuchen mit viel Schokolade.", rezept.getDescription());
    }

    @Test
    public void testSetAndGetId() {
        rezept.setId(123);
        assertEquals(123, rezept.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        rezept.setTitle("Apfelkuchen");
        assertEquals("Apfelkuchen", rezept.getTitle());
    }

    @Test
    public void testSetAndGetOrigin() {
        rezept.setOrigin("Deutschland");
        assertEquals("Deutschland", rezept.getOrigin());
    }

    @Test
    public void testSetAndGetDescription() {
        rezept.setDescription("Saftiger Kuchen mit Äpfeln und Zimt");
        assertEquals("Saftiger Kuchen mit Äpfeln und Zimt", rezept.getDescription());
    }
}
