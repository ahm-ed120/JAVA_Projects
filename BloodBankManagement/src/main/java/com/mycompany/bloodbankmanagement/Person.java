/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;

import java.util.Scanner;

/**
 *
 * @author MAHNOOR SARDAR
 */
public abstract class Person {
    protected String id;
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    protected String email;

public Person()
{
    id="";
    name="";
    age=0;
    gender="";
    address="";
    email="";
}

public Person(String id, String name, int age, String gender, String address, String email)
{
    this.id=id;
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.address=address;
    this.email=email;
}

public void setter()
{
    Scanner input=new Scanner(System.in);
    System.out.println("Enter ID: ");
    id=input.next();
    System.out.println("Enter Name: ");
    name=input.next();
    System.out.println("Enter age: ");
    age=input.nextInt();
    System.out.println("Enter Gender");
    gender=input.next();
    System.out.println("Enter Address");
    address=input.next();
    System.err.println("Enter Email");
    email=input.next();
}

public String getname()
{
    return name;
}

public void setname(String name)
{
    this.name=name;
}

public int getage()
{
    return age;
}

public void setage(int age)
{
    this.age=age;
}
       
public String getgender()
{
    return gender;
}

public void setgender(String gender)
{
    this.gender=gender;
}

public String getaddress()
{
    return address;
}

public void setaddress(String address)
{
    this.address=address;
}

public String getemail()
{
    return email;
}

public void setemail(String email)
{
    this.email=email;
}
public void display()
{
    System.out.println("Id: "+id);
    System.out.println("name is: "+name);
    System.out.println("age is: "+age);
    System.out.println("gender: "+gender);
    System.out.println("address: "+address);
    System.out.println("email: "+ email);
}
    
}

