package View;

import Controler.afterLoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainScreenCamere extends Component {
    private JPanel mainScreenCamerePanel;
    private JButton camera1Button;
    private JButton camera2Button;
    private JButton camera3Button;
    private JButton camera4Button;
    private JButton camera5Button;
    private JButton camera6Button;
    private JButton camera7Button;
    private JButton camera8Button;
    private JButton camera9Button;
    private JButton backButton;

    private static final String STATE_FILE = "buttonStates.dat"; // Fișier pentru salvarea stării butoanelor
    private Map<JButton, String> buttonStates = new HashMap<>(); // Map pentru starea fiecărui buton

    public MainScreenCamere() {
        initializeButtons();

        // Adaugă ActionListener pentru fiecare buton
        addActionListeners();

        // Adaugă funcționalitatea pentru backButton
        backButton.addActionListener(e -> openAfterLogin());
    }

    private void initializeButtons() {
        // Initializează starea fiecărui buton ca verde
        buttonStates.put(camera1Button, "GREEN");
        buttonStates.put(camera2Button, "GREEN");
        buttonStates.put(camera3Button, "GREEN");
        buttonStates.put(camera4Button, "GREEN");
        buttonStates.put(camera5Button, "GREEN");
        buttonStates.put(camera6Button, "GREEN");
        buttonStates.put(camera7Button, "GREEN");
        buttonStates.put(camera8Button, "GREEN");
        buttonStates.put(camera9Button, "GREEN");

        // Încarcă starea din fișier
        loadButtonStates();

        // Setează culoarea inițială a butoanelor
        for (Map.Entry<JButton, String> entry : buttonStates.entrySet()) {
            setColor(entry.getKey(), entry.getValue());
        }
    }

    private void addActionListeners() {
        for (JButton button : buttonStates.keySet()) {
            button.setOpaque(true);
            button.setBorderPainted(false); // Elimină conturul pentru a evidenția culoarea
            button.addActionListener(e -> changeButtonColor(button));
        }
    }

    private void changeButtonColor(JButton button) {
        String currentState = buttonStates.get(button);
        String nextState;

        switch (currentState) {
            case "GREEN":
                nextState = "RED";
                break;
            case "RED":
                nextState = "YELLOW";
                break;
            case "YELLOW":
                nextState = "GREEN";
                break;
            default:
                nextState = "GREEN";
                break;
        }

        buttonStates.put(button, nextState);
        setColor(button, nextState);

        // Salvează starea curentă
        saveButtonStates();
    }

    private void setColor(JButton button, String state) {
        switch (state) {
            case "GREEN":
                button.setBackground(Color.GREEN);
                break;
            case "RED":
                button.setBackground(Color.RED);
                break;
            case "YELLOW":
                button.setBackground(Color.YELLOW);
                break;
        }
    }

    private void saveButtonStates() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STATE_FILE))) {
            Map<String, String> simplifiedState = new HashMap<>();
            for (Map.Entry<JButton, String> entry : buttonStates.entrySet()) {
                simplifiedState.put(entry.getKey().getText(), entry.getValue());
            }
            oos.writeObject(simplifiedState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadButtonStates() {
        File file = new File(STATE_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Map<String, String> savedStates = (Map<String, String>) ois.readObject();
            for (JButton button : buttonStates.keySet()) {
                String state = savedStates.get(button.getText());
                if (state != null) {
                    buttonStates.put(button, state);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void openAfterLogin() {
        // Închide fereastra curentă
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainScreenCamerePanel);
        if (currentFrame != null) {
            currentFrame.dispose(); // Închide fereastra curentă
        }

        // Creează și afișează noua fereastră pentru afterLogin
        JFrame afterLoginFrame = new JFrame("After Login");
        afterLogin afterLoginView = new afterLogin(); // Instanță a clasei afterLogin
        afterLoginFrame.setContentPane(afterLoginView.getAfterLoginPanel());
        afterLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        afterLoginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        afterLoginFrame.setVisible(true);
    }

    public JPanel getMainScreenCamerePanel() {
        return mainScreenCamerePanel;
    }
    public JButton getBackButton() {
        return backButton;
    }

}