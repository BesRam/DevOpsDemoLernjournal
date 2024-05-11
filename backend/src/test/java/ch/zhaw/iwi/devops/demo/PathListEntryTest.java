package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PathListEntryTest {

    @Test
    public void testDefaultActive() {
        PathListEntry<?> entry = new PathListEntry<>();
        assertTrue(entry.isActive());
    }

    @Test
    public void testNameSetterGetter() {
        PathListEntry<?> entry = new PathListEntry<>();
        entry.setName("TestName");
        assertEquals("TestName", entry.getName());
    }

    @Test
    public void testKeySetterGetter() {
        PathListEntry<String> entry = new PathListEntry<>();
        entry.setKey("123", "TestKey");
        assertEquals("TestKey", entry.getKey().getName());
        assertEquals("123", entry.getKey().getKey());
    }

    @Test
    public void testActiveSetter() {
        PathListEntry<?> entry = new PathListEntry<>();
        entry.setActive(false);
        assertFalse(entry.isActive());
    }

    @Test
    public void testEqualsAndHashCode() {
        PathListEntry<String> entry1 = new PathListEntry<>();
        PathListEntry<String> entry2 = new PathListEntry<>();
        entry1.setKey("123", "TestKey");
        entry2.setKey("123", "TestKey");
        
        assertEquals(entry1, entry2);
        assertEquals(entry1.hashCode(), entry2.hashCode());
    }
}
