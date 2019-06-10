package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryVo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	@Column(name="CategoryName")
	private String categoryname;
	
	@Column(name="Description")
	private String categorydes;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorydes() {
		return categorydes;
	}

	public void setCategorydes(String categorydes) {
		this.categorydes = categorydes;
	}

}