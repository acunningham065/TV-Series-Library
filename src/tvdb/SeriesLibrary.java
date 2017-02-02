package tvdb;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This is the Class that handles the TV Show Library.
 * That includes adding, editing and reviewing
 * 
 * @author 40176468
 * 
 */
public class SeriesLibrary 
{
	//Declare the global variables and objects
	private ArrayList<TVShow> showLibrary = new ArrayList<TVShow>();
	private ArrayList<Actor> actorList = new ArrayList<Actor>();


	/**
	 * This is the primary constructor of the Series Library Class.
	 * It generates the dummy data on instantiation
	 */
	public SeriesLibrary() 
	{		
		//Read in the dummy data
		showLibrary.addAll(HelperMethods.generateTVShows());	
		actorList.addAll(generateFullActorList());

	}//End constructor


	/**
	 * This method returns the show library
	 * @return The TV Show Library
	 */
	public ArrayList<TVShow> getShowLibrary()
	{
		return showLibrary;		
	}


	/**
	 * This method returns the list of all of the actors
	 * @return the actorList
	 */
	public ArrayList<Actor> getActorList()
	{
		return actorList;
	}


	/**
	 * This method prints the details of every TV Show in the library
	 */
	public void printTVShowDatabase()
	{
		for (TVShow tvShow : showLibrary)
		{
			System.out.println("--------------------------------------------");

			tvShow.printBasicDetails();

		}//End For

		System.out.println("--------------------------------------------\n\n");

	}//End printTVShowDatabase


	/**
	 * This method ask the user to enter the details of a tv show, validates the entries and then
	 * creates the TV Show using the TV Show constructors
	 */
	public void addTVSeries() 
	{
		//Declare local variables
		String nameInput = "", ageRatingInput = "";
		int launchYearInput = 0, totalNumOfEpisodesInput = 0, numOfEpisodeInSeasonInput = 0, numOfReviewsToAdd = 0;
		Genre genreInput = null;
		ArrayList<Review> reviewListInput = new ArrayList<Review>();
		ArrayList<Actor> actorsInShowInput = new ArrayList<Actor>();
		ArrayList<Actor> actorsThatLeftTheShowInput = new ArrayList<Actor>();
		ArrayList<Episode> episodeListInput = new ArrayList<Episode>();


		//Read all required info for the tv series
		//---------------------------- TV Show Name ----------------------------\\
		nameInput = HelperMethods.stringAskReadAndValidate("Please enter the TV Show's name: ", true, true, 5);

		insertBlankLine();

		//---------------------------- Age Rating ----------------------------\\		
		ageRatingInput = readAndValidateAgeRating();

		insertBlankLine();

		//---------------------------- Genre ----------------------------\\
		genreInput = readAndValidateGenre();

		insertBlankLine();

		//---------------------------- Launch Year ----------------------------\\	
		launchYearInput = readAndValidateLaunchYear();

		insertBlankLine();

		//---------------------------- Total Number Of Episodes ----------------------------\\
		totalNumOfEpisodesInput = readAndValidateTotalNumOfEps();

		insertBlankLine();

		//---------------------------- Episodes Per Season ----------------------------\\
		numOfEpisodeInSeasonInput = readAndValidateNumOfEpsPerSeason();

		insertBlankLine();

		//---------------------------- Current Actors ----------------------------\\
		actorsInShowInput = readAndValidateActorList(true, nameInput);

		insertBlankLine();

		//---------------------------- Past Actors ----------------------------\\
		actorsThatLeftTheShowInput = readAndValidateActorList(false, nameInput);

		insertBlankLine();

		//---------------------------- Reviews ----------------------------\\
		numOfReviewsToAdd = HelperMethods.requestAndReadInInteger("Number of reviews to add for this TV Show: ");

		for (int numOfReviews = 0; numOfReviews < numOfReviewsToAdd; numOfReviews++)
		{			
			reviewListInput.add(readAndValidateReview());

		} //End For

		insertBlankLine();

		//---------------------------- Episodes ----------------------------\\
		episodeListInput = readAndValidateEpisodeList(1);

		insertBlankLine();

		//---------------------------- Creating and adding the TV Show Objects to the Series List ----------------------------\\
		showLibrary.add(new TVShow(nameInput, ageRatingInput, genreInput, launchYearInput, totalNumOfEpisodesInput, numOfEpisodeInSeasonInput, reviewListInput, actorsInShowInput, actorsThatLeftTheShowInput, episodeListInput));

		//Print a separating line
		System.out.println("----------------------------------------------------------");

		//Finally Print the details
		showLibrary.get(showLibrary.size() - 1).printBasicDetails();
		
		System.out.println("----------------------------------------------------------\n");

	}//End addTVSeries


