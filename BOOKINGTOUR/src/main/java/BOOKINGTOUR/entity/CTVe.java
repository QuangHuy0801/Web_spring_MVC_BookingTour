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
@Table(name="CTVE")
public class CTVe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	
	 @ManyToOne()
	  @JoinColumn(name="CCCDKH") private KhachHang khachHang;
	 
	@ManyToOne()
	@JoinColumn(name="IDVE")
	private VeTour veTour;
	
	  @ManyToOne()
	  @JoinColumn(name="IDKM") private KhuyenMai khuyenMai;
	  
	  
	  @ManyToOne()
	  @JoinColumn(name="MANVXN") private NhanVien nhanVienXN;
	  
	  
	  @ManyToOne()
	  @JoinColumn(name="MANVHUY") private NhanVien nhanVienHuy;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	public VeTour getVeTour() {
		return veTour;
	}


	public void setVeTour(VeTour veTour) {
		this.veTour = veTour;
	}


	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}


	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}


	public NhanVien getNhanVienXN() {
		return nhanVienXN;
	}


	public void setNhanVienXN(NhanVien nhanVienXN) {
		this.nhanVienXN = nhanVienXN;
	}


	public NhanVien getNhanVienHuy() {
		return nhanVienHuy;
	}


	public void setNhanVienHuy(NhanVien nhanVienHuy) {
		this.nhanVienHuy = nhanVienHuy;
	}
	 
	

	
	


	

}
