package services;

import exceptions.FuncionarioInativoException;
import exceptions.HorasInvalidasException;
import exceptions.ValorHoraInvalidoException;
import interfaces.Calculadora;
import models.Funcionario;

public class CalculadoraBonus implements Calculadora {
    @Override
    public double calcular(Funcionario f) throws Exception {
        if (!f.isAtivo()) {
            throw new FuncionarioInativoException("Funcionário não está ativo.");
        }
        if (f.getValorHora() <= 0) {
            throw new ValorHoraInvalidoException("Valor da hora inválido.");
        }
        if (f.getHorasTrabalhadas() < 0 || f.getHorasExtra() < 0) {
            throw new HorasInvalidasException("Horas trabalhadas ou extras não podem ser negativas.");
        }
        int totalHoras = f.getHorasTrabalhadas() + f.getHorasExtra();
        if (totalHoras > 200) {
            return f.getValorHora() * f.getHorasTrabalhadas() * 1.15;
        }
        return 0;
    }
}