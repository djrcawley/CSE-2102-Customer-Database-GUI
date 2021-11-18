import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayAllProf implements ActionListener {
    ArrayList<CustomerProf> customers;
    JFrame displayAll;
    CustomerProfDB database;

    public DisplayAllProf(CustomerProfDB data){
        displayAll = new JFrame();
        database = data;
        customers = database.customerList;

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Customer Profiles");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 2));

        for(CustomerProf customer : customers){
            displayCustomer(customer, panel);
        }

        //Find Button
        JButton closeButton = new JButton("CLOSE");
        closeButton.addActionListener(this);

        //Another Filler Label
        JLabel label2 = new JLabel("");
        panel.add(label2);

        panel.add(closeButton);

        displayAll.add(panel, BorderLayout.CENTER);
        displayAll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayAll.setTitle("Customer Profile");
        displayAll.pack();
        displayAll.setVisible(true);
    }

    public void displayCustomer(CustomerProf customer, JPanel panel){
        VehicleInfo vehicle = customer.getVehicleInfo();

        //Set all Text Fields
        JLabel adminID = new JLabel("Admin ID:");
        JLabel adminIDV = new JLabel(customer.getadminID());
        JLabel fName = new JLabel("First Name:");
        JLabel fNameV = new JLabel(customer.getFirstName());
        JLabel lName = new JLabel("Last Name:");
        JLabel lNameV = new JLabel(customer.getLastName());
        JLabel address = new JLabel("Address:");
        JLabel addressV = new JLabel(customer.getAddress());
        JLabel phone = new JLabel("Phone:");
        JLabel phoneV = new JLabel(customer.getPhone());
        JLabel income = new JLabel("Income:");
        JLabel incomeV = new JLabel(String.valueOf(customer.getIncome()));
        JLabel use = new JLabel("Use:");
        JLabel useV = new JLabel(customer.getUse());
        JLabel status = new JLabel("Status:");
        JLabel statusV = new JLabel(customer.getStatus());
        JLabel model = new JLabel("Model:");
        JLabel modelV = new JLabel(vehicle.getModel());
        JLabel year = new JLabel("Year:");
        JLabel yearV = new JLabel(vehicle.getYear());
        JLabel type = new JLabel("Type:");
        JLabel typeV = new JLabel(vehicle.getType());
        JLabel method = new JLabel("Method:");
        JLabel methodV = new JLabel(vehicle.getMethod());

        panel.add(adminID);
        panel.add(adminIDV);
        panel.add(fName);
        panel.add(fNameV);
        panel.add(lName);
        panel.add(lNameV);
        panel.add(address);
        panel.add(addressV);
        panel.add(phone);
        panel.add(phoneV);
        panel.add(income);
        panel.add(incomeV);
        panel.add(use);
        panel.add(useV);
        panel.add(status);
        panel.add(statusV);
        panel.add(model);
        panel.add(modelV);
        panel.add(year);
        panel.add(yearV);
        panel.add(type);
        panel.add(typeV);
        panel.add(method);
        panel.add(methodV);
    }

    public void actionPerformed(ActionEvent e) {
        MainMenu gui = new MainMenu();
        displayAll.dispose();
    }
}
