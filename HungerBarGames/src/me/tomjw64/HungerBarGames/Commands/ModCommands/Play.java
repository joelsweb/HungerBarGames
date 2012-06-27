package me.tomjw64.HungerBarGames.Commands.ModCommands;

import org.bukkit.command.CommandSender;

import me.tomjw64.HungerBarGames.Commands.HBGCommand;
import me.tomjw64.HungerBarGames.Managers.PlaylistManager;
import me.tomjw64.HungerBarGames.Util.Playlist;

public class Play extends HBGCommand{

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		Playlist pl=PlaylistManager.getPlaylist(args[0]);
		if(pl!=null)
		{
			if(!pl.isActive())
			{
				sender.sendMessage(prefix+GREEN+"Playlist Started!");
				pl.playNext();
			}
			else
			{
				sender.sendMessage(prefix+RED+"This playlist is already active!");
			}
		}
		else
		{
			sender.sendMessage(prefix+RED+"There is no playlist by that name!");
		}
	}

	@Override
	public String cmd() {
		return null;
	}

	@Override
	public String usage() {
		return null;
	}

	@Override
	public String description() {
		return null;
	}

	@Override
	public String permission() {
		return null;
	}

	@Override
	public int numArgs() {
		return 0;
	}

}
