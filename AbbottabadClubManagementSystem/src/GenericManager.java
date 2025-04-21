import java.util.ArrayList;

public class GenericManager<T> {
    private ArrayList<T> items;

    // Constructor
    public GenericManager() {
        items = new ArrayList<>();
    }

    // Method to add an item
    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added: " + item);
    }

    // Method to remove an item
    public boolean removeItem(T item) {
        if (items.remove(item)) {
            System.out.println("Item removed: " + item);
            return true;
        } else {
            System.out.println("Item not found: " + item);
            return false;
        }
    }

    //getter 
    public ArrayList<T> getItems() {
        return items;
    }

    // Method to display all items
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
        } else {
            System.out.println("List of Items:");
            for (T item : items) {
                System.out.println(item);
            }
        }
    }
}