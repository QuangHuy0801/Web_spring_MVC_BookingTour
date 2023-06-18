package BOOKINGTOUR.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BOOKINGTOUR.entity.BookingTour;
import BOOKINGTOUR.entity.CTPhongLuuTru;
import BOOKINGTOUR.entity.CTTour;
import BOOKINGTOUR.entity.CTVe;
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.LoaiTour;
import BOOKINGTOUR.entity.NhanVien;
import BOOKINGTOUR.entity.NoiLuuTru;
import BOOKINGTOUR.entity.Phong;
import BOOKINGTOUR.entity.Tour;

@Transactional
@Controller
public class dattourController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsdattour")
	public String dsdattour(HttpServletRequest request,ModelMap model,@RequestParam(defaultValue = "0") int page,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int idTour) {
		
		int pageSize = 6;
		int totalUsers = getSize();
		List<BookingTour> dattour = this.getDatTour(page,pageSize,idTour);
	    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
	    if(totalPages==0) {
			totalPages=1;
		}
	    model.addAttribute("offset", page * pageSize);
	    model.addAttribute("tours", getTours());
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		model.addAttribute("bookingtours",dattour);
		model.addAttribute("message", message);
		return "dattour/dsdattour";
	}
	@RequestMapping(value="themdattour")
	public String themdattour(HttpServletRequest request,ModelMap model) {
		model.addAttribute("bookingtour", new BookingTour());
		model.addAttribute("loaitours",gettLoaiTours());
		model.addAttribute("tours", getTours());
		return"dattour/themdattour";
	}
	
	@RequestMapping(value="insertdattour", method = RequestMethod.POST) 
	public String insertdattour(@ModelAttribute("bookingtour") BookingTour bookingtour,ModelMap model,BindingResult errors) {
		boolean kiemtra =true;
		
		if (bookingtour.gettGBD() == null) {
			errors.rejectValue("tGBD", "bookingtour", "Vui lòng nhập thời gian bắt đầu !");
			kiemtra=false;
		}
		 if (bookingtour.gettGKT() == null) {
			errors.rejectValue("tGKT", "bookingtour", "Vui lòng nhập thời gian kết thúc !");
			kiemtra=false;
			}
		 else {
		 int compareResult = bookingtour.gettGBD().compareTo(bookingtour.gettGKT());
		if (compareResult > 0) {
				errors.rejectValue("tGBD", "bookingtour", "Ngày bắt đầu phải trước ngày kết thúc !");
				kiemtra=false;
			}}
		 if (bookingtour.getMaxNL() < bookingtour.getMinNL()){
			errors.rejectValue("maxNL", "bookingtour", "Số lượng tối đa nhỏ hơn số lượng tối thiểu!");
			kiemtra=false;}
		 if (bookingtour.getMaxTN() < bookingtour.getMinTN()){
			errors.rejectValue("maxTN", "bookingtour",  "Số lượng tối đa nhỏ hơn số lượng tối thiểu!");
			kiemtra=false;}
		 if (bookingtour.getMaxTE() < bookingtour.getMinTE()){
			errors.rejectValue("maxTE", "bookingtour", "Số lượng tối đa nhỏ hơn số lượng tối thiểu!");
			kiemtra=false;}
		if ((bookingtour.getMaxNL() + bookingtour.getMaxTE() + bookingtour.getMaxTN()) < 5) {
			errors.rejectValue("maxTE", "bookingtour", "Số lượng quá ít để đăng kí tour!");
			kiemtra = false;
		}
		
		if(kiemtra==true) {
		
			
		if(bookingtour.getLoaiTour().getId()==2) {
			bookingtour.setTrangThai(1);
			bookingtour.setMinNL(bookingtour.getMaxNL());
			bookingtour.setMinTN(bookingtour.getMaxTN());
			bookingtour.setMinTE(bookingtour.getMaxTE());
		}
		else {bookingtour.setTrangThai(0);}
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(bookingtour);
				t.commit();
				System.out.println(bookingtour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}
			
			model.addAttribute("bookingtours",this.geBookingTours());
			model.addAttribute("loaitours",gettLoaiTours());
			model.addAttribute("tours", getTours());
		
			return "dattour/themdattour";
	}
	
	@RequestMapping(value="suadattour/{id}")
	public String suadiemdulich(ModelMap model ,@PathVariable int id) {
		model.addAttribute("bookingtour", searchbBookingTour(id));
		model.addAttribute("loaitours",gettLoaiTours());
		model.addAttribute("tours", getTours());
		return"dattour/suadattour";
	}
	@RequestMapping(value="suadattour/updatetour", method = RequestMethod.POST) 
	public String editdiemluutru(@ModelAttribute("bookingtour") BookingTour bookingtour,ModelMap model,BindingResult errors) {
		boolean kiemtra =true;
		int compareResult = bookingtour.gettGBD().compareTo(bookingtour.gettGKT());
		if (bookingtour.gettGBD() == null) {
			errors.rejectValue("tGBD", "bookingtour", "Vui lòng nhập thời gian bắt đầu !");
			kiemtra=false;
		}
		 if (bookingtour.gettGKT() == null) {
			errors.rejectValue("tGKT", "bookingtour", "Vui lòng nhập thời gian kết thúc !");
			kiemtra=false;}
		if (compareResult > 0) {
				errors.rejectValue("tGBD", "bookingtour", "Ngày bắt đầu phải trước ngày kết thúc !");
				kiemtra=false;
			}
		 if (bookingtour.getMaxNL() < bookingtour.getMinNL()){
			errors.rejectValue("maxNL", "bookingtour", "Số lượng tối đa nhỏ hơn số lượng tối thiểu!");
			kiemtra=false;}
		 if (bookingtour.getMaxTN() < bookingtour.getMinTN()){
			errors.rejectValue("maxTN", "bookingtour",  "Số lượng tối đa nhỏ hơn số lượng tối thiểu!");
			kiemtra=false;}
		 if (bookingtour.getMaxTE() < bookingtour.getMinTE()){
			errors.rejectValue("maxTE", "bookingtour", "Số lượng tối đa nhỏ hơn số lượng tối thiểu!");
			kiemtra=false;}
		if ((bookingtour.getMaxNL() + bookingtour.getMaxTE() + bookingtour.getMaxTN()) < 5) {
			errors.rejectValue("maxTE", "bookingtour", "Số lượng quá ít để đăng kí tour!");
			kiemtra = false;
		}
		if(kiemtra==true) {
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(bookingtour);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}
			model.addAttribute("bookingtour", bookingtour);
			model.addAttribute("loaitours",gettLoaiTours());
			model.addAttribute("tours", getTours());
		return "dattour/suadattour";
	}
	
	@RequestMapping(value="xoadattour/{id}")
	public String xoadiemluutru(ModelMap model ,@PathVariable int id) {
	
	
	
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from BookingTour where id= :id";
			Query query = session.createQuery(hql);
			
			query.setParameter("id", id);
			System.out.println(query.executeUpdate());
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		
		return"redirect:/dsdattour.htm";
	}
	
	@RequestMapping(value = "dsdatphong/themdatphong/{id}")
	public String themdatphong(HttpServletRequest request, ModelMap model, @PathVariable int id,
			@ModelAttribute("message") String message, @RequestParam(defaultValue = "0") int currentPage,
			@RequestParam(defaultValue = "") String timkiem) {
		BookingTour bookingTour = searchbBookingTour(id);
		int pageSize=6;
		int totalUsers = getSizePhong(id);
		System.out.println(totalUsers);
		List<CTPhongLuuTru> ctPhongLuuTrus = this.getPhongs(currentPage, pageSize, id, timkiem);
		int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
		if (totalPages == 0) {
			totalPages = 1;
		}
		List<Phong> listPhong1 = new ArrayList<Phong>();
		for (CTPhongLuuTru c : ctPhongLuuTrus) {
			listPhong1.add(c.getPhong());
		}

		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("offset", currentPage * pageSize);
		model.addAttribute("idBK", id);
		model.addAttribute("phongs", listPhong1);
		return "dattour/themdatphong";
	}
	@RequestMapping(value="dsdatphong/themdatphong/insert", method = RequestMethod.POST)
	public String insertdatphong(HttpServletRequest request,ModelMap model ,@ModelAttribute("id") String id,@ModelAttribute("idBK") String idBK) throws ParseException {
		
		BookingTour bookingTour =this.searchbBookingTour( Integer.parseInt(idBK));
		
		if(request.getParameter("tgden").length()==0 ) {
			model.addAttribute("message", 4);
			return "redirect:/dsdatphong/themdatphong/" + bookingTour.getId() + ".htm";}
		else if(request.getParameter("tgdi").length()==0 ){
			
			model.addAttribute("message", 4);
			return "redirect:/dsdatphong/themdatphong/" + bookingTour.getId() + ".htm";}

			String tmp = request.getParameter("tgden");
			String tmp1 = request.getParameter("tgdi");
	Date tgden =formatter.parse(tmp);
	Date tgdi =formatter.parse(tmp1);
	int compareResult = tgden.compareTo(tgdi);
	int compareResult1 = bookingTour.gettGBD().compareTo(tgden);
	int compareResult2 = tgdi.compareTo(bookingTour.gettGKT());
		if(compareResult > 0) {
			model.addAttribute("message", 5);
			return "redirect:/dsdatphong/themdatphong/" + bookingTour.getId() + ".htm";}
		if(compareResult1 >= 0) {
			model.addAttribute("message", 6);
			return "redirect:/dsdatphong/themdatphong/" + bookingTour.getId() + ".htm";}
		if(compareResult2 >= 0) {
			model.addAttribute("message", 7);
			return "redirect:/dsdatphong/themdatphong/" + bookingTour.getId() + ".htm";}
		
		int loaihinh= Integer.parseInt(request.getParameter("loaihinh"));
		
		Phong phong= this.searchPhong(Integer.parseInt(id));
		CTPhongLuuTru ctPhongLuuTru =new CTPhongLuuTru();
		ctPhongLuuTru.setPhong(phong);
		ctPhongLuuTru.setBookingTour(bookingTour);
		ctPhongLuuTru.setNgayDen(tgden);
		ctPhongLuuTru.setNgayDi(tgdi);
		ctPhongLuuTru.setFullNgay(loaihinh);
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(ctPhongLuuTru);
				t.commit();
				
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			int id1=Integer.parseInt(idBK);
			
			
			return "redirect:/dsdatphong/themdatphong/" + id1 + ".htm";
			
			
	}
	
	
	@RequestMapping(value="dsdatphong/{id}")
	public String dsdatphong(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int currentPage) {
		BookingTour bookingTour= this.searchbBookingTour(id);
	
		
		// Giả sử danh sách CTPhongLuuTru đã được khởi tạo và lưu trữ trong biến ctPhongLuuTruList
		int pageSize = 7; // Số lượng phần tử trên mỗi trang
		

		int totalCount = bookingTour.getCtPhongLuuTrus().size(); // Tổng số lượng phần tử trên toàn bộ danh sách
		 int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		 System.out.println(totalCount);
		 if(totalPages==0) {
				totalPages=1;
			}
		
		
		int startIndex = (currentPage)  * pageSize;
		int endIndex = Math.min(startIndex + pageSize, totalCount);
		System.out.println(startIndex);
		System.out.println(endIndex);
		// Lấy phần tử của danh sách theo giới hạn kết quả trả về
		List<CTPhongLuuTru> result = bookingTour.getCtPhongLuuTrus().subList(startIndex, endIndex);
		
		 
		
		
		 model.addAttribute("offset", currentPage * pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", currentPage);
	    
		model.addAttribute("message", message);
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		model.addAttribute("ctphongluutrus",result);
		return"dattour/dsdatphong";
	}
	
	@RequestMapping(value="xoadatphong/{id}")
	public String xoadatphong(ModelMap model ,@PathVariable int id) {
	CTPhongLuuTru ctPhongLuuTru= searchCtPhongLuuTru(id);
	
	
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from CTPhongLuuTru where id= :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			System.out.println(query.executeUpdate());
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		
		return "redirect:/dsdatphong/" + ctPhongLuuTru.getBookingTour().getId()+ ".htm";
	
	}
	
	
	public List<BookingTour> geBookingTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour";
		List<BookingTour> bookingTours = session.createQuery(hql).list();
		return  bookingTours;
	}
	public List<Tour> getTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour";
		List<Tour> tous = session.createQuery(hql).list();
		return  tous;
	}
	public List<LoaiTour> gettLoaiTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiTour";
		List<LoaiTour> loaiTours = session.createQuery(hql).list();
		return  loaiTours;
	}
	
	public Tour searchTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Tour) query.list().get(0);
	}
	
	public CTPhongLuuTru searchCtPhongLuuTru(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTPhongLuuTru WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (CTPhongLuuTru) query.list().get(0);
	}
	
	public BookingTour searchbBookingTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (BookingTour) query.list().get(0);
	}
	
	public Phong searchPhong(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phong WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Phong) query.list().get(0);
	}
	public List<Phong> getPhongs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phong";
		List<Phong> phong = session.createQuery(hql).list();
		return  phong;
	}
	public static List<Phong> phongConLai(List<Phong> list1, List<Phong> list2) {
	    List<Phong> combined = new ArrayList<>();
	    combined.addAll(list2);
	    combined.removeAll(list1);
	    return combined;
	}
	public int  getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour";
		Query query = session.createQuery(hql);
		List<BookingTour> list = query.list();

		return list.size();
	}
	public List<BookingTour> getDatTour(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<BookingTour> list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}
	public List<BookingTour> getDatTour(int page, int pageSize, int idTour) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<BookingTour> list;
		if (idTour == 0 )
		{
			hql ="FROM BookingTour t ORDER BY t.tGBD DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else
		{
			hql ="FROM BookingTour t where t.tour1.id =:idTour ORDER BY t.id DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("idTour", idTour);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
		return list;
	}
	
	public List<CTPhongLuuTru> getPhongs(int page, int pageSize, int idTour,String ten) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<CTPhongLuuTru> list;
		if (ten.length() == 0 )
		{
			hql ="FROM CTPhongLuuTru t where t.bookingTour.id !=:idTour ORDER BY t.phong.ten DESC";
			query = session.createQuery(hql);
			query.setParameter("idTour", idTour);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else
		{
			hql ="FROM CTPhongLuuTru t where t.phong.noiLuuTru1.tenNLT LIKE CONCAT( '%',:ten, '%') and  t.bookingTour.id !=:idTour ORDER BY t.phong.ten DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("idTour", idTour);
			query.setParameter("ten", ten);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
		return list;
	}
	
	public int  getSizePhong(int idTour) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<CTPhongLuuTru> list;
		
			hql ="FROM CTPhongLuuTru t where t.bookingTour.id !=:idTour";
			query = session.createQuery(hql);
			query.setParameter("idTour", idTour);
			list = query.list();
		return list.size();
	}
	
}
