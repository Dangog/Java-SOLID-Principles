package br.com.alura;

import service.AbrigoService;
import client.ClientHTTPConfiguration;
import service.PetsService;

import java.util.Scanner;

public class AdopetConsoleApplication {
        public static void main(String[] args) {

            ClientHTTPConfiguration client = new ClientHTTPConfiguration();

            PetsService petsService = new PetsService(client);
            AbrigoService abrigoService = new AbrigoService(client);

            System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
            try {
                int opcaoEscolhida = 0;
                while (opcaoEscolhida != 5) {
                    System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                    System.out.println("1 -> Listar abrigos cadastrados");
                    System.out.println("2 -> Cadastrar novo abrigo");
                    System.out.println("3 -> Listar pets do abrigo");
                    System.out.println("4 -> Importar pets do abrigo");
                    System.out.println("5 -> Sair");

                    String textoDigitado = new Scanner(System.in).nextLine();
                    opcaoEscolhida = Integer.parseInt(textoDigitado);

                    if (opcaoEscolhida == 1) {
                        abrigoService.listarAbrigo();
                    } else if (opcaoEscolhida == 2) {
                        abrigoService.cadastrarAbrigo();
                    } else if (opcaoEscolhida == 3) {
                        petsService.listarPetCadastradosPorAbrigo();
                    } else if (opcaoEscolhida == 4) {
                        petsService.importarPetsPorAbrigo();
                    } else if (opcaoEscolhida == 5) {
                        break;
                    } else {
                        System.out.println("NÚMERO INVÁLIDO!");
                        opcaoEscolhida = 0;
                    }
                }
                System.out.println("Finalizando o programa...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
