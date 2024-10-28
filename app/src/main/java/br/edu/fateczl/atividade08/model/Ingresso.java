/**
 * @author: Felipe Bernardes Cisilo
 */
package br.edu.fateczl.atividade08.model;

public class Ingresso {
    private String id;
    private float valor;

    public Ingresso(String id, float valor) {
        this.id = id;
        this.valor = valor;
    }

    public Ingresso() {
        super();
    }

    public float valorFinal(float taxaConveniencia) {
        return valor + taxaConveniencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
