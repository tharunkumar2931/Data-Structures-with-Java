public class Ecommerce{
    private String pid;
    private String product_name;
    private String brand;
    private String product_url;
    private int retail_price;
    private int discounted_price;
    private float product_rating;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public int getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(int retail_price) {
        this.retail_price = retail_price;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    public float getProduct_rating() {
        return product_rating;
    }

    public void setProduct_rating(float product_rating) {
        this.product_rating = product_rating;
    }
    public static void main(String[] args){
    EcommerceSorting ea=new EcommerceSorting();
    Ecommerce[] ecommerces= ea.readFile("data//flipkart_product_sample.csv");
    ea.sortingFileBasedOnRetailPrice(ecommerces);
    ea.sortingFileBasedOnRatings(ecommerces);
    long start=System.currentTimeMillis();
    ea.printArrayForBasedOnRating(ecommerces);
    long end=System.currentTimeMillis();
    long result=(start-end);
    System.out.println("Time taken is:"+result);
    long start1=System.currentTimeMillis();
    ea.printArrayForBasedPrice(ecommerces);
    long end1=System.currentTimeMillis();
    long result1=(start1-end1);
    System.out.println("Time taken is:"+result1);
    }

   
}