package nsu.edu.java;

import nsu.edu.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dbhandle {
    private Connection conn = null; //连接

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //获取密码
    public ArrayList<String> getPassword(String sql){
        ArrayList<String> psd = new ArrayList<>();
        try {
            conn = new DBconn().getConn();//连接数据库
            ps = conn.prepareStatement(sql);//预编译
            rs = ps.executeQuery();//执行语句
            while (rs.next()){
                psd.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return psd;
    }

    public int getRowCount(String sql){
        int pageCount = 0;

        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                pageCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return pageCount;

    }

    public ArrayList<Student> getStudent(String sql){
        ArrayList<Student> stu = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student st = new Student();
                st.setStu_ID(rs.getInt(1));
                st.setStu_num(rs.getString(2));
                st.setStu_name(rs.getString(3));
                st.setStu_psd(rs.getString(4));
                int Class_ID =rs.getInt(5);
                st.setStu_class(this.getName("select Class_name from Class_tb where Class_ID=" + String.valueOf(Class_ID)+""));
                stu.add(st);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return stu;
    }

    public String getName(String sql){
        String name = "";
      ResultSet rst = null;
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rst = ps.executeQuery();
            while (rst.next()){
                name = rst.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(rst != null) {
                        rst.close();
                        rst = null;
                    }if(ps != null){
                        ps.close();
                        ps = null;
                    }if(conn != null){
                        conn.close();
                        conn =null;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
        return name;
    }

    public ArrayList<Teacher> getTeacher(String sql){
        ArrayList<Teacher> teacher = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Teacher st = new Teacher();
                st.setTea_ID(rs.getInt(1));
                st.setTea_name(rs.getString(2));
                st.setTea_psd(rs.getString(3));

                teacher.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return teacher;
    }

    public ArrayList<Course> getCourse(String sql){
        ArrayList<Course> course = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Course st = new Course();
                st.setCou_ID(rs.getInt(1));
                st.setCou_name(rs.getString(2));
                course.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return course;
    }


    public ArrayList<Banji> getBanji(String sql){
        ArrayList<Banji> banji = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Banji st = new Banji();
                st.setClass_ID(rs.getInt(1));
                st.setClass_name(rs.getString(2));
                banji.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return banji;
    }


    public ArrayList<Score> getScore(String sql){
        ArrayList<Score> score = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Score sco = new Score();
                sco.setScore_ID(rs.getInt(1));
                int Stu_ID = rs.getInt(2);
                sco.setStu_name(this.getName("select Stu_name from Stu_tb where Stu_ID="+Stu_ID+""));
                int Class_ID = rs.getInt(3);
                sco.setClass_name(this.getName("select Class_name from Class_tb where Class_ID="+Class_ID+""));
                int Tea_ID = rs.getInt(4);
                sco.setTea_name(this.getName("select Tea_name from Tea_tb where Tea_ID="+Tea_ID+""));
                int Cou_ID = rs.getInt(5);
                sco.setCou_name(this.getName("select Cou_name from Cou_tb where Cou_ID="+Cou_ID+""));
                sco.setScore_score(rs.getInt(6));
                score.add(sco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return score;
    }

    public ArrayList<Tea_Cou_Cla> getTea_Cou_Cla(String sql){
        ArrayList<Tea_Cou_Cla> al = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Tea_Cou_Cla tcc = new Tea_Cou_Cla();
                int Tea_ID = rs.getInt(1);
                int Cou_ID = rs.getInt(2);
                int Class_ID = rs.getInt(3);

                tcc.setTea_name(this.getName("select Tea_name from Tea_tb where Tea_ID="+Tea_ID+""));

                tcc.setCou_name(this.getName("select Cou_name from Cou_tb where Cou_ID="+Cou_ID+""));
                tcc.setCla_name(this.getName("select Class_name from Class_tb where Class_ID="+Class_ID+""));
                al.add(tcc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return al;
    }


    public ArrayList<Title> getTitle(String sql){
        ArrayList<Title> title = new ArrayList<>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Title tl = new Title();
                tl.setTitle_ID(rs.getInt(1));
                tl.setTitle_name(rs.getString(2));
                tl.setTitle_opt_a(rs.getString(3));
                tl.setTitle_opt_b(rs.getString(4));
                tl.setTitle_opt_c(rs.getString(5));
                tl.setTitle_opt_d(rs.getString(6));
                tl.setTitle_answer(rs.getString(7));
                tl.setTitle_score(rs.getInt(8));
                int Cou_ID = rs.getInt(9);
                int Tea_ID =rs.getInt(10);
                tl.setCou_name(this.getName("select Cou_name from Cou_tb where Cou_ID="+Cou_ID+""));
                tl.setTea_name(this.getName("select Tea_name from Tea_tb where Tea_ID="+Tea_ID+""));
                title.add(tl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return title;
    }


    public ArrayList<String> getAttribute(String sql){
        ArrayList<String> att = new ArrayList<String>();
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
               att.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return att;
    }

    public int getID(String sql){
        int ID = 1;
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                ID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return ID;
    }

    public void close(){
        if(rs != null){
            try {
                rs.close();
                rs = null;
                if(ps != null){
                    ps.close();
                    ps = null;
                }if(conn != null){
                    conn.close();
                    conn =null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean Update(String sql){
        boolean b = false;
        try {
            conn = new DBconn().getConn();
            ps = conn.prepareStatement(sql);
            int rs = ps.executeUpdate();
            if(rs != 0){
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return b;
    }
}
