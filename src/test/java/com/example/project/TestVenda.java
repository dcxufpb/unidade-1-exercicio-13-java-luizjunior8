package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestVenda {

    private void verificarCampoObrigatorio(String mensagemEsperada, Venda venda) {
		try {
			venda.dadosVenda();
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
    }

    private String NOME_LOJA = "Loja 1";
	private String LOGRADOURO = "Log 1";
	private int NUMERO = 10;
	private String COMPLEMENTO = "C1";
	private String BAIRRO = "Bai 1";
	private String MUNICIPIO = "Mun 1";
	private String ESTADO = "E1";
	private String CEP = "11111-111";
	private String TELEFONE = "(11) 1111-1111";
	private String OBSERVACAO = "Obs 1";
	private String CNPJ = "11.111.111/1111-11";
    private String INSCRICAO_ESTADUAL = "123456789";
    private String DATA_HORA = Venda.getSystemData();
    private int CCF = 123456;
    private int COO = 654321;
    
    private Endereco brickEndereco = new Endereco(LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO, ESTADO, CEP);
    
    private Loja brickLoja = new Loja (NOME_LOJA, brickEndereco, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);

    @Test	
	public void validLoja() {
        Venda lojaNull = new Venda (null, DATA_HORA, CCF, COO);
		verificarCampoObrigatorio("Informe uma loja válida", lojaNull);
    }
    @Test
    public void validTime() {
        Venda nullTime = new Venda (brickLoja, null, CCF, COO);
        verificarCampoObrigatorio("A data e a hora são obrigatórias", nullTime);

        Venda emptyTime = new Venda (brickLoja, "", CCF, COO);
        verificarCampoObrigatorio("A data e a hora são obrigatórias", emptyTime);
    }
    @Test
    public void validCCF() {
        Venda nullCcf = new Venda(brickLoja, DATA_HORA, 0, COO);
        verificarCampoObrigatorio("O campo ccf é obrigatório", nullCcf);
    }
    @Test
    public void validCOO() {
        Venda nullCoo = new Venda(brickLoja, DATA_HORA, CCF, 0);
        verificarCampoObrigatorio("O campo coo é obrigatório", nullCoo);
    }
}