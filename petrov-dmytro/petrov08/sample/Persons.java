package sample;

import javafx.beans.property.*;

import java.io.Serializable;

public class Persons implements Serializable {
    private String firstName;
    private String lastName;
    private String subName;
    private String address;
    private String birthday;
    private String phone;



    public Persons(String firstName, String lastName, String subName, String address, String birthday, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subName = subName;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        // Some initial dummy data, just for convenient testing.
//        this.subName = new SimpleStringProperty("Botovich");
//        this.street = new SimpleStringProperty("some street");
//        this.postalCode = new SimpleIntegerProperty(1234);
//        this.city = new SimpleStringProperty("some city");
//        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));

    }

    public Persons(){}

    public String toString(){
        return firstName +"\t"+
                lastName +"\t"+
                subName +"\t"+
                address +"\t"+
                birthday +"\t"+
                phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
