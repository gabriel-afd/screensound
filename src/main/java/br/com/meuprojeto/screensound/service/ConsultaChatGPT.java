package br.com.meuprojeto.screensound.service;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterInformacao(String texto) {
        OpenAiService service = new OpenAiService("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");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(100)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}