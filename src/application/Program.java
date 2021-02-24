package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy):");
			LocalDate checkIn = LocalDate.from( dtf.parse(  sc.nextLine() ) );
			System.out.print("Check-out date (dd/MM/yyyy):");
			LocalDate checkOut = LocalDate.from( dtf.parse( sc.nextLine() ) );
			Reservation res = new Reservation(roomNumber,checkIn,checkOut);
			System.out.println("Reservation: " + res);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = LocalDate.from( dtf.parse(  sc.nextLine() ) );
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = LocalDate.from( dtf.parse( sc.nextLine() ) );
				
		
			res.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + res);
		}
		catch(DateTimeParseException e ) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage() );
		}
		
		sc.close();
	}
}
