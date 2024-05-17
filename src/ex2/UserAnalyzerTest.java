package ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAnalyzerTest {
    private List<User> users;
    private UserAnalyzer userAnalyzer;

    @BeforeEach
    void setUp() {
        users = List.of(
                new User("John", "Doe", 30, "USA"),
                new User("Alice", "Smith", 25, "USA"),
                new User("Alice", "Howard", 27, "USA"),
                new User("Bob", "Johnson", 35, "UK"),
                new User("Emma", "Brown", 28, "UK"),
                new User("Emma", "Doe", 28, "UK"),
                new User("Michael", "Lee", 40, "Canada"),
                new User("Emma", "Wang", 22, "China")
        );
        userAnalyzer = new UserAnalyzer(users);
    }

    @Test
    void testCalculateAverageAge() {
        double averageAge = userAnalyzer.calculateAverageAge();
        assertEquals(29.375, averageAge);
    }

    @Test
    void testFindCountriesWithMostUsers() {
        List<String> countriesWithMostUsers = userAnalyzer.findCountriesWithMostUsers();
        assertEquals(2, countriesWithMostUsers.size());
        assertTrue(countriesWithMostUsers.contains("USA"));
        assertTrue(countriesWithMostUsers.contains("UK"));
    }

    @Test
    void testFindMostCommonFirstName() {
        String mostCommonFirstName = userAnalyzer.findMostCommonFirstName();
        assertEquals("Emma", mostCommonFirstName);
    }

    @Test
    void testFindMostCommonLastName() {
        String mostCommonLastName = userAnalyzer.findMostCommonLastName();
        assertEquals("Doe", mostCommonLastName);
    }

    @Test
    void testFindOldestUser() {
        User oldestUser = userAnalyzer.findOldestUser();
        assertEquals("Michael", oldestUser.getFirstName());
        assertEquals("Lee", oldestUser.getLastName());
    }

    @Test
    void testFindYoungestUser() {
        User youngestUser = userAnalyzer.findYoungestUser();
        assertEquals("Emma", youngestUser.getFirstName());
        assertEquals("Wang", youngestUser.getLastName());
    }

    @Test
    void testFindUniqueCountries() {
        List<String> uniqueCountries = userAnalyzer.findUniqueCountries();
        assertEquals(4, uniqueCountries.size());
        assertTrue(uniqueCountries.contains("USA"));
        assertTrue(uniqueCountries.contains("UK"));
        assertTrue(uniqueCountries.contains("Canada"));
        assertTrue(uniqueCountries.contains("China"));
    }
}
