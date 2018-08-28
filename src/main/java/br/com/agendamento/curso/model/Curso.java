package br.com.agendamento.curso.model;

import com.owlike.genson.annotation.JsonIgnore;
import com.owlike.genson.annotation.JsonProperty;

public class Curso implements AbstractModel{

	
	@JsonProperty("Id")
	private Long id;

	@JsonProperty("Titlulo")
	private String titulo;

	@JsonProperty("cargaHoraria")
	private CargaHoraria cargaHoraria;

	@JsonProperty("dataInicio")
	private String dataInicio;

	public Curso() {
		super();
	}

	public Curso(Long id, String titulo, CargaHoraria cargaHoraria, String dataInicio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.cargaHoraria = cargaHoraria;
		this.dataInicio = dataInicio;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@JsonIgnore
	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(CargaHoraria cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@JsonIgnore
	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", cargaHoraria=" + cargaHoraria + ", dataInicio="
				+ dataInicio + "]";
	}

	
	
}
