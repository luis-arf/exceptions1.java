package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy):");
		LocalDate checkIn = LocalDate.from( dtf.parse(  sc.nextLine() ) );
		System.out.print("Check-out date (dd/MM/yyyy):");
		LocalDate checkOut = LocalDate.from( dtf.parse( sc.nextLine() ) );
		
		if( checkOut.isBefore(checkIn) ) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation res = new Reservation(roomNumber,checkIn,checkOut);
			System.out.println("Reservation: " + res);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = LocalDate.from( dtf.parse(  sc.nextLine() ) );
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = LocalDate.from( dtf.parse( sc.nextLine() ) );
			
	
			String result = res.updateDates(checkIn, checkOut);
			if( result != null )
				System.out.println("Error in reservation: " + result);
			else
				System.out.println("Reservation: " + res);
		}
		
	
		sc.close();
	}
}