	/**
	 * This method prints a numbered list of TV Shows for the user to choose which TV Show they wish to edit.
	 * It then displays the details of said TV Show and asks what field you would like to edit or if you wish to return to the
	 * Main menu. It then calls the appropriate method
	 */
	public void editTVSeries()
	{
		//Declare the local variables
		int userChoice = 0;
		TVShow tvShowToEdit;
		String[] menuOptions = new String[]{"Title", "Age Rating", "Genre", "Launch Year", "Total number of Episodes", "Number of episodes per season", "Reviews", "Actors/Actresses", "Episodes", "Back To Home"};


		tvShowToEdit = MenuSystem.displayAndReadOptionSelectedFromTVShowSelectMenu(showLibrary, "edit");

			
		//At this point we know that the userChoice is valid so print the details of the TV Show
		System.out.println("---------------- TV Show Edit ----------------");
		tvShowToEdit.printBasicDetails();
		insertBlankLine();

		do
		{			
			//Read in their choice for action
			userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(menuOptions, "edit");

			//Switch on their choice
			switch (userChoice)
			{
				case 1:	
					insertBlankLine();
					//Edit title 
					tvShowToEdit.setTitle(HelperMethods.stringAskReadAndValidate("Please enter the new title for " + tvShowToEdit.getTitle(), true, true, 5)); 
					break;

				case 2: 
					insertBlankLine(); 
					//Edit age rating 
					tvShowToEdit.setAgeRating(readAndValidateAgeRating()); 
					break;

				case 3:
					insertBlankLine();
					//Edit Genre
					tvShowToEdit.setGenre(readAndValidateGenre());

				case 4:	
					insertBlankLine(); 
					//Edit launch rating
					tvShowToEdit.setLaunchYear(readAndValidateLaunchYear()); 
					break;

				case 5: 
					insertBlankLine(); 
					//Edit Total Number of episodes
					tvShowToEdit.setTotalNumEpisodes(readAndValidateLaunchYear()); 
					break;

				case 6:	
					insertBlankLine();
					//Edit Number of episodes per season
					tvShowToEdit.setEpisodesPerSeason(readAndValidateNumOfEpsPerSeason()); 
					break;

				case 7:	
					insertBlankLine(); 
					//Edit Reviews
					editReviews(tvShowToEdit);
					break;

				case 8:	
					insertBlankLine(); 
					//Edit Cast Lists
					editCastLists(tvShowToEdit);
					break;

				case 9:
					insertBlankLine();
					//Edit Episodes List
					editEpisodes(tvShowToEdit);
					break;

				case 10:
					//Do nothing as selecting this number will break out of the loop and return to the main menu
					System.out.println("\nReturning to the Main Menu\n"); 
					break;

				default: 
					System.out.println("\nThe option you selected does not exist.\nPlease Try Again."); 
					break;

			}//End Switch

		} while (userChoice != 10); //End do...while

	}//End editTVSeries


	/**
	 * This method prints a numbered list of TV Shows for the user to choose which TV Show they wish to review.
	 * It then calls the method readAndValidateReviewScores. Finally it adds the reviews to the TV Show Object
	 */
	public void rateTVSeries()
	{
		//Declare the local variables
		TVShow showToRate;

		showToRate = MenuSystem.displayAndReadOptionSelectedFromTVShowSelectMenu(showLibrary, "review");

		//At this point we know that the userChoice is valid so ask them to rate it and then assign it to the TV Show
		System.out.println("---------------- TV Show Review ----------------");

		showToRate.rateSeries(readAndValidateReview());	

	}//End rateTVSeries

