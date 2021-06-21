
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class WordImplementation {
    static WordBinaryTree readFromFile(String fileName) throws FileNotFoundException {
        String line = null;
        String str[]=null;
        int count=0;
        WordBinaryTree bt = new WordBinaryTree();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {   
                line = line.toLowerCase().replaceAll("[,:;.-]","");
                str=line.split("[\\s,]");
                for(String word:str){
                Word w=new Word();
                w.setWord(word);
                bt.insert(bt.root,w);
                count++;
                }
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        System.out.println(count);
        return bt;
    }
    static void showTree(WordBinaryTree bt)
    {
        bt.traversal(bt.root, Direction.PREORDER);
    }
    public static void main(String[] args) {
        WordBinaryTree bt = null;
        try {
            bt = readFromFile("data/daffodils.txt");
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        showTree(bt);
        int count=bt.size(bt.root);
        System.out.println("the size for tree is:"+count);
        Word[] words=bt.occurance(bt.root,count);
        Word[] wordsInArr=bt.wordsList(words);
        WordBinaryTree wb=new WordBinaryTree();
        long start=System.currentTimeMillis();
        for(int i=0;i<wordsInArr.length;i++)
        {
            try{
            Word ws=new Word();
            ws.setWord(wordsInArr[i].getWord());
            ws.setNoOfRepeatedWordsInList(wordsInArr[i].getNoOfRepeatedWordsInList());
            wb.insertFromArray(wb.root,ws);
            }
            catch(NullPointerException n){
                continue;
            }
        }
        long end=System.currentTimeMillis();
        long time=end-start;
        System.out.println("Time taken to insert elements is:"+time);
        System.out.println("Elements in list after removing similar elements");
        wb.printTree(wb.root,Direction.INORDER);
    }
    
}


