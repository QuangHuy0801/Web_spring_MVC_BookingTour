package BOOKINGTOUR.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.KhuyenMai;
import BOOKINGTOUR.entity.NhanVien;

@Transactional
@Controller
public class dotkhuyenmaiController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsdotkhuyenmai")
	public String dsdotkhuyenmai(HttpServletRequest request,ModelMap model,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String tungay,
			@RequestParam(defaultValue = "") String denngay) {
		
		int pageSize = 6;
		int totalUsers = getSize();
		List<KhuyenMai> khuyenMai = this.getKhuyenMai(page,pageSize,tungay,denngay);
	    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
	    if(totalPages==0) {
			totalPages=1;
		}
	   
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		
	    model.addAttribute("offset", page * pageSize);
		model.addAttribute("dotkhuyenmais",khuyenMai);
		model.addAttribute("message", message);
		return "dotkhuyenmai/dsdotkhuyenmai";
	}
	
	
	@RequestMapping(value="themdotkhuyenmai")
	public String themdotkhuyenmai(HttpServletRequest request,ModelMap model) {
		model.addAttribute("dotKhuyenMai1", new KhuyenMai());
		model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return"dotkhuyenmai/themdotkhuyenmai";
	}
	@RequestMapping(value="insertDotKhuyenMai", method = RequestMethod.POST) 
	public String insertDotKhuyenMai(@ModelAttribute("dotKhuyenMai1") KhuyenMai dotkhuyenmai,ModelMap model,BindingResult errors) {
		boolean kiemtra =true;
		
		if (dotkhuyenmai.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "dotkhuyenmai", "Vui lòng nhập tên!");
			kiemtra=false;
		}
		if (dotkhuyenmai.gettGBD() == null) {
			errors.rejectValue("tGBD", "dotkhuyenmai", "Vui lòng nhập thời gian bắt đầu !");
			kiemtra=false;
		}
		 if (dotkhuyenmai.gettGKT() == null) {
			errors.rejectValue("tGKT", "dotkhuyenmai", "Vui lòng nhập thời gian kết thúc !");
			kiemtra=false;
			}
		 else {
			 int compareResult = dotkhuyenmai.gettGBD().compareTo(dotkhuyenmai.gettGKT());
		if (compareResult > 0) {
				errors.rejectValue("tGBD", "dotkhuyenmai", "Ngày bắt đầu phải trước ngày kết thúc !");
				kiemtra=false;
			}}
		
		
		 if (dotkhuyenmai.getPhanTramGiam() >100||dotkhuyenmai.getPhanTramGiam() <=0  ) {
			errors.rejectValue("phanTramGiam", "dotkhuyenmai", "Vui lòng nhập đúng phần trăm muốn giảm !");
			kiemtra=false;
		}
		if(kiemtra==true) {
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(dotkhuyenmai);
				t.commit();
				System.out.println(dotkhuyenmai.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
		}
			model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return "dotkhuyenmai/themdotkhuyenmai";
	}
	@RequestMapping(value="suadotkhuyenmai/{id}")
	public String suadotkhuyenmai(ModelMap model ,@PathVariable int id) {
		KhuyenMai dotkhuyenmai =new KhuyenMai();
		dotkhuyenmai.setId(id);
		model.addAttribute("dotKhuyenMai1",this.searchKhuyenMai(id));
		model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return"dotkhuyenmai/suadotkhuyenmai";
	}
	
	@RequestMapping(value="suadotkhuyenmai/update", method = RequestMethod.POST) 
	public String editdotkhuyenmai(@ModelAttribute("dotKhuyenMai1") KhuyenMai dotKhuyenMai,ModelMap model,BindingResult errors) {
		int compareResult = dotKhuyenMai.gettGBD().compareTo(dotKhuyenMai.gettGKT());
		if (dotKhuyenMai.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "dotKhuyenMai", "Vui lòng nhập tên!");
		}
		
		else if (compareResult > 0) {
			errors.rejectValue("tGBD", "dotKhuyenMai", "Ngày bắt đầu phải trước ngày kết thúc !");
		}
		else if (dotKhuyenMai.getPhanTramGiam() >100||dotKhuyenMai.getPhanTramGiam() <=0 ) {
			errors.rejectValue("phanTramGiam", "dotKhuyenMai", "Vui lòng nhập phần trăm muốn giảm từ 0-100% !");
		}
		else {
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(dotKhuyenMai);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}
			
			model.addAttribute("dotKhuyenMai1",dotKhuyenMai);
			model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return "dotkhuyenmai/suadotkhuyenmai";
	}
	
	@RequestMapping(value="xoadotkhuyenmai/{id}")
	public String xoadotkhuyenmai(ModelMap model ,@PathVariable int id) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from KhuyenMai where id= :id";
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
		
		return"redirect:/dsdotkhuyenmai.htm";
	}
	public KhuyenMai searchKhuyenMai(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (KhuyenMai) query.list().get(0);
	}
	public List<KhuyenMai> getKhuyenMais() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai";
		List<KhuyenMai> khuyenmai = session.createQuery(hql).list();
		return  khuyenmai;
	}
	public int  getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai";
		Query query = session.createQuery(hql);
		List<KhuyenMai> list = query.list();

		return list.size();
	}
	public List<KhuyenMai> getKhuyenMai(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<KhuyenMai> list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}
	
	public List<KhuyenMai> getKhuyenMai(int page, int pageSize, String tungay, String denngay) {
		
		
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<KhuyenMai> list;
		if (tungay.length() !=0 && denngay.length() !=0)
		{
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			 hql ="FROM KhuyenMai t where t.tGKT <=:tGKT and t.tGBD >=:tGBD  ORDER BY t.id DESC";
				query = session.createQuery(hql);
				int offset = page * pageSize;
				query.setParameter("tGKT", date2);
				query.setParameter("tGBD", date1);
				list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		} else if (tungay.length() !=0)
		{LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql ="FROM KhuyenMai t where t.tGBD >=:tGBD ORDER BY t.id DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("tGBD", date1);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
	 else if (denngay.length() !=0)
	{
		
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		hql ="FROM KhuyenMai t where t.tGKT >=:tGKT ORDER BY t.id DESC";
		query = session.createQuery(hql);
		int offset = page * pageSize;
		query.setParameter("tGKT", date2);
		list = query.setFirstResult(offset).setMaxResults(pageSize).list();
	}
	 else {
		
		 hql ="FROM KhuyenMai t ORDER BY t.tGBD DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
	 }
		return list;
	}
}
