/**
 * @author: Felipe Bernardes Cisilo
 */
package br.edu.fateczl.atividade08.model;

public class IngressoVIP extends Ingresso{
    private String funcao;

    public IngressoVIP(String id, float valor, String funcao) {
        super();
        this.funcao = funcao;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        float valorBase = super.valorFinal(taxaConveniencia);
        return valorBase * 1.18f;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}