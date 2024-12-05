package models;

import exceptions.CpfInvalidoException;
import exceptions.EmailInvalidoException;
import exceptions.EnderecoInvalidoException;

public class Funcionario {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private boolean ativo;
    private double valorHora;
    private int horasTrabalhadas;
    private int horasExtra;

    public Funcionario(String nome, String cpf, String endereco, String email, boolean ativo, double valorHora, int horasTrabalhadas, int horasExtra)
            throws CpfInvalidoException, EnderecoInvalidoException, EmailInvalidoException {
        if (!cpf.matches("\\d{11}")) {
            throw new CpfInvalidoException("CPF deve conter 11 dígitos numéricos.");
        }
        if (endereco == null || endereco.isEmpty()) {
            throw new EnderecoInvalidoException("Endereço não pode ser vazio ou nulo.");
        }
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new EmailInvalidoException("E-mail inválido.");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.ativo = ativo;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExtra = horasExtra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
}