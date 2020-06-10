package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Player;
import Service.Player_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private Player_Service player_Service ;
	
	@PostMapping("save-player")
	public boolean saveStudent(@RequestBody Player player) {
		 return player_Service.savePlayer(player);
		
	}
	
	@GetMapping("player-list")
	public List<Player> allPlayer() {
		 return player_Service.getPlayers();
	}
	
	
	@DeleteMapping("delete-player/{player_id}")
	public boolean deleteStudent(@PathVariable("player_id") int player_id,Player player) {
		player.setPlayer_id(player_id);
		return player_Service.deletePlayer(player);
	}

	@GetMapping("player/{player_id}")
	public List<Player> allPlayerByID(@PathVariable("player_id") int player_id,Player player) {
		 player.setPlayer_id(player_id);
		 return player_Service.getPlayerByID(player);
		
	}
	
	@PostMapping("update-student/{student_id}")
	public boolean updateStudent(@RequestBody Player player,@PathVariable("player_id") int player_id) {
		player.setPlayer_id(player_id);
		return player_Service.updatePlayer(player);
	}
}
