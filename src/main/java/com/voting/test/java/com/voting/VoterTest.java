package com.voting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoterTest {

    @Test
    public void testEligibleVoter() {
        Voter voter = new Voter("Aarav", 22, "Indian", "IND123456", true);
        assertTrue(voter.isEligible());
        assertTrue(voter.getIneligibilityReasons().isEmpty());
    }

    @Test
    public void testUnderageVoter() {
        Voter voter = new Voter("Priya", 16, "Indian", "IND654321", true);
        assertFalse(voter.isEligible());
        assertTrue(voter.getIneligibilityReasons().contains("Underage (Must be at least 18 years old)"));
    }

    @Test
    public void testMultipleIneligibilityReasons() {
        Voter voter = new Voter("John", 17, "American", "US987654", false);
        assertFalse(voter.isEligible());
        assertEquals(3, voter.getIneligibilityReasons().size());
    }
}