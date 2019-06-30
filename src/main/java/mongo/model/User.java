package mongo.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {
    @Id
    private String id;

    private String name;
    private String lastName;
    private List<String> hobby;

    public User() {

    }

    public User(String name, String lastName, List<String> hobby) {
        this.name = name;
        this.lastName = lastName;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
