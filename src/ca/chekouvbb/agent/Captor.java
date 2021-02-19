package ca.chekouvbb.agent;

import ca.chekouvbb.environment.*;

import java.util.ArrayList;

public class Captor {


    //Cette fonction est celle qui représente la capteur de l'agent.
    // Elle permet de d'analyser le terrain et de retrouver
    // toutes les cases n'étant pas vides. C'est les croyances de
    // notre agent.
    public ArrayList<Box> getBelief(Environment environment){
        Manor manor = environment.getManor();
        ArrayList<Box> boxesToClean = new ArrayList<>();
        for (int x = 0; x<manor.getSize(); x++){
            for (int y = 0; y<manor.getSize(); y++){
                if (manor.getCase(x,y).toClean()){
                    boxesToClean.add(manor.getCase(x,y));
                }
            }
        }
        return boxesToClean;
    }
}
