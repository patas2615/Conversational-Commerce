package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name="area")
@Entity


public class AreaVo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int areaId;
		
		@Column(name="AreaName")
		private String areaname;
		
		@Column(name="AreaDescription")
		private String areades;
		
		@ManyToOne CityVo cityvo;

		public int getAreaId() {
			return areaId;
		}

		public void setAreaId(int areaId) {
			this.areaId = areaId;
		}

		public String getAreaname() {
			return areaname;
		}

		public void setAreaname(String areaname) {
			this.areaname = areaname;
		}

		public String getAreades() {
			return areades;
		}

		public void setAreades(String areades) {
			this.areades = areades;
		}

		public CityVo getCityvo() {
			return cityvo;
		}

		public void setCityvo(CityVo cityvo) {
			this.cityvo = cityvo;
		}
		

}
