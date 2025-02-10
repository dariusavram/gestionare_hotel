package View;

import javax.swing.*;
import java.awt.*;

public class Login {
    private JPanel loginPanel; // JPanel principal
    private JTextField textField1; // Username field
    private JPasswordField passwordField1; // Password field
    private JButton loginButton; // Login button

    // Getter pentru JPanel-ul principal
    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public JTextField getUsernameField() {
        return textField1;
    }

    public JPasswordField getPasswordField() {
        return passwordField1;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
