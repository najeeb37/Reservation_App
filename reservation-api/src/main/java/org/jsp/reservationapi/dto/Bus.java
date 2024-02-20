package org.jsp.reservationapi.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name = "from_loc",nullable = false)
	private String from;
	@Column(name="to_loc",nullable = false)
	private String to;
	@Column(nullable = false)
	private LocalDate dop;
	@Column(name="no_of_seats",nullable = false)
	private int nos;
	@Column(unique = true	)
	private String busNo;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	@JsonIgnore
	private Admin admin;
	
	@OneToMany(mappedBy = "bus")
	private List<Ticket> tickets;
}
