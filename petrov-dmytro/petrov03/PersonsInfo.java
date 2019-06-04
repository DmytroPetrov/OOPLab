package ua.lpnuai.oop.petrov03;

import java.util.ArrayList;

public class PersonsInfo {
    private static ArrayList<PersonInfo> personsInfos = new ArrayList<>();

    public static void setPersonsInfos(ArrayList<PersonInfo> personsInfos) {
        PersonsInfo.personsInfos = personsInfos;
    }

    public static ArrayList<PersonInfo> getPersonsInfos() {
        return personsInfos;
    }

    public PersonsInfo(){}

    public int size(){
        return personsInfos.size();
    }

    public PersonInfo get(int index){
        return personsInfos.get(index);
    }

    public void print(){
        for (int i = 0; i < personsInfos.size(); i++) {
            personsInfos.get(i).print();
        }
    }

    public void add(PersonInfo personInfo){
        personsInfos.add(personInfo);
    }

}
