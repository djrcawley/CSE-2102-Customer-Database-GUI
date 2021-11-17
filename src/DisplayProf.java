import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayProf implements ActionListener{
    JLabel adminID, fName, lName, address, phone, income, use, status, model, year, type, method;

    public DisplayProf(CustomerProf customer){
        JFrame fdProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Customer Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Set all Text Fields
        adminID = new JLabel("Admin ID:");
        fName = new JLabel("First Name:");
        lName = new JLabel("Last Name:");
        address = new JLabel("Address:");
        phone = new JLabel("Phone:");
        income = new JLabel("Income:");
        use = new JLabel("Use:");
        status = new JLabel("Status:");
        model = new JLabel("Model:");
        year = new JLabel("Year:");
        type = new JLabel("Type:");
        method = new JLabel("Method:");

        //Find Button
        JButton closeButton = new JButton("CLOSE");
        closeButton.addActionListener(this);

        panel.add(adminID);
        panel.add(fName);
        panel.add(lName);
        panel.add(address);
        panel.add(phone);
        panel.add(income);
        panel.add(use);
        panel.add(status);
        panel.add(model);
        panel.add(year);
        panel.add(type);
        panel.add(method);
        panel.add(closeButton);

        fdProf.add(panel, BorderLayout.CENTER);
        fdProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fdProf.setTitle("Customer Profile");
        fdProf.pack();
        fdProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
