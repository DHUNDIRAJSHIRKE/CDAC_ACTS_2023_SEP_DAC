package dao;

import static utils.HibernateUtils.getFactory;
import pojos.Player;
import pojos.Team;
import utils.HibernateUtils;
import org.hibernate.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String savePlayerDetails(Player player, Long teamId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			if (team != null) {
				team.addPlayer(player);
				session.persist(player);
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return "Player Added , with ID " + player.getId();
	}

}
