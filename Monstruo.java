import java.util.Scanner;

public class Monstruo implements Enemigo{
    private int vida;
    private int dano;

    public Monstruo(int hp){
        vida = hp;
        dano = 0;
    }

    public void combate(Jugador jugador){
        Scanner lector = new Scanner(System.in);
        while(jugador.get_vida_actual() > 0 && get_vida() > 0){
            System.out.printf("""
                                |'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''|
                                |                         COMBATE                           |
                                |-----------------------------------------------------------|
                                |                      Turno de %s                          |   
                                |                                                           |                             
                                | HP: %d/%d           Energia: %d/%d           Mana: %d/%d  |
                                | Fuerza: %d          Inteligencia: %d         XP: %d       |
                                |-----------------------------------------------------------|
                                |                                                           |
                                |                       ENEMIGO: %d                         |
                                |___________________________________________________________|%n"""
                                ,jugador.get_nombre(), jugador.get_vida_actual(), jugador.get_vida()
                                ,jugador.get_energia_actual(), jugador.get_energia(), jugador.get_mana_actual()
                                ,jugador.get_mana(), jugador.get_fuerza(), jugador.get_inteligencia()
                                ,jugador.get_xp(), get_vida());
            
            System.out.printf("""
                                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|
                                |                         DECISION                          |
                                |       1. Ataque                           2. Hechizo      |
                                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|%n""");

            System.out.println("Input (1 o 2):");
            int input = lector.nextInt();

            int dano_recibido = input == 1? jugador.ataque() : jugador.hechizo();

            set_dano(dano_recibido);
            set_vida(dano_recibido);

            System.out.printf("""
                            |***********************************************************|
                            |           El enemigo perdió %d puntos de vida             |
                            |***********************************************************|%n"""
                            , dano_recibido);

            if(get_vida() > 0){
                jugador.set_vida_actual(jugador.get_vida_actual() - get_dano());
                System.out.printf("""
                            |***********************************************************|
                            |       El enemigo ataca a %s ... !!!!!                     |
                            |       Acerta e inflinge %d puntos de vida a %s            |
                            |***********************************************************|%n"""
                            , jugador.get_nombre(), get_dano(), jugador.get_nombre());
            }
        }
        lector.close();
    }

    public int get_vida() {return vida;}
    public void set_vida(int nuevo) {
        vida -= nuevo;
        if(vida <= 0){
            vida = 0;
            System.out.printf("""
                            |***********************************************************|
                            |    El enemigo ha sido derrotado - insert Victory Jingle - |
                            |***********************************************************|%n""");
        }
    }

    public int get_dano() {return dano;}
    public void set_dano(int nuevo) {dano = nuevo;}
}
