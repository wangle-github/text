package com.usian.controller;

import com.github.pagehelper.PageInfo;
import com.usian.pojo.Employee;
import com.usian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired(required = false)
    private EmployeeService employeeService;

    @RequestMapping("doList")
    //@ResponseBody
    public String selectAll(Employee employee, @RequestParam(defaultValue = "1")int pageNum,
                            @RequestParam(defaultValue = "2")int pageSize, Model model){
        PageInfo<Employee> pageInfo = employeeService.selectAll(employee, pageNum, pageSize);
        model.addAttribute("employee",pageInfo);
        model.addAttribute("condition",employee);
        return "list";
    }


    @RequestMapping("doAdd")
    public String doAdd(){
        return "add";
    }
    // 添加信息
    @PostMapping("addemployee")
    public String insertEmployee(Employee employee){
        if(employee.getId() != null){
            employeeService.update(employee);
        }else{
            employeeService.add(employee);
        }
        return "redirect:doList";
    }

    @RequestMapping("doDeleteById")
    public String doDeleteById(Integer id){
        employeeService.delete(id);
        return "redirect:doList";
    }

    @RequestMapping("doUpdate")
    public String doUpdate(Integer id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("emp",employee);
        return "update";
    }

    @RequestMapping("goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("doLogin")
    public String selectByName(Model model, String name, String code, HttpServletRequest request){
        Employee employee = employeeService.selectByName(name);
        if (employee==null){
            model.addAttribute("errorname","用户名错误！");
            return "login";
        }
        if (!employee.getCode().equals(Integer.parseInt(code))){
            model.addAttribute("errorcode","密码错误！");
            return "login";
        }else {
            request.getSession().setAttribute("employee",employee);
            return "redirect:doList";
        }
    }
}
