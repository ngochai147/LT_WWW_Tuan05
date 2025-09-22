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

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllerDienThoai",urlPatterns = {"/dien-thoai"})
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private NhaCungCapDao nhaCungCapDao;
    private DienThoaiDao dienThoaiDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        nhaCungCapDao=new NhaCungCapImpl();
        dienThoaiDao=new DienThoaiImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DienThoai> dienThoais=dienThoaiDao.getAllDienThoai();
        List<NhaCungCap> nhaCungCapList=nhaCungCapDao.getAllNhaCungCap();
        req.setAttribute("listDienThoai",dienThoais);
        req.setAttribute("listNhaCungCap",nhaCungCapList);
        req.getRequestDispatcher("/views/dienthoai/DanhSachDienThoaiNCC.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<DienThoai> dienThoais = null;
        NhaCungCap nhaCungCap = null;

        String tenNhaCC = req.getParameter("nhaCC");
        String keyTimKiem = req.getParameter("timKiem");

        List<NhaCungCap> nhaCungCapList = nhaCungCapDao.getAllNhaCungCap();

        if (keyTimKiem != null && !keyTimKiem.trim().isEmpty()) {
            try {
                int maNCC = Integer.parseInt(keyTimKiem);
                if(maNCC<10000){
                    nhaCungCap = nhaCungCapDao.getNhaCungCapMaNCC(maNCC);
                }
            } catch (NumberFormatException e) {
                if ((nhaCungCap = nhaCungCapDao.getNhaCungCapTenNCC(keyTimKiem)) != null) {
                    // tìm theo tên
                } else if ((nhaCungCap = nhaCungCapDao.getNhaCungCapDiaChi(keyTimKiem)) != null) {
                    // tìm theo địa chỉ
                } else if ((nhaCungCap = nhaCungCapDao.getNhaCungCapSoDienThoai(keyTimKiem)) != null) {
                    // tìm theo số điện thoại
                }
            }
        }

        if (nhaCungCap == null && tenNhaCC != null) {
            nhaCungCap = nhaCungCapDao.getNhaCungCapTenNCC(tenNhaCC);
        }

        if (nhaCungCap != null) {
            dienThoais = nhaCungCapDao.getAllDienThoaiNCC(nhaCungCap.getMaNCC());
        }

        req.setAttribute("listDienThoai", dienThoais);
        req.setAttribute("listNhaCungCap", nhaCungCapList);
        req.setAttribute("tenNhaCC", tenNhaCC);
        req.setAttribute("keyTimKiem", keyTimKiem);

        req.getRequestDispatcher("/views/dienthoai/DanhSachDienThoaiNCC.jsp").forward(req, resp);
    }

}
