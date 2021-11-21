import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayAllProf implements ActionListener {
    JLabel adminIDV, fNameV, lNameV, addressV, phoneV, incomeV, useV, statusV, modelV, yearV, typeV, methodV;
    ArrayList<CustomerProf> customers;
    JPanel panel;
    JFrame displayAll;
    CustomerProfDB database;
    int index = 0;

    public DisplayAllProf(CustomerProfDB data){
        displayAll = new JFrame();
        database = data;
        customers = database.customerList;

        panel = new JPanel();
        JLabel label = new JLabel("");
        JLabel label2 = new JLabel("Customer Profile");
        panel.add(label);
        panel.add(label2);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 2));

        AddLabels();

        displayCustomer(customers.get(index++), panel);


        //Find Button
        JButton closeButton = new JButton("Next");
        closeButton.addActionListener(this);

        //Another Filler Label
        JLabel label3 = new JLabel("");
        panel.add(label3);

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
        adminIDV.setText(customer.getadminID());
        fNameV.setText(customer.getFirstName());
        lNameV.setText(customer.getLastName());
        addressV.setText(customer.getAddress());
        phoneV.setText(customer.getPhone());
        incomeV.setText(String.valueOf(customer.getIncome()));
        useV.setText(customer.getUse());
        statusV.setText(customer.getStatus());
        modelV.setText(customer.getVehicleInfo().getModel());
        yearV.setText(customer.getVehicleInfo().getYear());
        typeV.setText(customer.getVehicleInfo().getType());
        methodV.setText(customer.getVehicleInfo().getMethod());
    }

    public void AddLabels(){
        JLabel adminID = new JLabel("Admin ID:");
        adminIDV = new JLabel();
        JLabel fName = new JLabel("First Name:");
        fNameV = new JLabel();
        JLabel lName = new JLabel("Last Name:");
        lNameV = new JLabel();
        JLabel address = new JLabel("Address:");
        addressV = new JLabel();
        JLabel phone = new JLabel("Phone:");
        phoneV = new JLabel();
        JLabel income = new JLabel("Income:");
        incomeV = new JLabel();
        JLabel use = new JLabel("Use:");
        useV = new JLabel();
        JLabel status = new JLabel("Status:");
        statusV = new JLabel();
        JLabel model = new JLabel("Model:");
        modelV = new JLabel();
        JLabel year = new JLabel("Year:");
        yearV = new JLabel();
        JLabel type = new JLabel("Type:");
        typeV = new JLabel();
        JLabel method = new JLabel("Method:");
        methodV = new JLabel();

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
        if(index < customers.size()){
            displayCustomer(customers.get(index++), panel);
        }else{
            MainMenu gui = new MainMenu();
            displayAll.dispose();
        }
    }
}