package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;


public class MainMenuWindow extends JFrame {

    protected static JMenuItem carEdit, carCreate, carSearch, carShowAll, empCreate, empEdit, empDelete, empSearch, empShowAll, custEdit, custSearch, custCreate, custShowAll;
    protected static JTextArea carShow, employeeShow, customerShow;
    protected static DbFunctions db = new DbFunctions();
    protected static Connection conn = db.connect_to_db("service", "postgres", "1q2w3e");
    protected static ResultSet results;
    protected static JScrollPane scroller3, scroller4, scroller5;
    protected static JLabel lblCars, lblCustomer, carHeader, employeeHeader,customerHeader, lblEmpFirstName, lblEmpLastName, lblEmpSalary, lblEmpCNP, lblEmpAddress,
            lblEmpPhone, lblEmpJob, lblCarBrand,lblSearchCars, lblCarModel, lblCarKM, lblCarGas, lblCarDefection, lblCarDateIn, lblCarDateOut, lblCustFirstName, lblCustLastName, lblCustAddress, lblCustPhone, lblCustCNP
            ,lblSearchCarsBrand,lblEnterIDEmployee, lblSearchCarsModel,lblSearchCarsGas,lblSearchCarsDefection,    lblSearchEmployee,lblSearchEmployeeFirstName,lblSearchEmployeeLastName,lblSearchEmployeeJob , lblSearchCustomer,lblSearchCustomerFirstName,lblSearchCustomerLastName;
    protected static JPanel employeePanel, customerPanel, carPanel,searchCarBrandPanel, searchCarModelPanel, searchCarGasPanel, searchCarDefectionPanel,searchEmployeeFirstNamePanel,searchEmployeeLastNamePanel,searchEmployeeJobPanel,searchCustomerFirstNamePanel,searchCustomerLastNamePanel;
    protected static JButton btnEmployeeAdd, btnEmployeeExit, btnCarAdd, btnCarExit, btnCustAdd,btnCustExit, btnSearchCarBrand,btnSearchCarModel,btnSearchCarGas,btnSearchCarDefection, btnSearchEmployeeFirstName,btnSearchEmployeeLastName, btnSearchEmployeeJob,  btnSearchCustomerFirstName,btnSearchCustomerLastName,  btnSearchEmployeeEdit,btnEmployeeUpdate;
    protected static JTextField txtEmpJob, txtEmpFirstName, txtEmpLastName,txtSearchEmployeeEdit, txtEmpAddress, txtEmpPhone, txtEmpCNP, txtEmpSalary, txtCarBrand, txtCarModel, txtCarKM, txtCarGas, txtCarDefection, txtCarDateIn, txtCarDateOut, txtCustFirstName, txtCustLastName, txtCustAddress, txtCustPhone, txtCustCNP,
            txtSearchCarsBrand,txtSearchCarsModel,txtSearchCarsGas,txtSearchCarsDefection, txtSearchEmployeeFirstName,txtSearchEmployeeLastName,txtSearchEmployeeJob, txtSearchCustomerFirstName,txtSearchCustomerLastName;
    protected static JComboBox<String> listCarSearch, listEmployeeSearch, listCustomerSearch;
    protected JMenu carMenu, employeeMenu, customerMenu;

    protected static Car myCar = new Car();
    protected static Employee myEmployee = new Employee();
    protected static Customer myCustomer = new Customer();
    protected MenuHandler menuEventHandler = new MenuHandler();
    protected ButtonHandler btnEventHandler = new ButtonHandler();
    protected ListHandler lstEventHandler = new ListHandler();
    protected JMenuBar menuBar = new JMenuBar();
    protected Font customFont1 = new Font("Courier", Font.BOLD, 15);
    protected Font customFont2 = new Font("Courier", Font.ITALIC, 13);
    protected Font customFont3 = new Font("Sans Serif", Font.BOLD, 22);
    protected Font customFont4 = new Font("Sans Serif", Font.BOLD, 40);

    private String[] carChoices = {"Select Here", "Brand", "Model", "Gas", "Defection"};
    private String[] employeeChoices = {"Select Here", "First Name", "Last Name", "Employee JOB"};
    private String[] customerChoices = {"Select Here", "First Name", "Last Name"};


