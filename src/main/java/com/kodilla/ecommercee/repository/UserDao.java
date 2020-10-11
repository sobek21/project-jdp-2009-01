package com.kodilla.ecommercee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@Repository
public interface UserDao extends CrudRepository<T, Long> {

    @Override
    Optional<T> findById(Long id);
}
