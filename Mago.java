public class Mago extends Jugador {
    public Mago(String nom){
        super(nom, 10, 0, 3, 10, 6, 15);
    }

    public int ataque(){
        int energia = get_energia_actual();
        if(energia == 0) {
            return 0;
        }

        double dano_ataque = get_fuerza() * Math.floor(get_inteligencia()/4) + energia;

        energia = energia - 3 < 0? 0 : energia - 3;
        set_energia_actual(energia);
        return (int) dano_ataque;
    }
    
    public int hechizo(){
        int mana = get_mana_actual();
        if(mana == 0) {
            return 0;
        }

        double dano_mana = get_inteligencia() * Math.floor(get_fuerza()/4) + mana;

        mana = mana - 5 < 0? 0 : mana - 5;
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

            set_vida(get_vida() + 2*nuevo_nivel);
            set_vida_actual(get_vida());
            set_fuerza(get_fuerza() + 1);
            set_inteligencia(get_inteligencia() + 3*nuevo_nivel);
            set_energia(get_energia() + 1);
            set_energia_actual(get_energia());
            set_mana(get_energia() + 3*nuevo_nivel);
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
