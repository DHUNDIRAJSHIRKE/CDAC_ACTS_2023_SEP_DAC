package tester;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;

import dao.PlayerDao;
import dao.PlayerDaoImpl;

import pojos.Player;
import pojos.Team;

public class Day9_HandsOn_Tester {

	public static void main(String[] args) {
		System.out.println("Starting the app");
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			TeamDao teamDao = new TeamDaoImpl();
			// String name, String abbreviation, String owner, int maxAge, double
			// minBattingAvg,
//			int minWicketsTaken

			/*
			 * To get Team by Abbr
			 * 
			 * 
			 * System.out.println("Enter Abbreviation: ");
			 * System.out.println(teamDao.getTeamDetailsByAbbr(sc.next()));
			 */
			/*
			 * To Add team Details
			 * 
			 * 
			 * 
			 * System.out.println("Enter name, Abbr, owner, maxAge, MinBatAvg, minWickets");
			 * Team newTeam = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(),
			 * sc.nextDouble(), sc.nextInt());
			 * System.out.println(teamDao.addTeamDetails(newTeam));
			 */

			// Get list of teams having more age than specified age
			/*
			System.out.println("Enter Age value: ");
			teamDao.getTeamsAboveAge(sc.nextInt()).forEach(System.out::println);
			*/
				
			
			//update no of wickets and batting avg by searching id
			/*
			System.out.println("Enter id ");
			int id = sc.nextInt();
			Team newTeam = teamDao.getTeamById(id);
			System.out.println(newTeam);
			System.out.println("Enter wickets, BatAvg:");
			System.out.println(teamDao.updateWicketsNAvg(sc.nextInt(),sc.nextDouble(),id));
			 */
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			System.out.println("Enter Team details: ");
			System.out.println("Name , Abb, owner, maxAge, minBatAvg, minWickets: ");
			Team newTeam = new Team(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			
			teamDao.addNewTeam(newTeam);
			
			
			//String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken, Team myTeam
			System.out.println("Enter Player details:");
			System.out.println("firstName, lastName, dob, battingAvg, wicketsTaken : ");
			Player newPlayer = new Player(sc.next(),sc.next(),LocalDate.parse(sc.next()) ,sc.nextDouble(),sc.nextInt());
			PlayerDao playerDao = new PlayerDaoImpl(); 
			System.out.println(playerDao.savePlayerDetails(newPlayer, 1l));
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
