package com.bouazzaoui.tritest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import org.junit.jupiter.api.Test;

import com.bouazzaoui.tri.Person;

public class SortPersonsTest {

    @Test
    public void testSortPersonsByLastNameAndFirstName() {
        List<Person> people = Arrays.asList(
                Person.builder()
                        .lastName("Bouazzaoui")
                        .firstName("Yassine")
                        .birthDate(LocalDate.of(1990, 1, 1))
                        .build(),
                Person.builder()
                        .lastName("Elgaddari")
                        .firstName("Abdeljabbar")
                        .birthDate(LocalDate.of(1985, 6, 15))
                        .build(),
                Person.builder()
                        .lastName("Erraoucha")
                        .firstName("Yassine")
                        .birthDate(LocalDate.of(1995, 12, 20))
                        .build(),
                Person.builder()
                        .lastName("Errazaki")
                        .firstName("Ayoub")
                        .birthDate(LocalDate.of(1992, 9, 5))
                        .build()
        );

        // Tri de la liste de personnes
        Collections.sort(people);

        // Vérifications après le tri
        assertThat(people).extracting("lastName", "firstName").containsExactly(
                tuple("Bouazzaoui", "Yassine"),
                tuple("Elgaddari", "Abdeljabbar"),
                tuple("Erraoucha", "Yassine"),
                tuple("Errazaki", "Ayoub")
        );
    }

    @Test
    public void testCalculateAge() {
        List<Person> people = Arrays.asList(
                Person.builder()
                        .lastName("Bouazzaoui")
                        .firstName("Yassine")
                        .birthDate(LocalDate.of(1990, 1, 1))
                        .build(),
                Person.builder()
                        .lastName("Elgaddari")
                        .firstName("Abdeljabbar")
                        .birthDate(LocalDate.of(1985, 6, 15))
                        .build(),
                Person.builder()
                        .lastName("Erraoucha")
                        .firstName("Yassine")
                        .birthDate(LocalDate.of(1995, 12, 20))
                        .build(),
                Person.builder()
                        .lastName("Errazaki")
                        .firstName("Ayoub")
                        .birthDate(LocalDate.of(1992, 9, 5))
                        .build()
        );

        // Vérification des âges calculés
        assertThat(people)
                .extracting(Person::calculateAge)
                .allMatch(age -> age > 20, "All persons should be older than 20");
    }
}
