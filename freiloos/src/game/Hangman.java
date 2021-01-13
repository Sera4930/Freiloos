package game;
import java.util.*;

// Hangman Projekt von Dawid Voronov und Alexander Girin || AI1001

public class Hangman {
  static final String[] WOERTER = {"Tokio", "Hamburg","Kryptographie", "Ninja"}; 

  public static boolean istGueltig (String eingabe) { //checken ob gueltiger buchstabe noch hinzufuegen
    if (eingabe.length() != 1) return false; 
    return true;
  }
  
  public static String errateneBuchstaben(String ausgewaehltesWort) {
    String unterstriche = "";
    for (int i = 0; i < ausgewaehltesWort.length(); i++) {
  	  unterstriche = unterstriche + "___ ";
    }
    return unterstriche;
  }
  
  public static void main(String[] args) {
    
    Random rnd = new Random(); 
    int zufaelligeWortauswahl = rnd.nextInt(WOERTER.length);
    String ausgewaehltesWort = WOERTER[zufaelligeWortauswahl];
  
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * Willkommen zu Hangman * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("Bitte einen Buchstaben eingeben, um das folgende Wort zu erraten!\n");
    System.out.println(errateneBuchstaben(ausgewaehltesWort));
    Scanner in = new Scanner(System.in);
    String eingabe = in.next();	
    
    for (int i = 0; i < ausgewaehltesWort.length(); ) { 
      while (true) {
        if (!istGueltig(eingabe)){
          System.out.println("Ungueltige Eingabe. Bitte nur einen Buchstaben eingeben!\n");
          eingabe = in.next();
        } else {
    	    System.out.println(ausgewaehltesWort);
    	    i++;
    	    break;
        } 
      }
    }
  }
}
