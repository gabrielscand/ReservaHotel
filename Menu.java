import java.util.Scanner; //Método Scanner para o usuario poder interagir

public class Menu {
    //Váriaveis de Interação
    static Scanner scanner = new Scanner(System.in);
    static int select = -1;
    static int select2;
    static int select3;

    //Variaveis Globais
    public static int QuartoSimples;
    public static int QuartoDuplo;
    public static int QuartoFamilia;
    public static int CanHospede = 0;

    //Variaveis Globais de Dados, Array String
    public static String[][] BD = new String[100][4];
    public static String ID;

    public static void main (String[] args) {
        // Variaveis dos Quartos
        QuartoSimples = 10;
        QuartoDuplo = 10;
        QuartoFamilia = 10;

        //Criação do Menu
        while (select != 0){

            try {
                //Print do Menu
                System.out.println("------ RESERVA DE QUARTOS ------\n");
                System.out.println("###### Escolha uma Opção: ######");
                System.out.println("\n1... Verificar Disponibilidade");
                System.out.println("\n2... Consultar Hospede");
                System.out.println("\n3... Registrar Reserva");
                System.out.println("\n4... Excluir Reserva");
                System.out.println("\n5... Mostrar Reservas");
                System.out.println("\n0... Sair");

                select = Integer.parseInt(scanner.nextLine());

                //Seleção do Menu
                switch (select) {
                    case 1:
                        ValDisponibilidade();
                        break;
                    case 2:
                        ConHospede();
                        break;
                    case 3:
                        RegHospede();
                        break;
                    case 4:
                        Eliminar();
                        break;
                    case 5:
                        MosReserva();
                        break;
                    case 0:
                        System.out.println("Até Breve");
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
                System.out.println("\n");
            } catch (NumberFormatException e){
                System.out.println("Erro");
            }
        }

    }

    // Validar a Disponibilidade
    public static void ValDisponibilidade(){
        System.out.println("\n\nDisponibilidade dos Quartos: ");

        System.out.println("Quarto Simples: " + QuartoSimples);
        System.out.println("Quarto Duplo: " + QuartoDuplo);
        System.out.println("Quarto Familia: " + QuartoFamilia);

        System.out.println("\n");
    }

    //Consultar os Hospedes
    public static void ConHospede(){
        System.out.println("Digitar Numero de Identificação: ");
        ID = scanner.nextLine();

        for (int i = 0; i <= 99; i++){
            if (BD[i][0] == null) {

            } else {
                if (BD[i][0].contains(ID)) {
                    System.out.println("\n Cliente Registrado ");
                    System.out.println("ID: " + BD[i][0]);
                    System.out.println("Nome: " + BD[i][1]);
                    System.out.println("Tipo de Quarto: " + BD[i][2]);
                    System.out.println("Café da Manha: " + BD[i][3]);
                }
            }
        }
    }
    //Função para remover uma reserva
    public static void Eliminar(){
        System.out.println("Digitar Numero de Identificação para Eliminar: ");
        ID = scanner.nextLine();

        for (int i = 0; i <= 99; i++) {
            if (BD[i][0] == null) {

            } else {
                if (BD[i][0].contains(ID)) {
                    System.out.println("Reserva Apagada com Sucesso");
                    System.out.println("ID: " + BD[i][0]);
                    System.out.println("Nome: " + BD[i][1]);
                    System.out.println("Tipo de Quarto: " + BD[i][2]);
                    System.out.println("Café da Manha: " + BD[i][3]);
                }
            }
        }

        select2 = Integer.parseInt(scanner.nextLine());
        if (select2 == 1){
            BD[CanHospede][2] = "1. Quarto Simples";
            QuartoSimples = QuartoSimples + 1;
        } else {
            if (select2 == 2) {
                BD[CanHospede][2] = "2. Quarto Duplo";
                QuartoDuplo = QuartoDuplo + 1;
            } else {
                if (select2 == 3) {
                    BD[CanHospede][2] = "3. Quarto Familia";
                    QuartoFamilia = QuartoFamilia + 1;
                } else {
                    System.out.println("Escolher uma Opção Válida");
                }
            }
        }

    }
    //Função para registrar uma reserva
    public static void RegHospede(){
        System.out.println("Digitar Numero de Identificação: ");
        BD[CanHospede][0] = scanner.nextLine();

        System.out.println("Digitar Nome do Hospede: ");
        BD[CanHospede][1] = scanner.nextLine();

        //Menu de escolha dos quartos
        System.out.println("Escolher Tipo de Quarto: \n");
        System.out.println("Tipos de Quartos: ");
        System.out.println("1. Quarto Simples");
        System.out.println("2. Quarto Duplo");
        System.out.println("3. Quarto Familia");

        //Seleção do Quarto
        select2 = Integer.parseInt(scanner.nextLine());
        if (select2 == 1){
            BD[CanHospede][2] = "1. Quarto Simples";
            QuartoSimples = QuartoSimples - 1;
        } else {
            if (select2 == 2) {
                BD[CanHospede][2] = "2. Quarto Duplo";
                QuartoDuplo = QuartoDuplo - 1;
            } else {
                if (select2 == 3) {
                    BD[CanHospede][2] = "3. Quarto Familia";
                    QuartoFamilia = QuartoFamilia - 1;
                } else {
                    System.out.println("Escolher uma Opção Válida");
                }
            }
        }

        System.out.println("Café da Manha: ");
        System.out.println("1. SIM");
        System.out.println("2. NÃO");

        select3 = Integer.parseInt(scanner.nextLine());

        if (select3 == 1) {
            BD[CanHospede][3] = "SIM";
        } else {
            if (select3 == 2) {
                BD[CanHospede][3] = "NÃO";
            } else {
                System.out.println("Escolher uma Opção Válida");
            }
        }

        CanHospede = CanHospede + 1;
        System.out.println("Reserva Registrada");

    }

    //Função para mostrar as reservas
    public static void MosReserva(){
        System.out.println("Base de Dados das Reservas");

        for (int i = 0; i <= 99; i++){
            for (int j = 0; j<=3; j++){
                if (BD[i][j] == null){

                } else {
                    System.out.println(BD[i][j] + " ");
                }
            }

            if (BD[i][0] == null) {

            } else {
                System.out.println("\n");
            }
        }

    }

}