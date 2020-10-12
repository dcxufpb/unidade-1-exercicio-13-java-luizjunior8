package com.example.project;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Venda {
    
    private Loja loja;
    private String dataHora;
    private int ccf;
    private int coo;

    public Venda(Loja loja, String dataHora, int ccf, int coo) {
        this.loja = loja;
        this.ccf = ccf;
        this.coo = coo;
        this.dataHora = getSystemData();
    }

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public int getCcf() {
		return this.ccf;
	}

	public void setCcf(int ccf) {
		this.ccf = ccf;
	}

	public int getCoo() {
		return this.coo;
	}

	public void setCoo(int coo) {
		this.coo = coo;
	}

	public String getdataHora() {
		return this.dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
    }
        
    
    public static String getSystemData() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

  
    public void validar_dados_obrigatorios() {

        if (this.loja == null){
            throw new RuntimeException ("Informe uma loja válida");
        }

        if (this.ccf == 0){
            throw new RuntimeException ("O campo ccf é obrigatório");
        }

        if (this.coo == 0){
            throw new RuntimeException ("O campo coo é obrigatório");
        }

        if (this.dataHora == null || this.dataHora == "") {
            throw new RuntimeException ("A data e a hora são obrigatórias");
        }
    }

    public String dadosVenda() {

        this.validar_dados_obrigatorios();

        String _ccf = " CCF:" + this.ccf;

        String _coo = " COO:" + this.coo;

        return (this.getdataHora() + _ccf + _coo);

       
    }
}
