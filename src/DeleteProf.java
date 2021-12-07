import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProf implements ActionListener {
    CustomerProfDB database; //Database
    JLabel adminID, lName; //Label
    //Fields
    JTextField adminIDT = new JFormattedTextField();
    JTextField lNameT = new JFormattedTextField();
    JFrame deleteProf; //Frame

    public DeleteProf(CustomerProfDB data){
        database = data; //Set database
        deleteProf = new JFrame(); //Set frame

        //Create panel
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Delete Profile");
        panel.add(label);
        //Set layout
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Set Text Fields
        adminID = new JLabel("Admin ID:");
        lName = new JLabel("Last Name:");

        //Delete Button
        JButton deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(this);
        //Add panel
        panel.add(adminID);
        panel.add(adminIDT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(deleteButton);
        //Complete Frame
        deleteProf.add(panel, BorderLayout.CENTER);
        deleteProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteProf.setTitle("Delete Profile");
        deleteProf.pack();
        deleteProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String admin = adminIDT.getText(); //Get user adminID
        String last = lNameT.getText(); //Get lastName
        boolean wasDeleted = database.deleteProfile(admin, last); //Try to delete
        if (wasDeleted){
            //Delete profile from the DB
            new SuccessfulDelete();
            database.writeAllCustomerProf();
        }
        else{
            //User Not Found
            JOptionPane.showMessageDialog(null, "Profile Not Found");
        }
        deleteProf.dispose(); //Close Frame
    }
}
