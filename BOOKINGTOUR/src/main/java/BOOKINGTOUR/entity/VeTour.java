package BOOKINGTOUR.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="VETOUR")
public class VeTour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	
	@Column(name="GIAVE")
	private  int giaVe;
	
	@Column(name="PHIDICHUYEN")
	private  int phiDiChuyen;
	@Column(name="GIACOC")
	private  int giaCoc;
	
	
	
	@ManyToOne() 
	 @JoinColumn(name="IDBK")
	private BookingTour bookingTour1;
	
	@OneToMany(mappedBy = "veTour", fetch = FetchType.LAZY)
	private List<CTVe> cTve;
	
	@ManyToOne()
	@JoinColumn(name="IDLV")
	private LoaiVe loaiVe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	public int getPhiDiChuyen() {
		return phiDiChuyen;
	}

	public void setPhiDiChuyen(int phiDiChuyen) {
		this.phiDiChuyen = phiDiChuyen;
	}

	public int getGiaCoc() {
		return giaCoc;
	}

	public void setGiaCoc(int giaCoc) {
		this.giaCoc = giaCoc;
	}

	public BookingTour getBookingTour1() {
		return bookingTour1;
	}

	public void setBookingTour1(BookingTour bookingTour1) {
		this.bookingTour1 = bookingTour1;
	}

	public List<CTVe> getcTve() {
		return cTve;
	}

	public void setcTve(List<CTVe> cTve) {
		this.cTve = cTve;
	}

	public LoaiVe getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(LoaiVe loaiVe) {
		this.loaiVe = loaiVe;
	}

	
	
	
	

}
