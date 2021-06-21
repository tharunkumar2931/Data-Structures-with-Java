import java.util.*;
public class SortingList implements Comparator<Ecommerces>{
    public int compare(Ecommerces a1,Ecommerces a2){   
        if(a1.getRetail_price()>(a2.getRetail_price()))
        {
            return 1;
        }
        else if(a1.getRetail_price()<(a2.getRetail_price())){
            return -1;
        }
        else{
            return 0;
        }
     }
}
