package BOOKINGTOUR.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="NHANVIEN")
public class NhanVien {
	@Id
	@Column(name="MANV")
	private  String maNV;
	@Column(name="HO")
	private  String ho;
	@Column(name="TEN")
	private  String ten;
	@Column(name="CCCD")
	private  String cCCD;
	@Column(name="GIOITINH")
	private  String gioiTinh;
	@Column(name = "NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	@Column(name="SDT")
	private  String sDT;
	@Column(name="DIACHI")
	private  String diaChi;
	@Column(name="EMAIL")
	private  String email;
	@Column(name="TRANGTHAI")
	private  int trangThai;
	
	@OneToOne(mappedBy = "nhanVien", fetch = FetchType.EAGER)
    private TaiKhoan taiKhoan;

	@OneToMany(mappedBy = "nhanVienXN", fetch = FetchType.EAGER)
	private List<CTVe> ctVeXN;
	
	@OneToMany(mappedBy = "nhanVienHuy", fetch = FetchType.EAGER)
	private List<CTVe> ctVeHuy;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}





	public List<CTVe> getCtVeXN() {
		return ctVeXN;
	}

	public void setCtVeXN(List<CTVe> ctVeXN) {
		this.ctVeXN = ctVeXN;
	}

	public List<CTVe> getCtVeHuy() {
		return ctVeHuy;
	}

	public void setCtVeHuy(List<CTVe> ctVeHuy) {
		this.ctVeHuy = ctVeHuy;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public TaiKhoan getTaikhoan() {
		return taiKhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taiKhoan = taikhoan;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	

}
