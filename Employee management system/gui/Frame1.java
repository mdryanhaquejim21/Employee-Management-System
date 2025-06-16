package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import manager.EmployeeManager;
import util.FileHandler;

public class Frame1 extends JFrame implements ActionListener {
    private JButton insertBtn, updateBtn, deleteBtn, viewBtn;
    private JTable table;
    private DefaultTableModel tableModel;

    private EmployeeManager manager;

    public Frame1() {
        setTitle("Employee Management Dashboard");
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 240, 250)); 

        manager = new EmployeeManager(100);
        Employee[] loaded = FileHandler.loadFromFile(100);
        for (Employee e : loaded) {
            if (e != null)
                manager.addEmployee(e);
        }

        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color peachColor = new Color(255, 179, 128); 

        insertBtn = new JButton("Insert");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        viewBtn = new JButton("View All");

        JButton[] buttons = { insertBtn, updateBtn, deleteBtn, viewBtn };
        int x = 50;
        for (JButton btn : buttons) {
            btn.setBounds(x, 30, 120, 30);
            btn.setFont(buttonFont);
            btn.setBackground(peachColor);
            btn.setFocusPainted(false);
            add(btn);
            btn.addActionListener(this);
            x += 150;
        }

        tableModel = new DefaultTableModel(new String[] {"ID", "Name", "Gender", "Contact", "Department", "Salary"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 650, 350);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertBtn) {
            insertEmployee();
        }
        else if (e.getSource() == updateBtn) {
            updateEmployee();
        }
        else if (e.getSource() == deleteBtn) {
            deleteEmployee();
        }
        else if (e.getSource() == viewBtn) {
            loadTable();
        }
    }

    private void insertEmployee() {
        String id = JOptionPane.showInputDialog(this, "Enter ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        String gender = JOptionPane.showInputDialog(this, "Enter Gender:");
        String contact = JOptionPane.showInputDialog(this, "Enter Contact:");
        String dept = JOptionPane.showInputDialog(this, "Enter Department:");
        double salary = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Salary:"));

        Employee e = new Employee(name, gender, contact, id, dept, salary);
        if (manager.addEmployee(e)) {
            FileHandler.saveToFile(manager.getAllEmployees(), manager.getCount());
            JOptionPane.showMessageDialog(this, "Employee added.");
        }
        else {
            JOptionPane.showMessageDialog(this, "Employee list is full.");
        }
    }

    private void updateEmployee() {
        String id = JOptionPane.showInputDialog(this, "Enter ID to update:");
        String dept = JOptionPane.showInputDialog(this, "Enter New Department:");
        double salary = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter New Salary:"));

        if (manager.updateEmployee(id, dept, salary)) {
            FileHandler.saveToFile(manager.getAllEmployees(), manager.getCount());
            JOptionPane.showMessageDialog(this, "Employee updated.");
        }
        else {
            JOptionPane.showMessageDialog(this, "Employee not found.");
        }
    }

    private void deleteEmployee() {
        String id = JOptionPane.showInputDialog(this, "Enter ID to delete:");
        if (manager.deleteEmployee(id)) {
            FileHandler.saveToFile(manager.getAllEmployees(), manager.getCount());
            JOptionPane.showMessageDialog(this, "Employee deleted.");
        }
        else {
            JOptionPane.showMessageDialog(this, "Employee not found.");
        }
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        Employee[] all = manager.getAllEmployees();
        for (Employee e : all) {
            tableModel.addRow(new Object[] {
                    e.getId(), e.getName(), e.getGender(),
                    e.getContact(), e.getDepartment(), e.getSalary()
            });
        }
    }
}
