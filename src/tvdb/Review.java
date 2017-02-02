package tvdb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This Class holds the structure and behaviours for a Review Object
 * 
 * @author 40176468
 *
 */
public class Review
{
	//Declare Instance Variables
	private String author = "";
	private String review = "";
	private LocalDate dateReviewed = LocalDate.now();
	private float reviewScore = 0;
	
	
	/**
	 * This is the primary constructor for the Review Class
	 * @param author
	 * @param review
	 * @param reviewScore
	 */
	public Review(String author, String review, float reviewScore)
	{
		this.author = author;
		this.review = review;
		//Date is not read in as they are reviewing it there and then
		this.reviewScore = reviewScore;
		
	}//End Constructor
	
	/**
	 * This is the secondary constructor for the Review Class
	 * @param author
	 * @param review
	 * @param dateReviewed
	 * @param reviewScore
	 */
	public Review(String author, String review, LocalDate dateReviewed, float reviewScore)
	{
		this.author = author;
		this.review = review;
		this.dateReviewed = dateReviewed;
		this.reviewScore = reviewScore;
		
	}//End Constructor

	
	//---------------------------------- Getters/Accessors ----------------------------------\\
	/**
	 * @return the author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * @return the review
	 */
	public String getReview()
	{
		return review;
	}
	
	/**
	 * @return the dateReviewed
	 */
	public LocalDate getDateReviewed()
	{
		return dateReviewed;
	}
	
	/**
	 * @return the reviewScore
	 */
	public float getReviewScore()
	{
		return reviewScore;
	}
	
	//---------------------------------- Setters/Mutators ----------------------------------\\	

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	/**
	 * @param review the review to set
	 */
	public void setReview(String review)
	{
		this.review = review;
	}
	
	/**
	 * @param dateReviewed the dateReviewed to set
	 */
	public void setDateReviewed(LocalDate dateReviewed)
	{
		this.dateReviewed = dateReviewed;
	}
	
	/**
	 * @param reviewScore the reviewScore to set
	 */
	public void setReviewScore(float reviewScore)
	{
		this.reviewScore = reviewScore;
	}

	
	//---------------------------------- General Methods ----------------------------------\\
	/**
	 * This method prints the review's details
	 */
	public void printReview()
	{
		//Declare a date format for outputting correctly
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Print Details
		System.out.println("Author: " + getAuthor() + " | Reviewed on: " + dateFormat.format(getDateReviewed()) +  "\nReview: " + getReview() 
		+ "\nScore out of 10: " + getReviewScore());
				
	}//End printReview
	
	
}
