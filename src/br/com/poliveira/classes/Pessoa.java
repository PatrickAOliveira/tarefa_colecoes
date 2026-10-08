package br.com.poliveira.classes;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String sexo;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String sexo) {
        this(nome);
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Permite ordenar objetos Pessoa pelo nome automaticamente com
    // Collections.sort()
    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.getNome());
    }

    @Override
    public String toString() {
        return nome + " (" + sexo + ")";
    }
}
