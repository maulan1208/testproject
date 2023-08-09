package edu.vti.rocket.democl3.repository;

import edu.vti.rocket.democl3.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
