package org.example;

import Controler.LoginController;
import Model.LoginModel;
import View.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Creează View și Model pentru login
        Login loginView = new Login();
        LoginModel loginModel = new LoginModel();

        // Creează Controller pentru Login
        new LoginController(loginModel, loginView);

        // Setează fereastra principală pentru Login
        JFrame frame = new JFrame("Login");
        frame.setContentPane(loginView.getLoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fereastra deschisă pe tot ecranul
        frame.setVisible(true);
    }
}