	/**
	 * This method prints a numbered list of TV Shows for the user to choose which TV Show they wish to add an episode to.
	 * It then calls the readAndValidateEpisodeList passing through either the last episode number or 1
	 * depending on wheter the TV Show has episodes already
	 */
	public void addTVEpisode()
	{
		//Declare local variables
		TVShow showToAddTo = MenuSystem.displayAndReadOptionSelectedFromTVShowSelectMenu(showLibrary, "add an episode to");
		
		insertBlankLine();
		
		//If there are episodes
		if (showToAddTo.getEpisodeList().size() > 0) 
		{
			//Get the last episode number
			showToAddTo.getEpisodeList().addAll(readAndValidateEpisodeList(showToAddTo.getEpisodeList().get(showToAddTo.getEpisodeList().size() - 1).getEpisodeNumber() + 1));
			
		} 
		else 
		{
			//If No episodes yet episode numbers start at 1
			showToAddTo.getEpisodeList().addAll(readAndValidateEpisodeList(1));

		} //End If
		
		insertBlankLine();
		
	}//End addTVEpisode
	
	
	/**
	 * This method prints a numbered list of TV Shows for the user to choose which TV Show they wish to see the episodes of.
	 * It then prints the details of every episode in the list
	 */
	public void printEpisodesForShow()
	{
		//Declare local variables
		TVShow showToPrintEpisodesOf = MenuSystem.displayAndReadOptionSelectedFromTVShowSelectMenu(showLibrary, "print episodes of");
		
		insertBlankLine();
		
		for (Episode episode : showToPrintEpisodesOf.getEpisodeList())
		{
			episode.printDetails();
			
			insertBlankLine();
			
		}//End For
		
	}//End printEpisodesForShow
	

	/** 
	 * This method asks the user to enter a list of episodes
	 * It asks how many episodes the user wants to enter
	 * Ir runs through a for loop which reads in a TV Show Episode's information and adds it to an arraylist
	 * Finally it returns the array list of episodes
	 * @return An arraylist of episodes
	 */
	private ArrayList<Episode> readAndValidateEpisodeList(int episodeCounter) 
	{
		String tempInput = "", episodeTitle = "", synopsis = "";
		int runningTime = 0, numEpisodesToAdd = 0;
		LocalDate dateAired = LocalDate.now();
		ArrayList<Episode> episodeList = new ArrayList<Episode>();


		numEpisodesToAdd = HelperMethods.requestAndReadInInteger("Number of episodes to add for this series: ");

		for(int counter = 0; counter < numEpisodesToAdd; counter++)
		{
			//read the input
			tempInput = HelperMethods.stringAskReadAndValidate("Episode Title: ", false, false, 3);

			//Check if the input is end
			if (!tempInput.trim().toLowerCase().equals("end"))
			{
				episodeTitle = new String(tempInput);

				insertBlankLine();
				
				synopsis = HelperMethods.stringAskReadAndValidate("Episode Synopsis:\n", true, true, 1);
				
				insertBlankLine();

				//TODO IMPROVEMENT - Ensure the air date is not before the show launched
				dateAired = HelperMethods.requestAndReadInDate("the episode air date");
				
				insertBlankLine();

				runningTime = HelperMethods.requestAndReadInInteger("Episode Running Time: ");
				
				insertBlankLine();

				episodeList.add(new Episode(episodeCounter, episodeTitle, synopsis, dateAired, runningTime));

				episodeCounter++;

			} //End If

		}//End For 

		return episodeList;

	}//End readAndValidateEpisodeList


	/**
	 * This method asks the user to enter a review
	 * Ir runs through a for loop which reads in a TV Show Review's information
	 * Finally it returns the review
	 * @return An arraylist of review scores
	 */
	public Review readAndValidateReview() 
	{
		//Declare local variables
		Review review = new Review("", "", LocalDate.now(), 0);

		//Set the author's name
		review.setAuthor(HelperMethods.stringAskReadAndValidate("Please enter your name (or End if you have completed your review): ", false, false, 3));

		insertBlankLine();
		
		//Read in their review
		review.setReview(HelperMethods.stringAskReadAndValidate("Please enter your review now: ", true, true, 1));

		//Date reviewed will always be the time the review is entered on the system
		insertBlankLine();
		
		//Read in the score
		review.setReviewScore(readAndValidateReviewScore(review));
		
		insertBlankLine();
		
		return review;

	}//End readAndValidateReviews


