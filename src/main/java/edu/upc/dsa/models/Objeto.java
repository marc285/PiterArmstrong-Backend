package edu.upc.dsa.models;

public class Objeto {
     String nombre;
     int coste;
//ppner lo de la base de datos



    public Objeto(){} //constructor vacio


    public Objeto(String nom, int cost) {

        this.nombre = nom;
        this.coste = cost;
    }

    public void setNombre(String nom) {
        this.nombre=nom;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getCoste() {
        return coste;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }



    //4 tipos de objetos_
    //piezas (no me das stats de ningun tipo)
    //armas(me suben el ataque)
    //armaduras(me suben la defensa)
    //botiguines(me suben la vida)

    public class arma{

    }
    public class armadura{

    }
    public class botiquin{

    }


}
