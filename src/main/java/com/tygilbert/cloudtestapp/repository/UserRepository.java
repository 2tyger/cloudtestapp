package com.tygilbert.cloudtestapp.repository;

import com.tygilbert.cloudtestapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
