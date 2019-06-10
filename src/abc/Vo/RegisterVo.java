package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class RegisterVo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int registerId;
	
	@Column(name="FirstName")
	private String fn;
	
	@Column(name="Lastname")
	private String ln;
	
	@Column(name="Gender")
	private String gender;

	
	@Column(name="ContactNumber")
	private String cn;

	@Column(name="Email")
	private String email;

	@ManyToOne LoginVo lvo;

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginVo getLvo() {
		return lvo;
	}

	public void setLvo(LoginVo lvo) {
		this.lvo = lvo;
	}
	

}
