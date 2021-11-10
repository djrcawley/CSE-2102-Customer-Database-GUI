import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    public void mainMenu() {

        JFrame mainMenu = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        ButtonGroup menuOptions = new ButtonGroup();

        newMenuOption(panel, menuOptions, "Create Profile");
        newMenuOption(panel, menuOptions, "Delete Profile");
        newMenuOption(panel, menuOptions, "Update Profile");
        newMenuOption(panel, menuOptions, "Find/Display Profile");
        newMenuOption(panel, menuOptions, "Display All Profiles");

        JButton selectButton = new JButton("SELECT");
        selectButton.addActionListener(this);
        panel.add(selectButton);

        mainMenu.add(panel, BorderLayout.CENTER);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setTitle("Welcome To the DJ ICS");
        mainMenu.pack();
        mainMenu.setVisible(true);
    }

    public void newMenuOption(JPanel panel, ButtonGroup option, String string){
        JRadioButton newOption = new JRadioButton(string);
        newOption.setActionCommand(string);
        panel.add(newOption);
        option.add(newOption);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {

    }

    // create one Frame
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.mainMenu();
    }
}
