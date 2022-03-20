package com;

public class Customer extends Person{
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    private int car_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private int customer_id;

    Customer(){
    super();
    setCustomer_id(0);
    setCar_id(0);
    }

    public Customer(String firstName, String lastName, String address, String phoneNum, String CNP,
                    int customer_id, int car_id)
    {
        super(firstName, lastName, address, phoneNum, CNP);
        setCar_id(car_id);
        setCustomer_id(customer_id);
    }
}
