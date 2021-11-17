import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProf implements ActionListener {
    CustomerProfDB database;
    JLabel adminID, lName;
    JTextField adminIDT = new JFormattedTextField();
    JTextField lNameT = new JFormattedTextField();
    JFrame deleteProf;

    public DeleteProf(CustomerProfDB data){
        database = data;
        deleteProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Delete Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Set Text Fields
        adminID = new JLabel("Admin ID:");
        lName = new JLabel("Last Name:");

        //Delete Button
        JButton deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(this);

        panel.add(adminID);
        panel.add(adminIDT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(deleteButton);

        deleteProf.add(panel, BorderLayout.CENTER);
        deleteProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteProf.setTitle("Delete Profile");
        deleteProf.pack();
        deleteProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String admin = adminIDT.getText();
        String last = lNameT.getText();
        boolean wasDeleted = database.deleteProfile(admin, last);
        if (wasDeleted){
            //Delete profile from the DB
            SuccessfulDelete gui = new SuccessfulDelete();
            database.writeAllCustomerProf();
        }
        else{
            //User Not Found
            System.out.println("Profile Not Found");
            MainMenu gui = new MainMenu();
            deleteProf.dispose();

        }
    }
}
