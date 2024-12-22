package com.bouazzaoui.iteratortest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.bouazzaoui.iterator.Person;

public class TestPersonWithIterator {
    @Test
    public void testRemoveWithIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder()
                .id(1)
                .name("Yassine")
                .birthDate(LocalDate.of(1990, 1, 1))
                .address("Agadir")
                .build());
        people.add(Person.builder()
                .id(2)
                .name("Abdeljabbar")
                .birthDate(LocalDate.of(1985, 6, 15))
                .address("Marrakech")
                .build());
        people.add(Person.builder()
                .id(3)
                .name("Ayoub")
                .birthDate(LocalDate.of(1995, 12, 20))
                .address("Casablanca")
                .build());

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if ("Ayoub".equals(person.getName())) {
                iterator.remove(); // Suppression sécurisée
            }
        }

        // Vérifications après suppression
        assertThat(people)
                .hasSize(2)
                .extracting("name")
                .doesNotContain("Ayoub");
    }
}
