package com.wordpress.carledwinj.spring.mockito.rest.model;

public class User {

	private Long id;
	
	private String name;
	
	private String surname;

	public User(){}
	
	public User(Long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long ind) {
		this.id = ind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public static User mock(Long id) {
        User user = new User();
        user.setName("Carl Edwin Antonio");
        user.setSurname("Nascimento");
        user.setId(id);

        return user;
    }
}
