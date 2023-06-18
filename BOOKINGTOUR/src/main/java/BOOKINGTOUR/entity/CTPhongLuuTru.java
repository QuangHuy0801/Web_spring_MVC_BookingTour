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
@Table(name="CTPHONGLUUTRU")
public class CTPhongLuuTru {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="NGAYDEN")
	private  Date ngayDen;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="NGAYDI")
	private  Date ngayDi;
	
	@Column(name="FULLNGAY")
	private  int fullNgay;
	
	
	
	@ManyToOne()
	@JoinColumn(name="IDBK")
	private BookingTour bookingTour;


	@ManyToOne()
	@JoinColumn(name="IDPHONG")
	private Phong phong;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getNgayDen() {
		return ngayDen;
	}


	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}


	public Date getNgayDi() {
		return ngayDi;
	}


	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}


	public int getFullNgay() {
		return fullNgay;
	}


	public void setFullNgay(int fullNgay) {
		this.fullNgay = fullNgay;
	}


	


	


	public BookingTour getBookingTour() {
		return bookingTour;
	}


	public void setBookingTour(BookingTour bookingTour) {
		this.bookingTour = bookingTour;
	}


	public Phong getPhong() {
		return phong;
	}


	public void setPhong(Phong phong) {
		this.phong = phong;
	}


	

}
