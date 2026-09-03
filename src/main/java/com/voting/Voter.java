package com.voting;

import java.util.ArrayList;
import java.util.List;

public class Voter {
    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean isIdValid;

    public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.isIdValid = isIdValid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean isIdValid() {
        return isIdValid;
    }

    public boolean isEligible() {
        return age >= 18 &&
                "Indian".equalsIgnoreCase(citizenship) &&
                isIdValid;
    }

    public List<String> getIneligibilityReasons() {
        List<String> reasons = new ArrayList<>();
        if (age < 18) {
            reasons.add("Underage (Must be at least 18 years old)");
        }
        if (!"Indian".equalsIgnoreCase(citizenship)) {
            reasons.add("Not an Indian citizen");
        }
        if (!isIdValid) {
            reasons.add("Invalid Voter ID status");
        }
        return reasons;
    }

    public String evaluateEligibility() {
        StringBuilder result = new StringBuilder();
        result.append("Voter: ").append(name).append(" (ID: ").append(voterId).append(")\n");
        if (isEligible()) {
            result.append("Status: ELIGIBLE TO VOTE\n");
        } else {
            result.append("Status: NOT ELIGIBLE TO VOTE\n");
            result.append("Reason(s):\n");
            for (String reason : getIneligibilityReasons()) {
                result.append(" - ").append(reason).append("\n");
            }
        }
        return result.toString();
    }
}