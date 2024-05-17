package ex2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserAnalyzer {
    private final List<User> users;

    public UserAnalyzer(List<User> users) {
        this.users = users;
    }

    public double calculateAverageAge() {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
    }

    public List<String> findCountriesWithMostUsers() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getCountry, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String findMostCommonFirstName() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getFirstName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String findMostCommonLastName() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getLastName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public User findOldestUser() {
        return users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(null);
    }

    public User findYoungestUser() {
        return users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .orElse(null);
    }

    public List<String> findUniqueCountries() {
        return users.stream()
                .map(User::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }
}