import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.regex.*;

public class CreateProf implements ActionListener {
    //Labels
    JLabel adminID, fName, lName, address, phone, income, use, status, model, year, type, method;
    CustomerProfDB database; //Database
    JFrame createProf; //Frame
    //Init TextField
    JTextField adminIdT = new JFormattedTextField();
    JTextField fNameT = new JFormattedTextField();
    JTextField lNameT = new JFormattedTextField();
    JTextField addressT = new JFormattedTextField();
    JTextField phoneT = new JFormattedTextField();
    JTextField incomeT = new JFormattedTextField();
    JTextField modelT = new JFormattedTextField();
    JTextField yearT = new JFormattedTextField();

    //Dropdown selection
    String[] uses = {"Personal", "Business", "Both"};
    String[] statuses = {"Active", "Inactive"};
    String[] types = {"Sedan", "Sport", "SUV", "Truck", "Other"};
    String[] methods = {"New", "Used", "Certified Pre-Owned"};
    JComboBox<String> useT = new JComboBox<>(uses);
    JComboBox<String> statusT = new JComboBox<>(statuses);
    JComboBox<String> typeT = new JComboBox<>(types);
    JComboBox<String> methodT = new JComboBox<>(methods);

    public CreateProf(CustomerProfDB data){
        database = data; //database
        createProf = new JFrame(); //Init Frame

        //Add Panel
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Create Profile");
        panel.add(label);
        //Set border layout
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Define all Text Fields
        adminID = new JLabel("Admin ID:");
        fName = new JLabel("First Name:");
        lName = new JLabel("Last Name:");
        address = new JLabel("Address:");
        phone = new JLabel("Phone:");
        income = new JLabel("Income:");
        model = new JLabel("Model:");
        year = new JLabel("Year:");

        //Define all dropdowns
        use = new JLabel("Use:");
        status = new JLabel("Status:");
        type = new JLabel("Type:");
        method = new JLabel("Method:");

        //Submit Button
        JButton submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);
        //Add Panels
        panel.add(adminID);
        panel.add(adminIdT);
        panel.add(fName);
        panel.add(fNameT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(address);
        panel.add(addressT);
        panel.add(phone);
        panel.add(phoneT);
        panel.add(income);
        panel.add(incomeT);
        panel.add(use);
        panel.add(useT);
        panel.add(status);
        panel.add(statusT);
        panel.add(model);
        panel.add(modelT);
        panel.add(year);
        panel.add(yearT);
        panel.add(type);
        panel.add(typeT);
        panel.add(method);
        panel.add(methodT);
        panel.add(submitButton);
        //Complete Frame
        createProf.add(panel, BorderLayout.CENTER);
        createProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createProf.setTitle("Create Profile");
        createProf.pack();
        createProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        //Collect User Response
        String admin = adminIdT.getText();
        String first = fNameT.getText();
        String last = lNameT.getText();
        String addressStr = addressT.getText();
        String phoneStr = phoneT.getText();
        String incomeStr = incomeT.getText();
        String useStr = String.valueOf(useT.getSelectedItem());
        String statusStr = String.valueOf(statusT.getSelectedItem());
        String modelStr = modelT.getText();
        String yearStr = yearT.getText();
        String typeStr = String.valueOf(typeT.getSelectedItem());
        String methodStr = String.valueOf(methodT.getSelectedItem());

        if(admin.isEmpty() || first.isEmpty() || last.isEmpty() || addressStr.isEmpty() || phoneStr.isEmpty() || incomeStr.isEmpty() || modelStr.isEmpty() || yearStr.isEmpty()){
            //Check for Empty Fields; if so alert user
            JOptionPane.showMessageDialog(null, "Please complete fields.");
            return;
        }
        //Parse income
        float incomeFloat;
        try{
            incomeFloat = Float.parseFloat(incomeStr);
        }
        catch(Exception e){
            //throw error if not a number
            JOptionPane.showMessageDialog(null, "Please enter income as a number.");
            return;
        }
        if (incomeFloat<0){
            JOptionPane.showMessageDialog(null, "Please enter an income of 0 or greater");
            return;
        }
        if(!isValidPhone(phoneStr)){
            //Check is phone number is valid
            JOptionPane.showMessageDialog(null, "Invalid phone number.");
            return;
        }
        if(!isValidYear(yearStr)){
            int currentYear = Calendar.getInstance().get(Calendar.YEAR)+1; //Next model year
            String message = String.format("Input a valid year (1885-%d)", currentYear); //Format Message
            JOptionPane.showMessageDialog(null, message); //Display Alert
            return;
        }


        VehicleInfo newVehicle = new VehicleInfo(modelStr, yearStr, typeStr, methodStr); //Create Vehicle
        CustomerProf newCustomer = new CustomerProf(admin, first, last, addressStr, phoneStr, incomeFloat, statusStr, useStr, newVehicle); //Create Customer
        //Insert Profile
        database.insertNewProfile(newCustomer);
        //Save to Database
        database.writeAllCustomerProf();
        //Alert user
        JOptionPane.showMessageDialog(null, "Profile Saved.");
        createProf.dispose(); //Close Window
    }

    public static boolean isValidPhone(String number)
    {
        //Regex String
        String regex = "(\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";
        //Credit Regex: https://stackoverflow.com/a/50122731
        Pattern p = Pattern.compile(regex); //Compiler
        Matcher m = p.matcher(number); //Match number
        return m.matches(); //Return validity
    }
    public static boolean isValidYear(String year)
    {
        boolean isvalid = false; //Check Validity
        try{
            int Year = Integer.parseInt(year); //Parse
            int currentYear = Calendar.getInstance().get(Calendar.YEAR)+1; //Next model year
            if(Year >= 1885 && Year <= currentYear){ //Between 1885 and next model year
                isvalid = true; //set true
            }
        }catch(Exception e){}
        return isvalid;//Return
    }
}