package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Player_DAO;
import Model.Player;

@Service
@Transactional
public class Player_Service_Imp implements Player_Service {
 
	@Autowired
	private Player_DAO playerdao;
	
	@Override
	public boolean savePlayer(Player player) {
		return playerdao.savePlayer(player);
	}

	@Override
	public List<Player> getPlayers() {
		return playerdao.getPlayer();
	}

	@Override
	public boolean deletePlayer(Player player) {
		return playerdao.deletePlayer(player);
	}

	@Override
	public List<Player> getPlayerByID(Player player) {
		return playerdao.getPlayerByID(player);
	}

	@Override
	public boolean updatePlayer(Player player) {
		return playerdao.updatePlayer(player);
	}

}
