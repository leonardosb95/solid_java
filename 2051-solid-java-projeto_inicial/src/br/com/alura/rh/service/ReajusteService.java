package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	private List<ValidacaoReajuste> validacoes;//lista de validacoes
	
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}
	
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v ->v.validar(funcionario, aumento)); //ele executa cada uma das validacoes, utilizando lambda
		BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);//Pegamos o salario atual do funcionario
		funcionario.atualizarSalario(salarioReajustado);
	}
	
	
}
