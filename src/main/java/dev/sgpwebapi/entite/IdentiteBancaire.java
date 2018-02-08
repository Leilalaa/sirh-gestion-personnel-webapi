package dev.sgpwebapi.entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdentiteBancaire {

	@Column(name = "BANQUE")
	private String banque;
	@Column(name = "BIC")
	private String bic;
	@Column(name = "IBAN")
	private String iban;
	
	public IdentiteBancaire() {
		
	}
	
	public IdentiteBancaire(String banque, String bic, String iban, Collaborateur collaborateur) {
		this.banque = banque;
		this.bic = bic;
		this.iban = iban;
	}
	
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}

	

}
