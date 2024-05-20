package service;

import domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;
import client.ClientHTTPConfiguration;
import static org.mockito.Mockito.*;

class AbrigoServiceTest {

    private ClientHTTPConfiguration client = mock(ClientHTTPConfiguration.class);
    private AbrigoService abrigoService = new AbrigoService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("Teste", "61981880392", "abrigo_alura@gmail.com");

    @Test
    public void deveVerificarSeDispararRequisicaoGetSeraChamado() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{"+abrigo.toString()+"}]");
        when(client.realizarRequisicaoGET(anyString())).thenReturn(response);

        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

    public void verificarSeNaoHaAbrigo() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[]");
        when(client.realizarRequisicaoGET(anyString())).thenReturn(response);

        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[0];

        Assertions.assertEquals(expectedAbrigosCadastrados, actual);
    }

}