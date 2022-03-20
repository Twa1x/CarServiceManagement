package com;



public class Employee extends Person
{

    private int employee_id;
    private String employee_job;
    private double employee_weekly_salary;


    public Employee()
    {
        super();
        setEmployeeJob("-");
        setEmployeeSalary(0);
    }

    public Employee(String firstName, String lastName, String address, String phoneNum, String CNP,
                    String employeeJob, double employeeWeeklySalary)
    {
        super(firstName, lastName, address, phoneNum, CNP);
        setEmployeeJob(employeeJob);
        setEmployeeSalary(employeeWeeklySalary);
    }


    public int getEmployeeID()
    {
        return this.employee_id;
    }

    public int incrementEmployeeID()
    {
        return ++employee_id;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employee_id = employeeID;
    }

    public String getEmployeeJob()
    {
        return this.employee_job;
    }

    public void setEmployeeJob(String employeeJob)
    {
        this.employee_job = employeeJob;
    }

    public double getEmployeeSalary()
    {
        return this.employee_weekly_salary;
    }

    public void setEmployeeSalary(double employeeWeeklySalary)
    {
        this.employee_weekly_salary = employeeWeeklySalary;
    }

    public String toString()
    {
        return (super.toString()+ "  EMPLOYEEID:" +getEmployeeID()+ "  EMPLOYEEJOB" +getEmployeeJob()+
                "  EMPLOYEESALARY:" +getEmployeeSalary());
    }

}
