package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;

    public LoginFrame() {
        setTitle("Login - Employee Management System");
        setSize(500, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230, 240, 250));
        panel.setBounds(0, 0, 500, 590);
        add(panel);

        ImageIcon icon = new ImageIcon(getClass().getResource("emp.png"));
        Image img = icon.getImage().getScaledInstance(500, 220, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBounds(0, 0, 500, 240);
        panel.add(imgLabel);


        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setBounds(100, 240, 100, 30);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200, 240, 180, 30);
        panel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passLabel.setBounds(100, 290, 100, 30);
        panel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 290, 180, 30);
        panel.add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 13));
        loginBtn.setBackground(new Color(255, 179, 128));
        loginBtn.setBounds(200, 350, 100, 35);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful !");
            this.dispose();
            new Frame1();

        }
        else {
            JOptionPane.showMessageDialog(this, "Login Failed ! Try Again");
        }
    }
}
