package ObjetosDelJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Mapache.PVector;

public abstract class ObjetoJuego {
    public PVector loc;
    PVector vel;
    Color col;
    public int tam;
    public ObjetoJuego(float x, float y, int tam){
        this.loc = new PVector(x, y);
        this.tam = tam;
    }

    public abstract void draw(Graphics g);
    public abstract void update();

    public ArrayList<ObjetoJuego> colsision(ObjetoJuego o, ArrayList<ObjetoJuego> a){
        return a;
    }
    public abstract boolean eliminar();
}