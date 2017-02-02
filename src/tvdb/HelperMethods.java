package tvdb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This Class holds methods that are useful for validation and to generate TV Show Data
 * 
 * @author 40176468
 * 
 */
public class HelperMethods {

	//Declare Global variables and Objects
	private static Scanner sc = new Scanner(System.in);

	
	/**
	 * This method accepts a string to print to the user and then prints it out.
	 * It will then check that the input is an integer value and then read it in or write an error message.
	 * It will do this until a valid entry is made or the program is stopped
	 * @param messageToPrint The string that is printed out to the user
	 * @return The integer input by the user
	 */
	public static int requestAndReadInInteger(String messageToPrint) 
	{
		//Declare local variables
		int input = 0;
		boolean validInput = false;

		do
		{
			//Ask for an integer
			System.out.print(messageToPrint);

			//Test if the input is an integer
			if (sc.hasNextInt())
			{
				input = sc.nextInt();
				
				if(input >= 0)
				{
					validInput = true;
					
				}//End If
			} 
			else 
			{
				//Inform user that they did not enter a valid int
				System.out.println("The data you entered was not a valid integer.\n");

				//force to the next
				sc.nextLine();

			}//End If

		} while (!validInput);

		//Force to the next line
		sc.nextLine();
		
		return input;

	}//End requestAndReadInInteger


	/**
	 * This method accepts a string to print to the user and then prints it out.
	 * It will then check that the input is an double value and then read it in or write an error message
	 * It will do this until a valid entry is made or the program is stopped
	 * @param messageToPrint The string that is printed out to the user
	 * @return The integer input by the user
	 */
	public static double requestAndReadInDouble(String messageToPrint) 
	{
		//Declare local variables
		double input = 0;
		boolean validInput = false;

		do
		{
			//Ask for an double
			System.out.print(messageToPrint);

			//Test if the input is an double
			if (sc.hasNextDouble())
			{
				input = sc.nextDouble();
				validInput = true;
			} 
			else 
			{
				//Inform user that they did not enter a valid double
				System.out.println("The data you entered was not a valid double.\n");

				//force to the next
				sc.next();

			}//End If

		} while (!validInput);

		return input;

	}//End requestAndReadInDouble

	
	/**
	 * This method accepts a string to print to the user and then prints it out.
	 * It will then check that the input is an float value and then read it in or write an error message
	 * It will do this until a valid entry is made or the program is stopped
	 * @param messageToPrint The string that is printed out to the user
	 * @return The integer input by the user
	 */
	public static float requestAndReadInFloat(String messageToPrint) 
	{
		//Declare local variables
		float input = 0;
		boolean validInput = false;

		do
		{
			//Ask for an float
			System.out.print(messageToPrint);

			//Test if the input is an float
			if (sc.hasNextFloat())
			{
				input = sc.nextFloat();
				validInput = true;
			} 
			else 
			{
				//Inform user that they did not enter a valid float
				System.out.println("The data you entered was not a valid float.\n");

				//force to the next
				sc.next();

			}//End If

		} while (!validInput);

		return input;

	}//End requestAndReadInFloat

	
	/**
	 * This method accepts a string to print to the user and then prints it out as part of the sentence "Please enter the year for " + dateRequired + ": ".
	 * It will then check that the inputs are integer values and then check that it will convert to a date correctly or write an error message.
	 * It will do this until a valid entry is made or the program is stopped
	 * @param dateRequired The string that is printed out to the user as part of the sentence "Please enter the year for " + dateRequired + ": "
	 * @return The date input by the user
	 */
	public static LocalDate requestAndReadInDate(String dateRequired) 
	{
		//Declare local variables
		int inputDay = 0, inputMonth = 0, inputYear = 0;
		boolean validInput = false;
		LocalDate dateReturned = LocalDate.now();

		do
		{
			do
			{
				//Ask for the year
				inputYear = HelperMethods.requestAndReadInInteger("Please enter the year for " + dateRequired + ": ");
				
				if (inputYear >= 1900 && inputYear <= LocalDate.now().getYear())
				{
					validInput = true;
				}
				else
				{
					System.out.println("The person cannot be born before 1900 or born after the current year");
					
					//Mark invalid
					validInput = false;
					
				} //End If
				
				System.out.println();
			
			}while(!validInput);
			
			
			do 
			{
				//Ask for the month
				inputMonth = HelperMethods.requestAndReadInInteger("Please enter the month for " + dateRequired + ": ");	
				
				if(inputMonth >= 1 && inputMonth <= 12)
				{
					//Mark valid
					validInput = true;
				}
				else
				{
					//Print to user that they input a month outside the list
					System.out.println("There are 12 months in a year therefore please enter an integer between 1 and 12");
					
					//mark invalid
					validInput = false;
					
				}//End If
				
				System.out.println();

			} while (!validInput); //End Do..While
			
			
			do 
			{				
				//Ask for the day
				inputDay = HelperMethods.requestAndReadInInteger("Please enter the day for " + dateRequired + ": ");
				
				//Check if it is in the broadest range
				if (inputDay > 0 && inputDay <= 31)
				{
					//Check if, depending on the month, it is not 31 days
					if (inputDay == 31 && (inputMonth == 4 || inputMonth == 6 || inputMonth == 9 || inputMonth == 11)) 
					{
						//Date is invalid
						System.out.println("April, June, September and November only have 30 days\nPlease Try Again\n");
						
						//mark invalid
						validInput = false;
						
					} //Check if it is February, if it is check it is less than 28 days OR if it is a leap year less than 29
					else if(inputMonth == 2 && inputDay > 28 || inputMonth == 2 && inputYear % 4 == 0 && inputDay > 29)
					{
						//Date is invalid
						System.out.println("February only has 28 days unless it is a leap year.\nPlease Try Again");
						
						//Mark Valid
						validInput = false;
						
					}
					else
					{
						//If it passes all of the above it is a valid date
						validInput = true;
						
					}//End If
					
				} 
				else 
				{
					//date is invalid
					System.out.println("Months have at least one day and at most 31 days.\nPlease enter an day between 1 and 31 (depending on the month)\n");
					
					//mark invalid
					validInput = false;
										
				} //End If

				System.out.println();
				
			} while (!validInput); //End Do..While
						
			
		} while (!validInput);//End Do..While

		//Try to put the date together
		dateReturned = LocalDate.of(inputYear, inputMonth, inputDay);
		
		return dateReturned;

	}//End requestAndReadInInteger

	

