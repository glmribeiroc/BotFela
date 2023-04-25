package br.com.botfela.commands;

import br.com.botfela.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");
        ListenerAdapter listenerAdapter = Main.cmdHandler.get(command[0]);
        if (listenerAdapter != null) listenerAdapter.onMessageReceived(event);
    }
}
