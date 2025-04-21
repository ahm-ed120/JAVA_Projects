package com.mycompany.studentfeemanagementsystem;

public abstract class Person {
    String name;
    String address;
    String cellNo;
    int age;

   
    public Person(String name, String address, String cellNo, int age) {
        this.name = name;
        this.address = address;
        this.cellNo = cellNo;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCellNo() {
        return cellNo;
    }

    public int getAge() {
        return age;
    }

    public abstract void display();
}
