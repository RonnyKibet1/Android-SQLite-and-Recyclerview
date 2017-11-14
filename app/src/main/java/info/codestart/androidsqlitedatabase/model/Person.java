package info.codestart.androidsqlitedatabase.model;

/**
 * Created by Ronsoft on 11/13/2017.
 */

public class Person {

    private long id;
    private String name;
    private String age;
    private String occupation;
    private String image;

    public Person() {
    }

    public Person(String name, String age, String occupation, String image) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
