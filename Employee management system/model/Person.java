package model;

public abstract class Person {
    private String name;
    private String gender;
    private String contact;

    public Person(String name, String gender, String contact) {
        this.name = name;
        this.gender = gender;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
