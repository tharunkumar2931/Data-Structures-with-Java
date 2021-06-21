import java.util.Collections;
import java.util.*;
import java.util.LinkedList;


public class LinkedListImplementation {
    public void traversal(LinkedList<Word> list){
        for(Word w:list)
        {
            System.out.println(w.getWord());
        }
    }
    public void sort(LinkedList<Word> list){
        Collections.sort(list,new SortingList());
    }
    public LinkedList<Word> occurance(LinkedList<Word> list)
    {
        LinkedList<Word> wordList=new LinkedList<>();
        for(int i=0;i<list.size();i++)
        {
            Word w=new Word();
            w.setWord(list.get(i).getWord());
            w.setNoOfRepeatedWordsInList(getOccurence(list,list.get(i).getWord()));
            wordList.add(w);
        }
        return wordList;
    }
    public int getOccurence(LinkedList<Word> list,String search){
        int count=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWord().equals(search))
            {
                count++;
            }
        }
        return count;
    }
    public LinkedList<Word> addingToListOfUniqueWords(LinkedList<Word> list){
        LinkedList<Word> wordList=new LinkedList<>();
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i).getWord().equals(list.get(i+1).getWord())){
                continue;
            }
            else{
                Word w=new Word();
                w.setWord(list.get(i).getWord());
                w.setNoOfRepeatedWordsInList(list.get(i).getNoOfRepeatedWordsInList());
                wordList.add(w);
            }
        }
        return wordList;
    }
    public void showWordList(LinkedList<Word> list){
        int i=0;
        for(Word wd:list)
        {
            System.out.println(wd.getWord()+"   "+wd.getNoOfRepeatedWordsInList());
            i++;
        }
        System.out.println(i);
    }
    public void inReverseOrder(LinkedList<Word> list)
    {
        Collections.reverse(list);
        for(int i=0;i<list.size();i++){
        System.out.println(list.get(i).getWord()+"  "+list.get(i).getNoOfRepeatedWordsInList());
        }
    }
    public void showFrequentWords(LinkedList<Word> list){
        System.out.println("Displaying FrequentWords.................");
        int highFreq=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getNoOfRepeatedWordsInList()>highFreq)
            {
                highFreq=list.get(i).getNoOfRepeatedWordsInList();
            }
        }
        while(highFreq>0){
            int i=0;
            while(i<list.size()){
                if(list.get(i).getNoOfRepeatedWordsInList()==highFreq)
                {
                    System.out.println(list.get(i).getWord()+" "+list.get(i).getNoOfRepeatedWordsInList());
                }
                i++;
            }
            highFreq--;
        }
    }
}
