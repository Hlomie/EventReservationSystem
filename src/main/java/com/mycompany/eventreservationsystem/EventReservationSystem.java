/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eventreservationsystem;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class EventReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter booking code: ");
        String bookingCode = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String message = makeReservation(bookingCode, password);
        System.out.println(message);
    }

    public static boolean checkBookingCode(String code) {
        return !(!code.contains("_") || code.length() > 12);
    }

    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }
            if (hasCapitalLetter && hasNumber && hasSpecialCharacter) {
                break;
            }
        }
        return hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }

    public static String makeReservation(String bookingCode, String password) {
        if (!checkBookingCode(bookingCode)) {
            return "Booking code is incorrectly formatted.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        } else {
            return "Reservation successfully made!";
        }
    }
}
    }

