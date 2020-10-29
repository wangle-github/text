package com.usian.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.Mapper.EmployeeMapper;
import com.usian.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired(required = false)
    private EmployeeMapper employeeMapper;

    public PageInfo<Employee> selectAll(Employee employee, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee>list = employeeMapper.selectAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    public void delete(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public Employee selectByName(String name) {
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        List<Employee>list = employeeMapper.selectByExample(example);
        return  list.get(0);
    }

    public Employee findById(Integer id) {
        Employee employee = (Employee) employeeMapper.selectByPrimaryKey(id);
        return employee;
    }
}
