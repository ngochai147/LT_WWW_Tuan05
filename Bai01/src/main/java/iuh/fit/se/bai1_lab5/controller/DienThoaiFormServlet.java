package iuh.fit.se.bai1_lab5.controller;

import iuh.fit.se.bai1_lab5.dao.DienThoaiImpl;
import iuh.fit.se.bai1_lab5.dao.NhaCungCapImpl;
import iuh.fit.se.bai1_lab5.dao.implement.DienThoaiDao;
import iuh.fit.se.bai1_lab5.dao.implement.NhaCungCapDao;
import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.model.NhaCungCap;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "dienThoaiController", urlPatterns = {"/dienthoai-form"})
public class DienThoaiFormServlet extends HttpServlet {
    private NhaCungCapDao nhaCungCapDao;
    private DienThoaiDao dienThoaiDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        nhaCungCapDao = new NhaCungCapImpl();
        dienThoaiDao = new DienThoaiImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenDT = req.getParameter("tenDT");
        String namSXStr = req.getParameter("namSX");
        int namSX = 0;
        if (namSXStr != null && !namSXStr.isEmpty()) {
            namSX = Integer.parseInt(namSXStr);
        }
        String cauHinh = req.getParameter("cauHinh");
        int maNCC = Integer.parseInt(req.getParameter("mancc"));
        String hinhAnh = req.getParameter("hinhAnh");

        DienThoai dienThoai = new DienThoai();
        NhaCungCap nhaCungCap = nhaCungCapDao.getNhaCungCapMaNCC(maNCC);

        dienThoai.setTenDT(tenDT);
        dienThoai.setNamSX(namSX);
        dienThoai.setCauHinh(cauHinh);
        dienThoai.setHinhAnh(hinhAnh);
        dienThoai.setNhaCungCap(nhaCungCap);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<DienThoai>> errors = validator.validate(dienThoai);

        if (errors.isEmpty()) {
            dienThoaiDao.save(dienThoai);
            req.setAttribute("listDienThoai", dienThoaiDao.getAllDienThoai());
            req.setAttribute("listNhaCungCap", nhaCungCapDao.getAllNhaCungCap());
            req.getRequestDispatcher("/views/dienthoai/DanhSachDienThoaiNCC.jsp")
                    .forward(req, resp);
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("dienthoai", dienThoai);
            req.setAttribute("listNhaCungCap", nhaCungCapDao.getAllNhaCungCap());
            req.getRequestDispatcher("/views/dienthoai/DienThoaiForm.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listNhaCungCap", nhaCungCapDao.getAllNhaCungCap());
        req.getRequestDispatcher("/views/dienthoai/DienThoaiForm.jsp")
                .forward(req, resp);
    }
}
