package tvdb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This Class holds the structure and behaviours for an Episode Object
 * 
 * @author 40176468
 *
 */
public class Episode
{
	//Declare Instance Variables
	private int episodeNumber = 0;
	private String title = "";
	private String synopsis = "";
	private LocalDate dateAired = LocalDate.now();
	private int runningTime = 0;
	
	
	/**
	 * This is the primary constructor of the Episode Class
	 * @param episodeNumber
	 * @param title
	 * @param synopsis
	 * @param dateAired
	 * @param runningTime
	 */
	public Episode(int episodeNumber, String title, String synopsis, LocalDate dateAired, int runningTime) {
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.synopsis = synopsis;
		this.dateAired = dateAired;
		this.runningTime = runningTime;
		
	}//End Constructor

	//------------------------------ Getters/Accessors ------------------------------\\	

	/**
	 * @return the episodeNumber
	 */
	public int getEpisodeNumber() {
		return episodeNumber;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}


	/**
	 * @return the dateAired
	 */
	public LocalDate getDateAired() {
		return dateAired;
	}


	/**
	 * @return the runningTime
	 */
	public int getRunningTime() {
		return runningTime;
	}

	//------------------------------ Setters/Mutators ------------------------------\\

	/**
	 * @param episodeNumber the episodeNumber to set
	 */
	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}


	/**
	 * @param dateAired the dateAired to set
	 */
	public void setDateAired(LocalDate dateAired) {
		this.dateAired = dateAired;
	}


	/**
	 * @param runningTime the runningTime to set
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	
	//------------------------------ General Methods ------------------------------\\
	/**
	 * This method prints all of the details of the Episode Class
	 */
	public void printDetails()
	{
		//Declare a date format for outputting correctly
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		System.out.println("Episode " + getEpisodeNumber() + ": " + getTitle() + " | Running Time: " + getRunningTime() + " minutes | Date Aired:  " 
				+ dateFormat.format(getDateAired()) + "\nSynosis: " + getSynopsis());
		
	}//End printDetails
	
	
}
