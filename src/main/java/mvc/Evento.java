package mvc;

import static java.lang.System.out;

import java.util.Calendar;

public class Evento {

   
	
	private float id;
    private String nomeEvento;
    private Calendar dataEvento;
    private String dataString;
    private String numeroConvidados;
    private String localEvento;    
    private String descricaoEvento;
    private String websiteEvento;
    private String enderecoEvento;
    private String complementoEndereco;
    
	public Evento() {}
    
	public String getEnderecoEvento() {
		return enderecoEvento;
	}

	public void setEnderecoEvento(String enderecoEvento) {
		this.enderecoEvento = enderecoEvento;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}
    
	public String getWebsiteEvento() {
		return websiteEvento;
	}

	public void setWebsiteEvento(String websiteEvento) {
		this.websiteEvento = websiteEvento;
	}

        
	public String getDescricaoEvento() {
		return descricaoEvento;
	}


	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}


	public float getId() {
		return id;
	}


	public void setId(float id) {
		this.id = id;
	}


	public String getNomeEvento() {
		return nomeEvento;
	}


	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}


	public Calendar getDataEvento() {
		return dataEvento;
	}


	public void setDataEvento(Calendar dataEvento) {
		this.dataEvento = dataEvento;
	}


	public String getNumeroConvidados() {
		return numeroConvidados;
	}


	public void setNumeroConvidados(String numeroConvidados) {
		this.numeroConvidados = numeroConvidados;
	}


	public String getLocalEvento() {
		return localEvento;
	}


	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}
     
               
}