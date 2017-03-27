package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDateTime;
/** Den här är användareinterface
 *@author  Sven  
 *@version 0.1**/
public class UserInterface {
	
	
	
/**
 * Det här är mainloopen 
 * @param args - Eventuella programargument
 * @return nothing**/
	public static void main(String[] args) {
			
		Cinema cinema = new Cinema();
		cinema.addFilm("Robocop 2", 240, "Action");
		try {
			System.out.println(cinema.getFilms());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Theater theater = new Theater(1, 10, 20);
		
		cinema.addViewing(1, "Robocop 2", LocalDateTime.now(), 0);
		String[] allViewings = cinema.getAllViewings();
		
//		System.out.println(cinema.getFilm("Robocop 2"));
		
		for (String viewing : allViewings) {
			System.out.println(viewing);
		}
		
		System.out.println(allViewings.length);
	}
}
		
//		String anser = "";
//		String adminAnser="";
//		String bookingAnser= "";
//		do {
//			System.out.println("Välkommen. \n"
//					+ "1. Bokning \n"
//					+ "2. Admin \n"
//					+ "3. Avsluta");
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			try {
//
//				anser = reader.readLine();
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//				System.out.println("Kunde inte läsa input");
//				break;
//			}
//
//			switch (anser) {
//
//
//			case "1":
//					System.out.println("Bokning av biljetter. \n"
//							+"1. Lista filmer. \n"
//							+"2. Lista salonger. \n"
//							+"3. Boka biljetter. \n"
//							+"4. Återgå till huvudmeny");	
//					try {
//						bookingAnser = reader.readLine();
//					} catch (IOException e) {				
//						e.printStackTrace();
//						System.out.println("Kunde inte läsa input");
//						break;
//						}
//
//							switch (bookingAnser) {
//					
//							case "1":
//									System.out.println("Lista filmer. \n");			
//									break;
//					
//					
//							case "2":					
//									System.out.println("Lista salonger. \n");
//									break;
//					
//							case "3":						
//									System.out.println("Boka biljetter.");
//									break;
//					
//							}while (!bookingAnser.equals("4"));
//
//							break;
//
//			
//
//			
//			
//			case "2":
//					System.out.println(" ADMIN. \n"
//							+ "1. Lägga till film \n"
//							+ "2. Ta bort film \n"
//							+ "3. Flytta film mellan salonger \n"
//							+ "4. Avsluta");
//				
//					try {
//
//						adminAnser = reader.readLine();
//					} catch (IOException e) {
//					
//						e.printStackTrace();
//						System.out.println("Kunde inte läsa input");
//						break;
//					}
//
//					switch (adminAnser) {
//							case "1":
//									System.out.println("Lägga till en film \n");
//				
//									break;
//							case "2":						
//									System.out.println("Ta bort film ");
//									break;
//							case "3":
//									System.out.println("Flytta film mellan salonger");
//									break;
//							}while (!adminAnser.equals("4"));
//			
//			
//			
//			default: 
//				if( anser.equals("3")){
//					System.out.println("Tack för att du har använt detta program");
//					break;
//				}
//				System.out.println("Du måste ange ett av de ovan nämna alternativen");
//				break;
//
//
//
//
//			}
//
//		} while (!anser.equals("3"));
//	}
//}





