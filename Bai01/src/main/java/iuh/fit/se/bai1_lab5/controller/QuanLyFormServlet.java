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

@WebServlet(name = "quanLyController",urlPatterns = {"/quanly"})
public class QuanLyFormServlet extends HttpServlet {

    private DienThoaiDao dienThoaiDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DienThoai> dienThoais=dienThoaiDao.getAllDienThoai();
        req.setAttribute("listDienThoai",dienThoais);
        req.getRequestDispatcher("/views/quanly/QuanLyForm.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maDT= Integer.parseInt(req.getParameter("maDT"));
        dienThoaiDao.xoaDienThoai(maDT);
        List<DienThoai> dienThoais=dienThoaiDao.getAllDienThoai();
        req.setAttribute("listDienThoai",dienThoais);
        req.getRequestDispatcher("/views/quanly/QuanLyForm.jsp")
                .forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        dienThoaiDao=new DienThoaiImpl();
    }
}
