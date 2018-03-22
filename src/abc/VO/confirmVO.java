package abc.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="confirmation")

public class confirmVO {

	@Id
	@Column(name="confirmId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int confirmId;
	
	@Column(name="trdate")
	private String trdate;

	@Column(name="ccode")
	private String ccode;
	
	@Column(name="confirmpin")
	private String confirmpin;

	@Column(name="userid")
	private String userid;

	@Column(name="clientconfirm")
	private String clientconfirm;
	
	@Column(name="comment")
	private String comment="";
	
	@Column(name="noreplycount")
	private String noreplycount="0";
	
	public String getNoreplycount() {
		return noreplycount;
	}

	public void setNoreplycount(String noreplycount) {
		this.noreplycount = noreplycount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/*
	@Column(name="clientfilepath")
	private String clientfilepath="1";
	

	public String getClientfilepath() {
		return clientfilepath;
	}

	public void setClientfilepath(String clientfilepath) {
		this.clientfilepath = clientfilepath;
	}
*/
	public String getClientconfirm() {
		return clientconfirm;
	}

	public void setClientconfirm(String clientconfirm) {
		this.clientconfirm = clientconfirm;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getConfirmId() {
		return confirmId;
	}

	public void setConfirmId(int confirmId) {
		this.confirmId = confirmId;
	}

	public String getTrdate() {
		return trdate;
	}

	public void setTrdate(String trdate) {
		this.trdate = trdate;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getConfirmpin() {
		return confirmpin;
	}

	public void setConfirmpin(String confirmpin) {
		this.confirmpin = confirmpin;
	}
	

}
