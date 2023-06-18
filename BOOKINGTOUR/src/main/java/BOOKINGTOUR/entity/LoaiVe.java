package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOAIVE")
public class LoaiVe {
	@Id
	@Column(name="ID")
	private  int id;
	@Column(name="TEN")
	private  String ten;
	
	@OneToMany(mappedBy = "loaiVe", fetch = FetchType.EAGER)
	private List<VeTour> veTours;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<VeTour> getVeTours() {
		return veTours;
	}

	public void setVeTours(List<VeTour> veTours) {
		this.veTours = veTours;
	}

	
	

}
