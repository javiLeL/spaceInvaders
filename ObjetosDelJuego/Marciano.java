package ObjetosDelJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Interfaz.Ventana;
import Mapache.PVector;

public class Marciano extends ObjetoJuego{
    int vida;

    public Marciano(float x, float y, int tam, int vida) {
        super(x, y, tam);
        vel = new PVector(tam, 0);
        
        if(vida<=0){
            this.vida=1;
        }else{
            this.vida = vida;
        }
    }
    public Marciano(float x, float y, int tam) {
        this(x, y, tam, 1);
    }

    @Override
    public void draw(Graphics g) {
        switch(vida){
            case 1:
                col = new Color(0, 255, 0);
            break;
            case 2:
                col = new Color(255, 255, 0);
            break;
            case 3:
                col = new Color(255, 0, 0);
            break;
            default:
                col = new Color(255, 255, 255);
        }
        if(vida<=0){
            col = new Color(0, 0 ,0);
        }
        g.setColor(col);
        g.fillRect((int)loc.x.floatValue(), (int)loc.y.floatValue(), tam, tam);
    }

    @Override
    public void update() {
        mover();
    }

    void mover(){
        loc.add(vel);
    }

    public boolean choque(){
        return loc.x<=0||loc.x + tam>=Ventana.WIDTH;
    }

    public void moverChoque(){
        loc.y+=tam;
        vel.x*=-1;
        mover();
    }

    @Override
    public ArrayList<ObjetoJuego> colsision(ObjetoJuego o, ArrayList<ObjetoJuego> a) {
        if(o.getClass().equals(Disparo.class)&&o!=null){
            if(o.loc.x>=loc.x&&o.loc.x<=loc.x+tam&&
                o.loc.y>=loc.y&&o.loc.y<=loc.y+tam){
                a.remove(o);
                vida--;
            }
        }
        return a;
    }

    @Override
    public boolean eliminar() {
        return vida<=0;
    }
}
