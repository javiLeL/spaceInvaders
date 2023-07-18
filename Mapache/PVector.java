package Mapache;

public class PVector {
    public Float x, y, z;

    /**
     * Vector bidimensional
     * @param x
     * @param y
     */
    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Vector tridimensional 
     * @param x
     * @param y
     * @param z
     */
    public PVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Suma de dos vectores AB
     * @param mas
     */
    public void add(PVector mas) {
        x += mas.x;
        y += mas.y;

        if(mas.z!=null && z!=null){
            z+=mas.z;
        }else if(z==null&&mas.z==null){
            z=null;
        }else{
            throw new RuntimeException("Error no se puede sumar null a z");
        }
    }

    /**
     * Setea el maximo modulo de un vector
     */
    public void limit(int e) {
        int f = modulo() / e;
        if (f != 0) {
            x /= f;
            y /= f;
        }
    }
    /**
     * Modulo de un vector (Solo para vectores bidimensionales)
     * @return modulo
     */
    public int modulo() {
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(x, 2));
    }
}