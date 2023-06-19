package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import classes.Piloto;
import classes.Aeronave;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Piloto piloto;
        Scanner in = new Scanner(System.in);
        Aeronave aeronave;

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                piloto = cadastrarPiloto(in);
                if (piloto != null) {
                    pilotos[qtdCadastrados] = piloto;
                    qtdCadastrados++;
                    System.out.println("\nPiloto " + piloto +  " cadastrado com sucesso.");
                }
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                System.out.println("\nPilotos:");
                for( int i = 0; i < qtdCadastrados; i++ ){
                    System.out.println("Piloto " + (i+1) + ": " + pilotos[i]);
                }

                voltarMenu(in);
            } else if (opcao == 3) {

                piloto = buscaPiloto(in, qtdCadastrados, pilotos);
                if (piloto != null) {
                    System.out.println("Piloto encontrado: " + piloto);
                } else {
                    System.out.println("Piloto não encontrado.");
                }

            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                 if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(in);
                    continue;
                }

                //Solicite ao usuário o piloto
                //Crie a aeronave vinculando-a ao piloto
                piloto = buscaPiloto(in, qtdCadastrados, pilotos);
                if (piloto == null) {
                    System.out.println("Piloto não encontrado");
                    continue;
                }

                System.out.println("Digite modelo da aeronave:");
                String modelo = in.nextLine();
                System.out.println("Digite o numero de serie da aernovave:");
                String numeroSerie = in.nextLine();

                aeronave = new Aeronave(modelo, numeroSerie, piloto);

                System.out.println("\nAeronave cadastrada com sucesso: " + aeronave);
                //Exiba os dados da aeronave
                voltarMenu(in);
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }

    private static Piloto cadastrarPiloto(Scanner in) {
        String nome;
        String cpf;
        String breve;
        Piloto piloto;

        System.out.println("Nome:");
        nome = in.nextLine();

        System.out.println("CPF:");
        cpf = in.nextLine();

        System.out.println("Breve:");
        breve = in.nextLine();

        piloto = new Piloto(nome, cpf, breve);
        try {
           piloto.setCpf(cpf);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return piloto;

    }

    private static Piloto buscaPiloto(Scanner in, int qtdCadastrados, Piloto[] pilotos) {
        System.out.println("Digite o CPF do piloto:");
        String cpf = in.nextLine();

        for( int i = 0; i < qtdCadastrados; i++ ){
            if (pilotos[i].getCpf().equals(cpf)) {
                return pilotos[i];
            }
        }

        return null;

    }
}
