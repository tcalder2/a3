package ttable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import json.JSONFailureException;
import json.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The class User.
 * 
 * @author James Baron
 * @author James Anderson
 * @author Chuhan Qin
 * 
 */
public class User {

	/** The user's FaceBook id. */
	private String fbId ="";

	/** The user's first name. */
	private String firstName = "";
	
	/** The user's last name. */
	private String lastName = "";
	
	/**
	 * Authenticate the user.
	 *
	 * @param password the password
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean authenticate(String password) throws JSONFailureException
	{
		Json json = new Json();
		
		//Will throw error if success fail.  That error will have messages.
		json.sendRequest("https://jbaron6.cs2212.ca/authenticate?password=" + password);
		
		return true;
	}
	
	/**
	 * Returns if this is the first login attempt or not.
	 * 
	 * @return						true if this is the first login, false otherwise
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static boolean isFirstLogin() throws JSONFailureException {
		//TODO: server call
		return false;
	}
	
	/**
	 * Returns whether test mode is on or not.
	 * 
	 * @return						true if test mode is on, false otherwise
	 * @throws JSONFailureException the JSON failure exception
	 */
	public static boolean isTestMode() throws JSONFailureException {
		//TODO: server call
		return false;
	}
	
	/**
	 * Set whether test mode is on or not.
	 * 
	 * @param testMode				the test mode boolean containing whether test mode is activated
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static void setTestMode(boolean testMode) throws JSONFailureException {
		//TODO: server call
	}

	/**
	 * Gets the current user's password recovery questions.
	 *
	 * @return the questions		the array of security questions
	 * @throws JSONFailureException the JSON failure exception
	 */	
	public static ArrayList<String> getSecurityQuestions() throws JSONFailureException
	{
		ArrayList<String> questions = new ArrayList<String>();
		
		Json json = new Json();
		JSONObject jsonObj = json.sendRequest("https://jbaron6.cs2212.ca/getquestions");
		
		
		JSONArray questionsArray = (JSONArray) jsonObj.get("questions");
		
		Iterator<?> questionsIt = questionsArray.iterator();
		
		while(questionsIt.hasNext())
			questions.add((String)questionsIt.next());
		
		return questions;
	}
	
	/**
	 * Get the users security question number.
	 * 
	 * @return						the users security question number
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static int getSecurityQuestionNumber() throws JSONFailureException {
		//TODO: add server call
		return 1;
	}
	
	/**
	 * Tests the security question answer for validity.
	 * 
	 * @param answer				the answer input by the user to be authenticated
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static void testSecurityQuestion(String answer) throws JSONFailureException {
		//TODO: add server call
	}
	
	/**
	 * Gets the current user.
	 *
	 * @return the currently logged user
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static User getUser() throws JSONFailureException
	{
		User user = new User();
		
		Json json = new Json();
		
		JSONObject jsonObj = json.sendRequest("https://jbaron6.cs2212.ca/getuser");
		
		JSONObject userObj = (JSONObject)jsonObj.get("user");
		
		user.fbId = ((String)userObj.get("fb_id"));
		user.firstName = ((String)userObj.get("first_name"));
		user.lastName = ((String)userObj.get("last_name"));
		
		return user;
	}
	
	/**
	 * Reset the user's password.
	 *
	 * @param oldPassword			the old password
	 * @param newPassword			the new password
	 * @return 						true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean resetPassword(String oldPassword, String newPassword) throws JSONFailureException
	{
		Json json = new Json();
		json.sendRequest("https://jbaron6.cs2212.ca/resetpassword?answer=" + oldPassword + "&new_password=" + newPassword);
		
		return true;
	}
	
	/**
	 * Gets an array of progeny.
	 *
	 * @return 						an array of progeny
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static ArrayList<Progeny> getProgeny() throws JSONFailureException 
	{
		ArrayList<Progeny> progenyList;

		progenyList = new ArrayList<Progeny>();
		
		// TODO: make server call and parse list
		
		return progenyList;
	}
	
	/**
	 * Adds a progeny.
	 *
	 * @param  progeny				the progeny to add
	 * @return 						the newly added progeny
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static Progeny addProgeny(String firstName, Date birthday) throws JSONFailureException {
		
		// TODO: server request
		Progeny result = new Progeny("Name", new Date(), "" + 0, 30); //TODO: replace this line with parsed info
		return result;
	}
	
	/**
	 * Removes the specified progeny.
	 * 
	 * @param progeny				the progeny to be removed
	 * @return						true if successful, false otherwise
	 * @throws JSONFailureException the JSON failure exception
	 */
	public static boolean removeProgeny(Progeny progeny) throws JSONFailureException {
		//TODO: code this, perhaps use progeny id to refer to the progeny
		return false;
	}
	
	/**
	 * 
	 * @param progeny				the progeny to 
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static void updateProgeny(Progeny progeny) throws JSONFailureException {
		//TODO: server request to push the new progeny
	}
	
	/**
	 * Gets an array of the levels (ie. global level settings).
	 * 
	 * @return 						an array of the levels 
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static ArrayList<Level> getLevels() throws JSONFailureException {
		ArrayList<Level> levels = new ArrayList<Level>();  //TODO: replace line with actual server call
		return levels;
	}
	
	/**
	 * Sets the answer to the user's password recovery question.
	 *
	 * @param answer the answer
	 * @param password the password
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean setAnswer(String answer, String password) throws JSONFailureException
	{
		Json json = new Json();
		json.sendRequest("https://jbaron6.cs2212.ca/setanswer?answer=" + answer + "&password=" + password);
		
		return true;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param oldPassword the old password
	 * @param newpassword the new password
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean setPassword(String oldPassword, String newpassword) throws JSONFailureException
	{
		Json json = new Json();
		
		json.sendRequest("https://jbaron6.cs2212.ca/setpassword?new_password=" + newpassword + "&old_password=" + oldPassword);
		
		return true;
	}
	
	/**
	 * Sets the user's password recovery question.
	 *
	 * @param question the question
	 * @param password the password
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean setQuestion(String question, String password) throws JSONFailureException
	{
		Json json = new Json();
		json.sendRequest("https://jbaron6.cs2212.ca/setquestion?question=" + question + "&password=" + password);		
		
		return true;
	}

	/**
	 * Gets the FaceBook ID of the current user.
	 *
	 * @return the FaceBook ID
	 */
	public String getFbId() {
		return fbId;
	}

	/**
	 * Gets the first name of the user.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name of the current user.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the number of mistakes allowed for a specified level.
	 *
	 * @param mistakesAllowed the new mistakes allowed
	 */
	public static void setMistakesAllowed(int level, int mistakesAllowed) throws JSONFailureException {
		User.getLevels().get(level - 1).setMistakesAllowed(mistakesAllowed);
		//TODO:  server call to update
	}
	
	/**
	 * 
	 * @param id					the id of the progeny to be updated
	 * @param progeny				the updated progeny to be sent to server
	 * @throws JSONFailureException	the JSON failure exception
	 */
	public static void updateProgeny(int id, Progeny progeny) throws JSONFailureException {
		//TODO:  server call to update
	}
}
