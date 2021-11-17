import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayProf implements ActionListener{
    JLabel adminID, fName, lName, address, phone, income, use, status, model, year, type, method;
    JLabel adminIDV, fNameV, lNameV, addressV, phoneV, incomeV, useV, statusV, modelV, yearV, typeV, methodV;
    JFrame fdProf;

    public DisplayProf(CustomerProf customer){
        VehicleInfo vehicle = customer.getVehicleInfo();

        fdProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Customer Profile", JLabel.CENTER);
        panel.add(label);

        //Filler Label
        JLabel label1 = new JLabel("");
        panel.add(label1);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 2));

        //Set all Text Fields
        adminID = new JLabel("Admin ID:");
        adminIDV = new JLabel(customer.getadminID());
        fName = new JLabel("First Name:");
        fNameV = new JLabel(customer.getFirstName());
        lName = new JLabel("Last Name:");
        lNameV = new JLabel(customer.getLastName());
        address = new JLabel("Address:");
        addressV = new JLabel(customer.getAddress());
        phone = new JLabel("Phone:");
        phoneV = new JLabel(customer.getPhone());
        income = new JLabel("Income:");
        incomeV = new JLabel(String.valueOf(customer.getIncome()));
        use = new JLabel("Use:");
        useV = new JLabel(customer.getUse());
        status = new JLabel("Status:");
        statusV = new JLabel(customer.getStatus());
        model = new JLabel("Model:");
        modelV = new JLabel(vehicle.getModel());
        year = new JLabel("Year:");
        yearV = new JLabel(vehicle.getYear());
        type = new JLabel("Type:");
        typeV = new JLabel(vehicle.getType());
        method = new JLabel("Method:");
        methodV = new JLabel(vehicle.getMethod());

        //Find Button
        JButton closeButton = new JButton("CLOSE");
        closeButton.addActionListener(this);

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

        //Another Filler Label
        JLabel label2 = new JLabel("");
        panel.add(label2);

        panel.add(closeButton);

        fdProf.add(panel, BorderLayout.CENTER);
        fdProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fdProf.setTitle("Customer Profile");
        fdProf.pack();
        fdProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        MainMenu gui = new MainMenu();
        fdProf.dispose();
    }
}
