import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class WordImplementation {
    public static LinkedList<Word> readFile(String fileName)
    {
        File file = new File(fileName);
        LinkedList<Word> words=new LinkedList<>();
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
                Word w=new Word();               
                w.setWord(wd);
                words.add(w);
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
        LinkedListImplementation ta=new LinkedListImplementation();
        LinkedList<Word> list=readFile("data/daffodils.txt");
        ta.traversal(list); 
        ta.sort(list); 
        LinkedList<Word> words=ta.occurance(list);
        LinkedList<Word> uniqueWords=ta.addingToListOfUniqueWords(words); 
        System.out.println("unique words.............................");
        ta.showWordList(uniqueWords);
        System.out.println("reverse order............................");
        ta.inReverseOrder(uniqueWords);
        ta.showFrequentWords(uniqueWords);
    }
}
