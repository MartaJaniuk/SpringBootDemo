package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Table(name = "person_details")
@Getter
@Setter
@ToString
public class PersonDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long streetNumber;
    private String street;
    private String city;

//    @OneToOne
//    @JoinColumn(name="persons_id")
//    private Person person;

}
