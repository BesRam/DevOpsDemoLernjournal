package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RezeptController {
    
    private Map<Integer, Rezept> rezepte = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.rezepte.put(1,new Rezept(1, "Pizza", "Italien", "Italienische Pizza nach Mamas Art"));
        this.rezepte.put(2,new Rezept(2, "Baguette", "Frankreich", "Baguette aus Frankreich"));
        this.rezepte.put(3,new Rezept(3, "Tsatsiki", "Griechenland", "Griechisches Tsatsiki mit Brot"));
        this.rezepte.put(4,new Rezept(4, "Currywurst", "Deutschland", "Deutsche Currywurst mit Ketchup"));
        this.rezepte.put(5,new Rezept(5, "Fajita", "Mexiko", "Mexikanische Fajitas mit Poulet"));
        System.out.println("Init Data");
    }

    @GetMapping("/recipetest")
    public String test() {
        return "Recipe app is up and running!";
    }

    @GetMapping("/recipecount")
    public int count() {
        return this.rezepte.size();
    }

    @GetMapping("/services/recipe")
    public List<PathListEntry<Integer>> recipe() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var recipe : this.rezepte.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(recipe.getId(), "recipeKey");
            entry.setName(recipe.getTitle());
            entry.getDetails().add(recipe.getDescription());
            entry.setTooltip(recipe.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/recipe/{key}")
    public Rezept getRecipe(@PathVariable Integer key) {
        return this.rezepte.get(key);
    }

    @PostMapping("/services/recipe")
    public void createRecipe(@RequestBody Rezept recipe) {
        var newId = this.rezepte.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        recipe.setId(newId);
        this.rezepte.put(newId, recipe);
    }

    @PutMapping("/services/recipe/{id}")
    public void createRecipe(@PathVariable Integer id, @RequestBody Rezept recipe) {
        recipe.setId(id);
        this.rezepte.put(id, recipe);
    }

    @DeleteMapping("/services/recipe/{key}")
    public Rezept deleteRecipe(@PathVariable Integer key) {
        return this.rezepte.remove(key);
    }
}
