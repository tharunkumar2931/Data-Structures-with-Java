public class SingleLinkedList {
    Node head;
    public void addWord(String data){
        //creating new node
        Node newNode=new Node(data);
        newNode.next=null;
        if(head==null)
        {
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public int traversalOfList(SingleLinkedList list){
        Node current=list.head;
        int count=0;
        while(current!=null)
        {
            System.out.println(current.data);
            count++;
            current=current.next;
        }
        return count;
    }
    public void sortWord(SingleLinkedList list){
        Node current=list.head;
        Node index=null;
        String temp;
        if(list.head==null)
        {
            return;
        }
        else{
            while(current!=null){
                index=current.next;
                while(index!=null){
                    if(current.data.compareTo(index.data)>0)
                    {
                        temp=current.data;
                        current.data=index.data;
                        index.data=temp;
                    }
                    index=index.next;
                }
                current=current.next;
            }
        }
    }
    public Word[] occurance(SingleLinkedList list,int count){
        Word wordList[]=new Word[count];
        Node current=list.head;
        int i=0;
        while(current!=null)
        {
            Word w=new Word();
            w.setWord(current.data);
            w.setNoOfOccurance(getOccurence(list,current.data));
            wordList[i]=w;
            i++;
            current=current.next;
        }
        return wordList;
    }
    public int getOccurence(SingleLinkedList list,String search){
        Node current=list.head;
        int count=0;
        while(current!=null){
            if(current.data.equals(search))
            {
                count++;
            }
            current=current.next;
        }
        return count;
    }
    public void showWordList(Word[] wordList){
        System.out.println();
        System.out.println("Words in the list are.......");
        for(int i=0;i<wordList.length-1;i++)
        {
            if(wordList[i].getWord().equals(wordList[i+1].getWord())){
                continue;
            }
            else{
                System.out.println(wordList[i].getWord()+" "+wordList[i].getNoOfOccurance());
            }
        }
        System.out.println(wordList[wordList.length-1].getWord()+" "+wordList[wordList.length-1].getNoOfOccurance());
    }
    public void reverseOrder(Word[] wordList){
        System.out.println();
        System.out.println("In reverse order.........");
        for(int i=wordList.length-1;i>0;i--){
            if(wordList[i].getWord().equals(wordList[i-1].getWord())){
                continue;
            }
            else{
                System.out.println(wordList[i].getWord()+" "+wordList[i].getNoOfOccurance());
            }
            System.out.println(wordList[0].getWord()+" "+wordList[0].getNoOfOccurance());
            System.out.println(System.currentTimeMillis());
        }
    }
        public void showFrequentWords(Word[] wordList){
            System.out.println("Displaying FrequentWords........");
            int highFreq=0;
            for(int i=0;i<wordList.length;i++){
                if(wordList[i].getNoOfOccurance()>highFreq)
                {
                    highFreq=wordList[i].getNoOfOccurance();
                }
            }
            while(highFreq>0){
                int i=0;
                while(i<wordList.length){
                    if(wordList[i].getNoOfOccurance()==highFreq)
                    {
                        System.out.println(wordList[i].getWord()+" "+wordList[i].getNoOfOccurance());
                    }
                    i++;
                }
                highFreq--;
            }
        }
    }




    

