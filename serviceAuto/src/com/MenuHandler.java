package com;


import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class MenuHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem mItem = (JMenuItem) e.getSource();
        String sql;
        if (mItem == MainMenuWindow.carShowAll) {
            MainMenuWindow.lblCars.setVisible(true);
            MainMenuWindow.scroller3.setVisible(true);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.carShow.setText(null);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
            sql = "select * from car";
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

        }
        else if(mItem == MainMenuWindow.carSearch)
        {
            MainMenuWindow.scroller3.setVisible(true);
            MainMenuWindow.lblCars.setVisible(true);
            MainMenuWindow.listCarSearch.setVisible(true);
            MainMenuWindow.listCarSearch.setSelectedIndex(0);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.carShow.setText(null);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(true);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
        }
        else if (mItem == MainMenuWindow.empShowAll) {
            MainMenuWindow.scroller5.setVisible(true);
            MainMenuWindow.employeeHeader.setVisible(true);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.carHeader.setVisible(false);
            MainMenuWindow.employeeShow.setText(null);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
            sql = "select * from employee";
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
        }
        else if(mItem == MainMenuWindow.custShowAll)
        {
            MainMenuWindow.lblCustomer.setVisible(true);
            MainMenuWindow.scroller4.setVisible(true);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.customerShow.setText(null);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(false);
            MainMenuWindow.carHeader.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);

            sql = "select * from customer";
            MainMenuWindow.results = MainMenuWindow.db.getResults(MainMenuWindow.conn, sql);

            try
            {
                while(MainMenuWindow.results.next())
                {
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
            }
            catch (SQLException e1)
            {
                JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(mItem == MainMenuWindow.empCreate)
        {

            MainMenuWindow.btnEmployeeAdd.setEnabled(true);
            MainMenuWindow.employeePanel.setVisible(true);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(true);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.carHeader.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
        }
        else if(mItem == MainMenuWindow.carCreate)
        {

            MainMenuWindow.btnCarAdd.setEnabled(true);
            MainMenuWindow.carPanel.setVisible(true);
            MainMenuWindow.carHeader.setVisible(false);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCars.setVisible(true);
            MainMenuWindow.carPanel.setVisible(true);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
        }
        else if(mItem == MainMenuWindow.custCreate)
        {

            MainMenuWindow.btnCustAdd.setEnabled(true);
            MainMenuWindow.customerPanel.setVisible(true);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.carHeader.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(true);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
        }
        else if(mItem == MainMenuWindow.empSearch)
        {
            MainMenuWindow.employeeShow.setText(null);
            MainMenuWindow.scroller5.setVisible(true);
            MainMenuWindow.employeeHeader.setVisible(true);
            MainMenuWindow.listEmployeeSearch.setVisible(true);
            MainMenuWindow.lblSearchEmployee.setVisible(true);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setSelectedIndex(0);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);
        }
        if(mItem == MainMenuWindow.custSearch)
        {
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(true);
            MainMenuWindow.scroller4.setVisible(true);
            MainMenuWindow.listCustomerSearch.setVisible(true);
            MainMenuWindow.lblSearchCustomer.setVisible(true);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.listCustomerSearch.setSelectedIndex(0);
            MainMenuWindow.customerShow.setText(null);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(false);
            MainMenuWindow.employeeHeader.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(false);
            MainMenuWindow.btnEmployeeUpdate.setVisible(false);
            MainMenuWindow.lblEnterIDEmployee.setVisible(false);


        }
        else if(mItem == MainMenuWindow.empEdit)
        {
            MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
            MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
            MainMenuWindow.scroller5.setVisible(false);
            MainMenuWindow.employeePanel.setVisible(true);
            MainMenuWindow.employeeHeader.setVisible(true);
            MainMenuWindow.lblEnterIDEmployee.setVisible(true);
            MainMenuWindow.btnSearchEmployeeEdit.setVisible(true);
            MainMenuWindow.txtSearchEmployeeEdit.setVisible(true);
            MainMenuWindow.btnEmployeeUpdate.setVisible(true);
            MainMenuWindow.customerPanel.setVisible(false);
            MainMenuWindow.scroller3.setVisible(false);
            MainMenuWindow.lblCars.setVisible(false);
            MainMenuWindow.listCarSearch.setVisible(false);
            MainMenuWindow.searchCarDefectionPanel.setVisible(false);
            MainMenuWindow.searchCarBrandPanel.setVisible(false);
            MainMenuWindow.searchCarModelPanel.setVisible(false);
            MainMenuWindow.searchCarGasPanel.setVisible(false);
            MainMenuWindow.carPanel.setVisible(false);
            MainMenuWindow.lblCustomer.setVisible(false);
            MainMenuWindow.scroller4.setVisible(false);
            MainMenuWindow.listCustomerSearch.setVisible(false);
            MainMenuWindow.lblSearchCustomer.setVisible(false);
            MainMenuWindow.lblSearchCars.setVisible(false);
            MainMenuWindow.btnEmployeeAdd.setEnabled(false);
            MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
            MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
            MainMenuWindow.listEmployeeSearch.setVisible(false);
            MainMenuWindow.lblSearchEmployee.setVisible(false);
        }

    }
}