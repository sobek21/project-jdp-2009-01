package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import org.springframework.transaction.annotation.Transactional;

=======

import javax.transaction.Transactional;

>>>>>>> master
@Transactional
@Repository
public interface GroupDao extends CrudRepository <Group, Long> {

}
