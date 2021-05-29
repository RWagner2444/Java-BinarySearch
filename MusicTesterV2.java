import java.util.*;
/**
 * Learn Binary Search
 * 3-15-2021
 * Ryan Wagner
 */
public class MusicTesterV2
{
    public static void main(String[] args){
        Music[] songs = new Music[10];
        songs[0] = new Music("Livin' on a Prayer", 1986, "Bon Jovi");
        songs[1] = new Music("Sweet Caroline", 1969, "Neil Diamond");
        songs[2] = new Music("One", 1988, "Metallica");
        songs[3] = new Music("All Star", 1999, "Smash Mouth");
        songs[4] = new Music("Bohemian Rhapsody", 1975, "Queen");
        songs[5] = new Music("Satellite", 1993, "Dave Matthews Band");
        songs[6] = new Music("Under Pressure", 1995, "Queen");
        songs[7] = new Music("Dream On", 1973, "Areosmith");
        songs[8] = new Music("I Want It That Way", 1999, "Backstreet Boys");
        songs[9] = new Music("Free Fallin'", 1989, "Tom Petty");
        
        System.out.println("\nOriginal List: \n");
        printSongs(songs);
        
        /*sortTitles(songs);
        int title = findByTitle(songs, "Livin' on a Prayer");
        if(title != -1){
            System.out.printf("\n%s %-10s %4d %15s", "Found: ", songs[title].getTitle(), songs[title].getYear(), songs[title].getArtist());
        }
        else{
            System.out.println("\nNot found");
        }*/
        
        //sortYears(songs);
        //printSongs(songs);
        //findByYear(songs, 1999);
        
        //sortArtists(songs);
        //printSongs(songs);
        //findByArtist(songs, "Queen");
    }
    
    public static void printSongs(Music[] songs){
        System.out.printf("%s %24s %8s \n\n", "Title", "Year", "Artist");
        for(Music m: songs){
            System.out.println(m);
        }
    }
    
    public static int findByTitle(Music[] songs, String toFind)
    {
        int high = songs.length, low = -1, probe;
        while(high - low > 1){
            probe = (high + low) / 2;
            if(songs[probe].getTitle().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
            }
        }
        System.out.println("\nSearching for " + toFind + "...");
        if((low >= 0) && (songs[low].getTitle().compareTo(toFind) == 0)){
            return low;
        }
        else{
            return -1;
        }
    }
    
    public static void findByYear(Music[] songs, int toFind){
        int high = songs.length, low = -1, probe;
        while(high - low > 1){
            probe = (high + low) / 2;
            if(songs[probe].getYear() > toFind){
                high = probe;
            }
            else{
                low = probe;
                if(songs[probe].getYear() == toFind){
                    break;
                }
            }
        }
        System.out.println("\nSearching for " + toFind + "...");
        if((low >= 0) && songs[low].getYear() == toFind){
            multYears(songs, low, toFind);
        }
        else{
            System.out.println("Not Found: " + toFind);
        }
    }   
    
    public static void multYears(Music[] songs, int low, int toFind){
       int i, start = low, end = low;
       i = low - 1;
       while((i >= 0) && (songs[i].getYear() == toFind)){
           start = i;
           i--;
       }
       i = low + 1;
       while((i < songs.length) && songs[i].getYear() == toFind){
           end = i;
           i++;
       }
       for(i = start; i <= end; i++){
           System.out.println(songs[i]);
       }
    }
    
    public static void findByArtist(Music[] songs, String toFind){
        int high = songs.length, low = -1, probe;
        while(high - low > 1){
            probe = (high + low) / 2;
            if(songs[probe].getArtist().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
            }
        }
        System.out.println("\nSearching for " + toFind + "...");
        if((low >= 0) && (songs[low].getArtist().compareTo(toFind) == 0)){
            multArtists(songs, low, toFind);
        }
        else{
            System.out.println("Not Found: " + toFind);
        }
    }
    
    public static void multArtists(Music[] songs, int low, String toFind){
       int i, start = low, end = low;
       i = low - 1;
       while((i >= 0) && (songs[i].getArtist().compareTo(toFind) == 0)){
           start = i;
           i--;
       }
       i = low + 1;
       while((i < songs.length) && songs[i].getArtist().compareTo(toFind) == 0){
           end = i;
           i++;
       }
       for(i = start; i <= end; i++){
           System.out.println(songs[i]);
       }
    }
    
    public static void sortTitles(Music[] songs){
        int index;
        Music altMusic = new Music("", 0, "");
        for(int i = songs.length - 1; i > 0; i--){
            index = 0;
            for(int s = 1; s <= i; s++){
                if(songs[s].getTitle().compareTo(songs[index].getTitle()) > 0){
                    index = s;
                }
                altMusic = songs[i];
                songs[i] = songs[index];
                songs[index] = altMusic;
            }
        }
    }
    
    public static void sortYears(Music[] songs){
        int index;
        Music altMusic = new Music("", 0, "");
        for(int i = songs.length - 1; i > 0; i--){
            index = 0;
            for(int s = 1; s <= i; s++){
                if(songs[s].getYear() > songs[index].getYear()){
                    index = s;
                }
                altMusic = songs[i];
                songs[i] = songs[index];
                songs[index] = altMusic;
            }
        }
    }
    
    public static void sortArtists(Music[] songs){
        int index;
        Music altMusic = new Music("", 0, "");
        for(int i = songs.length - 1; i > 0; i--){
            index = 0;
            for(int s = 1; s <= i; s++){
                if(songs[s].getArtist().compareTo(songs[index].getArtist()) > 0){
                    index = s;
                }
                altMusic = songs[i];
                songs[i] = songs[index];
                songs[index] = altMusic;
            }
        }
    }
}