	/**
	 * This method reads a review score in ensuring it is between 0 and 10
	 * @param review
	 * @return reviewScore
	 */
	public float readAndValidateReviewScore(Review review)
	{
		//Declare local variable
		float reviewScore = 0;

		do
		{
			reviewScore = HelperMethods.requestAndReadInFloat("Please enter your score out of 10: ");	

			if (reviewScore < 0 || reviewScore > 10)
			{						
				System.out.println("The score you entered was not between 0 and 10.\nPlease Try Again.\n");

			} //End If

		} while (reviewScore < 0 || reviewScore > 10); //End do...while


		return reviewScore;

	}//End readAndValidateReviewScore


	/**
	 * This method asks the user to enter a how many current or past actors depending on whether the parameter currentActor is true or false they want to enter
	 * It then asks if they are undocumented (i.e. are they on the system). If they aren't part of the system they will be asked to create the actor. 
	 * If they aren't they will be asked to select them from a numbered list
	 * They are added to the arraylist and finally it returns the list of actors
	 * @param currentActor This defines if the actor list will be of current or past actors
	 * @param title This is the title of the TV Show being created. This is used for the acted in list of actors
	 * @return An arraylist of actors
	 */
	private ArrayList<Actor> readAndValidateActorList(boolean currentActor, String title) 
	{
		ArrayList<Actor> actorListInput = new ArrayList<Actor>();
		int numToAdd = 0;
		LocalDate dateOfBirthInput = LocalDate.now();
		String tempInput = "";


		if (currentActor) 
		{
			//Ask how many actors of the current cast they want to add
			numToAdd = HelperMethods.requestAndReadInInteger("Number of actors/actresses that are in the current cast that you would like to add: ");
		} 
		else 
		{
			//Ask how many actors of the past cast they want to add
			numToAdd = HelperMethods.requestAndReadInInteger("Number of actors/actresses that are in the past cast that you would like to add: ");

		} //End If

		insertBlankLine();

		for(int counter = 0; counter < numToAdd; counter++)
		{
			//Ask if they are a new actor (i.e. not yet documented on the system)
			tempInput = HelperMethods.stringAskReadAndValidate("Are they an undocumented actor? (Y/N): ", false, false, 1);

			insertBlankLine();
			
			if (tempInput.trim().equalsIgnoreCase("y")) 
			{
				//read the input
				tempInput = HelperMethods.stringAskReadAndValidate("Actor/Actress Name: ", false, false, 3);

				insertBlankLine();
				
				//Ask for date of birth
				dateOfBirthInput = HelperMethods.requestAndReadInDate("the actor's birthday");

				//Assign the input
				actorListInput.add(new Actor(tempInput, dateOfBirthInput, title));
				actorList.add(new Actor(tempInput, dateOfBirthInput, title));

			}
			else
			{
				insertBlankLine();
				
				Actor actorAdding = MenuSystem.displayActorsAndReadSelection(actorList);
				
				actorListInput.add(actorAdding);
				actorAdding.getShowsActedIn().add(title);

			}//End If
			
			insertBlankLine();
			
		}//End For

		return actorListInput;

	}//End readAndValidateActorList


	/**
	 * This method asks for the number of episodes per season and will ensure that is a valid
	 * integer before returning it
	 * @return The number of episodes per season
	 */
	private int readAndValidateNumOfEpsPerSeason() 
	{
		//Declare local variables
		int numOfEpisodeInSeasonInput = 0;
		boolean validInput = false;

		do
		{
			//Read Number Of Episodes per season
			numOfEpisodeInSeasonInput = HelperMethods.requestAndReadInInteger("Number of episodes per season: ");

			if (numOfEpisodeInSeasonInput > 0)
			{
				//A season can't have minus episodes therefore this is valid
				validInput = true;
			}
			else
			{
				//Inform user of their error
				System.out.println("A season can't have less than 1 episode.\nPlease Try Again\n");

			} //End If

		} while (!validInput); //End do...while

		return numOfEpisodeInSeasonInput;

	}//End readAndValidateNumOfEpsPerSeason


	/**
	 * This method asks for the total number of episodes broadcast and will ensure that is a valid
	 * integer before returning it
	 * @return The number of episodes ever broadcast
	 */
	private int readAndValidateTotalNumOfEps() 
	{
		int totalNumOfEpisodesInput = 0;
		boolean validInput = false;

		do
		{
			//Read Total Number Of Episodes
			totalNumOfEpisodesInput = HelperMethods.requestAndReadInInteger("Number of episodes broadcasted: ");

			if (totalNumOfEpisodesInput >= 0)
			{
				//A series can't have minus episodes therefore this is valid
				validInput = true;
			} 
			else
			{
				//Inform user of their error
				System.out.println("A series can't have less than 0 episodes.\nPlease Try Again\n");

			}//End If

		} while (!validInput); //End do...while

		return totalNumOfEpisodesInput;

	}//End readAndValidateTotalNumOfEps


