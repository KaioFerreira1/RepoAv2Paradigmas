package factory;

import enums.TipoCalculadora;
import exceptions.TipoCalculadoraInvalidoException;
import interfaces.Calculadora;
import services.CalculadoraBonus;
import services.CalculadoraExtra;
import services.CalculadoraSalario;

public class CalculadoraFactory {
    public static Calculadora getCalculadora(TipoCalculadora tipo) throws TipoCalculadoraInvalidoException {
        switch (tipo) {
            case SALARIO:
                return new CalculadoraSalario();
            case EXTRA:
                return new CalculadoraExtra();
            case BONUS:
                return new CalculadoraBonus();
            default:
                throw new TipoCalculadoraInvalidoException("Tipo de calculadora inválido.");
        }
    }
}