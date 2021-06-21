import java.util.*;
public class RatingComparator implements Comparator<Ecommerces>{
    public int compare(Ecommerces a1,Ecommerces a2){   
        if(a1.getProduct_rating()>(a2.getProduct_rating()))
        {
            return -1;
        }
        else if(a1.getProduct_rating()<(a2.getProduct_rating())){
            return 1;
        }
        else{
            return 0;
        }
     }
}
