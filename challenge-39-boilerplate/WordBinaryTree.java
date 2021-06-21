import java.util.Set;
import java.util.TreeSet;

public class WordBinaryTree {
    Node root;
        int count=0;

        public Node insert(Node node,Word word)
        {
            if(node == null)
            {
                node = new Node(word);
                if(root == null)
                    root = node;
                return node;
            }
            if(node.left!=null)
                node.left = insert(node.left,word);  
            else
                node.right = insert(node.right,word);       
            return node;
        }
    
        public void traversal(Node node,Direction dir)
        {
            if(dir.equals(Direction.INORDER))
            {
                if(node != null)
                {
                    traversal(node.left,Direction.INORDER);
                    System.out.println(node.word.getWord());
                    traversal(node.right,Direction.INORDER);
                }
            }
            if(dir.equals(Direction.PREORDER))
            {
                if(node!=null)
                {
                    System.out.println(node.word.getWord());
                    traversal(node.left,Direction.PREORDER);
                    traversal(node.right,Direction.PREORDER);
                }
            }
            if(dir.equals(Direction.POSTORDER))
            {
                if(node!=null)
                {
                    traversal(node.left,Direction.POSTORDER);                
                    traversal(node.right,Direction.POSTORDER);
                    System.out.println(node.word.getWord());
                }
            }
        }
        public int size(Node node)
        {
            if(node!=null){
            return 1+size(node.left)+size(node.right);
            }
            return 0;
            
        }
    public Word[] occurance(Node node,int count)
    {
        Word wordList[]=new Word[count];
        int i=0;
        while(node!=null)
        {
            Word w=new Word();
            w.setWord(node.word.getWord());
            w.setNoOfRepeatedWordsInList(getOccurence(node,node.word.getWord()));
            wordList[i]=w;
            i++;
            node=node.right;
        }
        
        return wordList;
    }
    
        public int getOccurence(Node node,String search){
            int count=0;
            while(node!=null)
            {
                if(node.word.getWord().equals(search)){
                count++;
                }
                node=node.right;    
            }
            return count;
        
        }
        
        public Word[] wordsList(Word[] word){
            Word[] wordsInArr=new Word[word.length];
            for(int i=0;i<word.length;i++)
            {
                boolean value=false;
                for(int j=0;j<i;j++){
                    if(word[i].getWord()!=null&&word[j].getWord()!=null){
                    if(word[i].getWord().equals(word[j].getWord())){
                        value=true;
                        break;
                    }
                }
                else{
                    continue;
                }
                }
                if(!value){
                    wordsInArr[i]=word[i];
                }
            }
            return wordsInArr;
        }
        
        public Node insertFromArray(Node node,Word word)
        {
            if(node == null)
            {
                node = new Node(word);
                if(root == null)
                    root = node;
                return node;
            }
            if(word.getWord().compareTo(node.word.getWord())<=0)
                node.left = insert(node.left,word);  
            else if(word.getWord().compareTo(node.word.getWord())>=0)  
                node.right = insert(node.right,word);       
            return node;
        } 

        public void printTree(Node node,Direction direction)
        {
            if(direction.equals(Direction.INORDER))
            {
                if(node!=null)
                {
                    System.out.println(node.word.getWord()+" "+node.word.getNoOfRepeatedWordsInList());
                    printTree(node.left,Direction.INORDER);
                    printTree(node.right,Direction.INORDER);
                }
            }
        }
        public void showFrequentWords(Word[] wordList){
            System.out.println("Displaying FrequentWords.................");
            int highFreq=0;
            for(int i=0;i<wordList.length;i++)
            {
                if(wordList[i]!=null){
                if(wordList[i].getNoOfRepeatedWordsInList()>highFreq)
                {
                    highFreq=wordList[i].getNoOfRepeatedWordsInList();
                }
            }
            else{
                continue;
            }
            }
            while(highFreq>0){
                int i=0;
                while(i<wordList.length){
                    if(wordList[i]==null){
                        i++;
                        continue;
                    }
                    else{
                        if(wordList[i].getNoOfRepeatedWordsInList()==highFreq)
                        {
                            System.out.println(wordList[i].getWord()+" "+wordList[i].getNoOfRepeatedWordsInList());
                        }
                    }
                i++;
                }
                highFreq--;
            }
        }
}
