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
@Table(name="NOILUUTRU")
public class NoiLuuTru {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	@Column(name="TENNLT")
	private  String tenNLT;
	@Column(name="DIACHI")
	private  String diaChi;
	@Column(name="SDT")
	private  String sDT;
	@Column(name="EMAIL")
	private  String email;
	@Column(name="LOAICHATLUONG")
	private  int chatLuong;
	@Column(name="MOTA")
	private  String moTa;

	
	@ManyToOne()
	@JoinColumn(name="IDLLT")
	private LoaiLuuTru loaiLuuTru;

	 @OneToMany(mappedBy = "noiLuuTru1", fetch = FetchType.EAGER) 
		 List<Phong> phong; 

	public List<Phong> getPhong() {
		return phong;
	}


	public void setPhong(List<Phong> phong) {
		this.phong = phong;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTenNLT() {
		return tenNLT;
	}


	public void setTenNLT(String tenNLT) {
		this.tenNLT = tenNLT;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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


	public int getChatLuong() {
		return chatLuong;
	}


	public void setChatLuong(int chatLuong) {
		this.chatLuong = chatLuong;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public LoaiLuuTru getLoaiLuuTru() {
		return loaiLuuTru;
	}


	public void setLoaiLuuTru(LoaiLuuTru loaiLuuTru) {
		this.loaiLuuTru = loaiLuuTru;
	}

	
	
	
	
	

}
