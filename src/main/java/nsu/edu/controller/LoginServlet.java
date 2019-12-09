package nsu.edu.controller;

import nsu.edu.java.Dbhandle;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");

                final Dbhandle dbh = new Dbhandle();
        final String user = request.getParameter("user");
        final String psd = request.getParameter("psd");
        final String role = request.getParameter("role");
        final String flag = request.getParameter("flag");
        boolean b = false;
        final HttpSession sess = request.getSession();
        sess.setAttribute("user",user);
        ArrayList<String> password = new ArrayList<String>();
        if(flag.equals("login")){
            sess.setAttribute("role","管理员");
            password = dbh.getPassword("select Man_psd from Man_tb where Man_name="+user+"");
            for (int i = 0; i < password.size(); i++) {
                if(password.get(i).equals(psd)){
                    b= true;
                    break;
                }
            }
            if(b == true){
                response.sendRedirect("Manager.jsp");
            }else {
                response.sendRedirect("login.jsp?flag = error");
            }
        }else if (role.equals("student")){
            sess.setAttribute("role","学生");
            password = dbh.getPassword("select Stu_psd from Stu_tb where Stu_name="+user+"");
            for (int i = 0; i < password.size(); i++) {
                if(password.get(i).equals(psd)){
                    b = true;
                    break;
                }
            }
            if(b == true){
                response.sendRedirect("Student.jsp");
            }else {
                response.sendRedirect("login.jsp?flag=error");
            }
        }else if (role.equals("teacher")){
            sess.setAttribute("role","教师");
            password = dbh.getPassword("select Tea_psd from Tea_tb where Tea_name="+user+"");
            for (int i = 0; i < password.size(); i++) {
                if(password.get(i).equals(psd)){
                    b = true;
                    break;
                }
            }
            if(b == true){
                response.sendRedirect("Teacher.jsp");
            }else {
                response.sendRedirect("login.jsp?flag=error");
            }

        }else if (flag.equals("invalidate")){
            sess.invalidate();
            response.sendRedirect("login.jsp");
        }
    }
}
