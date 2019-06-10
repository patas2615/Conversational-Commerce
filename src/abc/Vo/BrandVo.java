package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class BrandVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brandId;
	
	@Column(name="BrandName")
	private String brandname;
	
	@Column(name="Description")
	private String branddes;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBranddes() {
		return branddes;
	}

	public void setBranddes(String branddes) {
		this.branddes = branddes;
	}

}

