package br.com.botfela.commands;

import br.com.botfela.Main;
import com.theokanning.openai.completion.CompletionRequest;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AICommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();

        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(msg.substring(msg.indexOf(" ")+1))
                .temperature(0.7)
                .maxTokens(2048)
                .n(1)
                .build();

        event.getChannel().sendMessage(Main.service.createCompletion(request).getChoices().get(0).getText()).queue();
    }

}
