package services;

import exceptions.FuncionarioInativoException;
import exceptions.HorasTrabalhadasInvalidasException;
import exceptions.ValorHoraInvalidoException;
import interfaces.Calculadora;
import models.Funcionario;

public class CalculadoraSalario implements Calculadora {
    @Override
    public double calcular(Funcionario f) throws Exception {
        if (!f.isAtivo()) {
            throw new FuncionarioInativoException("Funcionário não está ativo.");
        }
        if (f.getValorHora() <= 0) {
            throw new ValorHoraInvalidoException("Valor da hora inválido.");
        }
        if (f.getHorasTrabalhadas() < 0) {
            throw new HorasTrabalhadasInvalidasException("Horas trabalhadas não podem ser negativas.");
        }
        return f.getValorHora() * f.getHorasTrabalhadas();
    }
}