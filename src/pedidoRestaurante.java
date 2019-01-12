package main;

public class pedidoRestaurante {
	
	
	private String horario;
	private String pratoPrincipal;
	private String acompanhamento;
	private String bebida;
	private String sobremesa;
	private String nomeCliente;
	
	private int quantidadePratoPrincipal = 0;
	private int quantidadeAcompanhamento = 0;
	private int quantidadeBebida = 0;
	private int quantidadeSobremesa = 0;

	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getPratoPrincipal() {
		return pratoPrincipal;
	}
	
	public void setPratoPrincipal(String pratoPrincipal) {
		this.pratoPrincipal = pratoPrincipal;
	}
	
	public String getAcompanhamento() {
		return acompanhamento;
	}
	
	public void setAcompanhamento(String acompanhamento) {
		this.acompanhamento = acompanhamento;
	}
	
	public String getBebida() {
		return bebida;
	}
	
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
	
	public String getSobremesa() {
		return sobremesa;
	}
	
	public void setSobremesa(String sobremesa) {
		this.sobremesa = sobremesa;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getQuantidadePratoPrincipal() {
		return quantidadePratoPrincipal;
	}

	public void setQuantidadePratoPrincipal(int quantidadePratoPrincipal) {
		this.quantidadePratoPrincipal = quantidadePratoPrincipal;
	}

	public int getQuantidadeAcompanhamento() {
		return quantidadeAcompanhamento;
	}

	public void setQuantidadeAcompanhamento(int quantdadeAcompanhamento) {
		this.quantidadeAcompanhamento = quantdadeAcompanhamento;
	}

	public int getQuantidadeBebida() {
		return quantidadeBebida;
	}

	public void setQuantidadeBebida(int quantidadeBebida) {
		this.quantidadeBebida = quantidadeBebida;
	}

	public int getQuantidadeSobremesa() {
		return quantidadeSobremesa;
	}

	public void setQuantidadeSobremesa(int quantidadeSobremesa) {
		this.quantidadeSobremesa = quantidadeSobremesa;
	}

}
