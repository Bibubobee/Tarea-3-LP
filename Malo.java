import java.util.Random;

public class Malo extends NPC{
    private int cantidad_energia;
    private int cantidad_mana;

    public Malo(String nom, int c_energia, int c_mana){
        set_nombre(nom);
        set_cant_energia(c_energia);
        set_cant_mana(c_mana);
    }

    public void interaccion(Jugador jugador) {
        System.out.printf("""
                           |***********************************************************| 
                           |   %s: SOY MALO TE VOY A DISMINUIR TU ENERGIA Y MANA EN    | 
                           |       %d Y %d!!!!                                         | 
                           |***********************************************************|%n"""
                            , get_nombre(), get_cant_energia(), get_cant_mana());
        
        Random rand = new Random();
        int valor = rand.nextInt(10) + 1;
        if(valor <= 6){
            jugador.set_energia_actual(jugador.get_energia_actual() - cantidad_energia);

            System.out.printf("""
                                |-----------------------------------------------------------| 
                                |   El NPC maldice al jugador y disminuye su Energia en %d  | 
                                |-----------------------------------------------------------|%n"""
                                , cantidad_energia);
        }
        else{
            System.out.printf("""
                                |-----------------------------------------------------------| 
                                |  No es el dia del NPC, la Energia de %s no es disminuida  | 
                                |-----------------------------------------------------------|%n"""
                                , jugador.get_nombre());
        }

        valor = rand.nextInt(10) + 1;
        if(valor <= 6){
            jugador.set_mana_actual(jugador.get_mana_actual() - cantidad_mana);

            System.out.printf("""
                                |-----------------------------------------------------------| 
                                |   El NPC maldice al jugador y disminuye su Mana en %d     | 
                                |-----------------------------------------------------------|%n"""
                                , cantidad_mana);
        }
        else{
            System.out.printf("""
                                |-----------------------------------------------------------| 
                                |   No es el dia del NPC, el Mana de %s no es disminuida    | 
                                |-----------------------------------------------------------|%n"""
                                , jugador.get_nombre());
        }
    }

    public int get_cant_energia() {return cantidad_energia;}
    public void set_cant_energia(int nuevo) {cantidad_energia = nuevo;}

    public int get_cant_mana() {return cantidad_mana;}
    public void set_cant_mana(int nuevo) {cantidad_mana = nuevo;}
}
