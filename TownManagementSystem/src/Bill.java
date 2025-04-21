import java.util.ArrayList;

public class Bill implements BillInfo {
    
    private double bill;
    private double tax;
    private double totalBill;
    private Owner owner;
    private ArrayList <House> house;

    public Bill() {
        bill = 0.0;
        tax =0.0;
        totalBill = 0.0;
        owner = new Owner();
        house = new ArrayList<>();
        
    }

    private void generateTotalBill(double amount){
        tax = amount * 0.15;
        totalBill = tax + amount;
    }

    public void addOwner(Owner owner){
        this.owner = owner;
        house = owner.getHouse();
    }

    @Override
    public void generatreHouseBill() {
        System.out.println("*****Houses*****");
        System.out.println();
        for (House h: house){
            h.display();
            System.out.println();
        }
        
        
    }

    @Override
    public void generateOwnerBill() {
        for (House h : house){
            bill+=h.getTotalCost();
        }
        generateTotalBill(bill);

        System.out.println("*****Owner Bill*****");
        System.out.println("Owner id: " + owner.getOwnerId());
        System.out.println("Owner name: " + owner.name);
        for (House h: house){
            System.out.println("House No: " + h.getHouseNo());
        }
        System.out.println("Bill: " + bill);
        System.out.println("Tax: " + tax);
        System.out.println("Total Bill: " +totalBill);

        
    }

    

    
}
