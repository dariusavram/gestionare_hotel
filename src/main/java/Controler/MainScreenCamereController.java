package Controler;

import View.MainScreenCamere;
import View.afterLogin;

import javax.swing.*;

public class MainScreenCamereController {
    private MainScreenCamere mainScreenCamereView;

    public MainScreenCamereController(MainScreenCamere mainScreenCamereView) {
        this.mainScreenCamereView = mainScreenCamereView;
        // Configurăm acțiunea pentru backButton
        mainScreenCamereView.getBackButton().addActionListener(e -> openAfterLogin());
    }
    private void openAfterLogin() {
        System.out.println("Navigăm la After Login.");
        JFrame frame = new JFrame("After Login");
        afterLogin afterLoginView = new afterLogin();
        new afterLoginController(afterLoginView);

        frame.setContentPane(afterLoginView.getAfterLoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fereastra deschisă pe tot ecranul
        frame.setVisible(true);

        // Închide fereastra curentă
        SwingUtilities.getWindowAncestor(mainScreenCamereView.getMainScreenCamerePanel()).dispose();
    }

}