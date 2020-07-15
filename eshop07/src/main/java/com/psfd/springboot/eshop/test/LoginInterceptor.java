package com.psfd.springboot.eshop.test;

import com.psfd.springboot.eshop.domain.Admin;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                } else if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }

        if (username != null && password != null) {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            session.setAttribute("admin", admin);
        }

        Admin admin = (Admin) session.getAttribute("admin");

        if (admin != null) {
            return true;
        }
        request.getRequestDispatcher("login.html").forward(request, response);
        return false;
    }
}
