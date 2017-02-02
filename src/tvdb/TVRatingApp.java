package tvdb;

import java.util.ArrayList;

/**

 * This is the Main Class for the TV Review App
 * This class allows the navigation to the various menus and
 * provides the search functionality
 * 
 * @author 40176468
 *
 */
public class TVRatingApp
{

	//Declare Global Variables and Objects
	public static SeriesLibrary TVShowDatabase = new SeriesLibrary();

	/**
	 * This is the main method of the TV Rating Application
	 * It will loop the calling of the main menu and calling the appropriate methods
	 * @param args
	 */
	//TODO IMPROVEMENT - Add delete options and save tv shows and actors to databases/text files	
	public static void main(String[] args)
	{
		//Declare local variables and objects
		int userChoice = 0;
		String[] menuOptions = new String[]{"Display TV Series Database", "Add a TV Series", "Edit a TV Series", "Rate a TV Series", "Add An Episode To A Show", "Search For a TV Series", "Print TV Show Episodes", "Actors and Actresses Menu", "Exit Application"};

		do
		{						
			//Print the menu and get the user's choice
			userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(menuOptions, "use");

			//Switch on their choice
			switch (userChoice)
			{
				case 1: System.out.println("\n"); TVShowDatabase.printTVShowDatabase(); break;
				case 2:	System.out.println("\n"); TVShowDatabase.addTVSeries(); break;
				case 3: System.out.println("\n"); TVShowDatabase.editTVSeries(); break;
				case 4:	System.out.println("\n"); TVShowDatabase.rateTVSeries(); break;
				case 5: System.out.println("\n"); TVShowDatabase.addTVEpisode(); break;
				case 6: System.out.println("\n"); searchForShow(); break;
				case 7: System.out.println("\n");TVShowDatabase.printEpisodesForShow(); break;
				case 8: System.out.println("\n"); actorActions(); break;
				case 9: System.out.println("Goodbye"); break;
				default: System.out.println("The selection you made was invalid.\nPlease choose one of the following options\n"); break;

			}//End Switch

		} while (userChoice != 9); //End do...while

	}//End Main
	
	
	/**
	 * This is the method for displaying the actor/actress menu
	 * This brings up the menu for displaying the list of all actors, adding, editing and searching actors
	 */
	private static void actorActions()
	{
		//Declare local variables
		int userChoice = 0;
		String[] menuOptions = new String[]{"Display All Actors/Actresses", "Add an Actor/Actress", "Edit an Actor/Actress", "Search for an Actor/Actress", "Return to Main Menu"};


		do
		{
			userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(menuOptions, "use");
			
			switch (userChoice)
			{
				case 1: System.out.println("\n"); TVShowDatabase.displayActorsDetails(); break;
				case 2:	System.out.println("\n"); TVShowDatabase.addActor();	break;
				case 3:	System.out.println("\n");TVShowDatabase.editActorFromFullList();	break;
				case 4:	System.out.println("\n");searchForActor(); break;
				case 5:	/*Return to Main Menu*/	break;
				default: System.out.println("The selection you made was invalid.\nPlease choose one of the following options\n"); break;

			}//End Switch			

		} while (userChoice != 5); //End do...while
		
		System.out.println();
		
	}//End actorActions
	
	
	/**
	 * This method displays a menu for search options for the actors
	 */
	private static void searchForActor()
	{
		//Declare local variables
		int userChoice = 0;

		do
		{
			System.out.println("1. Name\n2. Return to Actor/Actress Menu");

			userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the an option: ");

			switch (userChoice)
			{
				case 1:	searchActorName(TVShowDatabase.getActorList());	break;
				case 2:	/*Do nothing as the loop will break now*/ break;
				default: System.out.println("The selection you made was not a valid option.\nPlease Try Again");	break;

			}//End Switch

			System.out.println();
			
		}while(userChoice != 2); //End do...while
		
	}//End searchForActor
	
	
	/**
	 * This method uses a for loop to search through the passed list of actors.
	 * It checks if the name of the current actor retrieved from the list contains the name entered
	 * @param actorList
	 */
	private static void searchActorName(ArrayList<Actor> actorList)
	{
		//Declare local variables
		String nameToSearch = "";
		ArrayList<Actor> searchResults = new ArrayList<Actor>();
		
		nameToSearch = HelperMethods.stringAskReadAndValidate("Enter the actor's name (fully or partially): ", false, false, 3);
		
		//For every actor in the list check if they match
		for (Actor actor : actorList)
		{
			if (actor.getName().contains(nameToSearch))
			{				
				searchResults.add(actor);

			} //End If
			
		}//End For
		
		System.out.println("\n-------------------------- Search Results --------------------------\n");
		
		//Check if there are results
		if (searchResults.size() > 0)
		{
			for (Actor actor : searchResults)
			{
				actor.printDetails();		
				
			}//End For
		}
		else
		{
			//No Results
			System.out.println("No Results Found");
			
		} //End If
		
		System.out.println();
		
	}//End searchActorName
	
	
	/**
	 * This method displays the menu for search options for the TV Shows
	 * It then switches on the user choice and calls the appropriate method
	 */
	private static void searchForShow()
	{
		//Declare local variables
		int userChoice = 0;
		String[] menuOptions = new String[]{"Title", "Age Rating", "Genre", "Launch Year", "Total number of Episodes", "Number of episodes per season", "Reviews", "Current Actors/Actresses", "Past Actors/Actresses", "Episodes", "Back To Home"};

		do
		{
			userChoice = MenuSystem.displayAndReadOptionSelectedFromMenus(menuOptions, "search with");

			switch (userChoice)
			{
				case 1: System.out.println("\n"); searchTitle(TVShowDatabase.getShowLibrary());	break;
				case 2: System.out.println("\n"); searchAgeRating(TVShowDatabase.getShowLibrary()); break;
				case 3: System.out.println("\n"); searchGenre(TVShowDatabase.getShowLibrary()); break;
				case 4:	 System.out.println("\n"); searchLaunchYear(TVShowDatabase.getShowLibrary()); break;
				case 5: System.out.println("\n"); searchTotalNumEpisodes(TVShowDatabase.getShowLibrary());	break;
				case 6: System.out.println("\n"); searchNumEpisodesPerSeason(TVShowDatabase.getShowLibrary()); break;
				case 7: System.out.println("\n"); searchReviews(TVShowDatabase.getShowLibrary()); break;
				case 8: System.out.println("\n"); searchShowsForActorName(TVShowDatabase.getShowLibrary(), true); break;
				case 9: System.out.println("\n"); searchShowsForActorName(TVShowDatabase.getShowLibrary(), false); break;
				case 10: System.out.println("\n"); searchEpisodeTitle(TVShowDatabase.getShowLibrary()); break;
				case 11: System.out.println("\n"); /*For Main Menu Do nothing as the while loop will break out*/ break;
				default: System.out.println("\n"); System.out.println("The selection you made was invalid.\nPlease choose one of the following options\n"); break;

			}//End Switch

		} while (userChoice != 11); //End do...while

	}//End searchForShow

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It checks if the title of the current tv show retrieved from the list contains the title entered
	 * @param TVDatabase
	 */
	private static void searchTitle(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		String titleToSearch = "";
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		//Ask and read title to search for
		titleToSearch = HelperMethods.stringAskReadAndValidate("Please enter the title (fully or partially) of the show(s): ", true, true, 1); 

		//Search through the TV Show Database and add any shows that match to a list
		for (TVShow tvShow : TVShowDatabase.getShowLibrary())
		{
			if (tvShow.getTitle().toLowerCase().contains(titleToSearch.toLowerCase()))
			{
				searchResults.add(tvShow);				

			} //End If

		}//End For

		//Print Results out to user
		printTVShowResults(searchResults);

	}//End searchTitle

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It checks if the age rating of the current tv show retrieved from the list contains the age rating entered 
	 * @param TVDatabase
	 */
	private static void searchAgeRating(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		String ageRatingToSearch = "";
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		//Ask and read age rating to search for
		ageRatingToSearch = HelperMethods.stringAskReadAndValidate("Please enter the age rating (U, PG, 12, 15, 18) of the show(s): ", true, false, 1); 

		//Search through the TV Show Database and add any shows that match to a list
		for (TVShow tvShow : TVDatabase)
		{
			if (tvShow.getAgeRating().toLowerCase().contains(ageRatingToSearch.toLowerCase()))
			{
				searchResults.add(tvShow);			

			} //End If

		}//End For

		//Print Results out to user
		printTVShowResults(searchResults);

	}//End searchTitle

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It prints out a numbered list of genres and asks the user to select one
	 * It checks if the genre of the current tv show retrieved from the list is the same as the genre selected
	 * @param TVDatabase
	 */
	private static void searchGenre(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		int userChoice = 0, genreCounter = 1;
		Genre genreToSearch = null;
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		//Print the genre list
		for (Genre genre : Genre.values())
		{			
			System.out.println(genreCounter + ". " + genre);
			genreCounter++;

		}//End For

		//Ask for choice
		userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the genre you wish to search for: ");


		switch (userChoice)
		{
			case 1:	genreToSearch = Genre.ACTION; break;
			case 2:	genreToSearch = Genre.ADVENTURE; break;
			case 3:	genreToSearch = Genre.COMEDY; break;
			case 4:	genreToSearch = Genre.DOCUMENTARY; break;
			case 5:	genreToSearch = Genre.DRAMA; break;
			case 6:	genreToSearch = Genre.FANTASY; break;
			case 7:	genreToSearch = Genre.HORROR; break;
			case 8:	genreToSearch = Genre.MUSICAL; break;
			case 9:	genreToSearch = Genre.ROMANCE; break;
			case 10: genreToSearch = Genre.SCIENCEFICTION; break;
			case 11: genreToSearch = Genre.THRILLER; break;
			default: System.out.println("\nThe selection you made was invalid.\nPlease choose one of the following options\n");	break;

		}//End Switch

		for (TVShow tvShow : TVDatabase)
		{
			if (tvShow.getGenre().equals(genreToSearch))
			{
				searchResults.add(tvShow);				

			} //End If

		}//End For		

		//Print Results out to user
		printTVShowResults(searchResults);

	}//End searchGenre

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It checks if the launch year of the current tv show retrieved from the list is the same as the launch year entered
	 * @param TVDatabase
	 */
	private static void searchLaunchYear(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		int launchYearToSearch = 0;
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		//Ask and read launch year to search for
		launchYearToSearch = HelperMethods.requestAndReadInInteger("Please enter the launch year of the show(s): "); 

		//Search through the TV Show Database and add any shows that match to a list
		for (TVShow tvShow : TVDatabase)
		{
			if (tvShow.getLaunchYear() == launchYearToSearch)
			{
				searchResults.add(tvShow);				

			} //End If

		}//End For


		//Print Results out to user
		printTVShowResults(searchResults);

	}//End searchLaunchYear

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It checks if the total number of episodes of the current tv show retrieved from the list is the same as the number of episodes entered
	 * @param TVDatabase
	 */
	private static void searchTotalNumEpisodes(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		int totalNumEpisodesToSearch = 0;
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		//Ask and read total number of episodes to search for
		totalNumEpisodesToSearch = HelperMethods.requestAndReadInInteger("Please enter the total number of episodes broadcast of the show(s): ");

		//Search through the TV Show Database and add any shows that match to a list
		for (TVShow tvShow : TVDatabase)
		{
			if (tvShow.getTotalNumEpisodes() == totalNumEpisodesToSearch)
			{
				searchResults.add(tvShow);				

			} //End If

		}//End For

		//Print Results out to user
		printTVShowResults(searchResults);

	}//End searchTotalNumEpisodes

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It checks if the number of eps per season of the current tv show retrieved from the list is the same as the number of eps per season
	 * @param TVDatabase
	 */
	private static void searchNumEpisodesPerSeason(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		int numEpisodesPerSeasonToSearch = 0;
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		//Ask and read total number of episodes to search for
		numEpisodesPerSeasonToSearch = HelperMethods.requestAndReadInInteger("Please enter the number of episodes per season of the show(s): ");

		//Search through the TV Show Database and add any shows that match to a list
		for (TVShow tvShow : TVDatabase)
		{
			if (tvShow.getEpisodesPerSeason() == numEpisodesPerSeasonToSearch)
			{
				searchResults.add(tvShow);				

			} //End If

		}//End For

		//Print Results out to user
		printTVShowResults(searchResults);

	}//End searchNumEpisodesPerSeason

	
	/**
	 * This method prints a numbered list of search options for reviews.
	 * The user is asked to select an option. It then switches on the option and calls the appropriate method
	 * @param TVDatabase
	 */
	private static void searchReviews(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		int userChoice = 0;
		String[] reviewOptions = new String[]{"Author", "Mean Review Score", "Return to Field Selection Menu"};
	
		do {
			//Display review search options
			for (int pos = 0; pos < reviewOptions.length; pos++) 
			{			
				System.out.println((pos + 1) + ". " + reviewOptions[pos]);

			} //End For

			userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the field you wish to search by: ");

			switch (userChoice) 
			{
				case 1:	System.out.println(); searchAuthors(TVDatabase);	break;
				case 2: System.out.println(); searchMeanReviewScore(TVDatabase); break;
				case 3: /*Do nothing as we escape the loop at this point*/ break;
				default: System.out.println("The option you selected was not valid.\nPlease Try Again\n"); break;

			}//End Switch

		} while (userChoice != reviewOptions.length); //End Do..While
				
		System.out.println();
		
	}//End searchReviews
	
	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It then searches through the review list of the tv show retrieved
	 * It checks if the author of the current tv show review retrieved from the list contains the author name entered
	 * @param TVDatabase
	 */
	private static void searchAuthors(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variable
		String authorSearchString = "";
		ArrayList<Review> searchResults = new ArrayList<Review>();
		ArrayList<String> TVShowTitles = new ArrayList<String>();
		
		
		authorSearchString = HelperMethods.stringAskReadAndValidate("\nPlease enter the author's name (fully or partially) to search for: ", false, false, 1);
		
		for (int posInTVShowList = 0; posInTVShowList < TVDatabase.size(); posInTVShowList++) 
		{
			for (Review review: TVDatabase.get(posInTVShowList).getReviewList()) 
			{
				if (review.getAuthor().toLowerCase().contains(authorSearchString.toLowerCase()))
				{
					searchResults.add(review);
					TVShowTitles.add(TVDatabase.get(posInTVShowList).getTitle());
					
				} //End If

			} //End For
			
		} //End For
		
		System.out.println();
		
		printReviewResults(searchResults, TVShowTitles);	
		
	}//End searchAuthors
	
	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It checks if the mean review score of the current tv show retrieved from the list is the same as the mean review score entered
	 * @param TVDatabase
	 */
	private static void searchMeanReviewScore(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variables
		float reviewScoreSearch = 0;
		ArrayList<Review> searchResults = new ArrayList<Review>();
		ArrayList<String> TVShowTitles = new ArrayList<String>();
		
		reviewScoreSearch = HelperMethods.requestAndReadInFloat("Please enter the mean review score you wish to search for: ");
		
		for (TVShow tvShow : TVDatabase)
		{
			if (tvShow.calcMeanReviewScore() == reviewScoreSearch)
			{
				searchResults.addAll(tvShow.getReviewList());	
				TVShowTitles.add(tvShow.getTitle());

			} //End If
						
		}//End For
		
		printReviewResults(searchResults, TVShowTitles);
		
	}//End searchMeanReviewScore

	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * Depending on if the variable currentActors it will search the list of current or past actors
	 * @param TVDatabase
	 * @param currentActors
	 */
	private static void searchShowsForActorName(ArrayList<TVShow> TVDatabase, boolean currentActors)
	{
		//Declare local variable
		String nameSearchString = "";
		ArrayList<TVShow> searchResults = new ArrayList<TVShow>();

		nameSearchString = HelperMethods.stringAskReadAndValidate("Please enter the actor's name (fully or partially) to search for: ", false, false, 1);

		if (currentActors)
		{
			for (int posInTVShowList = 0; posInTVShowList < TVDatabase.size(); posInTVShowList++) 
			{
				for (Actor actor : TVDatabase.get(posInTVShowList).getCurrentActorsOfShow()) 
				{
					if (actor.getName().toLowerCase().contains(nameSearchString.toLowerCase()))
					{
						searchResults.add(TVDatabase.get(posInTVShowList));

					} //End If

				} //End For

			} //End For
		}
		else
		{
			for (int posInTVShowList = 0; posInTVShowList < TVDatabase.size(); posInTVShowList++) 
			{
				for (Actor actor : TVDatabase.get(posInTVShowList).getPastActorsOfShow()) 
				{
					if (actor.getName().toLowerCase().contains(nameSearchString.toLowerCase()))
					{
						searchResults.add(TVDatabase.get(posInTVShowList));

					} //End If

				} //End For

			} //End For

		} //End If		

		printTVShowResults(searchResults);	
		
	}//End searchActorName
	
	
	/**
	 * This method uses a for loop to search through the passed list of tv shows.
	 * It then searches through the episode list of the tv show retrieved
	 * It checks if the title of the current tv show episode retrieved from the list contains the title entered 
	 * @param TVDatabase
	 */
	private static void searchEpisodeTitle(ArrayList<TVShow> TVDatabase)
	{
		//Declare local variable
		String episodeTitleSearchString = "";
		ArrayList<Episode> searchResults = new ArrayList<Episode>();
		ArrayList<String> TVShowTitles = new ArrayList<String>();

		episodeTitleSearchString = HelperMethods.stringAskReadAndValidate("Please enter the episode title (fully or partially) to search for: ", false, false, 1);

		for (int posInTVShowList = 0; posInTVShowList < TVDatabase.size(); posInTVShowList++) 
		{
			for (Episode episode : TVDatabase.get(posInTVShowList).getEpisodeList()) 
			{
				if (episode.getTitle().toLowerCase().contains(episodeTitleSearchString.toLowerCase()))
				{
					searchResults.add(episode);
					TVShowTitles.add(TVDatabase.get(posInTVShowList).getTitle());

				} //End If

			} //End For

		} //End For

		System.out.println();
		
		printEpisodeResults(searchResults, TVShowTitles);
		
	}//End searchEpisodeTitle
	
	
	/**
	 * This method uses a for loop to print the details of the TV show Results
	 * @param searchResults
	 */
	private static void printTVShowResults(ArrayList<TVShow> searchResults)
	{
		System.out.println("\n-------------------------- Search Results --------------------------\n");
		
		//Check if there are results
		if (searchResults.size() > 0)
		{
			for (TVShow tvShow : searchResults)
			{
				
				System.out.print(tvShow.getTitle() + " | Rated: " + tvShow.getAgeRating() + " | Average Review Score: ");
				
				if (tvShow.getReviewList().size() > 0)
				{					
					System.out.println(tvShow.calcMeanReviewScore());

				} //End If
				
			}//End For
		}
		else
		{
			//No Results
			System.out.println("No Results Found");
			
		} //End If
		
		System.out.println();

	}//End printTVShowResults

	
	/**
	 * This method uses a for loop to print the details of the Episode Results
	 * @param searchResults
	 * @param TVShowTitles
	 */
	private static void printEpisodeResults(ArrayList<Episode> searchResults, ArrayList<String> TVShowTitles)
	{
		//Declare local variables
		int counter = 0;
		
		System.out.println("\n-------------------------- Search Results --------------------------");
		
		//Check if there are results
		if (searchResults.size() > 0)
		{
			for (Episode episode : searchResults)
			{				
				System.out.println("\n" + TVShowTitles.get(counter) + " | ");
				episode.printDetails();
				
				counter++;
				
			}//End For
		}
		else
		{
			//No Results
			System.out.println("No Results Found");
			
		} //End If

	}//End printEpisodeResults


	/**
	 * This method uses a for loop to print the details of the Review Results
	 * @param searchResults
	 * @param TVShowTitles
	 */
	private static void printReviewResults(ArrayList<Review> searchResults, ArrayList<String> TVShowTitles)
	{
		//Declare local variables
		int counter = 0;

		System.out.println("\n-------------------------- Search Results --------------------------");
		
		//Check if there are results
		if (searchResults.size() > 0)
		{
			for (Review review : searchResults)
			{				
				System.out.print("\n" + TVShowTitles.get(counter) + " | ");
				review.printReview();
				
				counter++;
				
			}//End For
		}
		else
		{
			//No Results
			System.out.println("No Results Found");
			
		} //End If
		
		//Spacing
		System.out.println();

	}//End printReviewResults


}
