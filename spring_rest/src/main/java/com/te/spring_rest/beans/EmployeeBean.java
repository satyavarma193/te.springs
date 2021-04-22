package com.te.spring_rest.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
@XmlRootElement(name = "employee-info")
@JsonRootName("employee-info")
@JsonPropertyOrder({ "id", "name" })
public class EmployeeBean implements Serializable {

	@Id
	@Column
	private Integer id;
	@Column
	private String name;
	@Column(name = "dob")
	private Date birthDate;
	@Column
	@XmlTransient
	private String password;

}
