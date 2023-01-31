package pl.pa.family.member.app.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import pl.pa.family.member.app.model.FamilyMemberDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FamilyMemberRepositoryInMemory implements FamilyMemberRepository {

    private Collection<FamilyMemberDAO> familyMembers = new ArrayList<>();

    @Override
    public Collection<FamilyMemberDAO> findByFamilyId(int familyId) {
        return familyMembers.stream().filter(e -> e.getFamilyId() == familyId).collect(Collectors.toList());
    }

    @Override
    public List<FamilyMemberDAO> findAll() {
        return null;
    }

    @Override
    public List<FamilyMemberDAO> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<FamilyMemberDAO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<FamilyMemberDAO> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return familyMembers.size();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(FamilyMemberDAO entity) {
        familyMembers.remove(entity);

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends FamilyMemberDAO> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends FamilyMemberDAO> S save(S entity) {
        familyMembers.add(entity);
        return entity;

    }

    @Override
    public <S extends FamilyMemberDAO> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<FamilyMemberDAO> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends FamilyMemberDAO> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends FamilyMemberDAO> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<FamilyMemberDAO> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public FamilyMemberDAO getOne(Integer integer) {
        return null;
    }

    @Override
    public FamilyMemberDAO getById(Integer integer) {
        return null;
    }

    @Override
    public FamilyMemberDAO getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends FamilyMemberDAO> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends FamilyMemberDAO> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends FamilyMemberDAO> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends FamilyMemberDAO> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends FamilyMemberDAO> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends FamilyMemberDAO> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends FamilyMemberDAO, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
