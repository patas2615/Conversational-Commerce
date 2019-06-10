package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int productId;
		
		@Column(name="ProductName")
		private String productname;
		
		@Column(name="ProductPrice")
		private String pp;
		
		@Column(name="ProductSize")
		private String ps;
		
		@Column(name="ProductColor")
		private String pc;
		
		@Column(name="ProductDescription")
		private String productdes;
		
		@Column(name="ProductImageName")
		private String productImageName;
		
		@Column(name="ProductImagePath")
		private String productImagePath;
		
		public String getProductImageName() {
			return productImageName;
		}
		public void setProductImageName(String productImageName) {
			this.productImageName = productImageName;
		}
		public String getProductImagePath() {
			return productImagePath;
		}
		public void setProductImagePath(String productImagePath) {
			this.productImagePath = productImagePath;
		}
		@ManyToOne CategoryVo catvo;

		@ManyToOne SubCategoryVo subcatvo;
		
		@ManyToOne BrandVo brandvo;
		
		@ManyToOne ShopVo shopvo;
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getPp() {
			return pp;
		}
		public void setPp(String pp) {
			this.pp = pp;
		}
		public String getPs() {
			return ps;
		}
		public void setPs(String ps) {
			this.ps = ps;
		}
		public String getPc() {
			return pc;
		}
		public void setPc(String pc) {
			this.pc = pc;
		}
		public String getProductdes() {
			return productdes;
		}
		public void setProductdes(String productdes) {
			this.productdes = productdes;
		}
		public CategoryVo getCatvo() {
			return catvo;
		}
		public void setCatvo(CategoryVo catvo) {
			this.catvo = catvo;
		}
		public SubCategoryVo getSubcatvo() {
			return subcatvo;
		}
		public void setSubcatvo(SubCategoryVo subcatvo) {
			this.subcatvo = subcatvo;
		}
		public BrandVo getBrandvo() {
			return brandvo;
		}
		public void setBrandvo(BrandVo brandvo) {
			this.brandvo = brandvo;
		}
		public ShopVo getShopvo() {
			return shopvo;
		}
		public void setShopvo(ShopVo shopvo) {
			this.shopvo = shopvo;
		}
		
		
}
