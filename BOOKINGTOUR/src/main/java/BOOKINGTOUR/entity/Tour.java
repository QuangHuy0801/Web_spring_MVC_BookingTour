package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TOUR")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;
	@Column(name="TEN")
	private  String ten;
	@Column(name="MOTA")
	private  String moTa;
	
	
	  @OneToMany(mappedBy = "tour1", fetch = FetchType.EAGER) 
	  private List<BookingTour> bookingTours;
	 

	@OneToMany(mappedBy="tour", fetch = FetchType.EAGER)
    private List<CTTour> ctTours ;

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

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<CTTour> getCtTours() {
		return ctTours;
	}

	public void setCtTours(List<CTTour> ctTours) {
		this.ctTours = ctTours;
	}
	
	



	

	
}
