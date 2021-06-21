import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EcommerceSorting {
    public Ecommerce[] readFile(String fileName) {
            try{
                int count=0;
                BufferedReader bf=new BufferedReader(new FileReader(fileName));
                String line;
                while((line=bf.readLine())!=null){
                    count=count+1;
                }
                String[] temp=new String[7];
                Ecommerce[] ecommerces=new Ecommerce[count];
                BufferedReader br=new BufferedReader(new FileReader(fileName));
                String data;
                br.readLine();
                int j=0;
                while((data=br.readLine())!=null){
                    temp=data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
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
                    catch(NumberFormatException n){
                        n.printStackTrace();
                    }
    
                }
                return ecommerces;
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
                return null;
            }
            catch(IOException e){
                e.printStackTrace();
                return null;
            }
        }
        public void sortingFileBasedOnRetailPrice(Ecommerce[] ecommerces){
            Ecommerce temp;
            int len=ecommerces.length;
            for(int i=0;i<len;i++){
                for(int j=1;j<len-i-1;j++){
                    if(ecommerces[j].getRetail_price()<ecommerces[j-1].getRetail_price()){
                        temp=ecommerces[j-1];
                        ecommerces[j-1]=ecommerces[j];
                        ecommerces[j]=temp;
                    }
                }
            }
        }
        public void sortingFileBasedOnRatings(Ecommerce[] ecommerces){
            Ecommerce temp;
            int len=ecommerces.length;
            for(int i=0;i<len;i++){
                for(int j=1;j<len-i-1;j++){
                    if(ecommerces[j].getProduct_rating()>ecommerces[j-1].getProduct_rating()){
                        temp=ecommerces[j-1];
                        ecommerces[j-1]=ecommerces[j];
                        ecommerces[j]=temp;
                    }
                }
            }
        }
        public void printArrayForBasedOnRating(Ecommerce[] ecommerces){
            for(int i=0;i<ecommerces.length-1;i++){
                if(ecommerces[i]!=null){
                    if(ecommerces[i].getProduct_rating()==0.0){
                        System.out.println(ecommerces[i].getPid()+","+ecommerces[i].getProduct_name()+","+ecommerces[i].getBrand()+","+ecommerces[i].getProduct_url()+","+ecommerces[i].getRetail_price()+","+ecommerces[i].getDiscounted_price()+","+" No ratings available");
                    }
                    else{
                        System.out.println(ecommerces[i].getPid()+","+ecommerces[i].getProduct_name()+","+ecommerces[i].getBrand()+","+ecommerces[i].getProduct_url()+","+ecommerces[i].getRetail_price()+","+ecommerces[i].getDiscounted_price()+","+ecommerces[i].getProduct_rating());
                    }
                }
            }
    
        }
        public void printArrayForBasedPrice(Ecommerce[] ecommerces){
            for(int i=0;i<100;i++){
                if(ecommerces[i]!=null){
                    System.out.println(ecommerces[i].getPid()+","+ecommerces[i].getProduct_name()+","+ecommerces[i].getBrand()+","+ecommerces[i].getProduct_url()+","+ecommerces[i].getRetail_price()+","+ecommerces[i].getDiscounted_price()+","+ecommerces[i].getProduct_rating());
    
                }
            }
        }
    }
    
        


    

