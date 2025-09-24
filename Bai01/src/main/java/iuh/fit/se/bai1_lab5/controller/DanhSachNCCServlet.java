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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllerNCC",urlPatterns = {"/nha-cung-cap"})
public class DanhSachNCCServlet extends HttpServlet {
    private NhaCungCapDao nhaCungCapDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhaCungCap> nhaCungCapList=nhaCungCapDao.getAllNhaCungCap();
        req.setAttribute("listNCC",nhaCungCapList);
        req.getRequestDispatcher("/views/dienthoai/NhaCungCap.jsp")
                .forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        nhaCungCapDao=new NhaCungCapImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyTimKiem = req.getParameter("timKiem");
        NhaCungCap nhaCungCap = null;
        List<NhaCungCap> nhaCungCapList = nhaCungCapDao.getAllNhaCungCap();

        if (keyTimKiem != null && !keyTimKiem.trim().isEmpty()) {
            List<NhaCungCap> listTemp=new ArrayList<>();
                if(nhaCungCapDao.getNhaCungCapMaNCC(Integer.parseInt(keyTimKiem))!=null){
                    nhaCungCap=nhaCungCapDao.getNhaCungCapMaNCC(Integer.parseInt(keyTimKiem));
                    listTemp.add(nhaCungCap);
                }else if ((nhaCungCap = nhaCungCapDao.getNhaCungCapTenNCC(keyTimKiem)) != null) {
                    listTemp.add(nhaCungCap);
                } else if ((nhaCungCap = nhaCungCapDao.getNhaCungCapDiaChi(keyTimKiem)) != null) {
                    listTemp.add(nhaCungCap);
                } else if ((nhaCungCap = nhaCungCapDao.getNhaCungCapSoDienThoai(keyTimKiem)) != null) {
                    listTemp.add(nhaCungCap);
                }
            req.setAttribute("listNCC",listTemp);
            req.getRequestDispatcher("/views/dienthoai/NhaCungCap.jsp")
                    .forward(req,resp);
        }else{
            req.setAttribute("listNCC",nhaCungCapList);
            req.getRequestDispatcher("/views/dienthoai/NhaCungCap.jsp")
                    .forward(req,resp);
        }

    }
}
