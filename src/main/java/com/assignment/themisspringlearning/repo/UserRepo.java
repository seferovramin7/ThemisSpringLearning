package com.assignment.themisspringlearning.repo;

import com.assignment.themisspringlearning.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
