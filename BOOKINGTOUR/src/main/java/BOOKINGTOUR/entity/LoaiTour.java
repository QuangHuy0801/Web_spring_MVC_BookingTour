package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOAITOUR")
public class LoaiTour {
	@Id
	@Column(name="ID")
	private  int id;
	@Column(name="TEN")
	private  String ten;
	
	@OneToMany(mappedBy = "loaiTour", fetch = FetchType.EAGER)
	private List<BookingTour> bookingTours;

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

	public List<BookingTour> getBookingTours() {
		return bookingTours;
	}

	public void setBookingTours(List<BookingTour> bookingTours) {
		this.bookingTours = bookingTours;
	}

	
	
}