	/**
	 * This Method accepts a string to print to the console, 
	 * whether the string input should have numbers or special characters,
	 * and what the minimum number of characters it should have.
	 * It then does the required checks and repeats the request until the String entered is valid.
	 * It then returns the valid input string
	 * @param requestForUser
	 * @param numbersAllowed
	 * @param specialCharactersAllowed
	 * @param minLength
	 * @return The valid string input from the user
	 */
	public static String stringAskReadAndValidate(String requestForUser, boolean numbersAllowed, boolean specialCharactersAllowed, int minLength)
	{
		//Declare local variables
		boolean validInput = false;
		String userInput = "";

		do
		{
			//Ask for the user to input a string with parameter
			System.out.print(requestForUser);

			//Read in the next line
			userInput = sc.nextLine();

			//Check if the user has the required number of characters
			if (userInput.trim().length() >= minLength)
			{
				if (!numbersAllowed && !specialCharactersAllowed)
				{
					//If numbers and special characters are not allowed then check if there are numbers
					for (int charPos = 0; charPos < userInput.length(); charPos++)
					{
						//Retrieve the character
						char charAtPos = userInput.charAt(charPos);

						//Check it is not a space or a letter
						if (!Character.isLetter(charAtPos) && !Character.isSpaceChar(charAtPos))
						{
							//if it isnt then is is not valid
							validInput = false;

							//Inform user that it is invalid
							System.out.println("This string should not contain numbers or special characters (e.g. *,.% etc.)\nPlease try again\n");

							//Break out of the loop as it would be inefficient to continue
							break;

						}
						else
						{
							//if it is then it is valid
							validInput = true;
							
						}//End If

					} //End For
					
					//If it is valid up to this point check if there is swearing, therefore check profanity
					if (validInput)
					{						
						validInput = profanityCheck(userInput);

					} //End If
					

				}
				else if (!numbersAllowed)
				{
					//If numbers and special characters are not allowed then check if there are numbers
					for (int charPos = 0; charPos < userInput.length(); charPos++)
					{
						//Retrieve the character
						char charAtPos = userInput.charAt(charPos);

						//Check it is not a digit
						if (Character.isDigit(charAtPos))
						{
							//if it isnt then is is not valid
							validInput = false;

							//Inform user that it is invalid
							System.out.println("This string should not contain numbers.\nPlease try again\n");

							//Break out of the loop as it would be inefficient to continue
							break;

						}
						else
						{
							//if it is then it is valid
							validInput = true;
							
						} //End If

					} //End For

					//If it is valid up to this point check if there is swearing, therefore check profanity
					if (validInput)
					{						
						validInput = profanityCheck(userInput);

					} //End If

				}
				else if (!specialCharactersAllowed)
				{
					//If numbers and special characters are not allowed then check if there are numbers
					for (int charPos = 0; charPos < userInput.length(); charPos++)
					{
						//Retrieve the character
						char charAtPos = userInput.charAt(charPos);

						//Check it is not a special character (i.e. not a letter or a space or a digit)
						if (!Character.isLetter(charAtPos) && !Character.isSpaceChar(charAtPos) && !Character.isDigit(charAtPos))
						{
							//if it isnt then is is not valid
							validInput = false;

							//Inform user that it is invalid
							System.out.println("This string should not contain special characters (e.g. *,.% etc.)\nPlease try again\n");

							//Break out of the loop as it would be inefficient to continue
							break;

						}
						else
						{
							//if it is then it is valid
							validInput = true;
							
						} //End If

					} //End For

					//If it is valid up to this point check if there is swearing, therefore check profanity
					if (validInput)
					{						
						validInput = profanityCheck(userInput);

					} //End If

				}
				else
				{
					//Even if numbers and spec. chars are allowed and it meets min length, check profanity
					validInput = profanityCheck(userInput);

				} //End If
			}
			else
			{
				//Inform the user that they have entered a string that is too short
				System.out.println("The string you entered was insufficient in length.\nPlease Try Again entering at least " + minLength + " characters\n");

			} //End If

		} while (!validInput); //End do...while

		return userInput;

	}//End stringAskReadAndValidate

	
	/**
	 * This method is used to check if there is profanity in the string
	 * @param stringToCheck
	 * @return
	 */
	//WARNING - THIS METHOD CONTAINS AN ARRAY OF SWEAR WORDS.
	//I HAVE USED A COMMON LIST OF SWEAR WORDS BLOCKED BY MOST SITES
	public static boolean profanityCheck(String stringToCheck)
	{
		String[] profanity = new String[]{"arse", "ass", "ballsack", "bollocks", "crap", "cunt", "fuck", "shit", "twat"};
		
		for (String swearWord : profanity) 
		{
			if(stringToCheck.toLowerCase().contains(swearWord))
			{
				System.out.println("The data you entered contained inappropriate language.\nRefrain from using such language and try again\n");
				
				//Break from sequence and return value so as to avoid accidentally sending true
				return false;
				
			}//End If
			
		}//End For
		
		//If it reached this point there is no specified swear words
		return true;
		
	}//End profanityCheck

