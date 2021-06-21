public class WordBinaryTree {
    Node root;
        int count=0;

        public Node insert(Node node,Word data)
        {
            if(node == null)
            {
                node = new Node(data);
                if(root == null)
                    root = node;
                return node;
            }
            if(node.left != null)
                node.left = insert(node.left,data);         
            else
                node.right = insert(node.right,data);       
            return node;
        }
    
        public void traversal(Node node,Direction dir){
            if(dir.equals(Direction.INORDER))
            {
                if(node != null)
                {
                    traversal(node.left,Direction.INORDER);
                    System.out.println(node.words.getWord());
                    traversal(node.right,Direction.INORDER);
                }
            }
            if(dir.equals(Direction.PREORDER))
            {
                if(node!=null)
                {
                    System.out.println(node.words.getWord());
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
                    System.out.println(node.words.getWord());
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
            w.setWord(node.words.getWord());
            w.setNoOfRepeatedWordsInList(getOccurence(node,node.words.getWord()));
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
                if(node.words.getWord().equals(search)){
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
                    if(word[i].getWord().equals(word[j].getWord())){
                        value=true;
                        break;
                    }
                }
                if(!value){
                    wordsInArr[i]=word[i];
                }
            }
            wordsInArr[word.length-1]=word[word.length-1];
            return wordsInArr;
        }
      
        public Node insertFromArray(Node node,Word data)
        {
            if(node == null)
            {
                node = new Node(data);
                if(root == null)
                    root = node;
                return node;
            }
            if(node.left != null)
                node.left = insertFromArray(node.left,data);         
            else
                node.right = insertFromArray(node.right,data);       
            return node;
        } 

        public void printTree(Node node,Direction direction)
        {
            if(direction.equals(Direction.INORDER))
            {
                if(node!=null)
                {
                    System.out.println(node.words.getWord()+" "+node.words.getNoOfRepeatedWordsInList());
                    printTree(node.left,Direction.INORDER);
                    printTree(node.right,Direction.INORDER);
                }
            }
        }
    
}
