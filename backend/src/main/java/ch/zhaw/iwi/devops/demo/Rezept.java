package ch.zhaw.iwi.devops.demo;

public class Rezept {
    private int id;
    private String title;
    private String origin;
    private String description;

    public Rezept(){}

    public Rezept(int id, String title, String origin, String description){
        this.id = id;
        this.title = title;
        this.origin = origin;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
