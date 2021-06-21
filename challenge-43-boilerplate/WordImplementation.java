import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WordImplementation {
    public static Map<String,Integer> readFile(String fileName)
    {
        File file = new File(fileName);
        Map<String,Integer> words=new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
          String line = null;
          String[] word = null;
          while((line = br.readLine())!=null)
          {
              if(!(line==null))
              {
                line = line.toLowerCase().replaceAll("[,':;.?-]","");
                word = line.split(" ");
              for(String wd:word)
              {    
                if(words.containsKey(wd))
                {
                    Integer count=words.get(wd);
                    count=count+1;
                    words.put(wd,count);
                }
                else{
                    words.put(wd, 1);
                }
              }
            }
          }
        }

        catch(FileNotFoundException f){
            f.printStackTrace();
            return null;
        }
        catch(IOException f){
            f.printStackTrace();
            return null;
        }
        return words;
    }

    public static void main(String[] args) {
        Map<String,Integer> words=readFile("data/daffodils.txt");
        TreeImplementation ti=new TreeImplementation();
        ti.showTree(words);
        System.out.println("sorted map.........................");
        ti.sort(words);
        ti.showFrequentWords(words);
    }
}
