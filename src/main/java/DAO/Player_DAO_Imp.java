package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Player;

@Repository
public class Player_DAO_Imp  implements Player_DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean savePlayer(Player player) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(player);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Player> getPlayer() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Player> query=currentSession.createQuery("from Player", Player.class);
		List<Player> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deletePlayer(Player player) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(player);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Player> getPlayerByID(Player player) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Player> query=currentSession.createQuery("from Player where player_id=:player_id", Player.class);
		query.setParameter("player_id", player.getPlayer_id());
		List<Player> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updatePlayer(Player player) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(player);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
