import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class EcommerceSortingUsingQuickSort {
    public void quickSort(Ecommerce[] ecommerces, int startIndex, int endIndex) 
    {
        int partition = partition(ecommerces, startIndex, endIndex-2);
        if(partition-1 > startIndex)
            quickSort(ecommerces, startIndex, partition-1);
        if(partition+1<endIndex)
            quickSort(ecommerces, partition+1,endIndex);

    }
    public int partition(Ecommerce[] ecommerces, int startIndex, int endIndex)
    {
        int pivot = ecommerces[endIndex].getRetail_price();
        for(int i = startIndex;i<endIndex;i++)
        {
            if(ecommerces[i].getRetail_price()<pivot)
            {
                swap(ecommerces,startIndex,i);
                startIndex++;                                        
            }            

        }
        swap(ecommerces,startIndex,endIndex);
        return startIndex;
    }

    public void swap(Ecommerce[] ecommerces,int index1,int index2)
    {
        Ecommerce temp;
        temp = ecommerces[index1];
        ecommerces[index1] = ecommerces[index2];
        ecommerces[index2] = temp;
    }
    public void printArrayForBasedOnPrice(Ecommerce[] ecommerces)
    {
        for(int i=0;i<ecommerces.length;i++)
        {
            if(ecommerces[i]!=null){
                System.out.println(ecommerces[i].getPid()+","+ecommerces[i].getProduct_name()+","+ecommerces[i].getBrand()+","+ecommerces[i].getProduct_url()+","+ecommerces[i].getRetail_price()+","+ecommerces[i].getDiscounted_price()+","+ecommerces[i].getProduct_rating());
                //System.out.println(ecommerces[i].getRetail_price());
            }
        }
    }
    public void writerFileForQuickSort(Ecommerce[] ecommerces)
    {
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter("Updated file for QuickSort.csv"));
            for(int i=0;i<ecommerces.length-2;i++){
                w.write(ecommerces[i].getPid()+","+ecommerces[i].getProduct_name()+","+ecommerces[i].getBrand()+","+ecommerces[i].getProduct_url()+","+ecommerces[i].getRetail_price()+","+ecommerces[i].getDiscounted_price()+","+ecommerces[i].getProduct_rating()+"\n");
            }
            w.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void random(Ecommerce[] ecommerces, int startIndex, int endIndex)
    {
        Random ran=new Random();
        int pivot =ran.nextInt(endIndex-startIndex)+startIndex;
        float temp=ecommerces[pivot].getProduct_rating();
        ecommerces[pivot].setProduct_rating(ecommerces[endIndex].getProduct_rating());
        ecommerces[endIndex].setProduct_rating(temp);
    }
    public void quickSortBasedOnRating(Ecommerce[] ecommerces, int startIndex, int endIndex) 
    {
        int partition = partitionForRating(ecommerces, startIndex, endIndex);
        if(partition-1>startIndex)
            quickSortBasedOnRating(ecommerces, startIndex, partition-1);
        if(partition+1<endIndex)
            quickSortBasedOnRating(ecommerces, partition+1,endIndex);

    }
    public int partitionForRating(Ecommerce[] ecommerces, int startIndex, int endIndex)
    {
        random(ecommerces, startIndex, endIndex);
        float pivot = ecommerces[endIndex].getProduct_rating();
        for(int i = startIndex;i<endIndex;i++)
        {
            try{
            if(ecommerces[i].getProduct_rating()<pivot)
            {
                swapForRating(ecommerces,startIndex,i);
                startIndex++;                                        
            }   
        }   
        catch(NullPointerException n)
        {
            continue;
        }      
        }
        swapForRating(ecommerces,startIndex,endIndex);
        return startIndex;
    }

    public void swapForRating(Ecommerce[] ecommerces,int index1,int index2)
    {
        Ecommerce temp;
        temp = ecommerces[index1];
        ecommerces[index1] = ecommerces[index2];
        ecommerces[index2] = temp;
    }
    public void printArrayForBasedOnRating(Ecommerce[] ecommerces)
    {
        for(int i=0;i<ecommerces.length;i++)
        {
            if(ecommerces[i]!=null){
                //System.out.println(ecommerces[i].getPid()+","+ecommerces[i].getProduct_name()+","+ecommerces[i].getBrand()+","+ecommerces[i].getProduct_url()+","+ecommerces[i].getRetail_price()+","+ecommerces[i].getDiscounted_price()+","+ecommerces[i].getProduct_rating());
                System.out.println(ecommerces[i].getProduct_rating());
            }
        }
    }
}
