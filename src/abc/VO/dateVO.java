package abc.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dates")

public class dateVO {

	public int getDateId() {
		return dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}



	@Id
	@Column(name="dateId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dateId;
	
	@Column(name="dates")
	private String dates;

	@Column(name="exchange")
	private String exchange;

	@Column(name="fpath")
	private String fpath;

	@Column(name="dpin")
	private String dpin;
	
	@Column(name="rows")
	private String rows;
	

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getDpin() {
		return dpin;
	}

	public void setDpin(String dpin) {
		this.dpin = dpin;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

}
