package util;
import model.Employee;
import java.io.*;

public class FileHandler {
    private static final String FILE_NAME = "employees.txt";


    public static void saveToFile(Employee[] employees, int count) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (int i = 0; i < count; i++) {
                Employee e = employees[i];
                String line = e.getId() + "," + e.getName() + "," + e.getGender() + "," + e.getContact() + "," + e.getDepartment() + "," + e.getSalary();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public static Employee[] loadFromFile(int maxSize) {
        Employee[] employees = new Employee[maxSize];
        int index = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = br.readLine()) != null && index < maxSize) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0];
                    String name = parts[1];
                    String gender = parts[2];
                    String contact = parts[3];
                    String dept = parts[4];
                    double salary = Double.parseDouble(parts[5]);

                    employees[index] = new Employee(name, gender, contact, id, dept, salary);
                    index++;
                }
            }
            br.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found, starting with empty list.");
        }
        catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid salary format in file.");
        }

        return employees;
    }
}
