package com.nikola;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;



@Entity //oznacuva deka ke se kreira tabela t.e entitet Costumer vo databazata 
public class Costumer {
@Id //ova oznacuva deka tortkata id ke bide primaren kluc vo tabelata
@SequenceGenerator(name = "costumer_id_sequence",sequenceName = "costumer_id_sequence")//kreirame sekvenca?
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costumer_id_sequence")
private Integer id;

private String name;
private String email;
private Integer age;

public Costumer () {
	
}
public Costumer(Integer id, String name, String email, Integer age) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.age = age;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
@Override
public int hashCode() {
	return Objects.hash(age, email, id, name);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Costumer other = (Costumer) obj;
	return Objects.equals(age, other.age) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
			&& Objects.equals(name, other.name);
}



}
