package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prestec database table.
 * 
 */
@Entity
@NamedQuery(name="Prestec.findAll", query="SELECT p FROM Prestec p")
public class Prestec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codi;

	@Column(name="data_prestec")
	private String dataPrestec;

	@Column(name="data_retorn")
	private String dataRetorn;

	private byte retornat;

	//bi-directional many-to-one association to Usuari
	@ManyToOne
	@JoinColumn(name="DNI")
	private Usuari usuari;

	//bi-directional many-to-one association to Llibre
	@ManyToOne
	@JoinColumn(name="ISBN")
	private Llibre llibre;

	public Prestec() {
	}

	public int getCodi() {
		return this.codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	public String getDataPrestec() {
		return this.dataPrestec;
	}

	public void setDataPrestec(String dataPrestec) {
		this.dataPrestec = dataPrestec;
	}

	public String getDataRetorn() {
		return this.dataRetorn;
	}

	public void setDataRetorn(String dataRetorn) {
		this.dataRetorn = dataRetorn;
	}

	public byte getRetornat() {
		return this.retornat;
	}

	public void setRetornat(byte retornat) {
		this.retornat = retornat;
	}

	public Usuari getUsuari() {
		return this.usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public Llibre getLlibre() {
		return this.llibre;
	}

	public void setLlibre(Llibre llibre) {
		this.llibre = llibre;
	}

}