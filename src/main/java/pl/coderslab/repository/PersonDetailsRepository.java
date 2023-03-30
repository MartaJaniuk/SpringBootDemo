package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.PersonDetails;

public interface PersonDetailsRepository extends JpaRepository<PersonDetails, Long> {
}
