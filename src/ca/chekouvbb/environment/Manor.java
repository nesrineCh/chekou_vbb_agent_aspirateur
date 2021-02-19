package ca.chekouvbb.environment;

import java.util.ArrayList;

public class Manor {
    private Box[][] matrix;
    private int size;

    // Crée un objet Manoir avec une matrice initialisée avec des cases vides. (sans poussières et bijoux)
    public Manor(int size) {
        this.size = size;
        this.matrix = new Box[size][size];
        for (int x = 0; x<size; x++ ){
            for (int y = 0; y<size; y++){
                this.matrix[x][y] = new Box(x,y);
            }
        }
    }

    public Manor(Box[][] matrix, int size) {
        this.matrix = matrix;
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public Box getCase(int x, int y){
        return this.matrix[x][y];
    }

    public void setCase(Box newBox, int x, int y){
        this.matrix[x][y] = newBox;
    }


    // entrées : Deux cases
    // sortie : la distance qui sépare les deux cases données en paramètres/
    public Double getDistance(Box box1, Box box2){
        return Math.sqrt(Math.pow(box2.getPosition_x() - box1.getPosition_x(), 2) + Math.pow(box2.getPosition_y() - box1.getPosition_y(), 2));
    }
    public Box[][] getMatrix(){
        return this.matrix;
    }

    //La fonction retourne une liste contenant les voisins directs de la box donnée en paramètre.
    public ArrayList<Box> getNeighbors(Box currentBox){
        ArrayList<Box> neighbors = new ArrayList<>();
        //if currentBox have left neighbor
        if (currentBox.getPosition_x() > 0){
            neighbors.add(matrix[currentBox.getPosition_x() - 1][currentBox.getPosition_y()]);
        }
        //if currentBox have right neighbor
        if (currentBox.getPosition_x() < size-1){
            neighbors.add(matrix[currentBox.getPosition_x() + 1][currentBox.getPosition_y()]);
        }
        //if currentBox have up neighbor
        if (currentBox.getPosition_y() > 0){
            neighbors.add(matrix[currentBox.getPosition_x()][currentBox.getPosition_y() - 1]);
        }
        //if currentBox have down neighbor
        if (currentBox.getPosition_y() < size-1){
            neighbors.add(matrix[currentBox.getPosition_x()][currentBox.getPosition_y() + 1]);
        }
        return neighbors;
    }


    //Les fonctions ci-dessous permettent de voir le positionnement d'une case par rapport à une autre.

    public boolean isAbove(Box box1, Box box2){
        return box1.getPosition_y() < box2.getPosition_y();
    }

    public boolean isBellow(Box box1, Box box2){
        return box1.getPosition_y() > box2.getPosition_y();
    }

    public boolean isAtRight(Box box1, Box box2){
        return box1.getPosition_x() > box2.getPosition_x();
    }

    public boolean isAtLeft(Box box1, Box box2){
        return box1.getPosition_x() < box2.getPosition_x();
    }



}
