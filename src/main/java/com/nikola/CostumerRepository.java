package com.nikola;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Integer>{ //costumerRepository ke ni ovozmozuva da CREATE, UPDATE
	//DELETE and READ operacii so databazata, zatoa nasleduvame od JpaRepository, koj prima dva generika
	//toa e imeto na tabelata t.e Entitetot (klasata koja ja imame) i data tipot na id

}
