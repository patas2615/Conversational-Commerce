package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="subcategory")
public class SubCategoryVo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int subcategoryId;
		
		@Column(name="SubCategoryName")
		private String subcategoryname;
		
		@Column(name="SubDescription")
		private String subcategorydes;
		
		@ManyToOne CategoryVo catvo;

		public int getSubcategoryId() {
			return subcategoryId;
		}

		public void setSubcategoryId(int subcategoryId) {
			this.subcategoryId = subcategoryId;
		}

		public String getSubcategoryname() {
			return subcategoryname;
		}

		public void setSubcategoryname(String subcategoryname) {
			this.subcategoryname = subcategoryname;
		}

		public String getSubcategorydes() {
			return subcategorydes;
		}

		public void setSubcategorydes(String subcategorydes) {
			this.subcategorydes = subcategorydes;
		}

		public CategoryVo getCatvo() {
			return catvo;
		}

		public void setCatvo(CategoryVo catvo) {
			this.catvo = catvo;
		}
		
		


}
