package com.bouazzaoui.filtertest;

import org.junit.jupiter.api.Test;
import com.bouazzaoui.iterator.Person;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonFilterTest {

    @Test
    public void testFilterByAddress() {
        // Création d'une liste de personnes
        List<Person> people = Arrays.asList(
                Person.builder().id(1).name("Yassine").birthDate(LocalDate.of(1998, 1, 18)).address("Agadir").build(),
                Person.builder().id(2).name("Abdeljabbar").birthDate(LocalDate.of(1992, 8, 17)).address("Marrakech").build(),
                Person.builder().id(3).name("Ayoub").birthDate(LocalDate.of(2000, 7, 21)).address("Agadir").build()
        );

        // Filtrer les personnes vivant à Agadir
        List<Person> filtered = people.stream()
                .filter(person -> "Agadir".equals(person.getAddress()))
                .collect(Collectors.toList());

        // Vérification
        assertThat(filtered).hasSize(2);
        assertThat(filtered).extracting("name").containsExactlyInAnyOrder("Yassine", "Ayoub");
    }

    @Test
    public void testFilterByAge() {
        // Création d'une liste de personnes
        List<Person> people = Arrays.asList(
                Person.builder().id(1).name("Yassine").birthDate(LocalDate.of(2003, 1, 1)).address("Agadir").build(),
                Person.builder().id(2).name("Abdeljabbar").birthDate(LocalDate.of(2007, 10, 15)).address("Marrakech").build(),
                Person.builder().id(3).name("Ayoub").birthDate(LocalDate.of(1998, 3, 15)).address("Casablanca").build()
        );

        // Filtrer les personnes de plus de 18 ans
        List<Person> adults = people.stream()
                .filter(person -> person.calculateAge() >= 18)
                .collect(Collectors.toList());

        // Vérification
        assertThat(adults).hasSize(2);
        assertThat(adults).extracting("name").containsExactlyInAnyOrder("Yassine", "Ayoub");
    }

    @Test
    public void testFilterByAgeAndAddress() {
        // Création d'une liste de personnes
        List<Person> people = Arrays.asList(
                Person.builder().id(1).name("Yassine").birthDate(LocalDate.of(1990, 5, 12)).address("Agadir").build(),
                Person.builder().id(2).name("Abdeljabbar").birthDate(LocalDate.of(1985, 3, 9)).address("Marrakech").build(),
                Person.builder().id(3).name("Ayoub").birthDate(LocalDate.of(2000, 7, 21)).address("Casablanca").build()
        );

        // Filtrer les personnes de plus de 30 ans vivant à Agadir
        List<Person> filtered = people.stream()
                .filter(person -> person.calculateAge() > 30 && "Agadir".equals(person.getAddress()))
                .collect(Collectors.toList());

        // Vérification
        assertThat(filtered).hasSize(1);
        assertThat(filtered).extracting("name").containsExactly("Yassine");
    }

    @Test
    public void testFilterByCustomCondition() {
        // Création d'une liste de personnes
        List<Person> people = Arrays.asList(
                Person.builder().id(1).name("Yassine").birthDate(LocalDate.of(2003, 1, 1)).address("Agadir").build(),
                Person.builder().id(2).name("Abdeljabbar").birthDate(LocalDate.of(1995, 7, 9)).address("Marrakech").build(),
                Person.builder().id(3).name("Ayoub").birthDate(LocalDate.of(2000, 7, 21)).address("Casablanca").build()
        );

        // Filtrer les personnes dont le prénom commence par "A"
        List<Person> filtered = people.stream()
                .filter(person -> person.getName().startsWith("A"))
                .collect(Collectors.toList());

        // Vérification
        assertThat(filtered).hasSize(2);
        assertThat(filtered).extracting("name").containsExactlyInAnyOrder("Abdeljabbar", "Ayoub");
    }
}
