import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    boolean command1 = false;
    boolean command2 = false;
    boolean command3 = false;
    boolean command4 = false;
    boolean command5 = false;

    public void mainMenu() {

        JFrame mainMenu = new JFrame();
        JLabel createProf = new JLabel("Create Profile");
        JLabel deleteProf = new JLabel("Delete Profile");
        JLabel updateProf = new JLabel("Update Profile");
        JLabel findProf = new JLabel("Find/Display Profile");
        JLabel displayAll = new JLabel("Display All Profiles");

        JButton selectButton = new JButton("SELECT");
        selectButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(createProf);
        panel.add(deleteProf);
        panel.add(updateProf);
        panel.add(findProf);
        panel.add(displayAll);
        panel.add(selectButton);

        mainMenu.add(panel, BorderLayout.CENTER);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setTitle("Welcome To the DJ ICS");
        mainMenu.pack();
        mainMenu.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        if (command1 == true){
            //Call createProf GUI

        }
        if (command2 == true){
            //Call deleteProf GUI
        }
        if (command3 == true){
            //Call updateProf GUI
        }
        if (command4 == true){
            //Call findProf GUI
        }
        if (command5 == true){
            //Call display GUI
        }
        else{

        }
    }

    // create one Frame
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.mainMenu();
    }
}
