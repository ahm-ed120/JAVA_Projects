public class Generic<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
    
    public void display (){
        System.out.println("Name: " + item);
    }

}
