package web.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false)
    private String fullName;
    @Column (nullable = false)
    private int age;
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public User(int id, String fullName, int age, Sex sex) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
    }
    public User(String fullName, int age, Sex sex) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
    }
    public User() {}

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

}
