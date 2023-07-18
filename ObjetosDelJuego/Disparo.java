package ObjetosDelJuego;

import java.awt.Color;
import java.awt.Graphics;

import Mapache.PVector;

public class Disparo extends ObjetoJuego{

    public Disparo(float x, float y, int tam) {
        super(x, y, tam);
        vel = new PVector(0, -tam/2);
        col = new Color(0, 255, 255);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(col);
        g.drawLine((int)loc.x.floatValue(), (int)loc.y.floatValue()+tam, (int)loc.x.floatValue(), (int)loc.y.floatValue());
    }

    @Override
    public void update() {
        loc.add(vel);
    }

    @Override
    public boolean eliminar() {
        return loc.y<=-tam;
    }
    
    
}
