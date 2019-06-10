package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class ShopVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int shopId;
		
		@Column(name="ShopName")
		private String shopname;
		
		@Column(name="Address")
		private String addr;
		
		@Column(name="Lattitude")
		private String lati;
		
		@Column(name="Longitude")
		private String longi;
		
		@ManyToOne CityVo cityvo;
		@ManyToOne AreaVo areavo;
		public int getShopId() {
			return shopId;
		}
		public void setShopId(int shopId) {
			this.shopId = shopId;
		}
		public String getShopname() {
			return shopname;
		}
		public void setShopname(String shopname) {
			this.shopname = shopname;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getLati() {
			return lati;
		}
		public void setLati(String lati) {
			this.lati = lati;
		}
		public String getLongi() {
			return longi;
		}
		public void setLongi(String longi) {
			this.longi = longi;
		}
		public CityVo getCityvo() {
			return cityvo;
		}
		public void setCityvo(CityVo cityvo) {
			this.cityvo = cityvo;
		}
		public AreaVo getAreavo() {
			return areavo;
		}
		public void setAreavo(AreaVo areavo) {
			this.areavo = areavo;
		}
		
}
