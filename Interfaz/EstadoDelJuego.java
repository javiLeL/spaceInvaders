package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import ObjetosDelJuego.Disparo;
import ObjetosDelJuego.Marciano;
import ObjetosDelJuego.ObjetoJuego;

public class EstadoDelJuego {
    ArrayList <ObjetoJuego> objetoJuego;
    EstadoDelJuego(){
        objetoJuego = new ArrayList<>();
        for(int i=0;i<5;i++){
            objetoJuego.add(new Marciano(i*20+i*20, 5, 20, 1));
        }
        objetoJuego.add(new Disparo(Ventana.WIDTH/2, Ventana.HEIGHT, 10));
        
    }
    void draw(Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, Ventana.WIDTH, Ventana.HEIGHT);
        for(int i=0;i<objetoJuego.size();i++){
            objetoJuego.get(i).draw(g);
        }
    }

    void update(){
        boolean choque=false;

        for(int i=0;i<objetoJuego.size();i++){
            if(objetoJuego.get(i).getClass().equals(Marciano.class)){
                if(Ventana.frameCount%10==0){
                    objetoJuego.get(i).update();
                    if(((Marciano) objetoJuego.get(i)).choque()){
                        choque = true;
                    }
                }
            }else{
                objetoJuego.get(i).update();
                for(int e=0;e<objetoJuego.size();e++){
                    objetoJuego = objetoJuego.get(i).colsision(objetoJuego.get(i), objetoJuego);
                }
            }
        }
        for(int i=0;i<objetoJuego.size();i++){
            if(choque&&objetoJuego.get(i).getClass().equals(Marciano.class)){
                ((Marciano) objetoJuego.get(i)).moverChoque();
            }
        }
    }
}
