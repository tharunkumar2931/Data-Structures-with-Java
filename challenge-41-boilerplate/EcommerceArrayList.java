import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class EcommerceArrayList {
    public ArrayList<Ecommerces> readFile(String fileName)// method for reading the file and storing in object array  
    {
        try {
            String[] temp=new String[7];
            ArrayList<Ecommerces> ecommerces=new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String data;
            br.readLine();
            while ((data=br.readLine())!=null) // read the file until end
            {
                temp= data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                Ecommerces s=new Ecommerces();
                try{
                    s.setPid(temp[0]);
                    s.setProduct_name(temp[1]);
                    s.setBrand(temp[2]);
                    s.setProduct_url(temp[3]);
                    s.setRetail_price(Integer.valueOf(temp[4]));
                    s.setDiscounted_price(Integer.valueOf(temp[5]));
                    if(temp[6].equals("No rating available"))//if product rating has "No rating available" then covert it to 0.0
                    {
                        temp[6]="0.0";
                    }
                    s.setProduct_rating(Float.valueOf(temp[6]));
                    ecommerces.add(s);
                }
                catch(NumberFormatException n)
                {
                    n.printStackTrace();
                }
            }
        return ecommerces;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void showList(ArrayList<Ecommerces> ecommerces){
        for(Ecommerces e:ecommerces)
        {
            System.out.println(e.getPid()+","+e.getProduct_name()+","+e.getBrand()+","+e.getProduct_url()+","+e.getRetail_price()+","+e.getDiscounted_price()+","+e.getProduct_rating());
        }
    }
    public void sortingBasedOnPrice(ArrayList<Ecommerces> ecommerces)
    {
        Collections.sort(ecommerces,new SortingList());
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter("Updated file(Price).csv"));
            for(Ecommerces e:ecommerces){
                w.write(e.getPid()+","+e.getProduct_name()+","+e.getBrand()+","+e.getProduct_url()+","+e.getRetail_price()+","+e.getDiscounted_price()+","+e.getProduct_rating()+"\n");
            }
            w.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void sortingBasedOnRating(ArrayList<Ecommerces> ecommerces)
    {
        Collections.sort(ecommerces,new RatingComparator());
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter("Updated file(Rating).csv"));
            for(Ecommerces e:ecommerces){
                w.write(e.getPid()+","+e.getProduct_name()+","+e.getBrand()+","+e.getProduct_url()+","+e.getRetail_price()+","+e.getDiscounted_price()+","+e.getProduct_rating()+"\n");
            }
            w.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
