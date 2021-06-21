import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class MusicCatalog{
    public MusicNode head;

    public boolean insertToList(MusicItem[] music){
        MusicNode current=null;
        boolean result=false;
        for(int i=0;i<music.length;i++)
        {
            MusicNode newNode=new MusicNode(music[i]);  
            if(head==null)
            {
                head=newNode;
                head.previous=null;
            }
            else
            {
                current=head;
                while(current.next!=null)
                {
                    current=current.next;
                }
                current.next=newNode;
                newNode.previous=current;
                newNode.next=null;
            }
            result=true;  
        }
            return result;
    }

    public MusicItem[] readFile(String fileName)
    {
        try{
            BufferedReader bf=new BufferedReader(new FileReader(fileName));
            String line;
            int count=0;
            while((line=bf.readLine())!=null){
                count=count+1;
            }
            MusicItem[] music=new MusicItem[count];
            BufferedReader rc=new BufferedReader(new FileReader(fileName));
            String data;
            int j=0;
            while((data=rc.readLine())!=null)
            {
                String[] temp=data.split(", ");
                try{
                    MusicItem w=new MusicItem();
                    w.setReleaseType(temp[0]);
                    w.setArtist(temp[1]);
                    w.setMusicItemName(temp[2]);
                    w.setGenre(temp[3]);
                    w.setYearOfRelease(Integer.parseInt(temp[4]));
                    w.setNumberOfSongs(Integer.parseInt(temp[5]));
                    w.setTotalPlayingTime(temp[6]);
                    music[j]=w;
                    j++;
                }
                   catch(NumberFormatException n){
                    n.printStackTrace();
                   }
                }
                return music;
           }
        catch(FileNotFoundException f){
            f.printStackTrace();
            return null;
        }
        catch(IOException f){
            f.printStackTrace();
            return null;
        }
    
    }
    public void showDetails(){
        MusicNode current=head;
        if(current==null){
        return;
        }
        while(current!=null){
            System.out.println(current.data.getReleaseType() + " " + current.data.getArtist() + " " + current.data.getMusicItemName()+" "+current.data.getGenre()+" "+current.data.getYearOfRelease()+" "+current.data.getNumberOfSongs()+" "+current.data.getTotalPlayingTime());
             current=current.next;    
        }
    }
    public boolean isInAscendingOrder(MusicNode current,MusicNode nextValue){
        return (current.data.getArtist().charAt(0)>nextValue.data.getArtist().charAt(0));
    }
    public void sorting(){
        MusicNode current=head;
        MusicNode nextValue=null;
        MusicItem temp;
        if(current==null){
            return;
        }
        else{
            while(current!=null){
                nextValue=current.next;
                while(nextValue!=null)
                {
                    if(isInAscendingOrder(current,nextValue)==true)
                    {
                        temp=current.data;
                        current.data=nextValue.data;
                        nextValue.data=temp;
                    }
                    nextValue=nextValue.next;
                }
                current=current.next;
            }
        }
    }
    public void showMusicCatalog(Direction direction){
        MusicNode current=head;
        MusicNode last=null;
        if(direction.equals(Direction.Forward))
        {
            while(current!=null)
            {
                System.out.println(current.data.getReleaseType() + " " + current.data.getArtist() + " " + current.data.getMusicItemName()+" "+current.data.getGenre()+" "+current.data.getYearOfRelease()+" "+current.data.getNumberOfSongs()+" "+current.data.getTotalPlayingTime());
                current=current.next;
            }
        }
        else{
            while(current!=null){
                last=current;
                current=current.next;
            }
            while(last!=null){
                System.out.println(last.data.getReleaseType() + " " + last.data.getArtist() + " " + last.data.getMusicItemName()+" "+last.data.getGenre()+" "+last.data.getYearOfRelease()+" "+last.data.getNumberOfSongs()+" "+last.data.getTotalPlayingTime());
                last=last.previous;
            }
        }
    }
        public void userChoice(){
        
           MusicNode current=head;
           int count=0;
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the album name or artist name or genre");
           String search=sc.nextLine();
           while(current!=null)
           {
               current=current.next;
               count++;
           } 
           MusicNode temp=head;
           for(int i=0;i<count;i++){
               if(temp.data.getArtist().equalsIgnoreCase(search))
               {
                   System.out.println(temp.data.getReleaseType()+" "+temp.data.getArtist()+" "+temp.data.getMusicItemName()+" "+temp.data.getGenre()+" "+temp.data.getYearOfRelease()+" "+temp.data.getNumberOfSongs()+" "+temp.data.getTotalPlayingTime());

               }
               else if(temp.data.getGenre().equalsIgnoreCase(search))
               {
                   System.out.println(temp.data.getReleaseType()+" "+temp.data.getArtist()+" "+temp.data.getMusicItemName()+" "+temp.data.getGenre()+" "+temp.data.getYearOfRelease()+" "+temp.data.getNumberOfSongs()+" "+temp.data.getTotalPlayingTime());
               }
               else if(temp.data.getMusicItemName().equalsIgnoreCase(search))
               {
                System.out.println(temp.data.getReleaseType()+" "+temp.data.getArtist()+" "+temp.data.getMusicItemName()+" "+temp.data.getGenre()+" "+temp.data.getYearOfRelease()+" "+temp.data.getNumberOfSongs()+" "+temp.data.getTotalPlayingTime());

               }
             temp=temp.next;
           }
       }    
    
}



