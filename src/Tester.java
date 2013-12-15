import DataAccessObject.UserDAO;
import domain.User;


public class Tester {
	public static void main(String[] args){
		System.out.println("running...");
		User andreas = new User();
		andreas.setEmail("andreaskastrup@gmail.com");
		andreas.setUsername("akast11");
		UserDAO andreasDAO = new UserDAO();
		andreasDAO.addUser(andreas);
		System.out.println("... done");
	}
}