	//-------------------------------------- Test Data TODO IMPROVEMENT - Could Read And Write From database/text file --------------------------------------\\
	/**
	 * This method generates the dummy data
	 * @return
	 */
	public static ArrayList<TVShow> generateTVShows()
	{		
		//Create list to store the generated TV Shows
		ArrayList<TVShow> TVShowList = new ArrayList<TVShow>();

		//Define the data
		String[] titles = new String[]{"Game Of Thrones", "How I Met Your Mother", "Doctor Who"};
		Genre[] genres = new Genre[]{Genre.FANTASY, Genre.COMEDY, Genre.SCIENCEFICTION};
		String[] ageRatings = new String[]{"18", "15", "PG"};
		int[] launchYear = new int[]{2010, 2005, 1990};
		int[] totalNumberOfEpisodes = new int[]{100, 180, 250};
		int[] numEpisodesPerSeason = new int[]{15, 20, 20};
		ArrayList<ArrayList<Review>> reviewsList = new ArrayList<ArrayList<Review>>();
		ArrayList<ArrayList<Actor>> currentActorList = new ArrayList<ArrayList<Actor>>();
		ArrayList<ArrayList<Actor>> pastActorList = new ArrayList<ArrayList<Actor>>();
		ArrayList<ArrayList<Episode>> episodeList = new ArrayList<ArrayList<Episode>>();

		ArrayList<Review> gameOfThronesReviews = new ArrayList<Review>();
		
		gameOfThronesReviews.add(new Review("Bob", "This show is shot wonderfully. It is a true classic", LocalDate.of(2012, 12, 15), 9.5f));
		gameOfThronesReviews.add(new Review("Jane", "This show has an excess of violence. It shouldn't be shown on TV", LocalDate.of(2010, 12, 15), 3.0f));
		reviewsList.add(gameOfThronesReviews);

		ArrayList<Review> howIMetYourMotherReviews = new ArrayList<Review>();
		howIMetYourMotherReviews.add(new Review("Bob", "This show is a cult classic. It is a true an amazing comedy. Though the ending was dissapointing", LocalDate.of(2010, 7, 25), 9.5f));
		howIMetYourMotherReviews.add(new Review("Jane", "This show is tries too hard to be funny.", LocalDate.of(2010, 1, 30), 3.5f));
		
		reviewsList.add(howIMetYourMotherReviews);

		ArrayList<Review> doctorWhoReviews = new ArrayList<Review>();

		doctorWhoReviews.add(new Review("Andrew", "It is a true classic. However the recent season has seen a drop in quality", LocalDate.of(2012, 5, 10), 7f));
		doctorWhoReviews.add(new Review("Sarah", "This show makes little sense and regularly steers to darker storylines that I don't find suitable for children.", LocalDate.of(2010, 3, 20), 3.0f));
		reviewsList.add(doctorWhoReviews);

		ArrayList<Actor> currentGameOfThronesActors = new ArrayList<Actor>();
		currentGameOfThronesActors.add(new Actor("Kit Harrington", LocalDate.of(1986, 12, 26), "Game Of Thrones"));

		currentActorList.add(currentGameOfThronesActors);

		ArrayList<Actor> currentHowIMetYourMotherActors = new ArrayList<Actor>();
		currentHowIMetYourMotherActors.add(new Actor("Neil Patrick Harris", LocalDate.of(1973, 6, 15), "How I Met Your Mother"));

		currentActorList.add(currentHowIMetYourMotherActors);

		ArrayList<Actor> currentDoctorWhoActors = new ArrayList<Actor>();
		currentDoctorWhoActors.add(new Actor("Peter Capaldi", LocalDate.of(1958, 4, 14), "Doctor Who"));

		currentActorList.add(currentDoctorWhoActors);

		ArrayList<Actor> pastGameOfThronesActors = new ArrayList<Actor>();
		pastGameOfThronesActors.add(new Actor("Sean Bean", LocalDate.of(1959, 4, 17), "Game Of Thrones"));

		pastActorList.add(pastGameOfThronesActors);

		ArrayList<Actor> pastHowIMetYourMotherActors = new ArrayList<Actor>();
		pastHowIMetYourMotherActors.add(new Actor("Jason Segel", LocalDate.of(1980, 1, 18), "How I Met Your Mother"));

		pastActorList.add(pastHowIMetYourMotherActors);

		ArrayList<Actor> pastDoctorWhoActors = new ArrayList<Actor>();
		pastDoctorWhoActors.add(new Actor("David Tennant", LocalDate.of(1971, 4, 18), "Doctor Who"));
		pastDoctorWhoActors.add(new Actor("Matt Smith", LocalDate.of(1982, 10, 28), "Doctor Who"));

		pastActorList.add(pastDoctorWhoActors);
		
		
		ArrayList<Episode> GOTEpisodeList = new ArrayList<Episode>();
		GOTEpisodeList.add(new Episode(1, "The Beginning", "This is the start of a long and brutal story", LocalDate.of(2010, 12, 2), 59));
		GOTEpisodeList.add(new Episode(2, "The Nest", "The story unfolds and the cogs start turning", LocalDate.of(2010, 12, 9), 60));
		GOTEpisodeList.add(new Episode(3, "The War", "Many characters die in this episode", LocalDate.of(2010, 12, 16), 59));
		
		episodeList.add(GOTEpisodeList);
		
		ArrayList<Episode> HIMYMEpisodeList = new ArrayList<Episode>();
		HIMYMEpisodeList.add(new Episode(1, "Splitsville", "When Barney prepares a comprehensive pre-nup", LocalDate.of(2012, 10, 1), 59));
		HIMYMEpisodeList.add(new Episode(2, "Nannies", "Marshall and Lily discover their trouble finding a nanny is a result of one of Barney's schemes", LocalDate.of(2012, 10, 8), 60));
		HIMYMEpisodeList.add(new Episode(3, "Who Wants to Be a Godparent?", "Lily and Marshall test their friends to see who would be the best godparents.", LocalDate.of(2012, 10, 15), 59));
		episodeList.add(HIMYMEpisodeList);
		
		ArrayList<Episode> DWEpisodeList = new ArrayList<Episode>();
		DWEpisodeList.add(new Episode(1, "The End Of Time: Part 1", "There are signs that The Master has returned. It is up to the Doctor to work out what he is trying to do", LocalDate.of(2008, 6, 12), 59));
		DWEpisodeList.add(new Episode(2, "The End Of Time: Part 2", "Two time lords battle it out. One want Gallifrey's return. One will do anything to stop it", LocalDate.of(2008, 6, 19), 59));
		
		episodeList.add(DWEpisodeList);
		
		//Generate the list
		for (int pos = 0; pos < titles.length; pos++) {

			TVShowList.add(new TVShow(titles[pos], ageRatings[pos], genres[pos], launchYear[pos], totalNumberOfEpisodes[pos], numEpisodesPerSeason[pos], reviewsList.get(pos), currentActorList.get(pos), pastActorList.get(pos), episodeList.get(pos)));

		} //End For

		return TVShowList;

	}//End 


}
