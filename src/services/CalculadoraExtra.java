package services;

import exceptions.FuncionarioInativoException;
import exceptions.HorasExtrasInvalidasException;
import exceptions.ValorHoraInvalidoException;
import interfaces.Calculadora;
import models.Funcionario;

public class CalculadoraExtra implements Calculadora {
    @Override
    public double calcular(Funcionario f) throws Exception {
        if (!f.isAtivo()) {
            throw new FuncionarioInativoException("Funcionário não está ativo.");
        }
        if (f.getValorHora() <= 0) {
            throw new ValorHoraInvalidoException("Valor da hora inválido.");
        }
        if (f.getHorasExtra() < 0) {
            throw new HorasExtrasInvalidasException("Horas extras não podem ser negativas.");
        }
        return f.getValorHora() * f.getHorasExtra();
    }
}