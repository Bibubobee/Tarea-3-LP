/*Al principio debe permitir que el DM ingrese el tama˜no del mundo, luego ir´a casilla por
casilla rellen´andola de la siguiente forma:
1. Qu´e tipo de tierra es.
2. La probabilidad de que un Enemigo aparezca
3. Qu´e tipo de Enemigo podr´ıa aparecer
4. Los atributos del Enemigo
5. Si es que habr´a un NPC
6. Si la respuesta es que s´ı, deber´a pedir:
Qu´e tipo de NPC es
Los atributos del NPC*/
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //****************************** CREACION TAMAÑO DEL MUNDO ************************************
        Scanner lector = new Scanner(System.in);
        System.out.printf("""
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
            | Bienvenido Dungeon Master!, ¿de qué tamaño será el mundo  |
            | de esta historia?                                         | 
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
        System.out.printf("Tamaño? (numero entero): ");
        System.out.printf("Tamaño? (numero entero): ");
        int tamano = lector.nextInt();
        Tierra[] mundo = new Tierra[tamano];

        /************************** CREACION DE TIERRAS *******************************/
        for (int i = 0; i < tamano; i++) {
            System.out.printf("""
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                | Para el espacio %d, ¿qué tipo de tierra es?               | 
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n"""
                , i);
            System.out.printf("""
                |~++++++++++++++++++++++++++++++++++++++++++++++++++++++++++| 
                |                        DECISION                           |
                |  1.Montaña            2.Planicie             3.Bosque     | 
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|%n""");
            System.out.printf("Eleccion (1, 2 o 3): ");
            int tipo_tierra = lector.nextInt();
            System.out.printf("""
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                |  ¿Cual es la probabilidad que aparezca un enemigo aqui?   | 
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
            System.out.printf("Probabilidad (de 0.0 a 1.0): ");
            float prob = lector.nextFloat();
            
            /******************************** INSERCIÓN DE TIERRA AL MUNDO ***************************/
            switch(tipo_tierra){
                case 1: /************* MONTAÑA *************/
                    Montana montana = new Montana(prob);
                    mundo[i] = montana;
                    break;
                case 2: /************* PLANICIE *************/
                    Planicie planicie = new Planicie(prob);
                    mundo[i] = planicie;
                    break;
                case 3: /************* BOSQUE *************/
                    Bosque bosque = new Bosque(prob);
                    mundo[i] = bosque;
                    break;
            }

            System.out.printf("""
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                |      ¿Qué tipo de enemigo aparecerá en esta Tierra?       | 
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
            System.out.printf("""
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++| 
                |                        DECISION                           |
                |       1.Monstruo                         2.Jefe Final     | 
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|%n""");
            System.out.printf("Enemigo (1 o 2): ");
            int enem = lector.nextInt();

            /************************** CREACION DEL ENEMIGO ******************************/
            switch (enem) {
                case 1:
                    System.out.printf("""
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                        |                   ¿Vida del Monstruo?                     | 
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                    System.out.printf("Vida (entero): ");
                    int hp = lector.nextInt();
                    Monstruo mon = new Monstruo(hp);
                    mundo[i].set_monstruo(mon);
                    break;
            
                case 2:
                    System.out.printf("""
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                        |                 ¿Nombre del Jefe Final?                   | 
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                    System.out.printf("Nombre (string): ");
                    String j_nom = lector.nextLine();
                    System.out.printf("""
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                        |                   ¿Vida del Jefe Final?                   | 
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                    System.out.printf("Vida (entero): ");
                    int j_hp = lector.nextInt();
                    System.out.printf("""
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                        |               ¿Daño base del Jefe Final?                  | 
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                    System.out.printf("Daño Base (entero): ");
                    int j_dano = lector.nextInt();
                    Jefe_Final jefe = new Jefe_Final(j_nom, j_hp, j_dano);
                    mundo[i].set_jefe(jefe);
                    break;
            }
            
            /******************************** CREACION NPC ************************************/
            System.out.printf("""
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                |               ¿Vive un NPC en esta Tierra?                | 
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
            System.out.printf("""
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++| 
                |                        DECISION                           |
                |       1.Si                                   2.No         | 
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|%n""");
            System.out.printf("Input (1 o 2): ");
            int input = lector.nextInt();

            if(input == 1){
                System.out.printf("""
                        |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++| 
                        |                        DECISION                           |
                        |                   ¿Qué tipo de NPC es?                    |
                        |       1.Malo            2.Neutro          3.Bueno         | 
                        |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|%n""");
                System.out.printf("NPC (1, 2 o 3): ");
                int t_npc = lector.nextInt();
                System.out.printf("""
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                        |                    ¿Nombre del NPC?                       | 
                        |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                System.out.printf("Nombre (string): ");
                String npc_nom = lector.nextLine();
                
                /***************************** CREACION TIPO DE NPC ***************************/
                switch (t_npc) {
                    case 1: /**************** MALO **************/
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |           ¿Cantidad de Energía que robará?                | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Energia a robar (entero): ");
                        int rob_en = lector.nextInt();
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |                    ¿Cantidad de Mana?                     | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Mana a robar (entero): ");
                        int rob_ma = lector.nextInt(); 
                        Malo malo = new Malo(npc_nom, rob_en, rob_ma);
                        mundo[i].set_npc(malo);   
                        break;

                    case 2: /**************** NEUTRO **************/
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |               ¿Requisito de su mision?                    | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Requisito (\"v\" o \"m\"): ");
                        char npc_req = lector.nextLine().charAt(0);
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |                    ¿Valor de la mision?                   | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Valor (entero si es requisito \"m\", 0 a %d si es \"v\"): ", tamano - 1);
                        int npc_val = lector.nextInt();
                        if(npc_req == 'v'){ //Por si acaso
                            npc_val = npc_val % tamano;
                        }
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |                ¿Recompensa de la mision?                  | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Recompensa (xp en int): ");
                        int npc_recom = lector.nextInt();
                        Neutro neutro = new Neutro(npc_nom, npc_req, npc_val, npc_recom);
                        mundo[i].set_npc(neutro);
                        break;

                    case 3: /**************** BUENO **************/
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |                 ¿Atributo que mejorará?                   | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Atributo (\"vida\"-\"xp\"-\"energia\"-\"mana\"): ");
                        String npc_atr = lector.nextLine();
                        System.out.printf("""
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
                            |                   ¿En cuánto mejorará?                    | 
                            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
                        System.out.printf("Cantidad (entero): ");
                        int npc_cant = lector.nextInt();
                        Bueno bueno = new Bueno(npc_nom, npc_atr, npc_cant);
                        mundo[i].set_npc(bueno);
                        break;
                }
            }
        }

        System.out.printf("""
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| 
            |    DM, su decision final ¿Posición inicial del jugador?   | 
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|%n""");
        System.out.printf("Posicion (entero entre 0 y %d): ", tamano - 1);
        int pos = lector.nextInt();
        System.out.printf("""
            |^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^| 
            |   Muy bien, Jugador ¿cual es el nombre de su personaje?   | 
            |___________________________________________________________|%n""");    
        System.out.printf("Posicion (entero entre 0 y %d): ", tamano - 1);
        String p_nom = lector.nextLine();
        System.out.printf("""
            |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++| 
            |                         DECISION                          | 
            |               ¿A qué clase pertenece %s?                  |
            |___________________________________________________________|
            |   1.Mago       |      2.Guerrero        |    3.Druida     |
            |  Usuario de    |       Usuario de       |  \"Jack of all  |
            |     Mana       |        Energía         |      Trades\"   |
            |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|%n"""
            , p_nom);
        System.out.printf("Eleccion (1, 2 o 3): ");
        int tipo_eleccion = lector.nextInt();
        Jugador jugador;
        switch (tipo_eleccion) {
            case 1:
                jugador = new Mago(p_nom);
                break;
        
            case 2:
                jugador = new Guerrero(p_nom);
                break;
            
            case 3:
                jugador = new Druida(p_nom);
                break;
        }   
        
        
        lector.close();
    }
}