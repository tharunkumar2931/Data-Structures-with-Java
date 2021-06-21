import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class WordImplementation {
    public static  SingleLinkedList readFile(String fileName)
     {
          File file = new File(fileName);
          SingleLinkedList sl = null;
          try (BufferedReader br = new BufferedReader(new FileReader(file))) 
          {
             String line = null;
             String[] words = null;
             sl = new SingleLinkedList();
      
              while ((line = br.readLine()) != null)
               {
                
                  line = line.toLowerCase().replaceAll("[,':;.?]", "");
                  words = line.split(" ");
      
                 for (String word : words) {
                     sl.addWord(word);
                    }
                }
            }
        
        
        
        catch(FileNotFoundException f){
            f.printStackTrace();
            return null;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
        return sl;
    }
    public static void main(String[] args){
        SingleLinkedList ta=new SingleLinkedList();
        SingleLinkedList list= readFile("data//daffodils.txt");
        ta.sortWord(list);
        int count=ta.traversalOfList(list);
        Word[] wordList=ta.occurance(list,count);
        ta.showWordList(wordList);
        ta.reverseOrder(wordList);
        ta.showFrequentWords(wordList);
    }
}


    


   




    


    

