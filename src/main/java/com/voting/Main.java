package com.voting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Voting Eligibility System ===");

        System.out.print("Enter number of voters to register: ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= count; i++) {
            System.out.println("\n--- Entering Details for Voter #" + i + " ---");

            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Citizenship (e.g., Indian): ");
            String citizenship = scanner.nextLine().trim();

            System.out.print("Voter ID Number: ");
            String voterId = scanner.nextLine().trim();

            System.out.print("Is Voter ID valid? (true/false): ");
            boolean isIdValid = Boolean.parseBoolean(scanner.nextLine().trim());

            Voter voter = new Voter(name, age, citizenship, voterId, isIdValid);
            System.out.println("\n--- Evaluation Output ---");
            System.out.print(voter.evaluateEligibility());
        }

        scanner.close();
    }
}