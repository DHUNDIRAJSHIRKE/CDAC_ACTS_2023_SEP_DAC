package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.Id;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
