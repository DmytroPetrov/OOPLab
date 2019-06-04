package ua.lpnuai.oop.petrov03;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;

import static java.lang.Math.min;

public class PersonInfo implements Serializable, Comparable<PersonInfo> {
    private  String name;
    private  String subname;
    private  String lastName;
    private  Date birthDate;
    private  LocalDateTime lastEdit;
    private  Vector<String> phoneNumber;
    private  String address;

    public PersonInfo(){
        this.lastEdit = LocalDateTime.now();
    }

    public void fill(String[] name, Date birthDate, Vector<String> phoneNumber, String address){
        this.lastEdit = LocalDateTime.now();
        this.name = name[0];
        subname = name[1];
        lastName = name[2];
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;

//        for (int i = 0; i < phoneNumber.size(); i++) {
//            this.phoneNumber = phoneNumber;
//        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSubname(String subname){
        this.subname = subname;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public void setLastEdit() {
        this.lastEdit = LocalDateTime.now();
    }

    public void setPhoneNumber(Vector<String> phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public String getAddress() {
        return address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getSubname() {
        return subname;
    }

    public Vector<String> getPhoneNumber() {
        return phoneNumber;
    }


    public void print(){
        System.out.println(toString());
    }

    public String toString(){
        return  name +"\t" +subname +"\t" +lastName +"\n" +
                birthDate.toString() +"\n"+
                address +"\n"+
                phoneNumber.toString() +"\n"+
                lastEdit.toString();
    }



    @Override
    public int compareTo(PersonInfo o) {
        String compareName = o.getName(),
        compareSubname = o.getSubname(),
        compareLastName = o.getLastName();
        int test = 0;

        for (int i = 0; i < min(name.length(), compareName.length()); i++) {
            if(this.name.charAt(0) > compareName.charAt(0)) {
                test = 0;
                break;
            }
            else if (this.name.charAt(0) < compareName.charAt(0)){
                test = -1;
                break;
            }
            /**SubName*/
            if ( i == min(name.length(), compareName.length()) - 1){

                for (int j = 0; j < min(subname.length(), compareSubname.length()); j++) {
                    if(this.name.charAt(0) > compareSubname.charAt(0)) {
                        test = 0;
                        break;
                    }
                    else if (this.name.charAt(0) < compareSubname.charAt(0)){
                        test = -1;
                        break;
                    }

                    /**LastName**/
                    if ( j == min(subname.length(), compareSubname.length()) - 1){
                        for (int k = 0; k < min(lastName.length(), compareLastName.length()); k++) {
                            if(this.name.charAt(0) > compareLastName.charAt(0)) {
                                test = 0;
                                break;
                            }
                            else if (this.name.charAt(0) < compareLastName.charAt(0)){
                                test = -1;
                                break;
                            }
                        }
                    }
                }
            }
        }


        return test;
    }

    private int comparingName(int i, String compareName){
        if(name.charAt(i) > compareName.charAt(i))
        {
            return 0;
        }
        if (name.charAt(i) < compareName.charAt(i)) {
            return -1;
        }
        return 1;
    }
}
