package br.com.alura;

import service.AbrigoService;
import client.ClientHTTPConfiguration;
import service.PetsService;

import java.util.Scanner;

public class AdopetConsoleApplication {
        public static void main(String[] args) {

            CommandExecutor commandExecutor = new CommandExecutor();
            ClientHTTPConfiguration client = new ClientHTTPConfiguration();
            PetsService petsService = new PetsService(client);

            System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
            try {
                int opcaoEscolhida = 0;
                while (opcaoEscolhida != 5) {
                    exibirMenu();

                    String textoDigitado = new Scanner(System.in).nextLine();
                    opcaoEscolhida = Integer.parseInt(textoDigitado);

                    switch (opcaoEscolhida){
                        case 1 -> commandExecutor.executeCommand(new ListarAbrigoCommand());
                        case 2 -> commandExecutor.executeCommand(new CadastrarAbrigoCommand());
                        case 3 -> commandExecutor.executeCommand(new ListarPetsCommand());
                        case 4 -> commandExecutor.executeCommand(new ImportarPetsCommand());
                        case 5 -> System.exit(0);
                        default -> System.out.println("Opção inválida");
                    }

                }
                System.out.println("Finalizando o programa...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void exibirMenu(){
            System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
            System.out.println("1 -> Listar abrigos cadastrados");
            System.out.println("2 -> Cadastrar novo abrigo");
            System.out.println("3 -> Listar pets do abrigo");
            System.out.println("4 -> Importar pets do abrigo");
            System.out.println("5 -> Sair");
        }
}
