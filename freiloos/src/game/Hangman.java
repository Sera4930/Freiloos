/**
* Our project Hangman is based on the well known game Hangman.
* you need to guess the hidden word that is shown upon initialization of the code to win.
* @version 1.0 Build Jan 23, 2021.
* @author Dawid Voronov, Alexander Girin || AI1001
*/
package game;

import java.util.Scanner;
import java.util.Random;



public class Hangman {
	/**
    * Hauptprogramm.
	*/
    private static final String[] QUIZWOERTER = {"Tokio", "Hamburg", "Kryptographie", "Ninja", "Vegan", "Darmstadt", "Darknet", "Netzpolitik", "Telekommunikationsgesetz", "Lokomotive"};
    private static final String QUIZWORT = QUIZWOERTER[new Random().nextInt(QUIZWOERTER.length)];
    private static String quizstand = erstelleVerdecktesWort();

    public static String erstelleVerdecktesWort() {
      String unterstriche = "";
        for (int i = 0; i < QUIZWORT.length(); i++) {
          unterstriche += "_";
        }
        return unterstriche;
	}

    public static String aufdeckenVerdecktesWort(String eingabe) {
      String neuerQuizstand = "";
      for (int i = 0; i < QUIZWORT.length(); i++) {
    	if (quizstand.substring(i, i + 1).equals("_")) {
    	  if  (eingabe.equalsIgnoreCase(QUIZWORT.substring(i, i + 1))) {
    		  neuerQuizstand += eingabe;
		  } else {
			  neuerQuizstand += "_";
		  }
    	} else if (quizstand.substring(i, i + 1).equalsIgnoreCase(QUIZWORT.substring(i, i + 1))) {
    		neuerQuizstand += quizstand.substring(i, i + 1);
    	}
      }
      if (neuerQuizstand.equalsIgnoreCase(QUIZWORT)) {
    	  gewinnNachricht();
      }
      return neuerQuizstand;
    }

    static boolean raten(String eingabe) {
    	for (int i = 0; i < QUIZWORT.length(); i++) {
			if (eingabe.equalsIgnoreCase(QUIZWORT.substring(i, i + 1))) {
			  return true;
			}
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
        } else if (auswahl == 2) {  
          System.out.println("   ");
          System.out.println();
          System.out.println("+------+ ");
          System.out.println("|      |");
          System.out.println("|      O");
          System.out.println("|      ");
          System.out.println("|      ");
          System.out.println("|        ");
          System.out.println("|        ");
        } else if (auswahl == 3) {
          System.out.println("   ");
          System.out.println();
          System.out.println("+------+ ");
          System.out.println("|      |");
          System.out.println("|      O");
          System.out.println("|      | ");
          System.out.println("|      ");
          System.out.println("|        ");
          System.out.println("|        ");
        } else if (auswahl == 4) {
          System.out.println("   ");
          System.out.println();
          System.out.println("+------+ ");
          System.out.println("|      |");
          System.out.println("|      O");
          System.out.println("|     /| ");
          System.out.println("|      ");
          System.out.println("|        ");
          System.out.println("|        ");
        } else if (auswahl == 5) {
          System.out.println("   ");
          System.out.println();
          System.out.println("+------+ ");
          System.out.println("|      |");
          System.out.println("|      O");
          System.out.println("|     /|\\ ");
          System.out.println("|      ");
          System.out.println("|        ");
          System.out.println("|        ");
        } else if (auswahl == 6) {
          System.out.println("   ");
          System.out.println();
          System.out.println("+------+ ");
          System.out.println("|      |");
          System.out.println("|      O");
          System.out.println("|     /|\\ ");
          System.out.println("|     /  ");
          System.out.println("|        ");
          System.out.println("|        ");
        } else if (auswahl == 7) {
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
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * Willkommen zu Hangman * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("Bitte einen Buchstaben oder das zuerratene Wort eingeben!\n");
        quizstandNachricht();
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
    
    static void quizstandNachricht() {
    	String quizstandMitLeerzeichen = "";
    	for (int i = 0; i < quizstand.length(); i++) {
    	  quizstandMitLeerzeichen += quizstand.charAt(i) + " ";
        }
    	System.out.println(quizstandMitLeerzeichen + "\n");
    }

    public static void main(String[] args) {
      willkommensNachricht();
      Scanner in = new Scanner(System.in);
      String eingabe = in.next().toLowerCase();
      String[] lobliste = { "Super!", "Nice.", "Sehr schoen.", "Weiter so!" };
      Random random = new Random();
      String lob = lobliste[random.nextInt(lobliste.length)];

      for (int anzahlVersuche = 0; anzahlVersuche < 7;) {
        if (eingabe.equalsIgnoreCase(QUIZWORT)) {
      	  gewinnNachricht();
          in.close();
          System.exit(0);
        } else if (eingabe.length() == 1 && raten(eingabe)) {
            trennNachricht();
            System.out.println( lob + " Der Buchstabe " + eingabe + " ist dabei.\n");
            String neuerQuizstand = aufdeckenVerdecktesWort(eingabe);
            quizstand = neuerQuizstand;
            quizstandNachricht();
            eingabe = in.next().toLowerCase();
        } else {
          anzahlVersuche++;
          if (anzahlVersuche == 7) {
            hangmanFigur(anzahlVersuche);
            in.close();
            System.exit(0);
          } else {
          trennNachricht();
          hangmanFigur(anzahlVersuche);
          System.out.println("\nLeider falsch! Noch " + (7 - anzahlVersuche) + " Fehlversuche erlaubt. Die Eingabe " + eingabe + " war nicht dabei.  Naechster Vesuch:");
          quizstandNachricht();
          eingabe = in.next().toLowerCase();
          }
        }
      }
    }
}