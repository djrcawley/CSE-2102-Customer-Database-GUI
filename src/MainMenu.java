import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener {
    ButtonGroup menuOptions = null;
    CustomerProfDB database = new CustomerProfDB("customer_profiles.txt");

    public MainMenu() {

        JFrame mainMenu = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        menuOptions = new ButtonGroup();

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
        ButtonModel selectedOption = menuOptions.getSelection();
        String x = selectedOption.getActionCommand();
        if(x.equals("Create Profile")){
            CreateProf gui = new CreateProf(database);
        }
        if(x.equals("Delete Profile")){
            DeleteProf gui = new DeleteProf(database);
        }
        if(x.equals("Update Profile")){
            UpdateProfFinder gui = new UpdateProfFinder();
        }
        if(x.equals("Find/Display Profile")){
            //FDProf gui = new MainMenu();
        }
        if(x.equals("Display All Profiles")){
            MainMenu gui = new MainMenu();
        }
    }

    // create one Frame
    public static void main(String[] args) {
        MainMenu gui = new MainMenu();
    }
}
