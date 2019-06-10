package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complain")
public class ComplainVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complainId;
	
	@Column
	private String comptitle;
	
	@Column
	private String compdes;

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public String getComptitle() {
		return comptitle;
	}

	public void setComptitle(String comptitle) {
		this.comptitle = comptitle;
	}

	public String getCompdes() {
		return compdes;
	}

	public void setCompdes(String compdes) {
		this.compdes = compdes;
	}

	
}
