package BKTM.Althaus.CoronaSchule;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestKlasse {
	// --- Variables ---
	private Schule bktm;

	// Lehrer
	private Lehrer althaus;
	private Lehrer dejong;
	private Lehrer gerlach;
	private Lehrer kannen;
	private Lehrer kremers;
	private Lehrer rensing;
	private Lehrer sauer;
	private Lehrer utens;

	// GOI20
	private Klasse goi20;

	private Schueler bruno;
	private Schueler danielB;
	private Schueler danielP;
	private Schueler gary;
	private Schueler joshua;
	private Schueler lukas;
	private Schueler norman;
	private Schueler tyron;

	// CornaGame-Variables
	private double infactionChance;
	private ArrayList<Person> infactionList;
	private double recoverChance;
	private ArrayList<Person> recoverList;
	private double deathChance;
	private ArrayList<Person> deathList;

	private int roundNumber = 0;
	private boolean schuleOffen = true;
	private boolean gameWin = true;

	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();

	private ArrayList<Person> personenList;
	private ArrayList<Klasse> klassenList;

	public TestKlasse() {
		infactionList = new ArrayList<Person>();
		recoverList = new ArrayList<Person>();
		deathList = new ArrayList<Person>();

		personenList = new ArrayList<Person>();
		klassenList = new ArrayList<Klasse>();
	}

	private void main() {
		// SetUP
		setUP();
		System.out.println("\n\n\n --- Corona Schule : --- \n");

		System.out.println("Wilkommen and der Corna Schule!");

		System.out.println("\nWie hoch soll die Infektionschance sein?");
		System.out.println("    (Range : 0,01 bis 1,00)");
		infactionChance = scanner.nextDouble();

		System.out.println("\nWie hoch soll die Genesungchance sein?");
		System.out.println("    (Range : 0,01 bis 1,00)");
		recoverChance = scanner.nextDouble();

		System.out.println("\nWie hoch soll die Sterbechance sein?");
		System.out.println("    (Range : 0,01 bis 1,00)");
		deathChance = scanner.nextDouble();

		// Erklärung des Spiels
		System.out.println("\n --- Erklärung : ---\n");
		System.out.println(" Sie können die Schule öffnen und schließen.");
		System.out.println(" Wenn sie die Schule öffnen können sich neue leute infizieren.");
		System.out.println(" Jede Runde können die Infizierten gensen oder sterben!");
		System.out.println(" Sie müssen die Schule 4 Runden offen halten um das Game zu beenden.");
		System.out.println(" Wenn ein Lehrer stirbt ist das Spiel vorbei!");
		System.out.println(" Bringe sie unser Schueler und Lehrer heil durch diese schwere Zeit!");

		// Run the Game
		for (int quartaleBeendet = 0; quartaleBeendet < 5; quartaleBeendet++) {
			System.out.println("\n --- Round : " + roundNumber + " --- \n");

			// School open / close
			if (schuleOffen) {
				System.out.println("Wollen sie die Schule schießen? (true / false) ");
				schuleOffen = !scanner.nextBoolean();
			} else {
				System.out.println("Wollen sie die Schule öffnen? (true / false) ");
				schuleOffen = scanner.nextBoolean();
			}

			// Round simulation
			if (schuleOffen) {
				bktm.oeffnen();
				bewerte(quartaleBeendet);
				infact();
			} else {
				bktm.schliessen();
				quartaleBeendet--;
			}

			recover();

			if (death()) {
				System.out.println("\n --- Ein Lehrer ist gestorben und kann nicht ersätzt werden. \n");
				System.out.println(" Das spiel ist vorbei!");
				System.out.println(" Sie haben : " + roundNumber + " Runden überlebt.");
				System.out.println(" Sie haben : " + quartaleBeendet + " Quartale beendet.");
				quartaleBeendet = 5;
				gameWin = false;
			}

			roundNumber++;
		}

		if (gameWin) {
			System.out.println("\n Gratulliere sie haben das Game gewonnen! \n");
		}

		// Bilanz

	}

	// Methods
	private void setUP() {
		// init
		bktm = new Schule("BK-TM");

		// --- SetUp GOI20 ---
		bktm.creatRaum("A 305");
		goi20 = new Klasse("GOI20", bktm.getRaumByNumber(1));
		ArrayList<Klasse> klasseGOI20 = new ArrayList<Klasse>();
		klasseGOI20.add(goi20);
		bktm.addKlasse(goi20);

		// addingLehrer
		althaus = new Lehrer("Frau Althaus", "Informatik", klasseGOI20);
		bktm.addPerson(althaus);

		dejong = new Lehrer("Herr Dejong", "English", klasseGOI20);
		bktm.addPerson(dejong);

		gerlach = new Lehrer("Herr Gerlach", "Mathematik", klasseGOI20);
		bktm.addPerson(gerlach);

		kannen = new Lehrer("Frau Kannen", "Religion", klasseGOI20);
		bktm.addPerson(kannen);

		kremers = new Lehrer("Herr Kremers", "Deutsch", klasseGOI20);
		bktm.addPerson(kremers);

		rensing = new Lehrer("Herr Rensing", "Geselschaftslehre-Geschichte", klasseGOI20);
		bktm.addPerson(rensing);

		sauer = new Lehrer("Herr Sauer", "Physik", klasseGOI20);
		bktm.addPerson(sauer);

		utens = new Lehrer("Herr Utens", "Wirtschaftslehre", klasseGOI20);
		bktm.addPerson(utens);

		
		// adding Students
		bruno = new Schueler("Bruno");
		bktm.addPerson(bruno);
		goi20.addSchueler(bruno);

		danielB = new Schueler("Daniel B.");
		bktm.addPerson(danielB);
		goi20.addSchueler(danielB);

		danielP = new Schueler("Daniel P.");
		bktm.addPerson(danielP);
		goi20.addSchueler(danielP);

		gary = new Schueler("Gary");
		bktm.addPerson(gary);
		goi20.addSchueler(gary);

		joshua = new Schueler("Joshua");
		bktm.addPerson(joshua);
		goi20.addSchueler(joshua);

		lukas = new Schueler("Lukas");
		bktm.addPerson(lukas);
		goi20.addSchueler(lukas);

		norman = new Schueler("Norman");
		bktm.addPerson(norman);
		goi20.addSchueler(norman);

		tyron = new Schueler("Tyron");
		bktm.addPerson(tyron);
		goi20.addSchueler(tyron);

		// Set Lists
		personenList = bktm.getPersonenList();
		klassenList = bktm.getKlassenList();
	}

	private void infact() {
		for (Person current : personenList) {
			if (!current.getHatCorona() && !recoverList.contains(current) && !deathList.contains(current)) {
				if (random.nextDouble() < infactionChance) {
					current.setHatCorona(true);
					infactionList.add(current);
					System.out.println("    Get infacted : " + current.getName());

				}
			}
		}
	}

	private void recover() {
		if (!infactionList.isEmpty()) {
			for (Person current : infactionList) {
				if (random.nextDouble() < recoverChance && !recoverList.contains(current)
						&& !deathList.contains(current)) {
					recoverList.add(current);
					System.out.println("    Get recover : " + current.getName());
				}
			}
		}
	}

	private boolean death() {
		boolean returnBool = false;
		if (!infactionList.isEmpty()) {
			for (Person current : infactionList) {
				if (random.nextDouble() < deathChance && !recoverList.contains(current)
						&& !deathList.contains(current)) {
					deathList.add(current);
					System.out.println("    Get death : " + current.getName());
					if (current instanceof Lehrer) {
						returnBool = true;
					}
				}
			}
		}
		return returnBool;
	}

	private void bewerte(int quartal) {
		ArrayList<Schueler> schuelerList;
		ArrayList<Lehrer> lehrerList;
		int[][] noten;
		int[] quartalsNoten;

		// For every Class on this School
		for (Klasse current : klassenList) {
			schuelerList = current.getSchuelerList();
			lehrerList = current.getLehrerList();

			System.out.println("\n --- " + current.getName() + " --- \n");

			// For every Student in this Class
			for (Schueler currentSchueler : schuelerList) {
				noten = currentSchueler.getNoten();
				if (noten == null) {
					noten = new int[5][lehrerList.size()];
				}
				quartalsNoten = new int[lehrerList.size()];
				System.out.println("Schueler : " + currentSchueler.getName() + " hat folgende Noten erhalten :: ");

				if (!deathList.contains(currentSchueler)) {
					// For every "Fach" of the Student
					for (Lehrer currentLehrer : lehrerList) {
						quartalsNoten[lehrerList.indexOf(currentLehrer)] = currentLehrer.bewerten();
						System.out.print(currentLehrer.getFach() + " : "
								+ quartalsNoten[lehrerList.indexOf(currentLehrer)] + " , ");
					}
					System.out.println("\n");
				} else {
					System.out.println("    - Ist Tot -    ");
				}

				// Set noten
				for (int i = 0; i < quartalsNoten.length; i++) {
					noten[quartal][i] = quartalsNoten[i];
				}
				currentSchueler.setNoten(noten);
			}
		}
	}

	// add space for "Abschlussbilanz"

	// Run Main
	public static void main(String[] args) {
		TestKlasse run = new TestKlasse();
		run.main();
	}
}