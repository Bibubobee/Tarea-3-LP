import java.util.Scanner;

public class Jefe_Final implements Enemigo{
    private String nombre;
    private int vida;
    private int dano_base;

    public Jefe_Final(String nom, int hp, int dano){
        set_nombre(nom);
        vida = hp;
        dano_base = dano;
    }

    public void combate(Jugador jugador){
        int vida_inicial = get_vida(); 
        Scanner lector = new Scanner(System.in);
        while(jugador.get_vida_actual() > 0 && get_vida() > 0){
            int fase_actual = 1;
            System.out.printf("""
                                |'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''|
                                |                      COMBATE FINAL                        |
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
                            |                %s perdió %d puntos de vida                |
                            |***********************************************************|%n"""
                            , get_nombre(), dano_recibido);

            if(get_vida() > 0){
                fase_actual = (int) Math.floor(get_vida()/2) <= vida_inicial? 1 : 2;
                int dano = get_dano() + 2*fase_actual;
                jugador.set_vida_actual(jugador.get_vida_actual() - dano);
                System.out.printf("""
                            |***********************************************************|
                            |       %s ataca a %s ... !!!!!!!!!!!!!                     |
                            |       Acerta e inflinge %d puntos de vida a %s            |
                            |***********************************************************|%n"""
                            ,get_nombre() , jugador.get_nombre(), get_dano(), jugador.get_nombre());
            }
        }
        lector.close();
    }

    public String get_nombre() {return nombre;}
    public void set_nombre(String nuevo) {nombre = nuevo;}

    public int get_vida() {return vida;}
    public void set_vida(int nuevo) {
        vida -= nuevo;
        if(vida <= 0){
            vida = 0;
            System.out.printf("""
                            |***********************************************************|
                            |  %s: NNnnoooooOOOOOOOOOOOOOOOoooooooooooooooOooooOoOOO... |
                            |***********************************************************|%n"""
                            , get_nombre());
            System.out.printf("""
                            |***********************************************************|
                            |    %s ha sido derrotado - insert Grand Victory Jingle -   |
                            |***********************************************************|%n"""
                            , get_nombre());
        }
    }

    public int get_dano() {return dano_base;}
    public void set_dano(int nuevo) {dano_base = nuevo;}
}
