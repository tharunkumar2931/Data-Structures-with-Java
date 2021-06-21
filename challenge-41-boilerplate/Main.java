import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EcommerceArrayList al=new EcommerceArrayList();
        ArrayList<Ecommerces> ecommerce=al.readFile("data/flipkart-product-sample.csv");
        //al.showList(ecommerce);
        al.sortingBasedOnPrice(ecommerce);
        al.sortingBasedOnRating(ecommerce);
    }
}
