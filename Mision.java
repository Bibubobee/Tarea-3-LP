public class Mision{
    private char requisito;
    private int valor;
    private int cantidad;
    private int recompensa;

    public Mision(){
        set_requisito(' ');
        set_valor(0);
        set_cantidad(0);
        set_recompensa(0);
    }

    public Mision(char req, int val, int recom){
        set_requisito(req);
        set_valor(val);
        set_cantidad(0);
        set_recompensa(recom);
    }

    public boolean verificar_requisito(){
        return cantidad == valor;
    }

    public char get_requisito() {return requisito;}
    public void set_requisito(char nuevo) {requisito = nuevo;}

    public int get_valor() {return valor;}
    public void set_valor(int nuevo) {valor = nuevo;}
    
    public int get_cantidad() {return cantidad;}
    public void set_cantidad(int nuevo) {cantidad = nuevo;}

    public int get_recompensa() {return recompensa;}
    public void set_recompensa(int nuevo) {recompensa= nuevo;}
}