package com.bouazzaoui.iterator;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', birthDate=" + birthDate + ", address='" + address + "'}";
    }
}
