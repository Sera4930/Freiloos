package game;

import java.util.Scanner;
import java.util.Random;

// Hangman Projekt von Dawid Voronov und Alexander Girin || AI1001

public class Hangman {
    private static final String[] QUIZWOERTER = { "Tokio", "Hamburg", "Kryptographie", "Ninja", "Vegan", "Darmstadt", "Darknet", "Netzpolitik", "Telekommunikationsgesetz", "Lokomotive"};
    private static final String QUIZWORT = QUIZWOERTER[new Random().nextInt(QUIZWOERTER.length)];

    
    public static String erstelleVerdecktesWort() {
		String unterstriche = "";
		for (int i = 0; i < QUIZWORT.length(); i++) {
			unterstriche = unterstriche + "_ ";
		}
		return unterstriche;
	}
  
    public static String aufdeckenVerdecktesWort(String eingabe, String quizstand) {
      String neuerQuizstand = "";
      for (int i = 0; i < quizstand.length(); i++) {
    	if (quizstand.charAt(i) == '_') {
    	  if (eingabe.equalsIgnoreCase(QUIZWORT.substring(i/2, i/2 + 1))) {
    		  neuerQuizstand += eingabe;
		  }
		  else {
			  neuerQuizstand += "_ ";
		  }
    	}
    	else if (quizstand.charAt(i) == QUIZWORT.charAt(i/2)) {
    		neuerQuizstand += quizstand.charAt(i);
    	}
      } 	  
      if (neuerQuizstand.equalsIgnoreCase(QUIZWORT)) {
    	  gewinnNachricht();
      }
      return neuerQuizstand;
    }

    static boolean raten(String eingabe) {
    	for (int i = 0; i < QUIZWORT.length(); i++) {
			if (eingabe.equalsIgnoreCase(QUIZWORT.substring(i, i + 1)))
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

    static void willkommensNachricht() {
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * Willkommen zu Hangman * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *\n");
        System.out.println("Bitte einen Buchstaben oder das zuerratene Wort eingeben!\n");
        System.out.println(erstelleVerdecktesWort() + "\n");
    }
    
    static void trennNachricht() {
    	System.out.println("\n* * * * * * * * * * * * * * * * *");
    	System.out.println("* * * * * * * * * * * * * * * * *\n");
    }
    
    static void gewinnNachricht() {
    	trennNachricht();
    	trennNachricht();
    	System.out.println("Super!! Richtig erraten das Wort lautete: " + QUIZWORT);
    	trennNachricht();
    	trennNachricht();
    	System.exit(0);
    }
    
    
    public static void main(String[] args) {
      willkommensNachricht();
      Scanner in = new Scanner(System.in);
      String eingabe = in.next();
      System.out.println(QUIZWORT);
      String quizstand = erstelleVerdecktesWort();
      
      for (int anzahlVersuche = 0; anzahlVersuche < 7;) {
        if (eingabe.equalsIgnoreCase(QUIZWORT)) {
      	  gewinnNachricht();
          in.close();
          System.exit(0);
        } else if (eingabe.length() == 1 && raten(eingabe)) {
            trennNachricht();
            System.out.println("Der Buchstabe " + eingabe + " ist dabei.\n");
            quizstand = aufdeckenVerdecktesWort(eingabe, quizstand);
            System.out.println(quizstand);
            
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

