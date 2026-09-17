import entidades.Funcionario;
import entidades.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static utils.Conversor.formatoMoeda;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));

        funcionarios.remove(1);

        System.out.println();
        System.out.println("Funcionário João removido:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        for (Funcionario funcionario : funcionarios) {
            funcionario.aumentoSalario(BigDecimal.valueOf(10));
        }

        Map<String, List<Funcionario>> agrupamentoFuncao = new HashMap<>();
        agrupamentoFuncao.put("Operadores", funcionarios.stream().filter(x -> x.getFuncao().equals("Operador")).toList());
        agrupamentoFuncao.put("Coordenadores", funcionarios.stream().filter(x -> x.getFuncao().equals("Coordenador")).toList());
        agrupamentoFuncao.put("Diretores", funcionarios.stream().filter(x -> x.getFuncao().equals("Diretor")).toList());
        agrupamentoFuncao.put("Recepcionistas", funcionarios.stream().filter(x -> x.getFuncao().equals("Recepcionista")).toList());
        agrupamentoFuncao.put("Contadores", funcionarios.stream().filter(x -> x.getFuncao().equals("Contador")).toList());
        agrupamentoFuncao.put("Gerentes", funcionarios.stream().filter(x -> x.getFuncao().equals("Gerente")).toList());
        agrupamentoFuncao.put("Eletricistas", funcionarios.stream().filter(x -> x.getFuncao().equals("Eletricista")).toList());

        System.out.println();
        System.out.println("Funcionários agrupados por função e com aumento de 10% de salário:");
        for (Map.Entry<String, List<Funcionario>> agrupamento : agrupamentoFuncao.entrySet()) {
            System.out.println(agrupamento);
        }

        System.out.println();
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12) {
                System.out.println(funcionario);
            }
        }

        System.out.println();
        System.out.println("Funcionário com a maior idade:");
        LocalDate nascimentoMaisLonginquo = LocalDate.now();
        Funcionario funcionarioComMaiorIdade = new Funcionario();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(nascimentoMaisLonginquo)) {
                nascimentoMaisLonginquo = funcionario.getDataNascimento();
                funcionarioComMaiorIdade = funcionario;
            }
        }
        Period idade = Period.between(funcionarioComMaiorIdade.getDataNascimento(), LocalDate.now());
        System.out.println("Nome: " + funcionarioComMaiorIdade.getNome() + ", " + "idade: " + idade.getYears());

        System.out.println();
        System.out.println("Funcionários por ordem alfabética:");
        funcionarios.sort(Comparator.comparing(Pessoa::getNome));
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        System.out.println();
        System.out.println("Total de salários:");
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            total = total.add(funcionario.getSalario());
        }
        System.out.println(formatoMoeda(total));
    }
}