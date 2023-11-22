package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
//props 
	private UserDaoImpl userDao;// dependency
	private User userDetails;// result
	// clnt info
	private String fname;
	private String lname;
	private String dob;
	private String email;
	private String pass;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	// def ctor
	public UserBean() throws SQLException {
		// create user dao instance
		userDao = new UserDaoImpl();
		System.out.println("user bean created...");
	}

	// generate getter n setter
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("email set!"+email);
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// add a B.L method to authenticate user
	public String authenticateUser() throws SQLException {
		System.out.println("in JB B.L auth user " + email + " " + pass);
		// JB ---> DAo's method
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null) // => invalid login
			return "login"; // JB rets dyn navigational outcome (i.e telling JSP where to take the clnt
							// next)
		//=> login successful
		if(userDetails.getRole().equals("admin"))
			return "admin_page";
		//=> voter 
		if(userDetails.isVotingStatus())
			return "logout";
		//=> voter not yet voter
		return "candidate_list";
	}
	
	
//	Business Logic to add new Voter
	public String registerVoter() throws SQLException{
		System.out.println("in javaBeans Business Logic Register Voter"+fname+" "+lname+" "+email + " " + pass+" "+dob);
		//String firstName, String lastName, String email, String password, Date dob
		
		//validate age ; if invalid, error message
		//else create user instance
		LocalDate parsedDob = LocalDate.parse(dob);
		LocalDate validDob = LocalDate.now().minusYears(21);
		if(parsedDob.isAfter(validDob)) {
			return "Too young to Vote!!";
		}else {
			//int userId, String firstName, String lastName, String email, Date dob, boolean votingStatus,
			//String role
			User newUser = new User(fname,lname,email,pass,Date.valueOf(parsedDob),false,"voter");
			return userDao.registerNewVoter(newUser);
			
		}

		
		
	}

}
