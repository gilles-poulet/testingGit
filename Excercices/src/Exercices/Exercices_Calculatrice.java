package Exercices;

public class Exercices_Calculatrice {

	    public static int addition(int nombre1, int nombre2) {
	        return nombre1 + nombre2;
	    }

	    public static int soustraction(int nombre1, int nombre2) {
	        return nombre1 - nombre2;
	    }

	    public static int multiplication(int nombre1, int nombre2) {
	        return nombre1 * nombre2;
	    }

	    public static int division(int nombre1, int nombre2) {
	        return nombre1 / nombre2;
	    }

	    public static void fuzzyMonkey(int base, int nbreIteration, int limiteMin, int limiteMax) {
	        int operation = 0;
	        int nombre2 = 0;

	        for (int i = 0; i < nbreIteration; i++) {
	            operation = (int) (Math.random() * 4 + 1);
	            nombre2 = (int) (Math.random() * limiteMax + limiteMin);

	            switch (operation) {
	                case 1:
	                	Exercices_Calculatrice.addition(base, nombre2);
	                    break;
	                case 2:
	                	Exercices_Calculatrice.soustraction(base, nombre2);
	                    break;
	                case 3:
	                	Exercices_Calculatrice.multiplication(base, nombre2);
	                    break;
	                case 4:
	                	Exercices_Calculatrice.division(base, nombre2);
	                    break;
	            }//fin switch
	        }//fin for
	    }//fin fuzzyMonkey
}//fin programme
