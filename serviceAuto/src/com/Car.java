package com;
import java.util.Date;

public class Car {
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    private int car_id;
    private String m_brand;
    private String m_model;
    private int m_numberKM;
    private String m_typeOfGas;
    private String m_defection;
    private String m_dateOut;
    private String m_dateIn;



    public Car(int car_id, String brand, String model, int numberKM, String typeOfGas, String defection,String dateIn, String dateOut) {
        m_brand = brand;
        m_model = model;
        m_numberKM = numberKM;
        m_typeOfGas = typeOfGas;
        m_defection = defection;
        m_dateIn = dateIn;
        m_dateOut =  dateOut;
       this.car_id = car_id;

    }

    public Car()
    {
        car_id = 0;
        m_brand = "";
        m_model = "";
        m_numberKM = -1;
        m_typeOfGas = "";
        m_defection = "";
    }

    public String GetBrand() { return m_brand; }

    public String GetModel() {
        return m_model;
    }

    public int GetNumberKM() {
        return m_numberKM;
    }

    public String GetTypeOfGas() {
        return m_typeOfGas;
    }

    public String GetDefection() {
        return m_defection;
    }

    public void SetBrand(String brand) { m_brand = brand;}

    public void SetModel(String model) {
        m_model = model;
    }

    public void SetNumberKM(int numberKM) {
        m_numberKM = numberKM;
    }

    public void SetTypeOfGas(String typeOfGas) {
        m_typeOfGas = typeOfGas;
    }

    public void SetDefection(String defection) {
        m_defection = defection;
    }

    public String getM_dateIn() {
        return m_dateIn;
    }

    public void setM_dateIn(String m_dateIn) {
        this.m_dateIn = m_dateIn;
    }

    public String getM_dateOut() {
        return m_dateOut;
    }

    public void setM_dateOut(String m_dateOut) {
        this.m_dateOut = m_dateOut;
    }

}
