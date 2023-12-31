package BOOKINGTOUR.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import BOOKINGTOUR.bean.Company;
import BOOKINGTOUR.bean.UploadFile;
import BOOKINGTOUR.entity.BookingTour;
import BOOKINGTOUR.entity.CTVe;
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.KhachHang;
import BOOKINGTOUR.entity.KhuyenMai;
import BOOKINGTOUR.entity.NhanVien;
import BOOKINGTOUR.entity.TaiKhoan;
import BOOKINGTOUR.entity.VeTour;
import BOOKINGTOUR.recaptcha.RecaptchaVerification;
import javassist.expr.NewArray;

@Transactional
@Controller
public class start {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;

	@Autowired
	@Qualifier("poly")
	Company company;
	@Autowired
	UploadFile baseUploadFile;

	@RequestMapping("index")
	public String welcome(HttpServletRequest request,HttpSession ss, ModelMap model) {
		model.addAttribute("taiKhoan", new TaiKhoan());
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request, HttpSession ss,@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
			BindingResult errors) throws IOException {
		boolean kt = true;
		String gRecaptchaResponse= request.getParameter("g-recaptcha-response");
		boolean verify =RecaptchaVerification.verify(gRecaptchaResponse);
		if (!verify) {
			model.addAttribute("error", "Vui lòng nhâp reCaptra");
			// System.out.println("có lổi Passwword");
			kt = false;
		}
		
		
		if (taiKhoan.getMANV().trim().length() == 0) {
			errors.rejectValue("MANV", "taiKhoan", "Vui lòng nhập username !");
			kt = false;
		}
		if (taiKhoan.getPASSWORD().trim().length() == 0) {
			errors.rejectValue("PASSWORD", "taiKhoan", "Vui lòng nhập password !");
			kt = false;
		}
		if (taiKhoan.getPASSWORD().trim().length() < 5) {
			errors.rejectValue("PASSWORD", "taiKhoan", "Password phải từ 5 kí tự trở lên!");
			kt = false;
		}
		if (kt == true) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(36000);
			String username = taiKhoan.getMANV();
			String password = taiKhoan.getPASSWORD();
			TaiKhoan taikhoan = queryLogin(username, password);
			if (taikhoan != null) {
				if (taikhoan.getNhanVien().getTrangThai() == 1) {

					session.setAttribute("TaiKhoan", taikhoan);
					return "redirect:/homeshow.htm";
				} else {
					model.addAttribute("error", "Tài khoản đã ngừng hoạt động !!!");
					return "login/login";
				}
			} else
				model.addAttribute("error", "Mã tài khoản hoặc mật khẩu chưa đúng !!!");
		}
		return "login/login";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// Xóa thông tin người dùng khỏi phiên làm việc và kết thúc phiên
		session.removeAttribute("TaiKhoan");
		/* session.removeAttribute("quyenHan"); */
		session.invalidate();
		return "redirect:/index.htm";
	}

	@RequestMapping("homeshow")
	public String homeshow1(ModelMap model) {
		model.addAttribute("company", company);
		return "home/homeshow";
	}

	@RequestMapping("homeshow1")
	public String homeshow1(ModelMap model, @RequestParam("photo") MultipartFile photo) {
		model.addAttribute("company", company);
		if (photo.isEmpty()) {
			model.addAttribute("message1", "vui lòng chọn file !");
		} else {
			try {

				String photoPath1 = baseUploadFile.getBasePath() + File.separator + "logo1.jpg";
				photo.transferTo(new File(photoPath1));
				Thread.sleep(5000);
				return "home/homeshow";
			} catch (Exception e) {
				model.addAttribute("Message1", "Lỗi lưu file !");
			}
		}
		return "home/homeshow";
	}

	@RequestMapping("homeshow2")
	public String homeshow2(ModelMap model, @RequestParam("photo") MultipartFile photo) {
		model.addAttribute("company", company);
		if (photo.isEmpty()) {
			model.addAttribute("message1", "vui lòng chọn file !");
		} else {
			try {

				String photoPath2 = baseUploadFile.getBasePath() + File.separator + "logo2.jpg";
				photo.transferTo(new File(photoPath2));
				Thread.sleep(5000);
				return "home/homeshow";
			} catch (Exception e) {
				model.addAttribute("Message1", "Lỗi lưu file !");
			}
		}
		return "home/homeshow";
	}

	@RequestMapping("homeshow3")
	public String homeshow3(ModelMap model, @RequestParam("photo") MultipartFile photo) {
		model.addAttribute("company", company);
		if (photo.isEmpty()) {
			model.addAttribute("message1", "vui lòng chọn file !");
		} else {
			try {

				String photoPath3 = baseUploadFile.getBasePath() + File.separator + "logo3.jpg";
				photo.transferTo(new File(photoPath3));
				Thread.sleep(5000);
				model.addAttribute("Message1", "Thêm thành công !");
				return "home/homeshow";
			} catch (Exception e) {
				model.addAttribute("Message1", "Lỗi lưu file !");
			}
		}
		return "home/homeshow";
	}

	@RequestMapping(value = "danhsachnhanvien")
	public String danhsachtaikhoan(HttpServletRequest request, ModelMap model,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String timkiem,
			@ModelAttribute("message") String message) {
		int pageSize = 6;
		int totalUsers = getSize();

		List<NhanVien> thongTinNhanVien = this.getNhanVien(page, pageSize, timkiem);
		int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
		if (totalPages == 0) {
			totalPages = 1;
		}

		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("nhanviens", thongTinNhanVien);
		model.addAttribute("message", message);
		return "admin/dsnhanvien";
	}
	
	@RequestMapping(value = "themnhanvien")
	public String themnhanvien(HttpServletRequest request, ModelMap model) {
		NhanVien nhanVien = new NhanVien();
		TaiKhoan taiKhoan = new TaiKhoan();
		nhanVien.setTaikhoan(taiKhoan);
		model.addAttribute("nhanvien", nhanVien);
		model.addAttribute("nhanviens", getListNhanVien());
		return "admin/themnhanvien";
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, @ModelAttribute("nhanvien") NhanVien nhanVien,
			ModelMap model, BindingResult errors) {

		boolean kt = true;
		if (nhanVien.getMaNV().trim().length() == 0) {
			errors.rejectValue("maNV", "nhanVien", "Vui lòng nhập mã nhân viên !");
			kt = false;
		}
		if (searchNhanVien(nhanVien.getMaNV()) != null) {
			errors.rejectValue("maNV", "nhanVien", "Mã nhân viên bị trùng !");
			kt = false;
		}
		if (nhanVien.getHo().trim().length() == 0) {
			errors.rejectValue("ho", "nhanVien", "Vui lòng nhập họ!");
			kt = false;
		}
		if (nhanVien.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "nhanVien", "Vui lòng nhập tên !");
			kt = false;
		}
		if (nhanVien.getcCCD().trim().length() == 0) {
			errors.rejectValue("cCCD", "nhanVien", "Vui lòng nhập CCCD !");
			kt = false;
		}
		if (checkTrungCCCD(nhanVien.getcCCD()) == 1) {
			errors.rejectValue("cCCD", "nhanVien", "Vui lòng nhập CCCD !");
			kt = false;
		}
		if (kt == true) {

			Session session = factory.openSession();
			Transaction tr = session.beginTransaction();
			nhanVien.setTrangThai(1);

			try {
				String mkDefault = "123456";
				TaiKhoan tk = new TaiKhoan();
				tk.setMANV(nhanVien.getMaNV());
				tk.setPASSWORD(mkDefault);
				tk.setIsAdmin(Integer.valueOf(request.getParameter("isAdmin")));
				System.out.println(Integer.valueOf(request.getParameter("isAdmin")));
				tk.setNhanVien(nhanVien);
				session.save(nhanVien);
				session.save(tk);
				tr.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				tr.rollback();
				model.addAttribute("message", 2);
			} finally {
				session.close();
			}
		}
		model.addAttribute("nhanviens", getListNhanVien());
		return "admin/themnhanvien";
	}
	@RequestMapping(value = "suanhanvien/{maNV}")
	public String suanhanvien(ModelMap model, @PathVariable String maNV) {
		model.addAttribute("nhanVien1", this.searchNhanVien(maNV));
		model.addAttribute("nhanviens", getListNhanVien());
		return "admin/suanhanvien";
	}

	@RequestMapping(value = "suattcanhan")
	public String suattcanhan(ModelMap model, HttpSession session) {
		TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan");
		model.addAttribute("nhanVien1", taiKhoan.getNhanVien());
		return "admin/suattcanhan";
	}

	@RequestMapping(value = "updatettcanhan", method = RequestMethod.POST)
	public String suattcanhan(@ModelAttribute("nhanVien1") NhanVien nhanVien, ModelMap model, BindingResult errors) {

		boolean kt = true;
		if (nhanVien.getHo().trim().length() == 0) {
			errors.rejectValue("ho", "nhanVien", "Vui lòng nhập họ!");
			kt = false;
		}
		if (nhanVien.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "nhanVien", "Vui lòng nhập tên !");
			kt = false;
		}
		if (nhanVien.getcCCD().trim().length() == 0) {
			errors.rejectValue("cCCD", "nhanVien", "Vui lòng nhập CCCD !");
			kt = false;
		}
		if (kt == true) {

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				nhanVien.setTrangThai(1);
				session.update(nhanVien);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);

			} finally {
				session.close();
			}
		}
		model.addAttribute("nhanVien1", nhanVien);
		model.addAttribute("nhanviens", getListNhanVien());
		return "admin/suattcanhan";
	}

	
	@RequestMapping(value = "doimatkhau")
	public String doimatkhau(ModelMap model, HttpSession session) {
		TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan");
		model.addAttribute("username", taiKhoan.getMANV());
		model.addAttribute("message1", "");
		return "admin/doimatkhau";
	}

	@RequestMapping(value = "/thaydoimatkhau", method = RequestMethod.POST)
	public String doiMatKhau(HttpSession session1, ModelMap model, HttpServletRequest request) {
		TaiKhoan taiKhoan = (TaiKhoan) session1.getAttribute("TaiKhoan");
		String username = taiKhoan.getMANV().trim();
		model.addAttribute("username", username);
		TaiKhoan check = searchTaiKhoan(username);
		String mk = request.getParameter("password");
		if (!mk.equals(check.getPASSWORD().trim())) {
			model.addAttribute("message1", "** Mật khẩu cũ không chính xác !");
			return "admin/doimatkhau";
		}
		String mk1 = request.getParameter("password1");
		if (mk.equals(mk1)) {
			model.addAttribute("message1", "** Mật khẩu mới không thể trùng với mật khẩu cũ !");
			return "admin/doimatkhau";
		}
		String mk2 = request.getParameter("password2");
		if (!mk1.equals(mk2)) {
			model.addAttribute("message1", "** Xác nhận mật khẩu không chính xác !");
			return "admin/doimatkhau";
		}
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			check.setPASSWORD(mk1);
			session.update(check);
			t.commit();
			return "redirect:/logout.htm";

		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Đổi mật khẩu thất bại !");
		} finally {
			session.close();
		}

		return "admin/doimatkhau";
	}

	@RequestMapping(value = "suanhanvien/update", method = RequestMethod.POST)
	public String editNhanVien(@ModelAttribute("nhanVien1") NhanVien nhanVien, ModelMap model, BindingResult errors) {

		boolean kt = true;
		if (nhanVien.getHo().trim().length() == 0) {
			errors.rejectValue("ho", "nhanVien", "Vui lòng nhập họ!");
			kt = false;
		}
		if (nhanVien.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "nhanVien", "Vui lòng nhập tên !");
			kt = false;
		}
		if (nhanVien.getcCCD().trim().length() == 0) {
			errors.rejectValue("cCCD", "nhanVien", "Vui lòng nhập CCCD !");
			kt = false;
		}
		if (kt == true) {

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(nhanVien);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);

			} finally {
				session.close();
			}
		}
		model.addAttribute("nhanVien1", nhanVien);
		model.addAttribute("nhanviens", getListNhanVien());
		return "admin/suanhanvien";
	}

	@RequestMapping(value = "xoanhanvien/{maNV}")
	public String xoanhanvien(ModelMap model, @PathVariable String maNV) {
		NhanVien nhanVien = searchNhanVien(maNV);
		TaiKhoan taiKhoan = nhanVien.getTaikhoan();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql2 = "delete from TaiKhoan where maNV =:maNV ";
			String hql1 = "delete from NhanVien where maNV=:maNV";

			Query query2 = session.createQuery(hql2);
			query2.setParameter("maNV", maNV);
			int result2 = query2.executeUpdate();
			Query query1 = session.createQuery(hql1);
			query1.setParameter("maNV", maNV);
			int result1 = query1.executeUpdate();

			t.commit();

			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);

		} finally {
			session.close();
		}

		return "redirect:/danhsachnhanvien.htm";
	}

	public List<NhanVien> getListNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		List<NhanVien> nhanviens = session.createQuery(hql).list();
		return nhanviens;
	}

	public TaiKhoan queryLogin(String username, String password) {

		Session session = factory.getCurrentSession();

		String hql = "FROM TaiKhoan WHERE MANV= :USERNAME AND PASSWORD = :PASSWORD";
		Query query = session.createQuery(hql);
		query.setParameter("USERNAME", username);
		query.setParameter("PASSWORD", password);
		if (query.list().size() == 0) {
			return null;
		}
		return (TaiKhoan) query.list().get(0);
	}

	

	public NhanVien searchNhanVien(String maNV) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien WHERE maNV = :maNV";
		Query query = session.createQuery(hql);
		query.setParameter("maNV", maNV);
		if (query.list().size() == 0)
			return null;
		return (NhanVien) query.list().get(0);
	}

	public TaiKhoan searchTaiKhoan(String maNV) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan WHERE maNV = :maNV";
		Query query = session.createQuery(hql);
		query.setParameter("maNV", maNV);
		if (query.list().size() == 0)
			return null;
		return (TaiKhoan) query.list().get(0);
	}

	public String taoMaNV() {
		String maNV1 = "manager";
		int ma = getNhanVien1().size() + 1;
		maNV1 += String.valueOf(ma);
		return maNV1;
	}

	public List<NhanVien> getNhanVien1() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		return list;
	}

	private int checkTrungCCCD(String cCCD) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where cCCD = :cCCD";
		Query query = session.createQuery(hql);
		query.setParameter("cCCD", cCCD);
		List<NhanVien> list = query.list();
		if (list.size() == 0)
			return 0;
		return 1;
	}

	public String getTen(String hoTen) {
		hoTen.trim();
		String ten = "";
		int index = hoTen.lastIndexOf(' ');
		ten = hoTen.substring(index + 1);
		return ten;
	}

	public String getHo(String hoTen) {
		hoTen.trim();
		int index = hoTen.lastIndexOf(getTen(hoTen));
		String ho = hoTen.substring(0, index);

		return ho.trim();
	}

	public List<NhanVien> getNhanVien(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<NhanVien> list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}

	public List<NhanVien> getNhanVien(int page, int pageSize, String ten) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<NhanVien> list;
		if (ten.length() == 0) {
			hql = "FROM NhanVien t ORDER BY t.taiKhoan.isAdmin DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else {
			hql = "FROM NhanVien t where t.ten LIKE CONCAT( :ten, '%') ORDER BY t.ten DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("ten", ten);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
		return list;
	}

	public int getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();

		return list.size();
	}

}
