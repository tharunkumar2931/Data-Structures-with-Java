import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class EcommerceSearchImplementation {
    public Ecommerce[] readFile(String fileName)
    {
        try {
            int count=0;
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line=bf.readLine())!=null){
                count=count+1;
            }
            String[] temp=new String[7];
            Ecommerce[] ecommerces=new Ecommerce[count];
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String data;
            br.readLine();
            int j=0;
            while ((data=br.readLine())!=null) 
            {
                temp= data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                Ecommerce s=new Ecommerce();
                try{
                    s.setPid(temp[0]);
                    s.setProduct_name(temp[1]);
                    s.setBrand(temp[2]);
                    s.setProduct_url(temp[3]);
                    s.setRetail_price(Integer.valueOf(temp[4]));
                    s.setDiscounted_price(Integer.valueOf(temp[5]));
                    if(temp[6].equals("No rating available"))
                    {
                        temp[6]="0.0";
                    }
                    s.setProduct_rating(Float.valueOf(temp[6]));
                    ecommerces[j]=s;
                    j++;
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
   
	public int searchingUsingLinear(Ecommerce[] ecommerces) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the pid number to search");
        String searchElement=sc.next();
        for(int i=0;i<ecommerces.length;i++)
        {
            if(ecommerces[i].getPid().equalsIgnoreCase(searchElement))
            {
                return i;
            }
            
        }
        return -1;
	}
	public int searchingUsingBinary(Ecommerce[] ecommerces) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the pid number to search");
        String searchElement=sc.next();
        int left = 0;
        int right = ecommerces.length - 1;

        while(left<=right)
        {
            int mid = (left+right)/2;
            if(ecommerces[mid].getPid().equalsIgnoreCase(searchElement))
                return mid;
            else if(searchElement.charAt(0)>ecommerces[mid].getPid().charAt(0))
                left = mid+1;
            else 
                right = mid-1;
        }
        return -1;
	}
}
