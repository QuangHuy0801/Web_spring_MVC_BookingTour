package BOOKINGTOUR.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BOOKINGTOUR.entity.BookingTour;
import BOOKINGTOUR.entity.CTPhongLuuTru;
import BOOKINGTOUR.entity.CTTour;
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.NoiLuuTru;
import BOOKINGTOUR.entity.Phong;
import BOOKINGTOUR.entity.Tour;

@Transactional
@Controller
public class tourController {
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsTour")
	public String dstour(HttpServletRequest request,ModelMap model,@RequestParam(defaultValue = "0") int page,@ModelAttribute("message") String message) {
		int pageSize = 7;
		int totalUsers = getSize();
		List<Tour> tour = this.getTour(page,pageSize);
	    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
	    if(totalPages==0) {
			totalPages=1;
		}
	    model.addAttribute("offset", page * pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		  model.addAttribute("tours",tour);
		  model.addAttribute("message",
		  message);
		 
		return "tour/dstour";
	}
	@RequestMapping(value="themtour")
	public String themtour(HttpServletRequest request,ModelMap model) {
		model.addAttribute("tour", new Tour());
		return"tour/themtour";
	}
	
	@RequestMapping(value="insertTour", method = RequestMethod.POST) 
	public String inserttour(@ModelAttribute("tour") Tour tour,ModelMap model) {
		
		System.out.println(tour.getTen());
		System.out.println(tour.getMoTa());

		if(checkTenTourTrung(tour.getTen())==1) {
			model.addAttribute("message", 3);

			return "diemluutru/themdiemluutru";
		}
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(tour);
				t.commit();
				System.out.println(tour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
		
		return "tour/themtour";
	}
	
	@RequestMapping(value="suatour/{id}")
	public String suatour(ModelMap model ,@PathVariable int id) {
		Tour tour =new Tour();
		tour.setId(id);
		
		model.addAttribute("tour",this.searchTour(id));
		
		return"tour/suatour";
	}
	@RequestMapping(value="updateTour", method = RequestMethod.POST) 
	public String editdiemdulich(@ModelAttribute("tour") Tour tour,ModelMap model) {
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(tour);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			
			
		return "tour/suatour";
	}
	
	@RequestMapping(value="xoatour/{id}")
	public String xoatour(ModelMap model ,@PathVariable int id) {
		Tour tour = searchTour(id);
		System.out.println(tour.getTen());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from Tour where id= :id";
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
		
		return"redirect:/dsTour.htm";
	}
	
	@RequestMapping(value="cttour/{id}")
	public String cttour(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int currentPage) {
		Tour tour= this.searchTour(id);
		
int pageSize = 7; // Số lượng phần tử trên mỗi trang
		

		int totalCount = tour.getCtTours().size(); // Tổng số lượng phần tử trên toàn bộ danh sách
		 int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		 System.out.println(totalCount);
		 if(totalPages==0) {
				totalPages=1;
			}
		Tour tourThuTu =tour;
		 Collections.sort(tourThuTu.getCtTours(), Comparator.comparing(CTTour::getThuTu)); 
		int startIndex = (currentPage)  * pageSize;
		int endIndex = Math.min(startIndex + pageSize, totalCount);
		System.out.println(startIndex);
		System.out.println(endIndex);
		// Lấy phần tử của danh sách theo giới hạn kết quả trả về
		List<CTTour> result = tourThuTu.getCtTours().subList(startIndex, endIndex);
		
		
		 
		
		
	    
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("message", message);
		model.addAttribute("id",id);
		model.addAttribute("tour",id);
		model.addAttribute("cttours",result);
		return"tour/cttour";
	}
	@RequestMapping(value="cttour/themcttour/insertcttour", method = RequestMethod.POST)
	public String insertcctour(ModelMap model ,@ModelAttribute("id") String id,@ModelAttribute("idtour") String idtour) {
		DiemDuLich diemdulich= this.searchDiemDuLich(Integer.parseInt(id));
		Tour tour =this.searchTour( Integer.parseInt(idtour));
		
		System.out.println(tour.getTen());
		System.out.println(diemdulich.getTen());
		
		CTTour ctTour =new CTTour();
		ctTour.setDiemDuLich(diemdulich);
		ctTour.setTour(tour);
		ctTour.setThuTu(tour.getCtTours().size()+1);
		
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(ctTour);
				t.commit();
				System.out.println(ctTour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			int id1=Integer.parseInt(idtour);
			
			
			return "redirect:/cttour/themcttour/" + id1 + ".htm";
			
			
	}
	
	
	@RequestMapping(value="cttour/themcttour/{id}")
	public String themcttour(HttpServletRequest request,ModelMap model,@PathVariable int id,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int currentPage) {
		Tour tour= new Tour();
		tour=searchTour(id);
		
		List<DiemDuLich> listDDL= new ArrayList<DiemDuLich>();
		
		 
		
		for(CTTour c:tour.getCtTours()) {
			listDDL.add(c.getDiemDuLich());
		}
		
		List<DiemDuLich> DDLConLai = diemDuLichConLai(listDDL,getListDiemDuLich());
		
		
		int pageSize = 5; // Số lượng phần tử trên mỗi trang
		int totalCount = DDLConLai.size(); // Tổng số lượng phần tử trên toàn bộ danh sách
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
		List<DiemDuLich> result = DDLConLai.subList(startIndex, endIndex);
		/* Collections.sort(result, Comparator.comparing(DiemDuLich::get)); */
		
		 
		
		
	    
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", currentPage);
		
	    model.addAttribute("offset", currentPage * pageSize);
		
		model.addAttribute("idtour",id);
		model.addAttribute("diemDuLichs",result);
		return"tour/themcttour";
	}
	
	
	@RequestMapping(value="cttour/capNhapThuTu", method = RequestMethod.POST)
	public String capNhapThuTu(HttpServletRequest request,ModelMap model ,@ModelAttribute("id") String id,@ModelAttribute("idTour") String idTour) {
		Tour tour =this.searchTour( Integer.parseInt(idTour));
		int indexThuTu=Integer.parseInt(request.getParameter("thuTu").trim()) ;
		 List<CTTour> listcttour  =   tour.getCtTours();
		 int thuTuMax=-1;
		 for(CTTour ct:listcttour) {
			 thuTuMax=Math.max(thuTuMax, ct.getThuTu());
		 }
		 CTTour ctTour= this.searchCTTour(Integer.parseInt(id));
		if(request.getParameter("thuTu").trim().length()==0 || indexThuTu <=0) {model.addAttribute("message", 2);}
		else if(indexThuTu==ctTour.getThuTu()) {}
		else {
			if(indexThuTu>thuTuMax) {indexThuTu=thuTuMax;}
			
			
		int thuTu =ctTour.getThuTu();
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				if(indexThuTu>thuTu) {
				String updateHql = "update CTTour set thuTu = thuTu + 1 where thuTu > :thuTu and tour.id = :tourId";
				Query updateQuery = session.createQuery(updateHql);
				updateQuery.setParameter("thuTu",indexThuTu);
				updateQuery.setParameter("tourId", tour.getId());
				updateQuery.executeUpdate();
				ctTour.setThuTu(indexThuTu);
				session.update(ctTour);
				
					String updateHql1 = "update CTTour set thuTu = thuTu - 1 where thuTu > :thuTu and tour.id = :tourId ";
					Query updateQuery1 = session.createQuery(updateHql1);
					updateQuery1.setParameter("thuTu",thuTu);
					updateQuery1.setParameter("tourId", tour.getId());
					updateQuery1.executeUpdate();
				}
				else {
				
					 
						String updateHql = "update CTTour set thuTu = thuTu + 1 where thuTu >= :thuTu and tour.id = :tourId and thuTu <:thuTu1";
						Query updateQuery = session.createQuery(updateHql);
						updateQuery.setParameter("thuTu",indexThuTu);
						updateQuery.setParameter("thuTu1",thuTu);
						updateQuery.setParameter("tourId", tour.getId());
						updateQuery.executeUpdate();
						ctTour.setThuTu(indexThuTu);
						session.update(ctTour);
				
				}
				
				
				
				t.commit();
				
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
		}
			int id1=Integer.parseInt(idTour);
			return "redirect:/cttour/" + id1 + ".htm";
			
}
	
	
	
	
	public DiemDuLich searchDiemDuLich(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiemDuLich WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (DiemDuLich) query.list().get(0);
	}
	
	@RequestMapping(value="xoacttour/{id}")
	public String xoadiemluutru(ModelMap model ,@PathVariable int id) {
	CTTour ctTour= searchCTTour(id);
	Tour tour =ctTour.getTour();
	int thuTu =ctTour.getThuTu();
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from CTTour where id= :id";
			Query query = session.createQuery(hql);
			
			query.setParameter("id", id);
			System.out.println(query.executeUpdate());
			String updateHql = "update CTTour set thuTu = thuTu - 1 where thuTu > :thuTu and tour.id = :tourId";
			Query updateQuery = session.createQuery(updateHql);
			updateQuery.setParameter("thuTu", ctTour.getThuTu());
			updateQuery.setParameter("tourId", tour.getId());
			updateQuery.executeUpdate();
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		
		return "redirect:/cttour/" + ctTour.getTour().getId() + ".htm";
	
	}
	
	
	
	public Tour searchTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Tour) query.list().get(0);
	}
	public CTTour searchCTTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (CTTour) query.list().get(0);
	}
	
	
	private int checkTenTourTrung( String ten) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour where ten = :ten";
		Query query = session.createQuery(hql);
		query.setParameter("ten", ten);
		List<Tour> list = query.list();
		if(list.size() == 0) return 0;
		return 1;
	}
	public List<Tour> getTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour";
		List<Tour> tous = session.createQuery(hql).list();
		return  tous;
	}
	
	public int idThuTuTuDongTang(Tour tour) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTTour where id =:tour.id";
		List<CTTour> ctTours = session.createQuery(hql).list();
		
		return  ctTours.size();
	}
	public List<DiemDuLich> getListDiemDuLich() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiemDuLich";
		List<DiemDuLich> diemDuLich = session.createQuery(hql).list();
		return  diemDuLich;
	}
	
	public static List<DiemDuLich> diemDuLichConLai(List<DiemDuLich> list1, List<DiemDuLich> list2) {
	    List<DiemDuLich> combined = new ArrayList<>();
	    
	    combined.addAll(list2);
	    combined.removeAll(list1);

	    return combined;
	}
	
	
	
	public int  getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour";
		Query query = session.createQuery(hql);
		List<BookingTour> list = query.list();

		return list.size();
	}
	public List<Tour> getTour(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<Tour> list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}
	
	
}
