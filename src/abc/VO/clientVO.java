package abc.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientDetails")
public class clientVO {

	@Id 
	@Column(name="clientCode")
	private String clientCode;
	
	@Column(name="clientName")
	private String clientCname;
	
	@Column(name="clientPhn")
	private String clientPhn;
	
	@Column(name="clientEmail")
	private String clientEmail;

	@Column(name="clientConfirm")
	private String clientConfirm="Y";


	public String getClientConfirm() {
		return clientConfirm;
	}

	public void setClientConfirm(String clientConfirm) {
		this.clientConfirm = clientConfirm;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientCname() {
		return clientCname;
	}

	public void setClientCname(String clientCname) {
		this.clientCname = clientCname;
	}

	public String getClientPhn() {
		return clientPhn;
	}

	public void setClientPhn(String clientPhn) {
		this.clientPhn = clientPhn;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	
}