    public MainMenuWindow() {

        setTitle("Main Menu");
        setSize(1366, 728);
        setResizable(false);
        setContentPane(new JLabel(new ImageIcon("images/MenuBackground.png")));
        createMenuBar();
        setCarMenu();
        createCarArea();
        createCarPanelAndEditOptions();
        createSearchCarsSelectionAndPanels();
        setEmployeeMenu();
        createEmployeeArea();
        createEmployeePanel();
        createSearchEmployeesSelectionAndPanels();
        setCustomerMenu();
        createCustomerArea();
        createCustomerPanelAndEditOptions();
        createSearchCustomersSelectionAndPanels();
        createSearchToEditEmployee();
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {

                onExit();
            }
        });

    }


    public void onExit() {


        System.exit(0);
    }

    private void createMenuBar() {
        menuBar.setLocation(0, 0);
        menuBar.setSize(1366, 300);
        setJMenuBar(menuBar);
    }


    private void setCarMenu() {
        carMenu = new JMenu("Cars");
        carMenu.setFont(customFont1);
        carMenu.setForeground(Color.blue);
        menuBar.add(carMenu);



        carCreate = new JMenuItem("Create new car");
        carCreate.setFont(customFont2);
        carCreate.setForeground(Color.blue);
        carMenu.add(carCreate);
        carCreate.addActionListener(menuEventHandler);


        carEdit = new JMenuItem("Edit Car");
        carEdit.setFont(customFont2);
        carEdit.setForeground(Color.blue);
        carMenu.add(carEdit);
        carEdit.addActionListener(menuEventHandler);

        carSearch = new JMenuItem("Search Cars");
        carSearch.setFont(customFont2);
        carSearch.setForeground(Color.blue);
        carMenu.add(carSearch);
        carSearch.addActionListener(menuEventHandler);

        carShowAll = new JMenuItem("View all Cars");
        carShowAll.setFont(customFont2);
        carShowAll.setForeground(Color.blue);
        carMenu.add(carShowAll);
        carShowAll.addActionListener(menuEventHandler);
    }

    private void setEmployeeMenu() {
        employeeMenu = new JMenu("Employee");
        employeeMenu.setFont(customFont1);
        employeeMenu.setForeground(Color.blue);
        menuBar.add(employeeMenu);

        empCreate = new JMenuItem("Create new Employee");
        empCreate.setFont(customFont2);
        empCreate.setForeground(Color.blue);
        employeeMenu.add(empCreate);
        empCreate.addActionListener(menuEventHandler);

        empEdit = new JMenuItem("Edit Employee");
        empEdit.setFont(customFont2);
        empEdit.setForeground(Color.blue);
        employeeMenu.add(empEdit);
        empEdit.addActionListener(menuEventHandler);

        empDelete = new JMenuItem("Delete Employee");
        empDelete.setFont(customFont2);
        empDelete.setForeground(Color.blue);
        employeeMenu.add(empDelete);
        empDelete.addActionListener(menuEventHandler);

        empSearch = new JMenuItem("Search Employees");
        empSearch.setFont(customFont2);
        empSearch.setForeground(Color.blue);
        employeeMenu.add(empSearch);
        empSearch.addActionListener(menuEventHandler);

        empShowAll = new JMenuItem("View all Employees");
        empShowAll.setFont(customFont2);
        empShowAll.setForeground(Color.blue);
        employeeMenu.add(empShowAll);
        empShowAll.addActionListener(menuEventHandler);
    }


    //Creates customer menu and items then adds to menu bar
    private void setCustomerMenu() {
        customerMenu = new JMenu("Customer");
        customerMenu.setFont(customFont1);
        customerMenu.setForeground(Color.blue);
        menuBar.add(customerMenu);

        custCreate = new JMenuItem("Create new Customer");
        custCreate.setFont(customFont2);
        custCreate.setForeground(Color.blue);
        customerMenu.add(custCreate);
        custCreate.addActionListener(menuEventHandler);

        custEdit = new JMenuItem("Edit Customer");
        custEdit.setFont(customFont2);
        custEdit.setForeground(Color.blue);
        customerMenu.add(custEdit);
        custEdit.addActionListener(menuEventHandler);

        custSearch = new JMenuItem("Search Customers");
        custSearch.setFont(customFont2);
        custSearch.setForeground(Color.blue);
        customerMenu.add(custSearch);
        custSearch.addActionListener(menuEventHandler);

        custShowAll = new JMenuItem("View all Customers");
        custShowAll.setFont(customFont2);
        custShowAll.setForeground(Color.blue);
        customerMenu.add(custShowAll);
        custShowAll.addActionListener(menuEventHandler);
    }

    private void createCarArea() {
        lblCars = new JLabel("Cars");
        lblCars.setForeground(Color.white);
        lblCars.setLocation(200, 20);
        lblCars.setSize(90, 60);
        lblCars.setFont(customFont4);
        lblCars.setVisible(false);
        add(lblCars);

        carShow = new JTextArea(1000, 15);
        scroller3 = new JScrollPane(carShow);
        scroller3.setLocation(30, 70);
        scroller3.setSize(1000, 500);
        carShow.setEditable(false);
        scroller3.setVisible(false);
        add(scroller3);
    }

    private void createEmployeeArea() {
        employeeShow = new JTextArea(1000, 15);
        scroller5 = new JScrollPane(employeeShow);
        scroller5.setLocation(30, 70);
        scroller5.setSize(1000, 500);
        employeeShow.setEditable(false);
        scroller5.setVisible(false);
        add(scroller5);
    }

    private void createCustomerArea() {
        lblCustomer = new JLabel("Customer");
        lblCustomer.setForeground(Color.white);
        lblCustomer.setLocation(200, 20);
        lblCustomer.setSize(220, 60);
        lblCustomer.setFont(customFont4);
        lblCustomer.setVisible(false);
        add(lblCustomer);

        customerShow = new JTextArea(1000, 15);
        scroller4 = new JScrollPane(customerShow);
        scroller4.setLocation(30, 70);
        scroller4.setSize(1000, 500);
        customerShow.setEditable(false);
        scroller4.setVisible(false);
        add(scroller4);
    }


    private void createCustomerPanelAndEditOptions() {
        customerPanel = new JPanel();
        customerPanel.setLayout(new GridLayout(10, 2));
        customerPanel.setSize(500, 400);
        customerPanel.setLocation(20, 70);

        lblCustFirstName = new JLabel("Customer First Name:");
        lblCustLastName = new JLabel("Customer Last Name:");
        lblCustAddress = new JLabel("Customer Address:");
        lblCustPhone = new JLabel("Customer Phone number:");
        lblCustCNP = new JLabel("Customer CNP:");


        txtCustFirstName = new JTextField();
        txtCustLastName = new JTextField();
        txtCustAddress = new JTextField();
        txtCustPhone = new JTextField();
        txtCustCNP = new JTextField();


        customerPanel.add(lblCustFirstName);
        customerPanel.add(txtCustFirstName);

        customerPanel.add(lblCustLastName);
        customerPanel.add(txtCustLastName);


        customerPanel.add(lblCustAddress);
        customerPanel.add(txtCustAddress);

        customerPanel.add(lblCustPhone);
        customerPanel.add(txtCustPhone);


        customerPanel.add(lblCustCNP);
        customerPanel.add(txtCustCNP);

        btnCustAdd = new JButton("Add Customer");
        btnCustExit = new JButton("Exit Customer");
        customerHeader = new JLabel("Customers");
        customerHeader.setSize(150, 30);
        customerHeader.setLocation(210, 20);
        customerHeader.setForeground(Color.white);
        customerHeader.setFont(customFont3);



        add(customerPanel);
        add(customerHeader);
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Panel"));
        customerPanel.add(btnCustAdd);
        btnCustAdd.addActionListener(btnEventHandler);
        customerPanel.add(btnCustExit);
        btnCustExit.addActionListener(btnEventHandler);

        customerPanel.setVisible(false);
        customerHeader.setVisible(false);

    }

    private void createCarPanelAndEditOptions() {
        carPanel = new JPanel();
        carPanel.setLayout(new GridLayout(10, 2));
        carPanel.setSize(500, 400);
        carPanel.setLocation(20, 70);

        lblCarBrand = new JLabel("Car brand:");
        lblCarModel = new JLabel("Car Model:");
        lblCarKM = new JLabel("Car number of km:");
        lblCarGas = new JLabel("Car type of gas:");
        lblCarDefection = new JLabel("Car Defection:");
        lblCarDateIn = new JLabel("Car check in :");
        lblCarDateOut = new JLabel("Car check out :");

        txtCarBrand = new JTextField();
        txtCarModel = new JTextField();
        txtCarKM = new JTextField();
        txtCarGas = new JTextField();
        txtCarDefection = new JTextField();
        txtCarDateIn = new JTextField();
        txtCarDateOut = new JTextField();

        btnCarAdd = new JButton("Add Car");
        btnCarExit = new JButton("Exit Car");
        carHeader = new JLabel("Cars");
        carHeader.setSize(150, 30);
        carHeader.setLocation(210, 20);
        carHeader.setForeground(Color.white);
        carHeader.setFont(customFont3);

        carPanel.add(lblCarBrand);
        carPanel.add(txtCarBrand);

        carPanel.add(lblCarModel);
        carPanel.add(txtCarModel);

        carPanel.add(lblCarKM);
        carPanel.add(txtCarKM);

        carPanel.add(lblCarGas);
        carPanel.add(txtCarGas);

        carPanel.add(lblCarDefection);
        carPanel.add(txtCarDefection);

        carPanel.add(lblCarDateIn);
        carPanel.add(txtCarDateIn);

        carPanel.add(lblCarDateOut);
        carPanel.add(txtCarDateOut);

        carPanel.add(btnCarAdd);

        carPanel.setBorder(BorderFactory.createTitledBorder("Car Panel"));
        btnCarAdd.addActionListener(btnEventHandler);
        carPanel.add(btnCarExit);
        btnCarExit.addActionListener(btnEventHandler);
        add(carPanel);
        add(carHeader);
        carPanel.setVisible(false);
        carHeader.setVisible(false);


      /*  btnSearchCarEdit = new JButton("Find Cars");
        btnSearchCarEdit.addActionListener(btnEventHandler);
        btnSearchCarEdit.setLocation(85, 520);
        btnSearchCarEdit.setSize(145, 30);
        btnSearchCarEdit.setVisible(false);
        add(btnSearchCarEdit);

        txtSearchCarEdit = new JTextField();
        txtSearchCarEdit.setLocation(20, 520);
        txtSearchCarEdit.setSize(50, 30);
        txtSearchCarEdit.setVisible(false);
        add(txtSearchCarEdit );*/

    }

    public void createSearchCarsSelectionAndPanels()
    {
        listCarSearch = new JComboBox<String>(carChoices);
        listCarSearch.setSize(300, 25);
        listCarSearch.setLocation(25, 600);
        listCarSearch.setMaximumRowCount(5);
        listCarSearch.addItemListener(lstEventHandler);
        add(listCarSearch);
        listCarSearch.setVisible(false);

        lblSearchCars = new JLabel("Search the Cars by:");
        lblSearchCars.setSize(300, 25);
        lblSearchCars.setLocation(25, 575);
        lblSearchCars.setForeground(Color.white);
        add(lblSearchCars);
        lblSearchCars.setVisible(false);

        lblSearchCarsBrand = new JLabel("Enter Car Brand");
        lblSearchCarsModel = new JLabel("Enter Cars Model");
        lblSearchCarsGas = new JLabel("Enter Cars Gas");
        lblSearchCarsDefection = new JLabel("Enter Car Defection");



        txtSearchCarsBrand = new JTextField();
        txtSearchCarsModel = new JTextField();
        txtSearchCarsGas = new JTextField();
        txtSearchCarsDefection = new JTextField();



        btnSearchCarBrand = new JButton("Search Car Brand");
        btnSearchCarModel = new JButton("Search Car Model");
        btnSearchCarGas = new JButton("Search Car Gas");
        btnSearchCarDefection = new JButton("Search Car Defection");



        searchCarBrandPanel = new JPanel();
        searchCarBrandPanel.setLocation(350, 585);
        searchCarBrandPanel.setSize(280, 70);
        searchCarBrandPanel.setLayout(new GridLayout(2,2));
        searchCarBrandPanel.add(lblSearchCarsBrand);
        searchCarBrandPanel.add(txtSearchCarsBrand);
        btnSearchCarBrand.addActionListener(btnEventHandler);
        searchCarBrandPanel.add(btnSearchCarBrand);
        searchCarBrandPanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchCarBrandPanel);
        searchCarBrandPanel.setVisible(false);

        searchCarModelPanel = new JPanel();
        searchCarModelPanel.setLocation(350, 585);
        searchCarModelPanel.setSize(280, 70);
        searchCarModelPanel.setLayout(new GridLayout(2,2));
        searchCarModelPanel.add(lblSearchCarsModel);
        searchCarModelPanel.add(txtSearchCarsModel);
        searchCarModelPanel.add(btnSearchCarModel);
        btnSearchCarModel.addActionListener(btnEventHandler);
        searchCarModelPanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchCarModelPanel);
        searchCarModelPanel.setVisible(false);


        searchCarGasPanel = new JPanel();
        searchCarGasPanel.setLocation(350, 585);
        searchCarGasPanel.setSize(280, 70);
        searchCarGasPanel.setLayout(new GridLayout(2,2));
        searchCarGasPanel.add(lblSearchCarsGas);
        searchCarGasPanel.add(txtSearchCarsGas);
        searchCarGasPanel.add(btnSearchCarGas);
        btnSearchCarGas.addActionListener(btnEventHandler);
        searchCarGasPanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchCarGasPanel);
        searchCarGasPanel.setVisible(false);


        searchCarDefectionPanel = new JPanel();
        searchCarDefectionPanel.setLocation(350, 585);
        searchCarDefectionPanel.setSize(280, 70);
        searchCarDefectionPanel.setLayout(new GridLayout(2,2));
        searchCarDefectionPanel.add(lblSearchCarsDefection);
        searchCarDefectionPanel.add(txtSearchCarsDefection);
        searchCarDefectionPanel.add(btnSearchCarDefection);
        btnSearchCarDefection.addActionListener(btnEventHandler);
        searchCarDefectionPanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchCarDefectionPanel);
        searchCarDefectionPanel.setVisible(false);


    }

    private void createEmployeePanel() {
        employeePanel = new JPanel();
        employeePanel.setLayout(new GridLayout(10, 2));
        employeePanel.setSize(500, 400);
        employeePanel.setLocation(20, 70);

        lblEmpFirstName = new JLabel("Employee First Name:");
        lblEmpLastName = new JLabel("Employee Last Name:");
        lblEmpAddress = new JLabel("Employee Address:");
        lblEmpPhone = new JLabel("Employee Phone number:");
        lblEmpCNP = new JLabel("Employee CNP:");
        lblEmpJob = new JLabel("Employee Job:");
        lblEmpSalary = new JLabel("Employee Salary:");

        txtEmpFirstName = new JTextField();
        txtEmpLastName = new JTextField();
        txtEmpAddress = new JTextField();
        txtEmpPhone = new JTextField();
        txtEmpCNP = new JTextField();
        txtEmpJob = new JTextField();
        txtEmpSalary = new JTextField();

        btnEmployeeAdd = new JButton("Add Employee");
        btnEmployeeExit = new JButton("Exit Employee");
        employeeHeader = new JLabel("Employees");

        employeeHeader.setSize(150, 30);
        employeeHeader.setLocation(210, 20);
        employeeHeader.setForeground(Color.white);
        employeeHeader.setFont(customFont3);

        employeePanel.add(lblEmpFirstName);
        employeePanel.add(txtEmpFirstName);

        employeePanel.add(lblEmpLastName);
        employeePanel.add(txtEmpLastName);

        employeePanel.add(lblEmpAddress);
        employeePanel.add(txtEmpAddress);

        employeePanel.add(lblEmpPhone);
        employeePanel.add(txtEmpPhone);

        employeePanel.add(lblEmpCNP);
        employeePanel.add(txtEmpCNP);

        employeePanel.add(lblEmpJob);
        employeePanel.add(txtEmpJob);

        employeePanel.add(lblEmpSalary);
        employeePanel.add(txtEmpSalary);
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee Panel"));
        employeePanel.add(btnEmployeeAdd);
        btnEmployeeAdd.addActionListener(btnEventHandler);
        employeePanel.add(btnEmployeeExit);
        btnEmployeeExit.addActionListener(btnEventHandler);
        add(employeeHeader);
        add(employeePanel);
        employeePanel.setVisible(false);
        employeeHeader.setVisible(false);
    }

    public void createSearchEmployeesSelectionAndPanels()
    {
        listEmployeeSearch = new JComboBox<String>(employeeChoices);
        listEmployeeSearch.setSize(300, 25);
        listEmployeeSearch.setLocation(25, 600);
        listEmployeeSearch.setMaximumRowCount(5);
        listEmployeeSearch.addItemListener(lstEventHandler);
        add(listEmployeeSearch);
        listEmployeeSearch.setVisible(false);

        lblSearchEmployee = new JLabel("Search the Employees by:");
        lblSearchEmployee.setSize(300, 25);
        lblSearchEmployee.setLocation(25, 575);
        lblSearchEmployee.setForeground(Color.white);
        add(lblSearchEmployee);
        lblSearchEmployee.setVisible(false);

        lblSearchEmployeeFirstName = new JLabel("Enter Employee First Name");
        lblSearchEmployeeLastName = new JLabel("Enter Employee  Last Name");
        lblSearchEmployeeJob = new JLabel("Enter Employee Job");


        txtSearchEmployeeFirstName  = new JTextField();
        txtSearchEmployeeLastName = new JTextField();
        txtSearchEmployeeJob = new JTextField();

        btnSearchEmployeeFirstName = new JButton("Search Emp First Name");
        btnSearchEmployeeLastName = new JButton("Search Emp Last Name");
        btnSearchEmployeeJob = new JButton("Search Emp Job");


        searchEmployeeFirstNamePanel = new JPanel();
        searchEmployeeFirstNamePanel.setLocation(350, 585);
        searchEmployeeFirstNamePanel.setSize(325, 70);
        searchEmployeeFirstNamePanel.setLayout(new GridLayout(2,2));
        searchEmployeeFirstNamePanel.add(lblSearchEmployeeFirstName);
        searchEmployeeFirstNamePanel.add(txtSearchEmployeeFirstName);
        searchEmployeeFirstNamePanel.add(btnSearchEmployeeFirstName);
        btnSearchEmployeeFirstName.addActionListener(btnEventHandler);
        searchEmployeeFirstNamePanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchEmployeeFirstNamePanel);
        searchEmployeeFirstNamePanel.setVisible(false);

        searchEmployeeLastNamePanel = new JPanel();
        searchEmployeeLastNamePanel.setLocation(350, 585);
        searchEmployeeLastNamePanel.setSize(325, 70);
        searchEmployeeLastNamePanel.setLayout(new GridLayout(2,2));
        searchEmployeeLastNamePanel.add(lblSearchEmployeeLastName);
        searchEmployeeLastNamePanel.add(txtSearchEmployeeLastName);
        searchEmployeeLastNamePanel.add(btnSearchEmployeeLastName);
        btnSearchEmployeeLastName.addActionListener(btnEventHandler);
        searchEmployeeLastNamePanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchEmployeeLastNamePanel);
        searchEmployeeLastNamePanel.setVisible(false);

        searchEmployeeJobPanel = new JPanel();
        searchEmployeeJobPanel.setLocation(350, 585);
        searchEmployeeJobPanel.setSize(325, 70);
        searchEmployeeJobPanel.setLayout(new GridLayout(2,2));
        searchEmployeeJobPanel.add(lblSearchEmployeeJob);
        searchEmployeeJobPanel.add(txtSearchEmployeeJob);
        searchEmployeeJobPanel.add(btnSearchEmployeeJob);
        btnSearchEmployeeJob.addActionListener(btnEventHandler);
        searchEmployeeJobPanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchEmployeeJobPanel);
        searchEmployeeJobPanel.setVisible(false);
    }

    public void createSearchCustomersSelectionAndPanels()
    {
        listCustomerSearch = new JComboBox<String>(customerChoices);
        listCustomerSearch.setSize(300, 25);
        listCustomerSearch.setLocation(25, 600);
        listCustomerSearch.setMaximumRowCount(5);
        listCustomerSearch.addItemListener(lstEventHandler);
        add(listCustomerSearch);
        listCustomerSearch.setVisible(false);

        lblSearchCustomer = new JLabel("Search the Customers by:");
        lblSearchCustomer.setSize(300, 25);
        lblSearchCustomer.setLocation(25, 575);
        lblSearchCustomer.setForeground(Color.white);
        add(lblSearchCustomer);
        lblSearchCustomer.setVisible(false);

        lblSearchCustomerFirstName = new JLabel("Enter Customer First Name");
        lblSearchCustomerLastName = new JLabel("Enter Customer  Last Name");

        txtSearchCustomerFirstName  = new JTextField();
        txtSearchCustomerLastName = new JTextField();


        btnSearchCustomerFirstName = new JButton("Search Cust First Name");
        btnSearchCustomerLastName = new JButton("Search Cust Last Name");

        searchCustomerFirstNamePanel = new JPanel();
        searchCustomerFirstNamePanel.setLocation(350, 585);
        searchCustomerFirstNamePanel.setSize(325, 70);
        searchCustomerFirstNamePanel.setLayout(new GridLayout(2,2));
        searchCustomerFirstNamePanel.add(lblSearchCustomerFirstName);
        searchCustomerFirstNamePanel.add(txtSearchCustomerFirstName);
        searchCustomerFirstNamePanel.add(btnSearchCustomerFirstName);
        btnSearchCustomerFirstName.addActionListener(btnEventHandler);
        searchCustomerFirstNamePanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchCustomerFirstNamePanel);
        searchCustomerFirstNamePanel.setVisible(false);

        searchCustomerLastNamePanel = new JPanel();
        searchCustomerLastNamePanel.setLocation(350, 585);
        searchCustomerLastNamePanel.setSize(325, 70);
        searchCustomerLastNamePanel.setLayout(new GridLayout(2,2));
        searchCustomerLastNamePanel.add(lblSearchCustomerLastName);
        searchCustomerLastNamePanel.add(txtSearchCustomerLastName);
        searchCustomerLastNamePanel.add(btnSearchCustomerLastName);
        btnSearchCustomerLastName.addActionListener(btnEventHandler);
        searchCustomerLastNamePanel.setBorder(BorderFactory.createTitledBorder("Search Panel"));
        add(searchCustomerLastNamePanel);
        searchCustomerLastNamePanel.setVisible(false);

    }

    private void createSearchToEditEmployee()
    {
        lblEnterIDEmployee = new JLabel("Enter ID of employee you want to edit");
        lblEnterIDEmployee.setLocation(20, 480);
        lblEnterIDEmployee.setSize(210, 30);
        lblEnterIDEmployee.setForeground(Color.white);
        lblEnterIDEmployee.setVisible(false);
        add(lblEnterIDEmployee);

        btnSearchEmployeeEdit = new JButton("Find Employee");
        btnSearchEmployeeEdit.addActionListener(btnEventHandler);
        btnSearchEmployeeEdit.setLocation(85, 520);
        btnSearchEmployeeEdit.setSize(135, 30);
        btnSearchEmployeeEdit.setVisible(false);
        add(btnSearchEmployeeEdit);

        txtSearchEmployeeEdit = new JTextField();
        txtSearchEmployeeEdit.setLocation(20, 520);
        txtSearchEmployeeEdit.setSize(50, 30);
        txtSearchEmployeeEdit.setVisible(false);
        add(txtSearchEmployeeEdit);

        btnEmployeeUpdate = new JButton("Update Employee");
        btnEmployeeUpdate.addActionListener(btnEventHandler);
        btnEmployeeUpdate.setSize(165, 40);
        btnEmployeeUpdate.setLocation(20, 560);
        btnEmployeeUpdate.setEnabled(false);
        btnEmployeeUpdate.setVisible(false);
        add( btnEmployeeUpdate);
    }


}
