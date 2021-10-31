package com.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservations")
public class Reservations implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	private Timestamp startDate;
	private Timestamp devolutionDate;
	private String status = "created";

	@ManyToOne
	@JoinColumn(name = "skateId")
	@JsonIgnoreProperties({"reservations", "client"})
	private Skateboard skate;

	@ManyToOne
	@JoinColumn(name = "ClientId")
	@JsonIgnoreProperties({"messages", "reservations"})
	private Client client;

	private String score;

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Timestamp devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Skateboard getSkate() {
		return skate;
	}

	public void setSkate(Skateboard skate) {
		this.skate = skate;
	}

}
