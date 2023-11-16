package tester;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.Candidate;
import pojos.User;

public class TestLayeredApp1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			CandidateDaoImpl cDao = new CandidateDaoImpl();
			System.out.println();
			System.out.println("Enter Email and password:");
			User newUser = dao.authenticateUser(sc.next(),sc.next());
			System.out.println(newUser);
			List<Candidate> cList = cDao.getAllCandidates();
			Iterator itr = cList.iterator();
			while(itr.hasNext()){
				Object tem = (Candidate)itr.next();
				System.out.println(tem);
			}
			//System.out.println(cList);
			System.out.println("Enter role begin n end date");
			//tester  --> Dao's method
			List<User> users = dao.getSelectedUsers(sc.next(),
					Date.valueOf(sc.next()),Date.valueOf(sc.next()));
			System.out.println("Selected Users ");
			users.forEach(System.out::println);
			//clean up
			dao.cleanUp();
			cDao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
