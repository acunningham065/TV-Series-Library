package tvdb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * This Class holds the structure and behaviours for an Actor Object
 * 
 *  @author 40176468
 *
 */
public class Actor 
{
	//Declare instance variables
	private String name = "";
	private LocalDate dateOfBirth = LocalDate.now();
	private ArrayList<String> showsActedIn = new ArrayList<String>();

	
	//------------------------------ Constructors ------------------------------\\
	/**
	 * This is the primary constructor for Actor
	 * @param name
	 * @param dateOfBirth
	 */
	public Actor(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;

	}//End Constructor
	
	
	/**
	 * This is the secondary constructor for Actor
	 * @param name
	 * @param dateOfBirth
	 * @param showsActedIn
	 */
	public Actor(String name, LocalDate dateOfBirth, String showsActedIn) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.showsActedIn.add(showsActedIn);

	}//End Constructor

	
	/**
	 * This is the tertiary constructor for Actor
	 * @param name
	 * @param dateOfBirth
	 * @param showsActedIn
	 */
	public Actor(String name, LocalDate dateOfBirth, ArrayList<String> showsActedIn) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.showsActedIn = showsActedIn;

	}//End Constructor


	//----------------------------------- Getters/Accessors -----------------------------------\\
	/**
	 * This method returns the name
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}


	/**
	 * This method returns the date of birth
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() 
	{
		return dateOfBirth;
	}


	/**
	 * This method returns the array list of TV Shows they have acted in
	 * @return the showsActedIn
	 */
	public ArrayList<String> getShowsActedIn() 
	{
		return showsActedIn;
	}


	//----------------------------------- Setters/Mutators -----------------------------------\\

	/**
	 * This method sets the name
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}


	/**
	 * This method sets the date of birth
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}


	/**
	 * This method sets the array list of shows acted in
	 * @param showsActedIn the showsActedIn to set
	 */
	public void setShowsActedIn(ArrayList<String> showsActedIn) 
	{
		this.showsActedIn = showsActedIn;
	}

	//----------------------------------- General methods -----------------------------------\\
	/**
	 * This method prints the details of the actor object
	 */
	public void printDetails()
	{
		//Declare a date format for outputting correctly
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Print the singular details
		System.out.println("Name: " + getName() + "\nDate Of Birth: " + dateFormat.format(getDateOfBirth()) + "\nAge: " + calculateAge() + "\nStars in:");
		
		for (String tvShowTitles : showsActedIn)
		{
			System.out.println(tvShowTitles);
			
		}//End For

	}//End printDetails
	
	
	/**
	 * This method calculates the number of years are between now and the actor's birthday
	 * @return The age of the actor
	 */
	public int calculateAge()
	{
		//Return the difference in the dates
		return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
		
	}//End calculateAge
	

}
