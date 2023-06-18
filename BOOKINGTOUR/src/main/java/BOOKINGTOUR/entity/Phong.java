package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PHONG")
public class Phong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	@Column(name="TENPHONG")
	private  String ten;
	@Column(name="GIA")
	private  int gia;
	@Column(name="SOGIUONG")
	private  int soGiuong;
	@Column(name="SLNGUOIMAX")
	private  int sLNMax;
	
	@Column(name="HANGPHONG")
	private  String hangPhong;
	
	@OneToMany(mappedBy = "phong", fetch = FetchType.LAZY)
	private List<CTPhongLuuTru> ctPhongLuuTrus;
	
	@ManyToOne()
	@JoinColumn(name="IDNLT")
	private NoiLuuTru noiLuuTru1;

	


	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}


	public String getHangPhong() {
		return hangPhong;
	}

	public void setHangPhong(String hangPhong) {
		this.hangPhong = hangPhong;
	}

	

	public NoiLuuTru getNoiLuuTru1() {
		return noiLuuTru1;
	}

	public void setNoiLuuTru1(NoiLuuTru noiLuuTru1) {
		this.noiLuuTru1 = noiLuuTru1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getsLNMax() {
		return sLNMax;
	}

	public void setsLNMax(int sLNMax) {
		this.sLNMax = sLNMax;
	}

	public List<CTPhongLuuTru> getCtPhongLuuTrus() {
		return ctPhongLuuTrus;
	}

	public void setCtPhongLuuTrus(List<CTPhongLuuTru> ctPhongLuuTrus) {
		this.ctPhongLuuTrus = ctPhongLuuTrus;
	}


	
	

}
