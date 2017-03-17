package cinema;

import java.time.Duration;
import java.time.LocalDateTime;
/** Den här är användareinterface
 *@author  Sven  
 *@version 0.1**/
public class Film implements Comparable<Film>{
	/**Movie title **/
	private String title;
	/**Description of the movie**/
	private String description;
	/**the length of the film **/
	private Duration length;
	/** the period the movie will play in the Cinema and the Theatre**/
	private LocalDateTime period;
	@Override
	public int compareTo(Film arg0) {		
		return 0;
	}
	/**construktor to the film
	 * This 
	 * @param args - 
	 * 
	 * @return nothing**/
	public Film (String title ,String description, Duration length ){
		this.title = title;
		this.description = description;
		this.length = length;	
	}
	
	
/**getTitle gets the title
 * @return title**/
	public String getTitle() {
		return title;
	}

	
	/** getPeriod
	 * @return period
	 **/
	public LocalDateTime getPeriod() {
		return period;
	}
	/**setPeriod sets the period variable
	 * 
	 * @param period
	 */
	public void setPeriod(LocalDateTime period) {
		this.period = period;
	}
	/** getDescription will get the Description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	/**getLenght will get the Description 
	 * 
	 * @return length
	 */
	public Duration getLength() {
		return length;
	}
	


}
