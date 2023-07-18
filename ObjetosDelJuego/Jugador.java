package ObjetosDelJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Interfaz.KeyBoard;
import Interfaz.Ventana;
import Mapache.PVector;

public class Jugador extends ObjetoJuego{
    boolean disparar;
    public Jugador(float x, float y, int tam) {
        super(x, y, tam);
        vel = new PVector(0, 0);
        col = new Color(255, 255, 255);
        disparar = false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(col);
        g.fillRect((int)loc.x.floatValue(), (int)loc.y.floatValue(), tam, 5);
    }

    @Override
    public void update() {
        if(KeyBoard.key=='a'){
            vel.x=(float) -5;
        }else if(KeyBoard.key=='d'){
            vel.x=(float) 5;
        }else if(KeyBoard.key==' '){
            disparar = true;
            KeyBoard.key = '+';
        }
        System.out.println(KeyBoard.key);
        loc.add(vel);

        if(loc.x<0){
            loc.x=(float) Ventana.WIDTH;
        }else if(loc.x>Ventana.WIDTH+tam){
            loc.x=(float) 0;
        }
    }

    @Override
    public boolean eliminar() {
        return false;
    }
    
    public ArrayList <ObjetoJuego> disparar(ArrayList <ObjetoJuego> a){
        ArrayList <ObjetoJuego> b = a;
        if(disparar){
            // if(Ventana.frameCount%5==0){
                b.add(new Disparo(loc.x+tam/2, loc.y, 10));
            // }
            
            disparar=false;
        }
        return b;
    }

}
