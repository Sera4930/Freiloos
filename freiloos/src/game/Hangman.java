package game;
import java.util.*;

// Hangman Projekt von Dawid Voronov und Alexander Girin || AI1001

public class Hangman {
  static final String[] WOERTER = {"Tokio", "Hamburg","Kryptographie", "Ninja"}; 

  public static boolean istGueltig (String eingabe) { //checken ob gueltiger buchstabe noch hinzufuegen
	  if (eingabe.length() != 1) return false; 
	  return true;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String eingabe = in.next();	
   
    Random rnd = new Random(); 
    int zufaelligesWort = rnd.nextInt(WOERTER.length);
    
    for (int i = 0; i < WOERTER[zufaelligesWort].length(); ) { 
      while (true) {
        if (!istGueltig(eingabe)){
          System.out.println("Ungueltige Eingabe. Bitte nur einen Buchstaben eingeben!sdf");
          eingabe = in.next();
        } else {
    	    System.out.println(WOERTER[zufaelligesWort]);
    	    i++;
    	    break;
        } 
      }
    }
  }
}
