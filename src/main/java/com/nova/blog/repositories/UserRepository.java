package com.nova.blog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.blog.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
