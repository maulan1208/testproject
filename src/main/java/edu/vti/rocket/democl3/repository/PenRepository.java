package edu.vti.rocket.democl3.repository;

import edu.vti.rocket.democl3.domain.Pen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenRepository extends JpaRepository<Pen, Long> {


}
