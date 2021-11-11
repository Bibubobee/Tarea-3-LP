abstract public class NPC {
    private String nombre;

    abstract public void interaccion(Jugador jugador);

    public String get_nombre() {return nombre;}
    public void set_nombre(String nuevo) {nombre = nuevo;}
}
