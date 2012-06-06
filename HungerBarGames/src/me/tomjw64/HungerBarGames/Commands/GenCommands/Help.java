package me.tomjw64.HungerBarGames.Commands.GenCommands;

import me.tomjw64.HungerBarGames.CommandHandler;
import me.tomjw64.HungerBarGames.Commands.HBGCommand;

import org.bukkit.command.CommandSender;

public class Help extends HBGCommand{

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		sender.sendMessage(prefix+GREEN+"HungerBarGames Commands:");
		for(HBGCommand c:CommandHandler.getCmds())
		{
			if(sender.isOp()||sender.hasPermission(c.permission()))
			{
				sender.sendMessage(BLUE+"/hbg "+c.usage()+YELLOW+" - "+c.description());
			}
		}
		sender.sendMessage(prefix+GREEN+"End of help");
	}

	@Override
	public String cmd() {
		return "help";
	}

	@Override
	public String usage() {
		return cmd();
	}

	@Override
	public String description() {
		return "shows help";
	}

	@Override
	public String permission() {
		return "HBG.player.help";
	}

	@Override
	public int numArgs() {
		return 0;
	}

}