	/**
	 * This method asks for the Year it was first broadcast and will ensure that is a valid
	 * integer before returning it
	 * @return The Year it was first broadcast
	 */
	private int readAndValidateLaunchYear() 
	{
		//Declare local variables
		int launchYearInput = 1927;
		boolean validInput = false;
		do
		{
			//Read Launch Year
			launchYearInput = HelperMethods.requestAndReadInInteger("TV Show Launch Year (in the form YYYY): ");

			//If not between the possible dates
			if (!(launchYearInput > 1925 && launchYearInput <= (LocalDate.now().getYear() + 1)))
			{
				//Inform user of error
				System.out.println("The launch year entered is not valid.\nYou can't have reviews for a series that launched before TV or more than a year in advance.\n");

				//Date entered is invalid
				validInput = false;				
			}
			else
			{
				validInput = true;

			}//End If

		} while (!validInput); //End do...while

		return launchYearInput;

	}//End readAndValidateLaunchYear


	/**
	 * This method prints a numbered list of genres for the user to pick from
	 * @return The TV Show Genre
	 */
	private Genre readAndValidateGenre()
	{
		//Declare local variables
		int userChoice = 0, genreCounter = 1;
		Genre genreInput = null;

		for (Genre genre : Genre.values())
		{			
			System.out.println(genreCounter + ". " + genre);
			genreCounter++;

		}//End For

		do
		{
			userChoice = HelperMethods.requestAndReadInInteger("Please select the genre (numerically): ");

			switch (userChoice)
			{
				case 1:	genreInput = Genre.ACTION; break;
				case 2:	genreInput = Genre.ADVENTURE; break;
				case 3:	genreInput = Genre.COMEDY; break;
				case 4:	genreInput = Genre.DOCUMENTARY; break;
				case 5:	genreInput = Genre.DRAMA; break;
				case 6:	genreInput = Genre.HORROR; break;
				case 7:	genreInput = Genre.MUSICAL; break;
				case 8:	genreInput = Genre.ROMANCE;	break;
				case 9:	genreInput = Genre.SCIENCEFICTION; break;
				case 10:genreInput = Genre.THRILLER; break;
				default: System.out.println("The data you entered did not correspond to a genre.\n"); break;

			}//End Switch

		} while (genreInput == null); //End do...while


		return genreInput;

	}//End readAndValidateGenre


	/**
	 * This method asks for the age rating and will ensure that is a valid
	 * option (i.e. U, PG, 12, 15, 18) before returning it
	 * @return The age rating of the TV Show
	 */
	private String readAndValidateAgeRating() 
	{
		//Declare local variables
		String ageRatingInput = "";
		boolean validInput = false;
		do
		{
			//Read TV Show Age Rating (U, PG, 12, 15, 18)
			ageRatingInput = HelperMethods.stringAskReadAndValidate("Please enter the TV Show's Age Rating (U, PG, 12, 15, 18): ", true, false, 1);

			if (ageRatingInput.equalsIgnoreCase("U") || ageRatingInput.equalsIgnoreCase("PG") || ageRatingInput.equalsIgnoreCase("12") || ageRatingInput.equalsIgnoreCase("15") || ageRatingInput.equalsIgnoreCase("18"))
			{
				//The input is valid
				validInput = true;
			} 
			else 
			{
				//Inform user of their error
				System.out.println("The rating you entered was invalid.\n");

			}//End If

		} while (!validInput); //End do...while

		return ageRatingInput;

	}//End readAndValidateAgeRating


	/**
	 * This method simply inserts a blank line. It solely exists for readability
	 */
	private void insertBlankLine() 
	{
		System.out.println();

	}//End insertBlankLine


