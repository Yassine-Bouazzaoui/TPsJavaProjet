package com.bouazzaoui.iteratortest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import com.bouazzaoui.iterator.Person;

public class TestPersonWithoutIterator {
    @Test
    public void testRemoveWithoutIterator() {
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

         assertThatThrownBy(() -> {
            for (Person person : people) {
                System.out.println("Traitement de : " + person);
                if ("Ayoub".equals(person.getName())) {
                    System.out.println("Tentative de suppression de : " + person);
                    people.remove(person); // Doit déclencher ConcurrentModificationException
                }
            }
        }).isInstanceOf(java.util.ConcurrentModificationException.class);
        
}
}