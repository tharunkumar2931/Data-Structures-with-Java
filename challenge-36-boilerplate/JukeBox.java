import java.util.Scanner;
public class JukeBox {
    public static void main(String[] args){
        MusicCatalog mc=new MusicCatalog();
        Scanner sc=new Scanner(System.in);
        MusicItem[] music=mc.readFile("data//music-catalog.csv");
        boolean result=mc.insertToList(music);
        if(result==true){
            mc.sorting();
        }
        mc.showDetails();
       System.out.println(".................");
        System.out.println("Enter the order which you want to print");
        String order=sc.next();
        if(order.equalsIgnoreCase("forward")){
            mc.showMusicCatalog(Direction.Forward);
        }
        else{
            mc.showMusicCatalog(Direction.Reverse);
        }
        System.out.println("...................");
         mc.userChoice();
    }
    
}
