package BOOKINGTOUR.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
@Table(name="BOOKINGTOUR")
public class BookingTour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TGBD")
	private  Date tGBD;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TGKT")
	private Date tGKT;
	
	@Column(name="MAXNL")
	private  int maxNL;
	@Column(name="MAXTE")
	private int maxTE;
	@Column(name="MAXTN")
	private  int maxTN;
	@Column(name="MINNL")
	private int minNL;
	@Column(name="MINTE")
	private  int minTE;
	@Column(name="MINTN")
	private int minTN;
	@Column(name="TRANGTHAI")
	private  int trangThai;
	@Column(name="GHICHU")
	private String ghiChu;

	
	@OneToMany(mappedBy = "bookingTour1", fetch = FetchType.LAZY)
	private List<VeTour> veTours;
	
	@ManyToOne()
	@JoinColumn(name="IDTOUR")
	private Tour tour1;
	
	
	@ManyToOne()
	@JoinColumn(name="IDLT")
	private LoaiTour loaiTour;
	
	@OneToMany(mappedBy = "bookingTour", fetch = FetchType.LAZY)
	private List<CTPhongLuuTru> ctPhongLuuTrus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date gettGBD() {
		return tGBD;
	}

	public void settGBD(Date tGBD) {
		this.tGBD = tGBD;
	}

	public Date gettGKT() {
		return tGKT;
	}

	public void settGKT(Date tGKT) {
		this.tGKT = tGKT;
	}

	public int getMaxNL() {
		return maxNL;
	}

	public void setMaxNL(int maxNL) {
		this.maxNL = maxNL;
	}

	public int getMaxTE() {
		return maxTE;
	}

	public void setMaxTE(int maxTE) {
		this.maxTE = maxTE;
	}

	

	public int getMaxTN() {
		return maxTN;
	}

	public void setMaxTN(int maxTN) {
		this.maxTN = maxTN;
	}

	public int getMinNL() {
		return minNL;
	}

	public void setMinNL(int minNL) {
		this.minNL = minNL;
	}

	public int getMinTE() {
		return minTE;
	}

	public void setMinTE(int minTE) {
		this.minTE = minTE;
	}

	public int getMinTN() {
		return minTN;
	}

	public void setMinTN(int minTN) {
		this.minTN = minTN;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Tour getTour1() {
		return tour1;
	}

	public void setTour1(Tour tour1) {
		this.tour1 = tour1;
	}

	public LoaiTour getLoaiTour() {
		return loaiTour;
	}

	public void setLoaiTour(LoaiTour loaiTour) {
		this.loaiTour = loaiTour;
	}

	

	public List<CTPhongLuuTru> getCtPhongLuuTrus() {
		return ctPhongLuuTrus;
	}

	public void setCtPhongLuuTrus(List<CTPhongLuuTru> ctPhongLuuTrus) {
		this.ctPhongLuuTrus = ctPhongLuuTrus;
	}

	public List<VeTour> getVeTours() {
		return veTours;
	}

	public void setVeTours(List<VeTour> veTours) {
		this.veTours = veTours;
	}


	
	

	
	

}
