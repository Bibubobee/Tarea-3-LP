abstract public class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;

    public Tierra(float prob){
        probabilidad_enemigo = prob;
    }

    abstract public boolean accion(Jugador jugador);

    public float get_prob_enem() {return probabilidad_enemigo;}
    public void set_prob_enem(float nuevo) {probabilidad_enemigo = nuevo;}

    public Monstruo get_monstruo() {return monstruo;}
    public void set_monstruo(Monstruo nuevo) {monstruo = nuevo;}

    public Jefe_Final get_jefe() {return jefe_final;}
    public void set_jefe(Jefe_Final nuevo) {jefe_final = nuevo;}

    public NPC get_npc() {return npc;}
    public void set_npc(NPC nuevo) {npc = nuevo;}
}
