package com.bouazzaoui.tri;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Person implements Comparable<Person> {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String address;

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public int compareTo(Person other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        return lastNameComparison != 0 ? lastNameComparison : this.firstName.compareTo(other.firstName);
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}
