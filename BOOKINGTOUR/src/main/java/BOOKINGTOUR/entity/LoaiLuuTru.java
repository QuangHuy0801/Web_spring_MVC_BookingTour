 package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOAILUUTRU")
public class LoaiLuuTru {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	@Column(name="TEN")
	private  String ten;
	@OneToMany(mappedBy = "loaiLuuTru", fetch = FetchType.EAGER)
	private List<NoiLuuTru> noiLuuTru;
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
	public List<NoiLuuTru> getNoiLuuTru() {
		return noiLuuTru;
	}
	public void setNoiLuuTru(List<NoiLuuTru> noiLuuTru) {
		this.noiLuuTru = noiLuuTru;
	}
	
	
	
}
