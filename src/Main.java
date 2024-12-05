import enums.TipoCalculadora;
import exceptions.CpfInvalidoException;
import exceptions.EmailInvalidoException;
import exceptions.EnderecoInvalidoException;
import factory.CalculadoraFactory;
import interfaces.Calculadora;
import models.Funcionario;

public class Main {
    public static void main(String[] args) {
        try {
            // Criando funcionários válidos
            Funcionario func1 = new Funcionario("João", "12345678901", "Rua A", "joao@email.com", true, 50, 160, 20);
            Funcionario func2 = new Funcionario("Maria", "98765432109", "Rua B", "maria@email.com", true, 60, 180, 30);

            // Funcionários inválidos para testar exceções
            try {
                Funcionario func3 = new Funcionario("José", "45678", "Rua C", "jose@email.com", false, 70, 200, 50);
            } catch (CpfInvalidoException e) {
                System.out.println("Erro ao criar funcionário: " + e.getMessage());
            }

            try {
                Funcionario func4 = new Funcionario("Ana", "78912345678", "", "ana@email.com", true, 40, 150, 10);
            } catch (EnderecoInvalidoException e) {
                System.out.println("Erro ao criar funcionário: " + e.getMessage());
            }

            try {
                Funcionario func5 = new Funcionario("Pedro", "32165498700", "Rua E", "pedro#email.com", true, 55, 140, 15);
            } catch (EmailInvalidoException e) {
                System.out.println("Erro ao criar funcionário: " + e.getMessage());
            }

            // Calculadoras
            Calculadora salarioCalc = CalculadoraFactory.getCalculadora(TipoCalculadora.SALARIO);
            Calculadora extraCalc = CalculadoraFactory.getCalculadora(TipoCalculadora.EXTRA);
            Calculadora bonusCalc = CalculadoraFactory.getCalculadora(TipoCalculadora.BONUS);

            // Calculando valores para funcionários válidos
            System.out.println("Salário João: " + salarioCalc.calcular(func1));
            System.out.println("Extras João: " + extraCalc.calcular(func1));
            System.out.println("Bônus João: " + bonusCalc.calcular(func1));

            System.out.println("Salário Maria: " + salarioCalc.calcular(func2));
            System.out.println("Extras Maria: " + extraCalc.calcular(func2));
            System.out.println("Bônus Maria: " + bonusCalc.calcular(func2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
