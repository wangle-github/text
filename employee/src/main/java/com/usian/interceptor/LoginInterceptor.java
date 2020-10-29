package com.usian.interceptor;

import com.usian.pojo.Employee;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)throws Exception {
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if(employee!=null){
            return true;
        }
        response.sendRedirect("/employee/goLogin");
        return false;
    }

}

