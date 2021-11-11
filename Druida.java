public class Druida extends Jugador {
    public Druida(String nom){
        super(nom, 15, 0, 5, 5, 5, 5);
    }

    public int ataque(){
        int energia = get_energia_actual();
        if(energia == 0) {
            return 0;
        }

        double dano_ataque = (int) (get_fuerza() + get_inteligencia())/3 * 
                            (int) Math.max(get_energia_actual()/3, get_mana_actual()/2);

        energia = energia - 3 < 0? 0 : energia - 3;
        set_energia_actual(energia);
        return (int) dano_ataque;
    }
    
    public int hechizo(){
        int mana = get_mana_actual();
        if(mana == 0) {
            return 0;
        }

        double dano_mana = (int) (get_fuerza() + get_inteligencia())/3 * 
                            (int) Math.max(get_energia_actual()/2, get_mana_actual()/3);

        mana = mana - 3 < 0? 0 : mana - 3;
        set_mana_actual(mana);
        return (int) dano_mana;
    }

    public void subir_experiencia(int cant){
        int[] xp_corte = {10, 25, 50, 100, 200, 350, 600, 900};
        set_xp(cant + get_xp());
        if(get_nivel() == 8){
            return;
        }

        if(get_xp() > xp_corte[get_nivel() - 1]){
            set_nivel(get_nivel() + 1);
            int nuevo_nivel = get_nivel();

            set_vida(get_vida() + nuevo_nivel);
            set_vida_actual(get_vida());
            set_fuerza(get_fuerza() + nuevo_nivel);
            set_inteligencia(get_inteligencia() + nuevo_nivel);
            set_energia(get_energia() + nuevo_nivel);
            set_energia_actual(get_energia());
            set_mana(get_energia() + nuevo_nivel);
            set_mana_actual(get_energia());

            System.out.printf("""
                                |------------------------------------------------|
                                |       %s Subió de Nivel al Nivel %d!!!!!       |
                                |------------------------------------------------|%n"""
                                , get_nombre()
                                , get_nivel());
            
            subir_experiencia(0); //Caso particular donde un Jugador sube muchos niveles a la vez.
        }
    }
}
