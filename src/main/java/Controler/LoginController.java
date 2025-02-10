package Controler;

import Model.LoginModel;
import View.Login;
import View.afterLogin;

import javax.swing.*;

public class LoginController {

    private LoginModel loginModel;
    private Login loginView;

    public LoginController(LoginModel loginModel, Login loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;

        // Adaugă acțiune pentru butonul de login
        this.loginView.getLoginButton().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = loginView.getUsernameField().getText();
        String password = new String(loginView.getPasswordField().getPassword());

        if (loginModel.validateLogin(username, password)) {
            JOptionPane.showMessageDialog(null, "Login reușit!", "Succes", JOptionPane.INFORMATION_MESSAGE);

            // Navigare către interfața afterLogin
            JFrame frame = new JFrame("After Login");
            afterLogin afterLoginView = new afterLogin();
            new afterLoginController(afterLoginView);

            frame.setContentPane(afterLoginView.getAfterLoginPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fereastra deschisă pe tot ecranul
            frame.setVisible(true);

            // Închide fereastra curentă
            SwingUtilities.getWindowAncestor(loginView.getLoginPanel()).dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Nume sau parolă incorectă!", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }
}
