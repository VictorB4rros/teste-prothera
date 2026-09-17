package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static utils.Conversor.formatoData;
import static utils.Conversor.formatoMoeda;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aumentoSalario(BigDecimal porcentagem) {
        this.salario = this.salario.multiply(BigDecimal.ONE.add(porcentagem.divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP)));
    }

    @Override
    public String toString() {
        return "Funcionario {" +
                "Nome = '" + super.getNome() + '\'' +
                ", Data de nascimento = " + formatoData(super.getDataNascimento()) +
                ", Salário = " + formatoMoeda(salario) +
                ", Função = '" + funcao + '\'' +
                '}';
    }
}
