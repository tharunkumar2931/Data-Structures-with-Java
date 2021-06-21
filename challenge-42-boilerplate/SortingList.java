import java.util.*;
public class SortingList implements Comparator<Word>{
    public int compare(Word a1,Word a2){   
        return a1.getWord().compareTo(a2.getWord()); 
     }
}
