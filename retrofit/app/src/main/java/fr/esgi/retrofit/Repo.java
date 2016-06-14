package fr.esgi.retrofit;

/**
 * Created by mohsan on 14/06/16.
 */
public class Repo {

    String name;
    String id;


    public Repo(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
