package br.com.igor.cafecg_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String nome;
    private float preco;
    private String descricao;


}
