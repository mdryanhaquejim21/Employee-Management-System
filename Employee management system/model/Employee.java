package model;

public class Employee extends Person {
    private String id;
    private String department;
    private double salary;

    public Employee(String name, String gender, String contact, String id, String department, double salary) {
        super(name, gender, contact);
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + getName() + ", Gender: " + getGender() +", Contact: " + getContact() + ", Department: " + department +", Salary: " + salary;
    }
}

