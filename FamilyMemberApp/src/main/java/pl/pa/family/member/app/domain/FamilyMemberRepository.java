package pl.pa.family.member.app.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pa.family.member.app.model.FamilyMemberDAO;

import java.util.Collection;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMemberDAO, Integer> {
    Collection<FamilyMemberDAO> findByFamilyId(int familyId);
}
