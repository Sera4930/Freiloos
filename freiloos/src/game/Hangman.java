package game;

import java.util.Scanner;
import java.util.Random;

// Hangman Projekt von Dawid Voronov und Alexander Girin || AI1001

public class Hangman {
    static final String[] QUIZWOERTER = { "Tokio", "Hamburg", "Kryptographie", "Ninja", "Vegan", "Darmstadt", "Darknet", "Netzpolitik", "Telekommunikationsgesetz", "Lokomotive"};

    public static String erstelleVerdecktesWort(String ausgewaehltesWort) {
		String unterstriche = "";
		for (int i = 0; i < ausgewaehltesWort.length(); i++) {
			unterstriche = unterstriche + "___ ";
		}
		return unterstriche;
	}
  
    public static String aufdeckenVerdecktesWort(String eingabe, String ausgewaehltesWort) {
		String verdecktesWort = erstelleVerdecktesWort(ausgewaehltesWort);
		for (int i = 0; i < ausgewaehltesWort.length(); i++ ) {
			if (eingabe.equalsIgnoreCase(ausgewaehltesWort.substring(i, i + 1))) {
				verdecktesWort = verdecktesWort + " " + eingabe + " ";
			}
			else {
				verdecktesWort = verdecktesWort + "___ ";
			}
		}
		return verdecktesWort;
	}

    static boolean raten(String eingabe, String ausgewaehltesWort) {
    	for (int i = 0; i < ausgewaehltesWort.length(); i++) {
			if (eingabe.equalsIgnoreCase(ausgewaehltesWort.substring(i, i + 1)))
				return true;
		}
		return false;
	}

    static void hangmanFigur(int auswahl) { //Quelle der Figur: https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c  
        if (auswahl == 1) {        
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
        else if (auswahl == 2) {         
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
        else if (auswahl == 3) {           
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
        else if (auswahl == 4) {          
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
        else if (auswahl == 5) {         
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
        else if (auswahl == 6) {          
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
        else if (auswahl == 7) {  
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

    static void willkommensNachricht(String ausgewaehltesWort) {
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * Willkommen zu Hangman * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *\n");
        System.out.println("Bitte einen Buchstaben oder das zuerratene Wort eingeben!\n");
        System.out.println(erstelleVerdecktesWort(ausgewaehltesWort) + "\n");
    }
    
    static void trennNachricht() {
    	System.out.println("\n* * * * * * * * * * * * * * * * *");
    	System.out.println("* * * * * * * * * * * * * * * * *\n");
    }
    
    static void gewinnNachricht(String ausgewaehltesWort) {
    	trennNachricht();
    	trennNachricht();
    	System.out.println("Super!! Richtig erraten das Wort lautete: " + ausgewaehltesWort);
    	trennNachricht();
    	trennNachricht();
    }
    
    
    public static void main(String[] args) {
      Random rnd = new Random();
      String ausgewaehltesWort = QUIZWOERTER[rnd.nextInt(QUIZWOERTER.length)];
      willkommensNachricht(ausgewaehltesWort);
      Scanner in = new Scanner(System.in);
      String eingabe = in.next();
      String wortAufdecken = "";

      for (int anzahlVersuche = 0; anzahlVersuche < 7;) {
        if (eingabe.equalsIgnoreCase(ausgewaehltesWort)) {
      	  gewinnNachricht(ausgewaehltesWort);
          in.close();
          System.exit(0);
        } else if (eingabe.length() == 1 && raten(eingabe, ausgewaehltesWort) == true) {
            trennNachricht();
            System.out.println("Der Buchstabe " + eingabe + " ist dabei.\n");
            wortAufdecken = "";
            System.out.println(aufdeckenVerdecktesWort(eingabe, ausgewaehltesWort));
            eingabe = in.next();
        }
        else {
          anzahlVersuche++;
          if (anzahlVersuche == 7) {
            hangmanFigur(anzahlVersuche);
            in.close();
            System.exit(0);
          }
          else {
          trennNachricht();
          hangmanFigur(anzahlVersuche);
          System.out.println("\nLeider falsch! Die Eingabe " + eingabe + " war falsch.  Naechster Vesuch:");
          eingabe = in.next();
          }
        }
      }
    }

}