	/**
	 * This method prints all of the actors that act/have acted in the entire library of show
	 */
	public ArrayList<Actor> generateFullActorList()
	{
		//Declare local variables
		ArrayList<Actor> actorList = new ArrayList<Actor>();

		//Print the list of all actors - For every TV Show in the Library
		for (TVShow tvShow : showLibrary)
		{
			//Add every actor currently acting in the show
			for (Actor actor : tvShow.getCurrentActorsOfShow()) 
			{
				actorList.add(actor);

			}//End For

			//Add every actor ever been on the show
			for (Actor actor : tvShow.getPastActorsOfShow()) 
			{
				actorList.add(actor);

			}//End For

		}//End For

		return actorList;

	}//End generateFullActorList


	/**
	 * This method prints an actors details 
	 */
	public void displayActorsDetails()
	{

		for (Actor actor : actorList)
		{
			System.out.println("--------------------------------------");

			actor.printDetails();

		}//End For		

		System.out.println();

	}//End displayActorsDetails


	/**
	 * This method asks the user to enter the details of an actor, it validates the input.
	 * If the inputs are valid, they will create an actor object and add them to the list of all actors
	 */
	public void addActor()
	{
		//Declare local variables
		String nameInput = "";
		LocalDate dateOfBirthInput = LocalDate.now();
		ArrayList<String> starredInShows = new ArrayList<String>();

		//read the input
		nameInput = HelperMethods.stringAskReadAndValidate("Actor/Actress Name: ", false, false, 3);

		insertBlankLine();

		//Ask for date of birth
		dateOfBirthInput = HelperMethods.requestAndReadInDate("the actor's birthday");

		insertBlankLine();

		//Ask for shows starred in
		starredInShows = validateTVShowStarredIn();
		
		insertBlankLine();

		actorList.add(new Actor(nameInput, dateOfBirthInput, starredInShows));

	}//End addActor


	/**
	 * This method prints a numbered list of actors for the user to choose which actor they wish to edit.
	 * It then displays the details of said actor and asks what field they would like to edit or if you wish to return to the
	 * Actor menu. It then calls the appropriate method
	 */
	public void editActorFromFullList()
	{
		//Declare local variables
		int userChoice = 0;
		Actor actorToEdit = MenuSystem.displayActorsAndReadSelection(actorList);

		do
		{
			System.out.println("1. Name\n2. Date Of Birth\n3. Shows Starred In\n4. Return to Actor/Actress Menu");

			userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the field you wish to edit: ");

			System.out.println();
			
			switch (userChoice)
			{
				case 1:	insertBlankLine(); actorToEdit.setName(HelperMethods.stringAskReadAndValidate("Actor/Actress Name: ", false, false, 3)); break;
				case 2:	insertBlankLine(); actorToEdit.setDateOfBirth(HelperMethods.requestAndReadInDate("the actor's birthday"));	break;
				case 3:	insertBlankLine(); actorToEdit.setShowsActedIn(validateTVShowStarredIn());	break;
				case 4:	/*Do nothing as the loop will break now*/ break;
				default: System.out.println("The selection you made was not a valid option.\nPlease Try Again"); break;

			}//End Switch
			
			System.out.println();

		}while(userChoice != 4); //End do...while

	}//End editActor


	/**
	 * This method reads in a list of shows titles
	 * @return The arraylist of the shows the actor is/has been in
	 */
	private ArrayList<String> validateTVShowStarredIn()
	{
		//Declare local variables
		ArrayList<String> starredInShows = new ArrayList<String>();
		String tempInput = "";

		do
		{
			do
			{				
				//Ask if finished entering actors
				tempInput = HelperMethods.stringAskReadAndValidate("Are you finished associating shows? (Y/N): ", false, false, 1);

			}while(!tempInput.trim().equalsIgnoreCase("Y") && !tempInput.trim().equalsIgnoreCase("N")); //End do...while


			if (tempInput.trim().equalsIgnoreCase("N")) 
			{	
				//Read in string - TODO IMPROVEMENT: Change so they can only select TV shows in the library
				starredInShows.add(HelperMethods.stringAskReadAndValidate("Enter the name of the show they starred in: ", true, true, 5));

			} //End If		

		} while (!tempInput.trim().equalsIgnoreCase("Y")); //End do...while

		return starredInShows;

	}//End validateTVShowStarredIn


