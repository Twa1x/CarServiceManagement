package com;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

public class ButtonHandler implements  ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String sql;
        String strEmpSalary = "";

        switch(e.getActionCommand()) {
            case "Add Employee":
                MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.txtEmpFirstName.getText());
                MainMenuWindow.myEmployee.setLastName(MainMenuWindow.txtEmpLastName.getText());
                MainMenuWindow.myEmployee.setAddress(MainMenuWindow.txtEmpAddress.getText());
                MainMenuWindow.myEmployee.setPhoneNumber(MainMenuWindow.txtEmpPhone.getText());
                MainMenuWindow.myEmployee.setCNP(MainMenuWindow.txtEmpCNP.getText());
                MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.txtEmpJob.getText());
                strEmpSalary = (MainMenuWindow.txtEmpSalary.getText());

                if (MainMenuWindow.myEmployee.getFirstName().isEmpty() || MainMenuWindow.myEmployee.getLastName().isEmpty() || MainMenuWindow.myEmployee.getAddress().isEmpty()
                        || MainMenuWindow.myEmployee.getPhoneNumber().isEmpty() || MainMenuWindow.myEmployee.getCNP().isEmpty()
                        || MainMenuWindow.myEmployee.getEmployeeJob().isEmpty() || strEmpSalary.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have not entered some information",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    sql = "INSERT INTO employee(first_name, last_name, address, phone_number,  \"CNP\", emp_job, emp_salary)"
                            + "VALUES" +
                            "('" + MainMenuWindow.myEmployee.getFirstName() + "','" + MainMenuWindow.myEmployee.getLastName() + "',  '" + MainMenuWindow.myEmployee.getAddress() + "', '" + MainMenuWindow.myEmployee.getPhoneNumber() + "', '"
                            + MainMenuWindow.myEmployee.getCNP() + "', '" + MainMenuWindow.myEmployee.getEmployeeJob() + "', '" + strEmpSalary + "')";

                    MainMenuWindow.db.executeStatement(MainMenuWindow.conn, sql);
                }

                MainMenuWindow.txtEmpFirstName.setText(null);
                MainMenuWindow.txtEmpLastName.setText(null);
                MainMenuWindow.txtEmpAddress.setText(null);
                MainMenuWindow.txtEmpPhone.setText(null);
                MainMenuWindow.txtEmpCNP.setText(null);
                MainMenuWindow.txtEmpJob.setText(null);
                MainMenuWindow.txtEmpSalary.setText(null);
                break;
            case "Exit Employee":
                MainMenuWindow.customerPanel.setVisible(false);
                MainMenuWindow.scroller3.setVisible(false);
                MainMenuWindow.lblCars.setVisible(false);
                MainMenuWindow.carPanel.setVisible(false);
                MainMenuWindow.lblCustomer.setVisible(false);
                MainMenuWindow.scroller4.setVisible(false);
                MainMenuWindow.employeePanel.setVisible(false);
                MainMenuWindow.employeeHeader.setVisible(false);
                break;
            case "Add Car":
                MainMenuWindow.myCar.SetBrand(MainMenuWindow.txtCarBrand.getText());
                MainMenuWindow.myCar.SetModel(MainMenuWindow.txtCarModel.getText());
                MainMenuWindow.myCar.SetNumberKM(Integer.parseInt(MainMenuWindow.txtCarKM.getText()));
                MainMenuWindow.myCar.SetDefection(MainMenuWindow.txtCarDefection.getText());
                MainMenuWindow.myCar.setM_dateIn(MainMenuWindow.txtCarDateIn.getText());
                MainMenuWindow.myCar.setM_dateOut(MainMenuWindow.txtCarDateIn.getText());


                if (MainMenuWindow.myCar.GetBrand().isEmpty() || MainMenuWindow.myCar.GetModel().isEmpty() || MainMenuWindow.myCar.GetNumberKM() == 0 ||
                        MainMenuWindow.myCar.GetDefection().isEmpty() || MainMenuWindow.myCar.getM_dateIn().isEmpty() || MainMenuWindow.myCar.getM_dateOut().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have not entered some information",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    sql = "INSERT INTO public.car( brand, model, number_km, type_of_gas, defection, date_out, date_in)"
                            + "VALUES" +
                            "('" + MainMenuWindow.myCar.GetBrand() + "','" + MainMenuWindow.myCar.GetModel() + "',  '" + MainMenuWindow.myCar.GetNumberKM() + "', '" + MainMenuWindow.myCar.GetNumberKM() + "', '"
                            + MainMenuWindow.myCar.GetDefection() + "', '" + MainMenuWindow.myCar.getM_dateIn() + "', '" + MainMenuWindow.myCar.getM_dateOut() + "')";

                    MainMenuWindow.db.executeStatement(MainMenuWindow.conn, sql);
                }

                MainMenuWindow.txtCarBrand.setText(null);
                MainMenuWindow.txtCarModel.setText(null);
                MainMenuWindow.txtCarKM.setText(null);
                MainMenuWindow.txtCarGas.setText(null);
                MainMenuWindow.txtCarDefection.setText(null);
                MainMenuWindow.txtCarDateIn.setText(null);
                MainMenuWindow.txtCarDateOut.setText(null);

                break;
            case "Exit Car":
                MainMenuWindow.carPanel.setVisible(false);
                MainMenuWindow.scroller3.setVisible(false);
                MainMenuWindow.lblCars.setVisible(false);
                MainMenuWindow.lblCustomer.setVisible(false);
                MainMenuWindow.scroller4.setVisible(false);
                MainMenuWindow.carPanel.setVisible(false);
                MainMenuWindow.carHeader.setVisible(false);
                break;
            case "Add Customer":
                MainMenuWindow.myCustomer.setFirstName(MainMenuWindow.txtCustFirstName.getText());
                MainMenuWindow.myCustomer.setLastName(MainMenuWindow.txtCustLastName.getText());
                MainMenuWindow.myCustomer.setAddress(MainMenuWindow.txtCustAddress.getText());
                MainMenuWindow.myCustomer.setPhoneNumber(MainMenuWindow.txtCustPhone.getText());
                MainMenuWindow.myCustomer.setCNP(MainMenuWindow.txtCustCNP.getText());


                if (MainMenuWindow.myCustomer.getFirstName().isEmpty() || MainMenuWindow.myCustomer.getLastName().isEmpty() || MainMenuWindow.myCustomer.getAddress().isEmpty()
                        || MainMenuWindow.myCustomer.getPhoneNumber().isEmpty() || MainMenuWindow.myCustomer.getCNP().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have not entered some information",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    sql = "INSERT INTO customer(first_name, last_name, address, phone_number,  \"CNP\")"
                            + "VALUES" +
                            "('" + MainMenuWindow.myCustomer.getFirstName() + "','" + MainMenuWindow.myCustomer.getLastName() + "',  '" + MainMenuWindow.myCustomer.getAddress() + "', '" + MainMenuWindow.myCustomer.getPhoneNumber() + "', '"
                            + MainMenuWindow.myCustomer.getCNP() + "')";

                    MainMenuWindow.db.executeStatement(MainMenuWindow.conn, sql);
                }

                MainMenuWindow.txtCustFirstName.setText(null);
                MainMenuWindow.txtCustLastName.setText(null);
                MainMenuWindow.txtCustAddress.setText(null);
                MainMenuWindow.txtCustPhone.setText(null);
                MainMenuWindow.txtCustCNP.setText(null);

                break;
            case "Exit Customer":
                MainMenuWindow.customerPanel.setVisible(false);
                MainMenuWindow.scroller3.setVisible(false);
                MainMenuWindow.lblCustomer.setVisible(false);
                MainMenuWindow.scroller4.setVisible(false);
                MainMenuWindow.customerHeader.setVisible(false);
                break;
            case "Search Car Model":
                try {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.myCar.SetModel(MainMenuWindow.txtSearchCarsModel.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter a model and try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * "
                        + " FROM car WHERE model LIKE '%" + MainMenuWindow.myCar.GetModel() + "%'";

                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {

                        MainMenuWindow.myCar.SetBrand(MainMenuWindow.results.getString("brand"));
                        MainMenuWindow.myCar.SetModel(MainMenuWindow.results.getString("model"));
                        MainMenuWindow.myCar.SetNumberKM(parseInt(MainMenuWindow.results.getString("number_km")));
                        MainMenuWindow.myCar.SetTypeOfGas(MainMenuWindow.results.getString("type_of_gas"));
                        MainMenuWindow.myCar.SetDefection(MainMenuWindow.results.getString("defection"));

                        MainMenuWindow.carShow.append(String.format("Brand: %s, Model: %s, Number of km: %d, Type of gas: %s, Defection: %s\n", MainMenuWindow.myCar.GetBrand(), MainMenuWindow.myCar.GetModel(),
                                MainMenuWindow.myCar.GetNumberKM(), MainMenuWindow.myCar.GetTypeOfGas(), MainMenuWindow.myCar.GetDefection()));
                    }


                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                MainMenuWindow.txtSearchCarsModel.setText(null);
                break;
            case "Search Car Brand":
                try {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.myCar.SetBrand(MainMenuWindow.txtSearchCarsBrand.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter a brand and try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * " + " FROM car WHERE brand LIKE '%" + MainMenuWindow.myCar.GetBrand() + "%'";

                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {

                        MainMenuWindow.myCar.SetBrand(MainMenuWindow.results.getString("brand"));
                        MainMenuWindow.myCar.SetModel(MainMenuWindow.results.getString("model"));
                        MainMenuWindow.myCar.SetNumberKM(parseInt(MainMenuWindow.results.getString("number_km")));
                        MainMenuWindow.myCar.SetTypeOfGas(MainMenuWindow.results.getString("type_of_gas"));
                        MainMenuWindow.myCar.SetDefection(MainMenuWindow.results.getString("defection"));

                        MainMenuWindow.carShow.append(String.format("Brand: %s, Model: %s, Number of km: %d, Type of gas: %s, Defection: %s\n", MainMenuWindow.myCar.GetBrand(), MainMenuWindow.myCar.GetModel(),
                                MainMenuWindow.myCar.GetNumberKM(), MainMenuWindow.myCar.GetTypeOfGas(), MainMenuWindow.myCar.GetDefection()));
                    }


                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                MainMenuWindow.txtSearchCarsBrand.setText(null);
                break;

            case "Search Car Gas":
                try {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.myCar.SetTypeOfGas(MainMenuWindow.txtSearchCarsGas.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter a gas and try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * " + " FROM car WHERE type_of_gas LIKE '%" + MainMenuWindow.myCar.GetTypeOfGas() + "%'";

                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {

                        MainMenuWindow.myCar.SetBrand(MainMenuWindow.results.getString("brand"));
                        MainMenuWindow.myCar.SetModel(MainMenuWindow.results.getString("model"));
                        MainMenuWindow.myCar.SetNumberKM(parseInt(MainMenuWindow.results.getString("number_km")));
                        MainMenuWindow.myCar.SetTypeOfGas(MainMenuWindow.results.getString("type_of_gas"));
                        MainMenuWindow.myCar.SetDefection(MainMenuWindow.results.getString("defection"));

                        MainMenuWindow.carShow.append(String.format("Brand: %s, Model: %s, Number of km: %d, Type of gas: %s, Defection: %s\n", MainMenuWindow.myCar.GetBrand(), MainMenuWindow.myCar.GetModel(),
                                MainMenuWindow.myCar.GetNumberKM(), MainMenuWindow.myCar.GetTypeOfGas(), MainMenuWindow.myCar.GetDefection()));
                    }


                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                MainMenuWindow.txtSearchCarsGas.setText(null);
                break;


            case "Search Car Defection":
                try {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.myCar.SetDefection(MainMenuWindow.txtSearchCarsDefection.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter a defection and try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * " + " FROM car WHERE defection LIKE '%" + MainMenuWindow.myCar.GetDefection() + "%'";

                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {

                        MainMenuWindow.myCar.SetBrand(MainMenuWindow.results.getString("brand"));
                        MainMenuWindow.myCar.SetModel(MainMenuWindow.results.getString("model"));
                        MainMenuWindow.myCar.SetNumberKM(parseInt(MainMenuWindow.results.getString("number_km")));
                        MainMenuWindow.myCar.SetTypeOfGas(MainMenuWindow.results.getString("type_of_gas"));
                        MainMenuWindow.myCar.SetDefection(MainMenuWindow.results.getString("defection"));

                        MainMenuWindow.carShow.append(String.format("Brand: %s, Model: %s, Number of km: %d, Type of gas: %s, Defection: %s\n", MainMenuWindow.myCar.GetBrand(), MainMenuWindow.myCar.GetModel(),
                                MainMenuWindow.myCar.GetNumberKM(), MainMenuWindow.myCar.GetTypeOfGas(), MainMenuWindow.myCar.GetDefection()));
                    }


                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                MainMenuWindow.txtSearchCarsDefection.setText(null);
                break;

            case "Search Emp First Name":
                try {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.txtSearchEmployeeFirstName.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a first name", "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * FROM employee WHERE first_name LIKE '%" + MainMenuWindow.myEmployee.getFirstName() + "%'";
                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {
                        MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.results.getString("first_name"));
                        MainMenuWindow.myEmployee.setLastName(MainMenuWindow.results.getString("last_name"));
                        MainMenuWindow.myEmployee.setAddress(MainMenuWindow.results.getString("address"));
                        MainMenuWindow.myEmployee.setPhoneNumber(MainMenuWindow.results.getString("phone_number"));
                        MainMenuWindow.myEmployee.setCNP(MainMenuWindow.results.getString("CNP"));
                        MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.results.getString("emp_job"));
                        MainMenuWindow.myEmployee.setEmployeeSalary(Double.parseDouble(MainMenuWindow.results.getString("emp_salary")));

                        MainMenuWindow.employeeShow.append(String.format("First name: %s, Last name: %s, Address: %s, Phone number: %s,CNP: %s,  Employee job: %s, Employee salary : %f \n",
                                MainMenuWindow.myEmployee.getFirstName(), MainMenuWindow.myEmployee.getLastName(), MainMenuWindow.myEmployee.getAddress(), MainMenuWindow.myEmployee.getCNP(), MainMenuWindow.myEmployee.getPhoneNumber(),
                                MainMenuWindow.myEmployee.getEmployeeJob(), MainMenuWindow.myEmployee.getEmployeeSalary()));

                    }

                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                MainMenuWindow.txtSearchEmployeeFirstName.setText(null);
                break;

            case "Search Emp Last Name":
                try {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.myEmployee.setLastName(MainMenuWindow.txtSearchEmployeeLastName.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a last name", "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * FROM employee WHERE last_name LIKE '%" + MainMenuWindow.myEmployee.getLastName() + "%'";
                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {
                        MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.results.getString("first_name"));
                        MainMenuWindow.myEmployee.setLastName(MainMenuWindow.results.getString("last_name"));
                        MainMenuWindow.myEmployee.setAddress(MainMenuWindow.results.getString("address"));
                        MainMenuWindow.myEmployee.setPhoneNumber(MainMenuWindow.results.getString("phone_number"));
                        MainMenuWindow.myEmployee.setCNP(MainMenuWindow.results.getString("CNP"));
                        MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.results.getString("emp_job"));
                        MainMenuWindow.myEmployee.setEmployeeSalary(Double.parseDouble(MainMenuWindow.results.getString("emp_salary")));

                        MainMenuWindow.employeeShow.append(String.format("First name: %s, Last name: %s, Address: %s, Phone number: %s,CNP: %s,  Employee job: %s, Employee salary : %f \n",
                                MainMenuWindow.myEmployee.getFirstName(), MainMenuWindow.myEmployee.getLastName(), MainMenuWindow.myEmployee.getAddress(), MainMenuWindow.myEmployee.getCNP(), MainMenuWindow.myEmployee.getPhoneNumber(),
                                MainMenuWindow.myEmployee.getEmployeeJob(), MainMenuWindow.myEmployee.getEmployeeSalary()));

                    }

                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                MainMenuWindow.txtSearchEmployeeLastName.setText(null);
                break;

            case "Search Emp Job":
                try {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.txtSearchEmployeeJob.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a first name", "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * FROM employee WHERE emp_job LIKE '%" + MainMenuWindow.myEmployee.getEmployeeJob() + "%'";
                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {
                        MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.results.getString("first_name"));
                        MainMenuWindow.myEmployee.setLastName(MainMenuWindow.results.getString("last_name"));
                        MainMenuWindow.myEmployee.setAddress(MainMenuWindow.results.getString("address"));
                        MainMenuWindow.myEmployee.setPhoneNumber(MainMenuWindow.results.getString("phone_number"));
                        MainMenuWindow.myEmployee.setCNP(MainMenuWindow.results.getString("CNP"));
                        MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.results.getString("emp_job"));
                        MainMenuWindow.myEmployee.setEmployeeSalary(Double.parseDouble(MainMenuWindow.results.getString("emp_salary")));

                        MainMenuWindow.employeeShow.append(String.format("First name: %s, Last name: %s, Address: %s, Phone number: %s,CNP: %s,  Employee job: %s, Employee salary : %f \n",
                                MainMenuWindow.myEmployee.getFirstName(), MainMenuWindow.myEmployee.getLastName(), MainMenuWindow.myEmployee.getAddress(), MainMenuWindow.myEmployee.getCNP(), MainMenuWindow.myEmployee.getPhoneNumber(),
                                MainMenuWindow.myEmployee.getEmployeeJob(), MainMenuWindow.myEmployee.getEmployeeSalary()));

                    }

                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                MainMenuWindow.txtSearchEmployeeJob.setText(null);
                break;

            case "Search Cust First Name":
                try {
                    MainMenuWindow.customerShow.setText(null);
                    MainMenuWindow.myCustomer.setFirstName(MainMenuWindow.txtSearchCustomerFirstName.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a first name", "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * FROM customer WHERE first_name LIKE '%" + MainMenuWindow.myCustomer.getFirstName() + "%'";
                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {
                        MainMenuWindow.myCustomer.setFirstName(MainMenuWindow.results.getString("first_name"));
                        MainMenuWindow.myCustomer.setLastName(MainMenuWindow.results.getString("last_name"));
                        MainMenuWindow.myCustomer.setAddress(MainMenuWindow.results.getString("address"));
                        MainMenuWindow.myCustomer.setPhoneNumber(MainMenuWindow.results.getString("phone_number"));
                        MainMenuWindow.myCustomer.setCNP(MainMenuWindow.results.getString("CNP"));
                        // MainMenuWindow.myCustomer.setCar_id(parseInt(MainMenuWindow.results.getString("car_id")));

                        MainMenuWindow.customerShow.append(String.format("First name: %s, Last name: %s, Address: %s, Phone number: %s,CNP: %s \n",
                                MainMenuWindow.myCustomer.getFirstName(), MainMenuWindow.myCustomer.getLastName(), MainMenuWindow.myCustomer.getAddress(), MainMenuWindow.myCustomer.getCNP(), MainMenuWindow.myCustomer.getPhoneNumber()));

                    }

                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }


                MainMenuWindow.txtSearchCustomerFirstName.setText(null);
                break;

            case "Search Cust Last Name":
                try {
                    MainMenuWindow.customerShow.setText(null);
                    MainMenuWindow.myCustomer.setLastName(MainMenuWindow.txtSearchCustomerLastName.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a last name", "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT * FROM customer WHERE last_name LIKE '%" + MainMenuWindow.myCustomer.getLastName() + "%'";
                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

                try {
                    while (MainMenuWindow.results.next()) {
                        MainMenuWindow.myCustomer.setFirstName(MainMenuWindow.results.getString("first_name"));
                        MainMenuWindow.myCustomer.setLastName(MainMenuWindow.results.getString("last_name"));
                        MainMenuWindow.myCustomer.setAddress(MainMenuWindow.results.getString("address"));
                        MainMenuWindow.myCustomer.setPhoneNumber(MainMenuWindow.results.getString("phone_number"));
                        MainMenuWindow.myCustomer.setCNP(MainMenuWindow.results.getString("CNP"));
                        // MainMenuWindow.myCustomer.setCar_id(parseInt(MainMenuWindow.results.getString("car_id")));

                        MainMenuWindow.customerShow.append(String.format("First name: %s, Last name: %s, Address: %s, Phone number: %s,CNP: %s \n",
                                MainMenuWindow.myCustomer.getFirstName(), MainMenuWindow.myCustomer.getLastName(), MainMenuWindow.myCustomer.getAddress(), MainMenuWindow.myCustomer.getCNP(), MainMenuWindow.myCustomer.getPhoneNumber()));

                    }

                    MainMenuWindow.results.close();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }


                MainMenuWindow.txtSearchCustomerLastName.setText(null);
                break;


            case "Find Employee":
                try {
                    MainMenuWindow.myEmployee.setEmployeeID(Integer.parseInt(MainMenuWindow.txtSearchEmployeeEdit.getText()));
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                }

                sql = "SELECT *  FROM employee WHERE emp_id =" + MainMenuWindow.myEmployee.getEmployeeID();

                MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn,sql);

                try {

                        while (MainMenuWindow.results.next()) {
                            MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.results.getString("first_name"));
                            MainMenuWindow.myEmployee.setLastName(MainMenuWindow.results.getString("last_name"));
                            MainMenuWindow.myEmployee.setAddress(MainMenuWindow.results.getString("address"));
                            MainMenuWindow.myEmployee.setPhoneNumber(MainMenuWindow.results.getString("phone_number"));
                            MainMenuWindow.myEmployee.setCNP(MainMenuWindow.results.getString("CNP"));
                            MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.results.getString("emp_job"));
                            MainMenuWindow.myEmployee.setEmployeeSalary(Double.parseDouble(MainMenuWindow.results.getString("emp_salary")));

                    }

                    MainMenuWindow.txtEmpFirstName.setText(MainMenuWindow.myEmployee.getFirstName());
                    MainMenuWindow.txtEmpLastName.setText(MainMenuWindow.myEmployee.getLastName());
                    MainMenuWindow.txtEmpAddress.setText(MainMenuWindow.myEmployee.getAddress());
                    MainMenuWindow.txtEmpPhone.setText(MainMenuWindow.myEmployee.getPhoneNumber());
                    MainMenuWindow.txtEmpCNP.setText(MainMenuWindow.myEmployee.getCNP());
                    MainMenuWindow.txtEmpJob.setText(MainMenuWindow.myEmployee.getEmployeeJob());
                    MainMenuWindow.txtEmpSalary.setText(Double.toString(MainMenuWindow.myEmployee.getEmployeeSalary()));

                    MainMenuWindow.results.close();
                } catch (SQLException es) {
                    JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                MainMenuWindow.btnEmployeeAdd.setEnabled(false);
                MainMenuWindow.txtSearchEmployeeEdit.setEditable(false);
                MainMenuWindow.btnEmployeeUpdate.setEnabled(true);
                break;

            case "Update Employee":
                MainMenuWindow.myEmployee.setEmployeeID(Integer.parseInt(MainMenuWindow.txtSearchEmployeeEdit.getText()));
                MainMenuWindow.myEmployee.setFirstName(MainMenuWindow.txtEmpFirstName.getText());
                MainMenuWindow.myEmployee.setLastName(MainMenuWindow.txtEmpLastName.getText());
                MainMenuWindow.myEmployee.setAddress(MainMenuWindow.txtEmpAddress.getText());
                MainMenuWindow.myEmployee.setPhoneNumber(MainMenuWindow.txtEmpPhone.getText());
                MainMenuWindow.myEmployee.setCNP(MainMenuWindow.txtEmpCNP.getText());
                MainMenuWindow.myEmployee.setEmployeeJob(MainMenuWindow.txtEmpJob.getText());
                MainMenuWindow.myEmployee.setEmployeeSalary(Double.parseDouble(MainMenuWindow.txtEmpSalary.getText()));
                strEmpSalary = (MainMenuWindow.txtEmpSalary.getText());

                if(MainMenuWindow.myEmployee.getFirstName().isEmpty()||MainMenuWindow.myEmployee.getLastName().isEmpty()  || MainMenuWindow.myEmployee.getAddress().isEmpty()
                        || MainMenuWindow.myEmployee.getPhoneNumber().isEmpty() || MainMenuWindow.myEmployee.getCNP().isEmpty()
                        || MainMenuWindow.myEmployee.getEmployeeJob().isEmpty() || strEmpSalary.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "You have not entered some information",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    sql = "UPDATE employee SET first_name = '"+MainMenuWindow.myEmployee.getFirstName()+"', last_name = '"+MainMenuWindow.myEmployee.getLastName()+"', address = '"+MainMenuWindow.myEmployee.getAddress()+"', phone_number = '"+MainMenuWindow.myEmployee.getAddress()+"', \"CNP\" ='"+MainMenuWindow.myEmployee.getCNP()+"', emp_job = '"+MainMenuWindow.myEmployee.getEmployeeJob()+"', emp_salary ="+MainMenuWindow.myEmployee.getEmployeeSalary()+" WHERE emp_id = '"+MainMenuWindow.myEmployee.getEmployeeID()+"' ";
                    MainMenuWindow.db.executeStatement(MainMenuWindow.conn, sql);

                    JOptionPane.showMessageDialog(null, "Successful Update",
                            "Update", JOptionPane.INFORMATION_MESSAGE);
                }

                MainMenuWindow.txtSearchEmployeeEdit.setText(null);
                MainMenuWindow.txtEmpFirstName.setText(null);
                MainMenuWindow.txtEmpLastName.setText(null);
                MainMenuWindow.txtEmpAddress.setText(null);
                MainMenuWindow.txtEmpPhone.setText(null);
                MainMenuWindow.txtEmpCNP.setText(null);
                MainMenuWindow.txtEmpJob.setText(null);
                MainMenuWindow.txtEmpSalary.setText(null);
                break;

        }
    }

}
