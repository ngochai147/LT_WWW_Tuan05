package iuh.fit.se.bai1_lab5.controller;

import iuh.fit.se.bai1_lab5.dao.DienThoaiImpl;
import iuh.fit.se.bai1_lab5.dao.NhaCungCapImpl;
import iuh.fit.se.bai1_lab5.dao.implement.DienThoaiDao;
import iuh.fit.se.bai1_lab5.dao.implement.NhaCungCapDao;
import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.model.NhaCungCap;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(name = "quanLyController", urlPatterns = {"/quanly"})
@MultipartConfig
public class QuanLyFormServlet extends HttpServlet {
    private DienThoaiDao dienThoaiDao;
    private NhaCungCapDao nhaCungCapDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dienThoaiDao = new DienThoaiImpl();
        nhaCungCapDao = new NhaCungCapImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DienThoai> dienThoais = dienThoaiDao.getAllDienThoai();
        req.setAttribute("listDienThoai", dienThoais);
        req.getRequestDispatcher("/views/quanly/QuanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            int maDT = Integer.parseInt(req.getParameter("maDT"));
            dienThoaiDao.xoaDienThoai(maDT);

            req.setAttribute("listDienThoai", dienThoaiDao.getAllDienThoai());
            req.getRequestDispatcher("/views/quanly/QuanLyForm.jsp").forward(req, resp);

        } else if ("update".equals(action)) {
            int maDT = Integer.parseInt(req.getParameter("maDT"));
            DienThoai dienThoai = dienThoaiDao.findByMaDT(maDT);

            req.setAttribute("dienthoai", dienThoai);
            req.setAttribute("listNhaCungCap", nhaCungCapDao.getAllNhaCungCap());
            req.getRequestDispatcher("/views/dienthoai/UpdateForm.jsp").forward(req, resp);

        } else if ("updateSave".equals(action)) {
            int maDT = Integer.parseInt(req.getParameter("maDT"));
            DienThoai dienThoai = dienThoaiDao.findByMaDT(maDT);

            if (dienThoai != null) {
                dienThoai.setTenDT(req.getParameter("tenDT"));
                dienThoai.setNamSX(Integer.parseInt(req.getParameter("namSX")));
                dienThoai.setCauHinh(req.getParameter("cauHinh"));

                int maNCC = Integer.parseInt(req.getParameter("mancc"));
                NhaCungCap ncc = nhaCungCapDao.getNhaCungCapMaNCC(maNCC);
                dienThoai.setNhaCungCap(ncc);

                Part filePart = req.getPart("hinhAnh");
                if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String uploadPath = getServletContext().getRealPath("/images");
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) uploadDir.mkdirs();

                    filePart.write(uploadPath + File.separator + fileName);
                    dienThoai.setHinhAnh(fileName);
                }

                dienThoaiDao.updateDT(dienThoai);
            }
            req.setAttribute("listDienThoai", dienThoaiDao.getAllDienThoai());
            req.getRequestDispatcher("/views/quanly/QuanLyForm.jsp").forward(req, resp);
        }
    }
}
