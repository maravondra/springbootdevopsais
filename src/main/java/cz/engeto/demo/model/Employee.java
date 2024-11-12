package cz.engeto.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String surname;
}
