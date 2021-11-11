public class Bueno extends NPC {
    private String atributo; // "vida" "xp" "energia" "mana"
    private int cantidad;

    public Bueno(String nom, String atr, int cant){
        set_nombre(nom);
        set_atributo(atr);
        set_cantidad(cant);
    }

    public void interaccion(Jugador jugador) {
        System.out.printf("""
                           |***********************************************************| 
                           | %s: Creo que necesitas un poco de ayuda te subire %d a tu |
                           |     %s!!!!                                                | 
                           |***********************************************************|%n"""
                            , get_nombre(), get_cantidad(), get_atributo());

        switch (get_atributo()){
            case "vida":
                jugador.set_vida_actual(jugador.get_vida_actual() + cantidad);
                break;
            
            case "xp":
                jugador.subir_experiencia(cantidad);
                break;
            
            case "energia":
                jugador.set_energia_actual(jugador.get_energia_actual() + cantidad);
                break;

            case "mana":
                jugador.set_energia_actual(jugador.get_energia_actual() + cantidad);
                break;
        }
    }

    public String get_atributo() {return atributo;}
    public void set_atributo(String nuevo) {atributo = nuevo;}

    public int get_cantidad() {return cantidad;}
    public void set_cantidad(int nuevo) {cantidad = nuevo;}
}
