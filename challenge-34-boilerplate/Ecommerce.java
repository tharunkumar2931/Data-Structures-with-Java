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
    public static void main(String[] args) {
        EcommerceSearchImplementation es=new EcommerceSearchImplementation();
        Ecommerce[] ecommerces=es.readFile("data/flipkart_product_sample.csv");
        long start=System.currentTimeMillis();
        int index=es.searchingUsingLinear(ecommerces);
        long end=System.currentTimeMillis();
        long timeTaken=end-start;
        if(index==-1)
        {
            System.out.println("no product is available with the specific pid");
        }
        else{
            System.out.println("The product for the pid is "+ecommerces[index].getProduct_name());
        }
        long startTime=System.currentTimeMillis();
        int indexOfBinary=es.searchingUsingBinary(ecommerces);
        long endTime=System.currentTimeMillis();
        long timeTakenForBinary=endTime-startTime;
        if(indexOfBinary==-1)
        {
            System.out.println("no product is available with the specific pid");
        }
        else{
            System.out.println("The product for the pid is "+ecommerces[indexOfBinary].getProduct_name());
        }
        System.out.println("Time taken for linear search :"+timeTaken);
        System.out.println("Time taken for binary search :"+timeTakenForBinary);

    }
}