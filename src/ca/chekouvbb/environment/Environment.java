package ca.chekouvbb.environment;

import java.util.Random;

public class Environment implements Runnable {
    private Manor manor;

    public Environment(Manor manor) {
        this.manor = manor;
    }

    public Manor getManor() {
        return manor;
    }

    public void makeRandomDust(){
        if (genererInt(1,100)<=30){
            int x = genererInt(0,manor.getSize());
            int y = genererInt(0,manor.getSize());
            this.manor.getCase(x,y).setDust(true);
        }
    }

    public void makeRandomJewelry(){
        if (genererInt(1,100)<=30){
            int x = genererInt(0,manor.getSize());
            int y = genererInt(0,manor.getSize());
            this.manor.getCase(x,y).setJewelry(true);
          }
    }

    private int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        return borneInf+random.nextInt(borneSup-borneInf);
    }

    /* Appelle les fonctions qui crée aléatoirement les poussières et les bijoux dans le manoir
    Actualise l'interface graphique */
    @Override
    public void run() {
        while (true){
            makeRandomDust();
            makeRandomJewelry();

            manorUI();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // cette fonction permet d'avoir un visuel primitif du manoir.
    // La case signalée avec X est celle où l'agent ce trouve,
    // celles avec B contiennent de la poussière et des bijoux,
    // Celles avec J contiennent des bijoux
    // et enfin, celles avec D sont celles contenant de la poussière.
    // Les cases vides sont représentée par une étoile.
    public void manorUI(){
        clearScreen();
        System.out.println("---------------------------------");
        for (int x = 0; x<this.getManor().getSize(); x++ ){
            String line = "";
            for (int y = 0; y<this.getManor().getSize(); y++){
                if (this.getManor().getCase(x,y).getAgent()){
                    line += "X";
                }
                else {
                    if (this.getManor().getCase(x,y).getDust() && this.getManor().getCase(x,y).getJewelry()){
                        line += "B";
                    }
                    else if (this.getManor().getCase(x,y).getJewelry()){
                        line += "J";
                    }
                    else if (this.getManor().getCase(x,y).getDust()){
                        line += "D";
                    }
                    else {
                        line += "*";
                    }
                }
            }
            System.out.println(line);
        }
        System.out.println("--------------------------------");

    }

    // cette fonction à pour but de clear la console pour avoir un aperçu plus "dynamique"
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