	/**
	 * This method prints a numbered list of episodes for the user to choose which episode they wish to edit.
	 * It then displays the details of said episode and asks what field you would like to edit or if you wish to return to the
	 * Main menu. It then calls the appropriate method
	 * @param showToEdit
	 */
	private void editEpisodes(TVShow showToEdit)
	{
		//Declare local variables
		int counter = 1, userChoice = 0;
		Episode episodeToEdit = new Episode(0, "", "", null, 0);
		String tempInput = "";
		String[] editOptions = {"Episode Number", "Episode Title", "Synopsis", "Running Time", "Return To Edit Menu"};

		if (showToEdit.getEpisodeList().size() > 0)
		{
			do
			{
				for (Episode episode : showToEdit.getEpisodeList())
				{
					System.out.print("\n" + counter + ". ");
					episode.printDetails();

					counter++;

				} //End For		
				
				insertBlankLine();

				userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the episode you want to edit: ");


				if (userChoice >= 1 && userChoice <= showToEdit.getEpisodeList().size())
				{
					episodeToEdit = showToEdit.getEpisodeList().get(userChoice - 1);
				}
				else
				{
					System.out.println("The number you entered was not associated with an episode.\nPlease Try Again");

				} //End If

			} while (userChoice < 1 || userChoice > showToEdit.getEpisodeList().size()); //End do...while


			System.out.println("------------------ Episode Editing ------------------");
			episodeToEdit.printDetails();
			insertBlankLine();

			//Print Edit Options and read back the int
			userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(editOptions, "edit");


			switch (userChoice)
			{
				case 1: episodeToEdit.setEpisodeNumber(HelperMethods.requestAndReadInInteger("Enter the Episode Number: ")); break;
				case 2: episodeToEdit.setTitle(HelperMethods.stringAskReadAndValidate("Please enter the Episode Title: ", true, true, 1)); break;
				case 3: episodeToEdit.setSynopsis(HelperMethods.stringAskReadAndValidate("Episode Synopsis:\n", true, true, 1)); break;
				case 4: episodeToEdit.setRunningTime(HelperMethods.requestAndReadInInteger("Enter the Episode Running Time: ")); break;				
				case 5: /*Do Nothing as it will return to the Edit menu after the switch */ break;
				default: System.out.println("The option you selected was invalid"); break;

			}//End Switch

		}
		else
		{
			//No Episodes
			do
			{				
				System.out.println("No Episodes Exist\nWould like to add Episodes? (Y/N)");

			}while(!tempInput.equalsIgnoreCase("y") || !tempInput.equalsIgnoreCase("n"));

			if (tempInput.equalsIgnoreCase("y"))
			{
				showToEdit.getEpisodeList().addAll(readAndValidateEpisodeList(1));
			}
			else
			{
				System.out.println("\nReturning To Menu\n");

			} //End If


		} //End If


	}//End editEpisodes


	/**
	 * This method prints a numbered list of reviews for the user to choose which review they wish to edit.
	 * It then displays the details of said review and asks what field you would like to edit or if you wish to return to the
	 * Main menu. It then calls the appropriate method 
	 * @param showToEdit
	 */
	private void editReviews(TVShow showToEdit)
	{
		//Declare local variables
		int counter = 1, userChoice = 0;
		Review reviewToEdit = new Review("", "", 0);
		String[] editOptions = {"Author", "Review", "Review Score", "Return To Edit Menu"};

		if (showToEdit.getReviewList().size() > 0)
		{
			do
			{
				for (Review review : showToEdit.getReviewList())
				{
					System.out.print("\n" + counter + ". ");
					review.printReview();

					counter++;

				} //End For		

				userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the review you want to edit: ");


				if (userChoice >= 1 && userChoice <= showToEdit.getReviewList().size())
				{
					reviewToEdit = showToEdit.getReviewList().get(userChoice - 1);
				}
				else
				{
					System.out.println("The number you entered was not associated with a review.\nPlease Try Again");

				} //End If

			} while (userChoice < 1 || userChoice > showToEdit.getReviewList().size()); //End do...while

			System.out.println("------------------ Review Editing ------------------");
			reviewToEdit.printReview();
			insertBlankLine();

			//Print Edit Options and read back the int
			userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(editOptions, "edit");


			switch (userChoice)
			{
				case 1: reviewToEdit.setAuthor(HelperMethods.stringAskReadAndValidate("Please enter your name: ", false, false, 3)); break;
				case 2: reviewToEdit.setReview(HelperMethods.stringAskReadAndValidate("Please enter your review: ", true, true, 1)); break;
				case 3: reviewToEdit.setReviewScore(readAndValidateReviewScore(reviewToEdit));
				case 4: /*Do Nothing as it will return to the Edit menu after the switch */ break;
				default: System.out.println("The option you selected was invalid");break;

			}//End Switch

		}
		else
		{
			//No Reviews
			System.out.println("No Reviews Exist");

		} //End If

	}//End editReviews


