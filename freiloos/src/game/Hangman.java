package game;

import java.util.Scanner;
import java.util.Random;

// Hangman Projekt von Dawid Voronov und Alexander Girin || AI1001

public class Hangman {
	static final String[] QUIZWOERTER = { "Tokio", "Hamburg", "Kryptographie", "Ninja", "Vegan", "Darmstadt", "Darknet",
			"Netzpolitik", "Telekommunikationsgesetz", "Lokomotive" };

	public static boolean istGueltig(String eingabe) { // TODO checken ob gueltiger buchstabe noch hinzufuegen
		if (eingabe.length() != 1) {
			return false;
		}
		return true;
	}

    public static String erstelleVerdecktesWort(String ausgewaehltesWort) {
		String unterstriche = "";
		for (int i = 0; i < ausgewaehltesWort.length(); i++) {
			unterstriche = unterstriche + "___ ";
		}
		return unterstriche;
	}
    
    public static String aufdeckenVerdecktesWort(String eingabe, String ausgewaehltesWort) {
		String verdecktesWort = "";
		for (int i = 0; i < ausgewaehltesWort.length(); i++) {
			if (eingabe.equals(ausgewaehltesWort.substring(i,i+1))) {
				verdecktesWort = verdecktesWort + eingabe;
			}
			else {
				verdecktesWort = verdecktesWort + "___ ";
			}
		}
		return verdecktesWort;
	}

    public static boolean raten(String eingabe, String ausgewaehltesWort) {
    	for (int i = 0; i < ausgewaehltesWort.length(); i++) {
			if (eingabe.equals(ausgewaehltesWort.substring(i, i + 1)))
				return true;
		}
		return false;
	}


	

    public static void main(String[] args) {

    Random rnd = new Random();
    int zufaelligeWortauswahl = rnd.nextInt(QUIZWOERTER.length);
    String ausgewaehltesWort = QUIZWOERTER[zufaelligeWortauswahl];
    
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * Willkommen zu Hangman * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("* * * * * * * * * * * * * * * * *");
    System.out.println("Bitte einen Buchstaben eingeben, um das folgende Wort zu erraten!\n");
    System.out.println(erstelleVerdecktesWort(ausgewaehltesWort));
    Scanner in = new Scanner(System.in);
    String eingabe = in.next();

      for (int i = 0; i < ausgewaehltesWort.length(); ) {
        while (true) {
          if (!istGueltig(eingabe)) {
            System.out.println("Ungueltige Eingabe. Bitte nur einen Buchstaben eingeben!\n");
            eingabe = in.next();
          } else {
        	  System.out.println(raten(eingabe, ausgewaehltesWort)); //nur zum testen
        	  if (raten(eingabe, ausgewaehltesWort)==true) {
        		  aufdeckenVerdecktesWort(eingabe, ausgewaehltesWort);
        	  }
        	  System.out.println(ausgewaehltesWort); //nur zum testen
    	      i++;
    	      eingabe = in.next();
    	      break;
          }
        }
      }
    }
   
    public static void hangmanFigur(int auswahl) { //Quelle der Figur: https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c  
      if (auswahl == 1){        
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      ");
        System.out.println("|      ");
        System.out.println("|      ");
        System.out.println("|     ");
        System.out.println("|        ");
        System.out.println("|        ");
      }
      else if (auswahl == 2){         
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      O");
        System.out.println("|      ");
        System.out.println("|      ");
        System.out.println("|        ");
        System.out.println("|        ");
      }
      else if (auswahl == 3){           
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      O");
        System.out.println("|      | ");
        System.out.println("|      ");
        System.out.println("|        ");
        System.out.println("|        ");
      }
      else if (auswahl == 4){          
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      O");
        System.out.println("|     /| ");
        System.out.println("|      ");
        System.out.println("|        ");
        System.out.println("|        ");
      }
      else if (auswahl == 5){         
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      O");
        System.out.println("|     /|\\ ");
        System.out.println("|      ");
        System.out.println("|        ");
        System.out.println("|        ");
      }
      else if (auswahl == 6){          
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      O");
        System.out.println("|     /|\\ ");
        System.out.println("|     /  ");
        System.out.println("|        ");
        System.out.println("|        ");
      }
      else if (auswahl == 7){  
        System.out.println("GAME OVER!");
        System.out.println("   ");
        System.out.println();
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      O");
        System.out.println("|     /|\\ ");
        System.out.println("|     / \\ ");
        System.out.println("|        ");
        System.out.println("|        ");
    }
  }
}

