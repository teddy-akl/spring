package pers.yuanwy.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String address;
	private int age;
	private int sex;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	public long getId() {
		return id;
	}

	public User setId(long id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public User setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}

	public int getSex() {
		return sex;
	}

	public User setSex(int sex) {
		this.sex = sex;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public User setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}
}