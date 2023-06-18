package BOOKINGTOUR.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="CTTOUR")
public class CTTour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private  int id;

	
	@ManyToOne()
	  @JoinColumn(name="IDDDL") private DiemDuLich diemDuLich;
	 
	
	@ManyToOne()
	@JoinColumn(name="IDTOUR")
	private Tour tour;
	
	
	@Column(name="THUTU")
	private  int thuTu;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	  public DiemDuLich getDiemDuLich() { return diemDuLich; } public void
	  setDiemDuLich(DiemDuLich diemDuLich) { this.diemDuLich = diemDuLich; }
	 
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public int getThuTu() {
		return thuTu;
	}
	public void setThuTu(int thuTu) {
		this.thuTu = thuTu;
	}
	

	
}
