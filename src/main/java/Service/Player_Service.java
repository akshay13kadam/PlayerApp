package Service;

import java.util.List;

import Model.Player;

public interface Player_Service {

	
	public boolean savePlayer(Player Player);
	public List<Player> getPlayers();
	public boolean deletePlayer(Player Player);
	public List<Player> getPlayerByID(Player Player);
	public boolean updatePlayer(Player Player);
}
