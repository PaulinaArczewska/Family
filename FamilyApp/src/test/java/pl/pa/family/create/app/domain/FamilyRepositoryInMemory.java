package pl.pa.family.create.app.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import pl.pa.family.create.app.model.FamilyDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FamilyRepositoryInMemory implements FamilyRepository {

    private List<FamilyDAO> family = new ArrayList<>();

    @Override
    public Optional<FamilyDAO> findById(int id) {
        return family.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<FamilyDAO> findAll() {
        return null;
    }

    @Override
    public List<FamilyDAO> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<FamilyDAO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<FamilyDAO> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(FamilyDAO entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends FamilyDAO> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends FamilyDAO> S save(S entity) {
        family.add(entity);
        return entity;
    }

    @Override
    public <S extends FamilyDAO> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<FamilyDAO> findById(Integer integer) {
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
    public <S extends FamilyDAO> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends FamilyDAO> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<FamilyDAO> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public FamilyDAO getOne(Integer integer) {
        return null;
    }

    @Override
    public FamilyDAO getById(Integer integer) {
        return null;
    }

    @Override
    public FamilyDAO getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends FamilyDAO> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends FamilyDAO> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends FamilyDAO> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends FamilyDAO> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends FamilyDAO> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends FamilyDAO> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends FamilyDAO, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
