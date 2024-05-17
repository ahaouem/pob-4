package ex2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserAnalyzer {
    private final List<User> users;

    public UserAnalyzer(List<User> users) {
        this.users = users;
    }

    public double calculateAverageAge() {
        return users.stream()
                .mapToInt(User::age)
                .average()
                .orElse(0.0);
    }

    public List<String> findCountriesWithMostUsers() {
        return users.stream()
                .collect(Collectors.groupingBy(User::country, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String findMostCommonFirstName() {
        return users.stream()
                .collect(Collectors.groupingBy(User::firstName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String findMostCommonLastName() {
        return users.stream()
                .collect(Collectors.groupingBy(User::lastName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public User findOldestUser() {
        return users.stream()
                .max(Comparator.comparingInt(User::age))
                .orElse(null);
    }

    public User findYoungestUser() {
        return users.stream()
                .min(Comparator.comparingInt(User::age))
                .orElse(null);
    }

    public List<String> findUniqueCountries() {
        return users.stream()
                .map(User::country)
                .distinct()
                .collect(Collectors.toList());
    }
}