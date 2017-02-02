package tvdb;

import java.util.ArrayList;

/**
 * This method provides the listing and reading of choices for various menus
 * 
 *  @author 40176468
 *
 */
public class MenuSystem
{	
	/**
	 * Prints out a numbered list of tv shows buy using a for loop to iterate through the tv show array list.
	 * It checks the user choice to see if it is with in the limits of 1 and the size of the array as they are the limits of the printed list
	 * If it is it has an associated tv show and it is that tv show which is returned
	 * @param showLibrary - The show Library list which is printed
	 * @return The tv show that was selected
	 */
	public static TVShow displayAndReadOptionSelectedFromTVShowSelectMenu(ArrayList<TVShow> showLibrary, String functionOfSelection) 
	{
		//Declare local variables
		int userChoice = 0;
		TVShow tvShowSelected = null;

		if (showLibrary.size() > 0)
		{
			//Display all of the TV Shows in an ordered list
			for (int pos = 0; pos < showLibrary.size(); pos++) {

				System.out.println((pos + 1) + ". " + showLibrary.get(pos).getTitle());

			} //End For
			
			
			do
			{
				//Ask for their choice
				userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the TV Show you wish to " + functionOfSelection + ": ");
				
				//If it is within 1 and the size of the list of actors then add it to the list
				if (userChoice >= 1 && userChoice <= showLibrary.size())
				{
					tvShowSelected = showLibrary.get(userChoice - 1);
				}
				else
				{
					System.out.println("The number you entered does not correspond to a TV Show\nPlease Try Again\n");

				} //End If

			} while (userChoice < 1 && userChoice > showLibrary.size()); //End do...while
		}
		else
		{
			System.out.println("The TV Show List is empty.\nPlease Add A TV Series List to do this operation");
			
		} //End If		
		
		return tvShowSelected;

	}//End displayAndReadOptionSelectedFromTVShowSelectMenu

	
	/**
	 * Prints out a numbered list of actors buy using a for loop to iterate through the actor array list.
	 * It checks the user choice to see if it is with in the limits of 1 and the size of the array as they are the limits of the printed list
	 * If it is it has an associated actor and it is that actor which is returned
	 * @param actorList - The actor list which is printed
	 * @return The actor that was selected
	 */
	public static Actor displayActorsAndReadSelection(ArrayList<Actor> actorList)
	{
		//Declare local variables
		int userChoice = 0;
		Actor actorChosen = null;
		
		if(actorList.size() > 0)
		{
			do
			{
				for (int pos = 0; pos < actorList.size(); pos++)
				{
					System.out.println((pos + 1) + ". " + actorList.get(pos).getName());							

				} //End For


				userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the starring actor: ");

				//If it is within 1 and the size of the list of actors then add it to the list
				if (userChoice >= 1 && userChoice <= actorList.size())
				{
					actorChosen = actorList.get(userChoice - 1);
				}
				else
				{
					System.out.println("The number you entered does not correspond to an actor/actress\nPlease Try Again\n");

				} //End If

			}while(userChoice < 1 && userChoice > actorList.size()); //End do...while

		}
		else 
		{
			System.out.println("There are no actors to select");
			
		}//End If
		
		return actorChosen;
		
	}//End displayActorsAndReadSelection

	
	/**
	 * Prints out a menu buy using a for loop to iterate through the string array.
	 * It returns the user choice so long as it is with in the limits of 1 and the size of the array as they are the limits of the printed list
	 * @param menuOptions - This is the array of option to print to the user
	 * @param function - This is what the option will allow them to do
	 * @return Their choice of option numerically
	 */
	public static int displayAndReadOptionSelectedFromMenus(String[] menuOptions, String function)
	{
		//Declare local variables
		int userChoice = 0;
		
		do
		{
			for (int pos = 0; pos < menuOptions.length; pos++)
			{
				System.out.println((pos + 1) + ". " + menuOptions[pos]);

			} //End For		
			
			
			userChoice = HelperMethods.requestAndReadInInteger("Please select (numerically) the option you wish to " + function + ": ");

		} while (userChoice < 1 || userChoice > menuOptions.length); //End do...while
				
		return userChoice;
		
	}//End displayAndReadOptionSelectedFromEditMenus
	
	
}
