package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Player")
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int player_id;
	private String player_name;
	private String player_email;
	private String player_role;
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public String getPlayer_email() {
		return player_email;
	}
	public void setPlayer_email(String player_email) {
		this.player_email = player_email;
	}
	public String getPlayer_role() {
		return player_role;
	}
	public void setPlayer_role(String player_role) {
		this.player_role = player_role;
	}
	

	
}
