package pers.yuanwy.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pers.yuanwy.spring.boot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);

	void deleteById(long id);
}