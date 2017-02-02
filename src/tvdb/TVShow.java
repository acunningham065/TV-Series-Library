package tvdb;

import java.util.ArrayList;


/**
 *
 * This Class holds the structure and behaviours for a TVShow Object
 * 
 * @author 40176468
 *
 */
public class TVShow {
	
	//Declare Instance Variables
	private String title = ""; 
	private String ageRating = "";
	private Genre genre = null;
	private int launchYear = 1927;
	private int totalNumEpisodes = 0; 
	private int episodesPerSeason = 0;
	private ArrayList<Review> reviewList = new ArrayList<Review>();
	private ArrayList<Actor> currentActorsOfShow = new ArrayList<Actor>();
	private ArrayList<Actor> pastActorsOfShow = new ArrayList<Actor>();
	private ArrayList<Episode> episodeList = new ArrayList<Episode>();
	
	
	//------------------------------ Constructors ------------------------------\\
	/**
	 * This is the primary constructor for the TVShow Class
	 * @param title
	 * @param ageRating
	 * @param genre
	 * @param launchYear
	 * @param totalNumEpisodes
	 * @param episodesPerSeason
	 * @param reviewList
	 * @param currentActorsOfShow
	 * @param actorsThatLeftTheShow
	 * @param episodeList
	 */
	public TVShow(String title, String ageRating, Genre genre, int launchYear, int totalNumEpisodes, int episodesPerSeason, ArrayList<Review> reviewList, ArrayList<Actor> currentActorsOfShow, ArrayList<Actor> actorsThatLeftTheShow, ArrayList<Episode> episodeList) 
	{
		this.title = title;
		this.ageRating = ageRating;
		this.genre = genre;
		this.launchYear = launchYear;
		this.totalNumEpisodes = totalNumEpisodes;
		this.episodesPerSeason = episodesPerSeason;
		this.reviewList = new ArrayList<Review>(reviewList);
		this.currentActorsOfShow = new ArrayList<Actor>(currentActorsOfShow);
		this.pastActorsOfShow = new ArrayList<Actor>(actorsThatLeftTheShow);
		this.episodeList = new ArrayList<Episode>(episodeList);
		
	}//End Constructor

	
	//------------------------------ Getters/Accessors ------------------------------\\	
	/**
	 * This method returns the title
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}
	

	/**
	 * This method returns the age rating (e.g. U, PG, 12, 15, 18)
	 * @return The ageRating
	 */
	public String getAgeRating() {
		return ageRating;
	}
	
	
	/**
	 * This method returns the genre
	 * @return The genre
	 */
	public Genre getGenre() {
		return genre;
	}
	
	
	/**
	 * This method returns the launch Year
	 * @return The launchYear
	 */
	public int getLaunchYear() {
		return launchYear;
	}

	
	/**
	 * This method returns the total number of episodes
	 * @return The totalNumEpisodes
	 */
	public int getTotalNumEpisodes() {
		return totalNumEpisodes;
	}

	
	/**
	 * This method returns the number of episodes per season
	 * @return The episodesPerSeason
	 */
	public int getEpisodesPerSeason() {
		return episodesPerSeason;
	}

	
	/**
	 * This method returns the review list array list
	 * @return The reviewList
	 */
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}
		
	
	/**
	 * This method returns the current actors arraylist
	 * @return The currentActorsOfShow
	 */
	public ArrayList<Actor> getCurrentActorsOfShow() {
		return currentActorsOfShow;
	}

	
	/**
	 * This method returns the past actors arraylist
	 * @return The pastActorsOfShow
	 */
	public ArrayList<Actor> getPastActorsOfShow() {
		return pastActorsOfShow;
	}
	
	
	/**
	 * This method returns the episode arraylist
	 * @return The pastActorsOfShow
	 */
	public ArrayList<Episode> getEpisodeList() {
		return episodeList;
	}

	
	//------------------------------ Setters/Mutators ------------------------------\\	
	/**
	 * This method sets the title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	/**
	 * This method stes the age rating
	 * @param ageRating the ageRating to set
	 */
	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}
	
	
	/**
	 * This method returns the genre
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	
	/**
	 * This method sets the launch year
	 * @param launchYear the launchYear to set
	 */
	public void setLaunchYear(int launchYear) {
		this.launchYear = launchYear;
	}

	
	/**
	 * This method sets the total number of episodes
	 * @param totalNumEpisodes the totalNumEpisodes to set
	 */
	public void setTotalNumEpisodes(int totalNumEpisodes) {
		this.totalNumEpisodes = totalNumEpisodes;
	}

	
	/**
	 * This method sets the number of episodes per season
	 * @param episodesPerSeason the episodesPerSeason to set
	 */
	public void setEpisodesPerSeason(int episodesPerSeason) {
		this.episodesPerSeason = episodesPerSeason;
	}
	
	
	/**
	 * @param reviewScores the Review List to set
	 */
	public void setReviewsList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}
	
	
	/**
	 * @param currentActorsOfShow the currentActorsOfShow to set
	 */
	public void setActorsInShow(ArrayList<Actor> actorsInShow) {
		this.currentActorsOfShow = actorsInShow;
	}

	
	/**
	 * @param pastActorsOfShow the pastActorsOfShow to set
	 */
	public void setActorsThatLeftTheShow(ArrayList<Actor> actorsThatLeftTheShow) {
		this.pastActorsOfShow = actorsThatLeftTheShow;
	}
	
	
	/**
	 * @param episodeList the episodeList to set
	 */
	public void setEpisodeList(ArrayList<Episode> episodeList) {
		this.episodeList = episodeList;
	}
	
	
	//------------------------------ Other Methods ------------------------------\\	
	/**
	 * This method calculates the number of complete seasons the TV Show has
	 * @return The number of completed seasons
	 */
	public int calcCompletedSeasons()
	{
		//Return the integer division of the total and the number per season
		return totalNumEpisodes / episodesPerSeason;
		
	}//End Of calcCompletedSeasons

	
	/**
	 * This method adds the review passed in to the review list instance variable
	 * @param reviewToAdd
	 */
	public void rateSeries(Review reviewToAdd) 
	{
		//add new review to system
		reviewList.add(reviewToAdd);
		
	}//End rateSeries
	
	
	/**
	 * This method adds the episode passed in to the episode list instance variable
	 * @param episodeToAdd
	 */
	public void addEpisode(Episode episodeToAdd) 
	{
		//add new episode to system
		episodeList.add(episodeToAdd);
		
	}//End addEpisode
	
	
	/**
	 * This method checks that there were scores there to sum,
	 * If there are it sums the review scores, otherwise it informs the user
	 * there are no reviews yet.
	 * It returns the value of the mean variable
	 * @return
	 */
	public float calcMeanReviewScore()
	{
		//Declare local variables
		float total = 0;
		float mean = 0;

		//Check we don't divide by 0
		if (reviewList.size() > 0)
		{
			//Add all of the scores up
			for (int position = 0; position < reviewList.size(); position++)
			{
				total += reviewList.get(position).getReviewScore();			

			} //End For

			//Calculate the mean
			mean = total / reviewList.size();
		} 
		else
		{
			//Inform user that there are no reviews
			System.out.println("There are no reviews for this show yet");

		}//End If

		//Return the value of mean
		return mean;

	}//End calcMeanReviewScore
	
	
	/**
	 * This method prints all of the class' information to the console as well as
	 * the number of completed seasons and the mean review score
	 */
	public void printBasicDetails()
	{
		//Print all of the simple details to the console here
		System.out.println("Title: " + getTitle() + " Rated: " + getAgeRating() 
		+ "\nFirst Aired: " + getLaunchYear() + "\nTotal Number Of Episodes: " + getTotalNumEpisodes() 
		+ "\nEpisodes Per Season: " + getEpisodesPerSeason() + "\nCompleted Seasons: " + calcCompletedSeasons());
		System.out.println("\nMean Review Score: " + calcMeanReviewScore());

		//Print all of the listed details here
		//Print Header
		System.out.println("\nReviews:");
		
		//iterate through the list - If there are none then it will skip this
		for (Review review : reviewList)
		{
			review.printReview();
			
			System.out.println();
			
		}//End For
		
		
		//Print header
		System.out.println("\nCurrent Actors and Actresses:");
		
		//iterate through the list - If there are none then it will skip this
		for (Actor actor : currentActorsOfShow)
		{
			System.out.println(actor.getName());			

		} //End For
		
		
		//Print header
		System.out.println("\nPast Actors and Actresses:");

		//iterate through the list - If there are none then it will skip this
		for (Actor actor : pastActorsOfShow)
		{
			System.out.println(actor.getName());			

		} //End For
		
		
		//Print header
		System.out.println("\nEpisodes:");

		//iterate through the list - If there are none then it will skip this
		for (Episode episode : episodeList)
		{
			System.out.println(episode.getTitle());			

		} //End For
		
	}//End printDetails
	
	
	/**
	 * This method prints all of the class' information to the console as well as
	 * the number of completed seasons and the mean review score
	 */
	public void printAllDetails()
	{
		//Print all of the simple details to the console here
		System.out.println("Title: " + getTitle() + " Rated: " + getAgeRating() 
		+ "\nFirst Aired: " + getLaunchYear() + "\nTotal Number Of Episodes: " + getTotalNumEpisodes() 
		+ "\nEpisodes Per Season: " + getEpisodesPerSeason() + "\nCompleted Seasons: " + calcCompletedSeasons());
		System.out.println("\nMean Review Score: " + calcMeanReviewScore());

		//Print all of the listed details here
		//Print Header
		System.out.println("\nReviews:");
		
		//iterate through the list - If there are none then it will skip this
		for (Review review : reviewList)
		{
			review.printReview();
			
			System.out.println();
			
		}//End For
		
		
		//Print header
		System.out.println("\nCurrent Actors and Actresses:");
		
		//iterate through the list - If there are none then it will skip this
		for (Actor actor : currentActorsOfShow)
		{
			actor.printDetails();			

		} //End For
		
		
		//Print header
		System.out.println("\nPast Actors and Actresses:");

		//iterate through the list - If there are none then it will skip this
		for (Actor actor : pastActorsOfShow)
		{
			actor.printDetails();				

		} //End For
		
		
		//Print header
		System.out.println("\nEpisodes:");

		//iterate through the list - If there are none then it will skip this
		for (Episode episode : episodeList)
		{
			episode.printDetails();		

		} //End For
		
	}//End printDetails
	

}
