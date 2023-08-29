package br.com.anpede.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.anpede.entities.enums.CategoriaEquipamento;

@Entity
@Table(name = "tb_equipamento")
public class Equipamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private String marca;
	@Enumerated(EnumType.STRING)
	private CategoriaEquipamento categoria;
	private String foto;
	private Double valor;
	private Integer quantidade;
	
	@OneToMany(mappedBy = "equipamento", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EquipamentoItem> equipamentosItem;
	
	
	
	public List<EquipamentoItem> getEquipamentosItem() {
		return equipamentosItem;
	}

	public Equipamento() {
		// TODO Auto-generated constructor stub
	}

	public Equipamento(Long id, String nome, String descricao, String marca, CategoriaEquipamento categoria,String foto, Double valor, Integer quantidade,List<EquipamentoItem> equipamentosItem) {

		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.categoria = categoria;
		this.foto = foto;
		this.valor = valor;
		this.quantidade = quantidade;
		this.equipamentosItem = equipamentosItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public CategoriaEquipamento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEquipamento categoria) {
		this.categoria = categoria;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
