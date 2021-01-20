package game;

import java.util.Scanner;
import java.util.Random;

// Hangman Projekt von Dawid Voronov und Alexander Girin || AI1001

public class Hangman {
	static final String[] QUIZWOERTER = { "Tokio", "Hamburg", "Kryptographie", "Ninja", "Vegan", "Darmstadt", "Darknet",
			"Netzpolitik", "Telekommunikationsgesetz", "Lokomotive" };

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
			if (eingabe.equalsIgnoreCase(ausgewaehltesWort.substring(i,i+1))) {
				verdecktesWort = verdecktesWort + " " + eingabe + " ";
			}
			else {
				verdecktesWort = verdecktesWort + "___ ";
			}
		}
		return verdecktesWort;
	}

    public static boolean raten(String eingabe, String ausgewaehltesWort) {
    	for (int i = 0; i < ausgewaehltesWort.length(); i++) {
			if (eingabe.equalsIgnoreCase(ausgewaehltesWort.substring(i, i + 1)))
				return true;
		}
		return false;
	}

    static void hangmanFigur(int auswahl) { //Quelle der Figur: https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c  
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

    static void willkommensNachricht() {
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * Willkommen zu Hangman * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * *\n");
        System.out.println("Bitte einen Buchstaben eingeben, um das folgende Wort zu erraten!\n");
    }
    
    static void trennNachricht() {
    	System.out.println("\n* * * * * * * * * * * * * * * * *");
    	System.out.println("* * * * * * * * * * * * * * * * *\n");
    }
    
    public static void main(String[] args) {

    Random rnd = new Random();
    int zufaelligeWortauswahl = rnd.nextInt(QUIZWOERTER.length);
    String ausgewaehltesWort = QUIZWOERTER[zufaelligeWortauswahl];
    
    willkommensNachricht();
    System.out.println(erstelleVerdecktesWort(ausgewaehltesWort)+"\n");
    Scanner in = new Scanner(System.in);
    String eingabe = in.next();

    int anzahlVersuche = 0;
      while (anzahlVersuche < 7) {
        if (eingabe.equalsIgnoreCase(ausgewaehltesWort) || eingabe.length() == 1) {
          System.out.println("Ungueltige Eingabe. Bitte nur einen Buchstaben eingeben!\n");
          eingabe = in.next();
        } else {
          if (raten(eingabe, ausgewaehltesWort)==true) {
        	  trennNachricht();
        	  System.out.println(aufdeckenVerdecktesWort(eingabe, ausgewaehltesWort));
        	  eingabe = in.next();
          }
          else {
            anzahlVersuche++;
            if (anzahlVersuche == 7) {
              hangmanFigur(anzahlVersuche);
              break;
            }
            trennNachricht();
            hangmanFigur(anzahlVersuche);
            System.out.println("Leider falsch! Bitte Buchstaben eingeben.");
            eingabe = in.next();
            System.out.println(ausgewaehltesWort); //nur zum testen
          }
        }
      }
    }
}

