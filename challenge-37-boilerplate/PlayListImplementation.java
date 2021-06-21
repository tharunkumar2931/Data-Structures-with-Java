import java.util.Scanner;
public class PlayListImplementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PlayList pl=new PlayList();
        Song[] songs=pl.takingInputs();
        Node lastNode=pl.insertToList(songs);
        pl.showDetails();
        System.out.println("................................................");
        System.out.println("Do you want to update the list (y/n)");
        char choice=sc.next().charAt(0);
        if(choice=='y'){
        Song[] song=pl.takingUpdateingInputs();
        pl.updatingToList(song);
        }
        System.out.println("................................................");
        System.out.println("Do you want see from updated the list (y/n)");
        char list=sc.next().charAt(0);
        if(list=='y'){
            pl.showUpdatedDetails(lastNode);
        }
        System.out.println("................................................");
        System.out.println("Do you want to delete a item in the list (y/n)");
        char del=sc.next().charAt(0);
        if(del=='y'){
        pl.deleteTheItems();
        }
        pl.showDetails();
    }
}
