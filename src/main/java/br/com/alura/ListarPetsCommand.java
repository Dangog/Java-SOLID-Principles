package br.com.alura;

import client.ClientHTTPConfiguration;
import service.AbrigoService;
import service.PetsService;

import java.io.IOException;

public class ListarPetsCommand implements Command {
    @Override
    public void execute() {
        try {
            ClientHTTPConfiguration client = new ClientHTTPConfiguration();
            PetsService petsService = new PetsService(client);

            petsService.listarPetCadastradosPorAbrigo();
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}
