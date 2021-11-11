import java.util.Scanner;

public class Neutro extends NPC{
    private char requisito; // "v" o "m"
    private int valor;
    private int recompensa;
    private boolean ya_dio_mision;

    public Neutro(String nom, char req, int val, int recom){
        set_nombre(nom);
        set_requisito(req);
        set_valor(val);
        set_recompensa(recom);
        set_dio_mision(false);
    }

    public void interaccion(Jugador jugador) {
        if(!ya_dio_mision){
            if(requisito == 'v'){
                System.out.printf("""
                                |***********************************************************|
                                | %s : Hola, ¿quieres cumplir esta mision?                  |
                                |      Deberas llegar a %d del mundo y recibiras %d de xp   |
                                |***********************************************************|%n"""
                                ,get_nombre(), get_valor(), get_recompensa());
            }
            else if( requisito == 'm'){
                System.out.printf("""
                                |***********************************************************|
                                | %s : Hola, ¿quieres cumplir esta mision?                  |
                                |      Deberas matar %d Monstruos y recibiras %d de xp      |
                                |***********************************************************|%n"""
                                ,get_nombre(), get_valor(), get_recompensa());
            }
            
            System.out.println("""
                                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|
                                |                        DECISION                           |
                                |                   ¿Aceptas la mision?                     |
                                |           1. Si                              2. No        |
                                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|""");
            System.out.printf("Input (1 o 2):");
            Scanner lector = new Scanner(System.in);
            int input = lector.nextInt();

            if(input == 1){
                Mision mision = new Mision(requisito, valor, recompensa);
                jugador.get_misiones().add(mision);
                set_dio_mision(true);
                System.out.printf("""
                                |-----------------------------------------------------------|
                                |                    %s Aceptó la mision                    |
                                |-----------------------------------------------------------|%n"""
                                , jugador.get_nombre());
            }
            else{
                System.out.printf("""
                                |-----------------------------------------------------------|
                                |                    %s Rechazó la mision                   |
                                |-----------------------------------------------------------|%n"""
                                , jugador.get_nombre());
            }
            lector.close();
        }
        else{
            System.out.printf("""
            |***********************************************************|
            |           %s: Ya te di mi mision, saludos                 | 
            |***********************************************************|%n"""
            ,get_nombre());
        }
    }

    public char get_requisito() {return requisito;}
    public void set_requisito(char nuevo) {requisito = nuevo;}

    public int get_valor() {return valor;}
    public void set_valor(int nuevo) {valor = nuevo;}

    public int get_recompensa() {return recompensa;}
    public void set_recompensa(int nuevo) {recompensa = nuevo;}

    public boolean get_dio_mision() {return ya_dio_mision;}
    public void set_dio_mision(boolean nuevo) {ya_dio_mision = nuevo;}
}