	/**
	 * This method prints a numbered list of options related to cast lists for the user to choose one.
	 * It then calls the appropriate method and in turn causes the neccessary changes to occur
	 * @param showToEdit
	 */
	private void editCastLists(TVShow showToEdit)
	{
		//Declare local variables
		int userChoice = 0;
		String[] editActorOptions = {"Add Actor To Current Cast", "Add Actor To Past Cast", "Move Actor From Current Cast to Past Cast", "Move Past Actor From Past Cast to Current Cast", "Return To Edit Menu"};

		userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(editActorOptions, "edit");

		switch (userChoice)
		{
			case 1: insertBlankLine(); addActorToCast(true, showToEdit); break;
			case 2: insertBlankLine(); addActorToCast(false, showToEdit); break;
			case 3: insertBlankLine(); moveActorFromCastList(true, showToEdit); break;
			case 4: insertBlankLine(); moveActorFromCastList(false, showToEdit); break;
			case 5: /*Don't do anything as it will return to menu after switch*/ break;
			default: System.out.println("\nThe option you selected was invalid"); break;

		}//End Switch

	}//End editCastLists


	/**
	 * This method prints a numbered list of all actors for the user to select one.
	 * It then checks if the user selected one or if they entered an unassociated number.
	 * If a valid actor was picked, it checks if they are in either the current or past casts.
	 * If they are in neither it will add them to the appropriate list
	 * @param currentCast
	 * @param showToEdit
	 */
	private void addActorToCast(boolean currentCast, TVShow showToEdit)
	{
		//Declare local variables
		Actor actorToAdd = MenuSystem.displayActorsAndReadSelection(actorList);

		insertBlankLine();

		if(actorToAdd != null)
		{
			if (currentCast)
			{
				//If the actor isn't in either list
				if (!showToEdit.getCurrentActorsOfShow().contains(actorToAdd) && !showToEdit.getPastActorsOfShow().contains(actorToAdd))
				{
					//Add it to current cast
					showToEdit.getCurrentActorsOfShow().add(actorToAdd);
				}
				else
				{
					System.out.println("The actor you selected is either already listed or is a past cast member");
				} //End If

			}
			else
			{
				//If the actor isn't in either list
				if (!showToEdit.getPastActorsOfShow().contains(actorToAdd) && !showToEdit.getCurrentActorsOfShow().contains(actorToAdd))
				{
					//Add it to past cast
					showToEdit.getPastActorsOfShow().add(actorToAdd);
				}
				else
				{
					System.out.println("The actor you selected is either already listed or is a current cast member");
				} //End If

			} //End If

		}//End If - Error message to user is handled by the displayActorsAndReadSelection method

	}//End addActorToCast


	/**
	 * This method prints a numbered list of actors from either the current or past cast for the user to select one.
	 * It then checks if the user selected one or if they entered an unassociated number.
	 * If a valid actor was picked, it removes them from their current list and adds them to the other.
	 * @param currentCast
	 * @param showToEdit
	 */
	private void moveActorFromCastList(boolean currentCastToPastCast, TVShow showToEdit)
	{
		//Declare local variables
		Actor actorToAdd = null;

		if(currentCastToPastCast)
		{
			actorToAdd = MenuSystem.displayActorsAndReadSelection(showToEdit.getCurrentActorsOfShow());

			if(actorToAdd != null)
			{
				//Remove from current cast list
				showToEdit.getCurrentActorsOfShow().remove(actorToAdd);

				//Add to past actor list
				showToEdit.getPastActorsOfShow().add(actorToAdd);

			}//End If
		}		
		else
		{
			actorToAdd = MenuSystem.displayActorsAndReadSelection(showToEdit.getPastActorsOfShow());

			if(actorToAdd != null)
			{
				//Remove from current cast list
				showToEdit.getPastActorsOfShow().remove(actorToAdd);

				//Add to past actor list
				showToEdit.getCurrentActorsOfShow().add(actorToAdd);

			}//End If
		}

	}//End moveActorFromCastList


}
