package com.portfolio.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.admin.AdminService;
import com.portfolio.biz.admin.EmployeeVO;
import com.portfolio.biz.member.MemberService;
import com.portfolio.biz.order.CartVO;
import com.portfolio.biz.order.OrderService;
import com.portfolio.biz.order.OrderVO;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.ProductVO;
import com.portfolio.biz.qna.QnaService;
import com.portfolio.biz.qna.QnaVO;
import com.portfolio.biz.util.Criteria;
import com.portfolio.biz.util.PageMaker;

@Controller
@SessionAttributes("adminUser")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private QnaService qnaService;

	@RequestMapping(value = "/admin_login_form")
	public String adminLoginView(Model model, HttpSession session) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser != null) {
			return "redirect:admin_product_list";
		} else {
			return "admin/login";
		}

	}

	@RequestMapping(value = "/admin_login")
	public String adminLogin(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd,
			Model model) {
		int result = adminService.workerCheck(id, pwd);

		if (result == 1) {
			EmployeeVO adminUser = adminService.getEmployee(id);

			model.addAttribute("adminUser", adminUser);
			return "redirect:admin_product_list";
		} else {
			if (result == 0) {
				model.addAttribute("message", "비밀번호를 확인하세요.");
			} else {
				model.addAttribute("message", "아이디를 확인하세요.");
			}
			return "admin/login";
		}
	}

	@RequestMapping(value = "/admin_logout")
	public String adminLogout(Model model, SessionStatus status) {

		status.setComplete();

		return "admin/login";
	}

	@RequestMapping(value = "/admin_product_list")
	public String adminProductListView(@RequestParam(value = "key", defaultValue = "") String key, Criteria criteria,
			Model model, HttpSession session) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/login";
		} else {

			System.out.println("페이지 범위: " + criteria);
			// List<ProductVO> productList = productService.listProduct("");
			List<ProductVO> productList = productService.getListWithPaging(criteria, key);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			// 총 목록수를 DB에서 조회
			int totalCount = productService.countProductList("");
			pageMaker.setTotalCount(totalCount);
			System.out.println("페이징 정보: " + pageMaker);

			model.addAttribute("productList", productList);
			model.addAttribute("productListSize", productList.size());
			model.addAttribute("pageMaker", pageMaker);

			return "admin/product/productList";
		}
	}

	@RequestMapping(value = "/admin_product_write_form")
	public String adminProductWriterView(Model model, HttpSession session) {
		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/login";
		} else {
			String kindList[] = { "과일", "야채", "쥬스", "견과류" };

			model.addAttribute("kindList", kindList);

			return "admin/product/productWrite";
		}
	}

	@RequestMapping(value = "admin_product_write")
	public String adminProductWrite(@RequestParam(value = "product_image") MultipartFile uploadFile, ProductVO vo,
			Model model, HttpSession session) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/login";
		} else {
			if (vo.getSaleyn() == null) {
				vo.setSaleyn("n");
				vo.setDiscount("0");
			}

			String fileName = "";
			if (!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/assets/images/");
				System.out.println("ROOT경로 = " + root_path);
				// 업로드된 파일명을 가져온다.
				fileName = uploadFile.getOriginalFilename();

				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			vo.setImage(fileName); // Product에 이미지 저장
			productService.insertProduct(vo);

			return "redirect:admin_product_list";
		}
	}

	@RequestMapping(value = "admin_product_detail")
	public String adminProductDetail(ProductVO vo, Criteria criteria, Model model) {

		String kindList[] = { "", "과일", "야채", "쥬스", "견과류" };

		// @RequestParam(value = "pseq", defaultValue = "0") int pseq, vo.setPseq(pseq);

		ProductVO productVO = productService.getProduct(vo);

		model.addAttribute("productVO", productVO);

		int number = Integer.parseInt(productVO.getKind());

		model.addAttribute("kind", kindList[number]);
		model.addAttribute("criteria", criteria);
		return "admin/product/productDetail";
	}

	@RequestMapping(value = "admin_product_update_form")
	public String adminProductUpdateView(ProductVO vo, Model model) {
		String kindList[] = { "과일", "야채", "쥬스", "견과류" };

		ProductVO productVO = productService.getProduct(vo);

		model.addAttribute("productVO", productVO);

		model.addAttribute("kindList", kindList);

		return "admin/product/productUpdate";

	}

	@RequestMapping(value = "admin_product_update")
	public String adminProductUpdate(@RequestParam(value = "product_image") MultipartFile uploadFile, ProductVO vo,
			Model model, HttpSession session) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";
			if (!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/assets/images/");
				System.out.println("ROOT경로 = " + root_path);
				// 업로드된 파일명을 가져온다.
				fileName = uploadFile.getOriginalFilename();

				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				vo.setImage(fileName);
			}

			// 체크박스 체크 하지 않았을때, 스크립트에서 인식 안되서 컨트롤러에 씀.
			if (vo.getSaleyn() == null) {
				vo.setSaleyn("n");
				vo.setDiscount("0");
			}
			if (vo.getUseyn() == null) {
				vo.setUseyn("n");
			}
			productService.updateProduct(vo);

			return "redirect:admin_product_detail?pseq=" + vo.getPseq();
		}
	}

	@RequestMapping(value = "admin_order_list")
	public String adminOrderList(@RequestParam(value = "key", defaultValue = "") String key, Model model,
			Criteria criteria, HttpSession session) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/login";
		} else {

			System.out.println("페이지 범위: " + criteria);
			// List<OrderVO> orderList = orderService.listOrder(key);
			List<OrderVO> orderList = orderService.getListWithPaging(criteria, key);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);

			int totalCount = orderService.countOrderList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("페이징 정보: " + pageMaker);

			model.addAttribute("orderList", orderList);
			model.addAttribute("orderListSize", orderList.size());
			model.addAttribute("pageMaker", pageMaker);

			return "admin/order/orderList";
		}
	}

	@RequestMapping(value = "admin_order_save")
	public String AdminOrderSave(HttpServletRequest request) {

		String[] orderCheck = request.getParameterValues("result");

		for (String oseq : orderCheck) {
			orderService.updateOrderResult(oseq);
		}
		return "redirect:admin_order_list";
	}

	// Qna 게시판 전체 목록 조회
	@RequestMapping(value = "admin_qna_list")
	public String adminQnaList(Model model, HttpSession session) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/login";
		} else {

			List<QnaVO> qnaList = qnaService.listAllQna();
			model.addAttribute("qnaList", qnaList);
			return "admin/qna/qnaList";
		}
	}

	@RequestMapping(value = "admin_qna_detail")
	public String adminQnaDetail(@RequestParam(value = "qseq") int qseq, Model model) {

		QnaVO qnaVO = qnaService.getQna(qseq);
		model.addAttribute("qnaVO", qnaVO);
		return "admin/qna/qnaDetail";
	}

	@RequestMapping(value = "admin_qna_repsave")
	public String adminQnaResave(@RequestParam(value = "qseq") int qseq, QnaVO vo) {

		QnaVO qnaVO = new QnaVO();
		qnaVO.setQseq(qseq);
		qnaVO.setReply(vo.getReply());

		qnaService.updateQna(qnaVO);
		return "redirect:admin_qna_list";
	}

	// 회원 조회
	@RequestMapping(value = "admin_member_list")
	public String adminMemberList(Model model, HttpSession session, HttpServletRequest request) {

		EmployeeVO adminUser = (EmployeeVO) session.getAttribute("adminUser");

		if (adminUser == null) {
			return "admin/main";
		} else {
			String key = "";
			if (key != "") {
				key = request.getParameter("key");
				List<MemberVO> memberList = memberService.listMember(key);
				model.addAttribute("memberList", memberList);
				return "admin/member/memberList";
			}

			List<MemberVO> memberList = memberService.listMember(key);
			model.addAttribute("memberList", memberList);
			return "admin/member/memberList";
		}

	}
	//휴면ID 변경
	@RequestMapping(value = "/go_sleep_id")
	public String goSleepMemberCheckbox(
			@RequestParam(value = "id", required = false, defaultValue = "0") String[] idChecked) {

		for (int i = 0; i < idChecked.length; i++) {
			System.out.println(idChecked[i]);
		}

		for (String id : idChecked) {
			memberService.goSleepMember(id);
		}

		return "redirect:admin_member_list";
	}
	//휴면ID 해제
	@RequestMapping(value = "/go_activation_id")
	public String goActivationMemberCheckbox(
			@RequestParam(value = "id", required = false, defaultValue = "0") String[] idChecked) {

		for (int i = 0; i < idChecked.length; i++) {
			System.out.println(idChecked[i]);
		}

		for (String id : idChecked) {
			memberService.goActivationMember(id);
		}

		return "redirect:admin_member_list";
	}
	
	
}
