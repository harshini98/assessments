package com.deloitte.ecommerce;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import com.deloitte.ecommerce.entities.EWallet;
import com.deloitte.ecommerce.service.CustomerServiceImpl;
import com.deloitte.ecommerce.service.ICustomerService;
import com.deloitte.ecommerce.dao.EWalletDaoImpl;

@WebServlet("/second")
public class Servlet1 extends HttpServlet{
    private ICustomerService service=new CustomerServiceImpl(new EWalletDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String exitVal = req.getParameter("exit");
        boolean sessionDestroyed = false;
        if (exitVal != null && exitVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object mobilenoObj=null;
        if (!sessionDestroyed) {
            mobilenoObj = session.getAttribute("mobileno");
        }

        if (mobilenoObj == null || mobilenoObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String mobileno=mobilenoObj.toString();
        EWallet ewallet =service.findCustomerByMobileno(mobileno);
        String name=ewallet.getName();
        double balance=ewallet.getBalance();
        writer.println("Welcome " + mobileno +" name="+name+" balance="+balance);
        String exitLink = "<a href='/second?exit=true'>Exit </a> ";
        writer.println(exitLink);

    }
}
