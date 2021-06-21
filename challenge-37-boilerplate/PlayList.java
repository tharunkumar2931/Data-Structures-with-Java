import java.util.Scanner;
public class PlayList {
    public Node head;
   
    public Node insertToList(Song[] songs){
        Node current =null;
        Node temp=null;
        for(int i=0;i<songs.length;i++)
        {
            Node newNode = new Node(songs[i]);
            if(head==null)
            {
                head = newNode;
                head.previous = null;
            }
            else
            {
                current = head;
                while(current.next!=null)
                {
                    current=current.next;
                }
                current.next=newNode;
                newNode.previous=current;
                newNode.next=null;
            }
        }
        Node currentItem=head;
        while(currentItem!=null)
        {
            temp=currentItem;
            currentItem=currentItem.next;
        }
        return temp;
    }
    
    public Song[] takingInputs()
    {
        System.out.println("Enter the no of inputs");
        Scanner sc=new Scanner(System.in);
        int inputs=sc.nextInt();
        Song[] songs=new Song[inputs];
        try{
            for(int i=0;i<inputs;i++){
            Song s=new Song();
            System.out.println("Enter the Artist name");
            String artistName=sc.next();
            s.setArtist(artistName);
            System.out.println("Enter the music Item Name");
            String musicItem=sc.next();
            s.setMusicItemName(musicItem);
            System.out.println("Enter the Genre");
            String genre=sc.next();
            s.setGenre(genre);
            System.out.println("Enter the yearOfRelease");
            int year=sc.nextInt();
            s.setYearOfRelease(year);
            System.out.println("Enter the number of songs");
            int numberOfSongs=sc.nextInt();
            s.setNumberOfSongs(numberOfSongs);
            System.out.println("Enter the total Playing Time");
            String totalPlayingTime=sc.next();
            s.setTotalPlayingTime(totalPlayingTime);
            songs[i]=s;
            }
            return songs;
        }
        catch(NullPointerException f){
            f.printStackTrace();
            return null;
        }
    }
   
    public void deleteTheItems(){
        Node current=head;
        Node temp = null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of Artist or musicItemName or Genre to delete");
        String data=sc.next();
        if(current.data.getArtist().equalsIgnoreCase(data)||current.data.getMusicItemName().equalsIgnoreCase(data)||current.data.getGenre().equalsIgnoreCase(data))
        {
            head = current.next;
            current.previous=null;
            return;
        }
        while(current.next!=null&&!current.data.getArtist().equalsIgnoreCase(data))
        {
            temp = current;
            current = current.next;
        }
        while(current.next!=null&&!current.data.getMusicItemName().equalsIgnoreCase(data))
        {
            temp = current;
            current = current.next;
        }
        while(current.next!=null&&!current.data.getGenre().equalsIgnoreCase(data))
        {
            temp = current;
            current = current.next;
        }

        temp.next = current.next;
    }
    public void showDetails()
    {
        Node current = head;
        if(current == null)
            return;
        while(current!=null)
        {
            System.out.println(current.data.getArtist()+" "+current.data.getMusicItemName()+" "+current.data.getGenre()+" "+current.data.getYearOfRelease()+" "+current.data.getNumberOfSongs()+" "+current.data.getTotalPlayingTime());
            current = current.next;
        }

    }
 
    public void updatingToList(Song[] song){
        Node current =head;
        for(int i=0;i<song.length;i++)
        {
            Node newNode = new Node(song[i]);
            
                while(current.next!=null)
                {
                    current=current.next;
                }
                current.next=newNode;
                newNode.previous=current;
                newNode.next=null;
        }
    }
    public Song[] takingUpdateingInputs()
    {
        System.out.println("Enter the no of inputs for update the list");
        Scanner sc=new Scanner(System.in);
        int inputs=sc.nextInt();
        Song[] song=new Song[inputs];
        try{
            for(int i=0;i<inputs;i++){
            Song s=new Song();
            System.out.println("Enter the Artist name");
            String artistName=sc.next();
            s.setArtist(artistName);
            System.out.println("Enter the music Item Name");
            String musicItem=sc.next();
            s.setMusicItemName(musicItem);
            System.out.println("Enter the Genre");
            String genre=sc.next();
            s.setGenre(genre);
            System.out.println("Enter the yearOfRelease");
            int year=sc.nextInt();
            s.setYearOfRelease(year);
            System.out.println("Enter the number of songs");
            int numberOfSongs=sc.nextInt();
            s.setNumberOfSongs(numberOfSongs);
            System.out.println("Enter the total Playing Time");
            String totalPlayingTime=sc.next();
            s.setTotalPlayingTime(totalPlayingTime);
            song[i]=s;
            }
            return song;
        }
        catch(NullPointerException f){
            f.printStackTrace();
            return null;
        }
    }
    public void showUpdatedDetails(Node last)
    {
        Node current = last.next;
        if(current == null)
            return;
        while(current!=null)
        {
            System.out.println(current.data.getArtist()+" "+current.data.getMusicItemName()+" "+current.data.getGenre()+" "+current.data.getYearOfRelease()+" "+current.data.getNumberOfSongs()+" "+current.data.getTotalPlayingTime());
            current = current.next;
        }

    }

}
