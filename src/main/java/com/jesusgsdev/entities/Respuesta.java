
package com.jesusgsdev.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "respuesta")
public class Respuesta extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String	textoRespuesta;
	private Boolean	seleccionada;

	public Respuesta() { }

	public Respuesta(String	textoRespuesta, Boolean	seleccionada) {
		this.textoRespuesta = textoRespuesta;
		this.seleccionada = seleccionada;
	}


	@NotBlank
	public String gettextoRespuesta() {
		return this.textoRespuesta;
	}

	public void settextoRespuesta(final String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public Boolean getSeleccionada() {
		return this.seleccionada;
	}

	public void setSeleccionada(final Boolean seleccionada) {
		this.seleccionada = seleccionada;
	}


	// Relationships
	private Pregunta pregunta;


	@ManyToOne
	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(final Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Respuesta respuesta = (Respuesta) o;
		return Objects.equals(textoRespuesta, respuesta.textoRespuesta) &&
				Objects.equals(seleccionada, respuesta.seleccionada);
	}

	@Override
	public int hashCode() {

		return Objects.hash(textoRespuesta, seleccionada);
	}
}

