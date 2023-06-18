package BOOKINGTOUR.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;





@Entity
@Table(name="TAIKHOAN")
public class TaiKhoan {
	@Id
	@Column(name="MANV")
	private String MANV;
	
	@OneToOne()
	@MapsId
	 @JoinColumn(name="MANV")
    private NhanVien nhanVien;
	
	@Column(name="PASSWORD")
	private  String PASSWORD;
	
	
	@Column(name="ISADMIN")
	private  int isAdmin;
	
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	

	
	
	
	
	
	

}
