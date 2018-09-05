package pers.yuanwy.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pers.yuanwy.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
	@Query("select u from User u where u.username like concat('%',:username,'%')")
	List<User> findByUserNameLike(@Param("username") String username);

	@Query("select u from User u where u.username = :username")
	User findByUserName(@Param("username") String username);

	List<User> findByUsernameLike(String username);
}