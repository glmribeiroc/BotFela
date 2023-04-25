package br.com.botfela;

import br.com.botfela.commands.AICommand;
import br.com.botfela.commands.Commands;
import com.theokanning.openai.service.OpenAiService;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, ListenerAdapter> cmdHandler = new HashMap<>();
    private static final String API_KEY = "";
    public static OpenAiService service = new OpenAiService(API_KEY);
    private static final String BOT_KEY = "";

    public static void main(String[] args) {
        register();

        JDA jda = JDABuilder.createDefault(BOT_KEY,
                        EnumSet.allOf(GatewayIntent.class))
                .build();

        jda.addEventListener(new Commands());
    }

    private static void register() {
        cmdHandler.put("$fela", new AICommand());
    }
}