<%--
  Created by IntelliJ IDEA.
  User: joy
  Date: 2019/12/9
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script language="javascript">
        function check() {
            if((document.login.user.value) == ""){
                window.alert("用户名不能为空，请输入用户名");
                document.login.user.focus();
                return false;
            }else if((document.login.psd.value) == ""){
                window.alert("密码不能为空，请输入密码");
                document.login.psd.focus();
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>
<body topmargin ="0">
<table width="920" height="600" border="0" align="center" bgcolor="#2f4f4f">
    <tr>
        <td height="100"></td>
    </tr>
    <tr>
        <td height="400">
            <div align="center">

                <%
                    String flag = request.getParameter("flag");
                    if(flag != null){
                        if(flag.equals("error")){
                %>
                <h2><font color="red">对不起，密码和用户名不正确，请重新输入！</font></h2>
                <hr/>
                <%
                }else if(flag.equals("login")){
                %>

                <h2><font color="red">对不起，你还没有登录，无法访问该页面!！</font></h2>
                <hr/>
                <%
                        }
                    }
                %>
                <form action="LoginServlet? flag=login" method="post" name="login" id="login">
                    <div style="background: #1188aa;border-radius: 6px;width: 400px; color:#ffffff;"></div>
                    <br>
                    <table width="90%" border="0">
                        <tr>
                            <td headers="33" style="color: #ffffff;" align="center">
                                <strong>用户登录</strong>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="center">
                                    <label style="color: #ffffff;">
                                        用户名称
                                        <input name="user" type="text" id="user" size="20" />
                                    </label>
                                </div>
                            </td>
                        </tr>


                        <tr>
                            <td height="30">
                                <div align="center" style="color: #ffffff">
                                    用户口令<label>
                                    <input name="psd" type="password" id="psd" size="20">
                                </label>
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <td height="38">
                                <div align="center">
                                    <label>
                                        <input name="role" type="radio" id="radio" value="admin" checked="checked">
                                    </label>
                                    <label style="color: #ffffff">
                                        管理员&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="role" id="radio2" value="teacher">
                                        教师&nbsp;&nbsp;&nbsp;&nbsp;
                                    </label>
                                    <label style="color: #ffffff">
                                        <input type="radio" name="role" id="radio3" value="student">
                                        学生
                                    </label>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td height="40">
                                <div align="center">
                                    <label>
                                        <input type="submit" name="submit" id="submit" value="提交" onclick="javascript;return check()"/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </label>
                                </div>
                            </td>


                        </tr>



                    </table>
                    <br>
                </form>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                </form>


            </div></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
    </tr>
</table>
</body>
</html>

