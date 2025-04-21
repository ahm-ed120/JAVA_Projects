package oopProject;

import java.util.Scanner;

public class Superintendent extends Employee {

    private int interval;

    public Superintendent() {
        super();
        interval=0;
    }

    public Superintendent(String n, String fn, String id, String phone, int employeeNo, String city, Double invig_allowance, Double spdt_allowance, int interval) {
        super(n, fn, id, phone, employeeNo, city, invig_allowance, spdt_allowance);
        this.interval=interval;
    }

    @Override
    public void setter() {
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the interval of superintendent(in months): ");
        interval = input.nextInt();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Interval of superintendent: "+interval+"months");
        if(spdt_allowance==0)
        {
            System.out.println("Allowance not determined");
        }
        else {
            super.get_Allowance(2);
        }
    }

    @Override
    public void update() {
        super.update();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the interval of superintendent(in months): ");
        interval = input.nextInt();
    }
}
