package DAO;

import java.util.List;

import Model.Player;

public interface Player_DAO {

	public boolean savePlayer(Player player);
	public List<Player> getPlayer();
	public boolean deletePlayer(Player player);
	public List<Player> getPlayerByID(Player player);
	public boolean updatePlayer(Player player);
}
