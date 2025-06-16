package manager;
import model.Employee;

public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public boolean addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            return true;
        }
        return false;
    }

    public Employee getEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equals(id)) {
                return employees[i];
            }
        } 
        return null;
    }

    public boolean updateEmployee(String id, String newDept, double newSalary) {
        Employee emp = getEmployee(id);
        if (emp != null) {
            emp.setDepartment(newDept);
            emp.setSalary(newSalary);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public Employee[] getAllEmployees() {
        Employee[] current = new Employee[count];
        for (int i = 0; i < count; i++) {
            current[i] = employees[i];
        }
        return current;
    }

    public int getCount() {
        return count;
    }
}
