package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import pojos.Player;

import static utils.HibernateUtils.getFactory;

public class AddNewPlayerDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("hibernate booted successfully ! "+sf);
			PlayerDao pDao = new PlayerDaoImpl();
			System.out.println(" Enter new Player Details : name, Age,BattingAvg,WicketsTaken");
			Player newPlayer = new Player(sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			System.out.println(pDao.addPlayerDetails(newPlayer));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
