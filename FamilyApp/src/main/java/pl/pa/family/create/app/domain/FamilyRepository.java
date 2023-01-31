package pl.pa.family.create.app.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pa.family.create.app.model.FamilyDAO;

import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyDAO, Integer> {
    Optional<FamilyDAO> findById(int id);
}
