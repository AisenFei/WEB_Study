package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//注解的使用：小括号包裹多个属性，属性名=属性值，多个之间逗号间隔
//属性名为value时可以缺省
//Servlet定义服务：注意服务路径必须是/开始，否则Tomcat启动就会报错
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，响应编码，及响应数据类型（为响应体设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //解析数据
        //request.getParameter方法获取请求数据
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.printf("用户名=%s，密码=%s\n",u,p);

        //返回相应数据
        PrintWriter pw = resp.getWriter();//response获取io输出流
        pw.println("登陆成功");
        pw.println("欢迎你，"+u);
        pw.flush();//有缓冲的io操作，需要刷新缓冲区，才会真正的发送或接受数据
        pw.close();//io流操作完，一定要记住关闭资源
    }
}
