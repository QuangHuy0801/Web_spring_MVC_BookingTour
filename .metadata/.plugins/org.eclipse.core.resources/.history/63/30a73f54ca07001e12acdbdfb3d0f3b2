package QLXB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DOANHTHUTRAM")
public class DoanhThuTram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	@Column(name="SOVETAP")
	private  int soVeTap;
	

	@ManyToOne()
	  @JoinColumn(name="IDTRAMVE") 
	 private TramVe tramVe;
	
	@ManyToOne()
	  @JoinColumn(name="IDDTN") 
	 private DoanhThuNgay doanhThuNgay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoVeTap() {
		return soVeTap;
	}

	public void setSoVeTap(int soVeTap) {
		this.soVeTap = soVeTap;
	}

	public TramVe getTramVe() {
		return tramVe;
	}

	public void setTramVe(TramVe tramVe) {
		this.tramVe = tramVe;
	}

	public DoanhThuNgay getDoanhThuNgay() {
		return doanhThuNgay;
	}

	public void setDoanhThuNgay(DoanhThuNgay doanhThuNgay) {
		this.doanhThuNgay = doanhThuNgay;
	}
	
	
	
	
	

}
