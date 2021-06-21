import java.util.Map;
import java.util.TreeMap;

public class TreeImplementation {
    public void showTree(Map<String,Integer> words)
    {
        for(Map.Entry<String,Integer> entry:words.entrySet()){
        System.out.println("Key="+entry.getKey()+"      "+"value="+entry.getValue());
        }
    }
    public void sort(Map<String,Integer> words)
    {
        TreeMap<String,Integer> sorted=new TreeMap<>();
        sorted.putAll(words);
        for(Map.Entry<String,Integer> entry:sorted.entrySet()){
            System.out.println("Key="+entry.getKey()+"      "+"value="+entry.getValue());
        }
        System.out.println("In descending order................................");
        Map<String,Integer> des=sorted.descendingMap();
        for(Map.Entry<String,Integer> entry:des.entrySet()){
            System.out.println("Key="+entry.getKey()+"      "+"value="+entry.getValue());
        }
    }
    public void showFrequentWords(Map<String,Integer> words){
        System.out.println("Displaying FrequentWords.................");
        int highFreq=0;
        for(Map.Entry<String,Integer> entry:words.entrySet()){
            if(entry.getValue()>highFreq)
            {
                highFreq=entry.getValue();
            }
        }
        while(highFreq>0){
                for(Map.Entry<String,Integer> entry:words.entrySet()){
                    if(entry.getValue()==highFreq)
                    {
                        System.out.println("Key="+entry.getKey()+"      "+"value="+entry.getValue());
                    }
                }
            highFreq--;
        }
    }
}
