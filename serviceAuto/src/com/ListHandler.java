package com;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class ListHandler implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {

            if(e.getSource() == MainMenuWindow.listCarSearch)
            {
                if(MainMenuWindow.listCarSearch.getSelectedIndex() == 0)
                {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.searchCarBrandPanel.setVisible(false);
                    MainMenuWindow.searchCarModelPanel.setVisible(false);
                    MainMenuWindow.searchCarGasPanel.setVisible(false);
                    MainMenuWindow.searchCarDefectionPanel.setVisible(false);

                }
                else if(MainMenuWindow.listCarSearch.getSelectedIndex() == 1)
                {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.searchCarBrandPanel.setVisible(true);
                    MainMenuWindow.searchCarModelPanel.setVisible(false);
                    MainMenuWindow.searchCarGasPanel.setVisible(false);
                    MainMenuWindow.searchCarDefectionPanel.setVisible(false);


                }
                else if(MainMenuWindow.listCarSearch.getSelectedIndex() == 2)
                {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.searchCarBrandPanel.setVisible(false);
                    MainMenuWindow.searchCarModelPanel.setVisible(true);
                    MainMenuWindow.searchCarGasPanel.setVisible(false);
                    MainMenuWindow.searchCarDefectionPanel.setVisible(false);

                }
                else if(MainMenuWindow.listCarSearch.getSelectedIndex() == 3)
                {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.searchCarBrandPanel.setVisible(false);
                    MainMenuWindow.searchCarModelPanel.setVisible(false);
                    MainMenuWindow.searchCarGasPanel.setVisible(true);
                    MainMenuWindow.searchCarDefectionPanel.setVisible(false);

                }
                else if(MainMenuWindow.listCarSearch.getSelectedIndex() == 4)
                {
                    MainMenuWindow.carShow.setText(null);
                    MainMenuWindow.searchCarBrandPanel.setVisible(false);
                    MainMenuWindow.searchCarModelPanel.setVisible(false);
                    MainMenuWindow.searchCarGasPanel.setVisible(false);
                    MainMenuWindow.searchCarDefectionPanel.setVisible(true);

                }
            }
            else if(e.getSource() == MainMenuWindow.listEmployeeSearch)
            {
                if(MainMenuWindow.listEmployeeSearch.getSelectedIndex() == 0)
                {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
                    MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
                    MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
                }
                if(MainMenuWindow.listEmployeeSearch.getSelectedIndex() == 1)
                {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(true);
                    MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
                    MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
                }
                if(MainMenuWindow.listEmployeeSearch.getSelectedIndex() == 2)
                {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
                    MainMenuWindow.searchEmployeeLastNamePanel.setVisible(true);
                    MainMenuWindow.searchEmployeeJobPanel.setVisible(false);
                }
                if(MainMenuWindow.listEmployeeSearch.getSelectedIndex() == 3)
                {
                    MainMenuWindow.employeeShow.setText(null);
                    MainMenuWindow.searchEmployeeFirstNamePanel.setVisible(false);
                    MainMenuWindow.searchEmployeeLastNamePanel.setVisible(false);
                    MainMenuWindow.searchEmployeeJobPanel.setVisible(true);
                }
            }
            else if(e.getSource() == MainMenuWindow.listCustomerSearch)
            {
                if(MainMenuWindow.listCustomerSearch.getSelectedIndex() == 0)
                {
                    MainMenuWindow.customerShow.setText(null);
                    MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
                    MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);

                }
                if(MainMenuWindow.listCustomerSearch.getSelectedIndex() == 1)
                {
                    MainMenuWindow.customerShow.setText(null);
                    MainMenuWindow.searchCustomerFirstNamePanel.setVisible(true);
                    MainMenuWindow.searchCustomerLastNamePanel.setVisible(false);
                }
                if(MainMenuWindow.listCustomerSearch.getSelectedIndex() == 2)
                {
                    MainMenuWindow.customerShow.setText(null);
                    MainMenuWindow.searchCustomerFirstNamePanel.setVisible(false);
                    MainMenuWindow.searchCustomerLastNamePanel.setVisible(true);
                }

            }





    }

}
