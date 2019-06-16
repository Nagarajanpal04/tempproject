package com.ihg.devops.coding;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelReservationMain extends HotelDateOperationsImpl {

	public static void main(String[] args) {

		String hotelCode;
		ZoneId zoneId;
		ZonedDateTime zone;
		String date;
		HotelDateOperationsImpl hotel = new HotelDateOperationsImpl();

		Scanner in = new Scanner(System.in);
		Scanner ip = new Scanner(System.in);
		System.out.println(
				"1) Get the Reservation date using HotelCode/Time(HH:mm) format :- "
						+ " \n2) Get the Reservation date at exact moment :- "
						+ "\n3) Crosschecking the checkin date :- ");
		System.out.print("Selection: ");

		try {

			switch (in.nextInt()) {
				case 1 :
					System.out.println("Enter the HotelCode");
					hotelCode = in.next();

					zoneId = HotelDateOperationService.getTimeZone(hotelCode);
					zone = ZonedDateTime.now(zoneId);

					System.out.println("Enter the Time(HH:mm) format");
					date = ip.next();

					System.out.println(hotel.getReservationDate(date, zone));

					break;
				case 2 :
					System.out.println("Enter the HotelCode");
					hotelCode = in.next();

					zoneId = HotelDateOperationService.getTimeZone(hotelCode);
					System.out.println(hotel.getReservationDateNow(hotelCode));
					break;
				case 3 :
					System.out.println("Enter the HotelCode");
					hotelCode = in.next();

					zoneId = HotelDateOperationService.getTimeZone(hotelCode);
					zone = ZonedDateTime.now(zoneId);

					System.out.println(
							"Enter the Reservation Date (dddd-MM-dd) :-");
					date = ip.next();
					LocalDate ld = LocalDate.parse(date);
					System.out.println("Checkin available :- "
							+ hotel.canCheckInNow(hotelCode, ld));

					break;
				default :
					System.err.println("Unrecognized option");
					break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter any of the above 3 option");
		} catch (NullPointerException e) {
			System.out.println("Please enter the valid input");
		}
		in.close();
		ip.close();

	}

}
