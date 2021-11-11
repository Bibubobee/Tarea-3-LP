import java.util.Random;

public class Planicie extends Tierra{
    public Planicie(float prob) {
        super(prob);
    }

    public boolean accion(Jugador jugador){
        Random rng = new Random();
        if(jugador.get_vida_actual() > 0){
            if(get_npc() != null){ //NI PUTA IDEA SI FUNCIONA
                get_npc().interaccion(jugador);
            }
            float prob = rng.nextFloat();
            if(prob < get_prob_enem()){
                if(get_monstruo() != null){
                    get_monstruo().combate(jugador);
                }
                else if(get_jefe() != null){
                    get_jefe().combate(jugador);
                }
            }

            if(jugador.get_vida_actual() <= 0){
                return false;
            }
            return true;
        }
        return false;
    }
}
