package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="KHACHHANG")
public class KhachHang {
	@Id
	@Column(name="CCCD")
	private  String cCCD;
	
	@Column(name="HO")
	private  String ho;
	@Column(name="TEN")
	private  String ten;
	
	@Column(name="SDT")
	private  String sDT;
	@Column(name="EMAIL")
	private  String email;
	@Column(name="GHICHU")
	private  String ghiChu;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.EAGER)
	private List<CTVe> cTve;




	

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<CTVe> getcTve() {
		return cTve;
	}

	public void setcTve(List<CTVe> cTve) {
		this.cTve = cTve;
	}
	
	

}
