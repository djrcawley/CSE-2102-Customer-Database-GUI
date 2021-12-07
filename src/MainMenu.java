import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class MainMenu implements ActionListener {
    ButtonGroup menuOptions; //Program options
    String fileName = getDatabaseFile(); //Prompt user for database file via terminal
    CustomerProfDB database = new CustomerProfDB(fileName); //Create CustomerProfDB
    public boolean isValidfile = database.isValidfile; //Check is file is valid format
    JFrame mainMenu; //Frame

    public MainMenu() {
        if(isValidfile){ //If file is valid, open
            mainMenu = new JFrame(); //Frame

            //Panel Setup
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
            panel.setLayout(new GridLayout(0, 1));

            //Buttons (Options)
            menuOptions = new ButtonGroup();
            newMenuOption(panel, menuOptions, "Create Profile");
            newMenuOption(panel, menuOptions, "Delete Profile");
            newMenuOption(panel, menuOptions, "Update Profile");
            newMenuOption(panel, menuOptions, "Find/Display Profile");
            newMenuOption(panel, menuOptions, "Display All Profiles");


            //Select Option
            JButton selectButton = new JButton("SELECT");
            selectButton.addActionListener(this); //Listener
            panel.add(selectButton);

            //Combine all buttons and frames; make visible
            mainMenu.add(panel, BorderLayout.CENTER);
            mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenu.setTitle("Welcome To the DJ ICS");
            mainMenu.pack();
            mainMenu.setVisible(true);
        }else{ //else warn user and terminate program
            JOptionPane.showMessageDialog(null, "The database file exists but is not in the correct format.");
        }
    }

    public String getDatabaseFile(){
        Scanner in = new Scanner(System.in); //Create Scanner
        System.out.println("Enter File Name:");
        //Return file name
        return in.nextLine();
    }

    public void newMenuOption(JPanel panel, ButtonGroup option, String string){
        //Create a new Menu option
        JRadioButton newOption = new JRadioButton(string);
        newOption.setActionCommand(string);
        panel.add(newOption);
        option.add(newOption);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        ButtonModel selectedOption = menuOptions.getSelection();
        if (selectedOption != null){ //User must select option
            String x = selectedOption.getActionCommand();
            //Open page based on selected option
            if(x.equals("Create Profile")){
                new CreateProf(database);
            }
            if(x.equals("Delete Profile")){
                new DeleteProf(database);
            }
            if(x.equals("Update Profile")){
                new UpdateProfFinder(database);
            }
            if(x.equals("Find/Display Profile")){
                new FDProf(database);
            }
            if(x.equals("Display All Profiles")){
                new DisplayAllGetAdminID(database);
            }
        }
    }

    public static void main(String[] args) {
        new MainMenu(); //Begin Program
    }
}
