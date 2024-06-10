package de.clientside;



import de.tiere.PigTooFatListener;
import de.tiere.Schwein;

public class Main {

	private Metzger metzger = new Metzger();
	private Spediteur spediteur = new Spediteur();
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Schwein schwein = new Schwein("Miss Piggy");
		schwein.addPigTooFatListener(new SchweineMetzgerAdapter());
		schwein.addPigTooFatListener((Schwein s)->{spediteur.fahren(s);});
		schwein.addPigTooFatListener(spediteur::fahren);
		for (int i = 0; i < 11; i++) {
			schwein.fuettern();
		}


	}

	private class SchweineMetzgerAdapter implements PigTooFatListener {

		@Override
		public void pigTooFat(Schwein dickesSchwein) {
			metzger.schlachten(dickesSchwein);
		}
	}

}

class Metzger {


	public void schlachten(Object dickesSchwein) {
		System.out.println("Messer wetz");
	}
}

class Spediteur {


	public void fahren(Object ware) {
		System.out.println("Wir fahren auf der Autobahn");
	}
}




