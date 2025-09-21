package iuh.fit.se.bai1_lab5.controller;

import iuh.fit.se.bai1_lab5.dao.DienThoaiImpl;
import iuh.fit.se.bai1_lab5.dao.NhaCungCapImpl;
import iuh.fit.se.bai1_lab5.dao.implement.DienThoaiDao;
import iuh.fit.se.bai1_lab5.dao.implement.NhaCungCap;
import iuh.fit.se.bai1_lab5.model.DienThoai;
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
    private NhaCungCap nhaCungCap;
    private DienThoaiDao dienThoaiDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        nhaCungCap=new NhaCungCapImpl();
        dienThoaiDao=new DienThoaiImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DienThoai> dienThoais=dienThoaiDao.getAllDienThoai();
        req.setAttribute("list-dienthoai",dienThoais);
        req.getRequestDispatcher("/views/dienthoai/DanhSachDienThoaiNCC.jsp")
                .forward(req,resp);
    }
}
