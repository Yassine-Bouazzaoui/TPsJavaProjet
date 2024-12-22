package com.bouazzaoui.filter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.bouazzaoui.tri.Person;

public class PersonService {

    // Base de données fictive
    private static final List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Bouazzaoui", "Yassine", LocalDate.of(2003, 1, 1), "Agadir"),
            new Person("Elgaddari", "Abdeljabbar", LocalDate.of(2002, 11, 7), "Marrakech"),
            new Person("Errazaki", "Ayoub", LocalDate.of(1998, 17, 1), "Casablanca")
    );

    // Filtre les personnes par adresse
    public static List<Person> filterByAddress(String address) {
        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);
        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    // Filtre les personnes par Age
    public static List<Person> filterAdults() {
        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;
        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }
}
