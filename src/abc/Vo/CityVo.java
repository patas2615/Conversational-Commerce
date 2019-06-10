package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class CityVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cityId;
	
	@Column(name="CityName")
	private String cityname;
	
	@Column(name="Description")
	private String citydes;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCitydes() {
		return citydes;
	}

	public void setCitydes(String citydes) {
		this.citydes = citydes;
	}

	
}
