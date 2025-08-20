import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 3.1 Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Imprimir funcionários
        System.out.println("---- Lista de Funcionários ----");
        funcionarios.forEach(System.out::println);

        // 3.2 Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 Imprimir funcionários
        System.out.println("\n---- Lista de Funcionários (Após remover João) ----");
        funcionarios.forEach(System.out::println);

        // 3.4 Aumento de 10%
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.10"))));

        System.out.println("\n---- Lista de Funcionários (Após aumento de 10%) ----");
        funcionarios.forEach(System.out::println);

        // 3.5 Agrupar por função
        Map<String, List<Funcionario>> agrupadosPorFuncao =
                funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\n---- Agrupados por Função ----");
        agrupadosPorFuncao.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(System.out::println);
        });

        // 3.8 Aniversário em outubro e dezembro
        System.out.println("\n---- Aniversariantes (10 e 12) ----");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(System.out::println);

        // 3.9 Funcionário com maior idade
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("\n---- Funcionário mais velho ----");
            System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade);
        }

        // 3.10 Lista em ordem alfabética
        System.out.println("\n---- Funcionários em Ordem Alfabética ----");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // 3.11 Total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos Salários: " + String.format("%,.2f", totalSalarios).replace(",", "v").replace(".", ",").replace("v", "."));

        // 3.12 Salários mínimos
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\n---- Salários Mínimos ----");
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos.");
        });
    }
}
