package entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getDataNascimento(), pessoa.getDataNascimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDataNascimento());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
