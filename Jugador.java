import java.util.ArrayList;
import java.util.List;

abstract public class Jugador{
    private String nombre;
    private int vida;
    private int xp;
    private int fuerza;
    private int inteligencia;
    private int energia;
    private int mana;
    private List<Mision> listo_misiones;

    private int nivel;
    private int vida_actual;
    private int energia_actual;
    private int mana_actual;

    public Jugador(String nom, int hp, int exp, int fuer, int intel, int ener, int magia){
        set_nombre(nom);
        set_vida(hp);
        set_xp(exp);
        set_fuerza(fuer);
        set_inteligencia(intel);
        set_energia(ener);
        set_mana(magia);
        listo_misiones = new ArrayList<Mision>();

        set_nivel(1);
        set_vida_actual(get_vida());
    }

    //PON LOS COMENTARIOS AQUI
    abstract public int ataque();
    abstract public int hechizo();
    abstract public void subir_experiencia(int cant);

    public String get_nombre() {return nombre;}
    public void set_nombre(String nuevo) {nombre = nuevo;}

    public int get_vida() {return vida;}
    public void set_vida(int nuevo) {vida = nuevo;}

    public int get_xp() {return xp;}
    public void set_xp(int nuevo) {xp = nuevo;}

    public int get_fuerza() {return fuerza;}
    public void set_fuerza(int nuevo) {fuerza = nuevo;}

    public int get_inteligencia() {return inteligencia;}
    public void set_inteligencia(int nuevo) {inteligencia = nuevo;}

    public int get_energia() {return energia;}
    public void set_energia(int nuevo) {energia = nuevo;}
    
    public int get_mana() {return mana;}
    public void set_mana(int nuevo) {mana = nuevo;}

    public List<Mision> get_misiones() {return listo_misiones;} //SUPONGO QUE ESTO BASTA.

    public int get_nivel() {return nivel;}//AGREGUÉ ESTO (README)
    public void set_nivel(int nuevo) {nivel = nuevo;}

    public int get_vida_actual() {return vida_actual;}//AGREGUÉ ESTO (README)
    public void set_vida_actual(int nuevo) {
        vida_actual = nuevo > vida? vida : nuevo;
        if(vida_actual <= 0){
            vida_actual = 0;
            System.out.printf("""
            |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
            |           %s murió tragicamente en su travesia            |
            |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|%n"""
            , nombre);
        }
    }

    public int get_energia_actual() {return energia_actual;}//AGREGUÉ ESTO (README)
    public void set_energia_actual(int nuevo) {
        energia_actual = nuevo > energia? energia : nuevo;
    }

    public int get_mana_actual() {return mana_actual;}//AGREGUÉ ESTO (README)
    public void set_mana_actual(int nuevo) {
        mana_actual = nuevo > mana? mana : nuevo;
    }
}