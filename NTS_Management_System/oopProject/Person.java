package oopProject;

abstract class Person {

 String name;
 String fname;
 String idCard;
 String phoneNo;

    Person()
    {
        name = null;
        fname = null;
        idCard=null;
        phoneNo=null;
    }

    Person(String n,String fn,String id,String phone)
    {
        this.name = n;
        this.fname=fn;
        this.idCard=id;
        this.phoneNo=phone;
    }


public abstract void setter();

public abstract void display();

public abstract void update();

}
