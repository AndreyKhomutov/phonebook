package com.getjavajob.training.web06.khomutova;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/showDepartments", method = RequestMethod.GET)
    public ModelAndView showDepartments() {
        List<Department> departments = departmentService.getAll();
        ModelAndView modelAndView = new ModelAndView("departments");
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }

    @RequestMapping(value = "/showDepartment", method = RequestMethod.GET)
    public ModelAndView showDepartment(@RequestParam("ID") int id) {
        Department department = departmentService.get(id);
        Employee boss = department.getDepartmentBoss();
        ModelAndView modelAndView = new ModelAndView("department");
        modelAndView.addObject("department", department);
        modelAndView.addObject("boss", boss);
        return modelAndView;
    }

    @RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
    public ModelAndView addDepartment() {
        ModelAndView modelAndView = new ModelAndView("addDepartment");
        modelAndView.addObject("employees", employeeService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/doAddDepartment", method = RequestMethod.POST)
    public String doAddDepartment(HttpServletRequest request) {
        Department department = new Department();
        department.setName(request.getParameter("name"));
        int bossID = Integer.parseInt(request.getParameter("departmentBoss")) + 1;
        department.setDepartmentBoss(employeeService.get(bossID));
        departmentService.add(department);
        return "redirect:/showDepartments";
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam("ID") int id) {
        departmentService.delete(id);
        return "redirect:/showDepartments";
    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.GET)
    public ModelAndView showUpdateDepartment(@RequestParam("ID") int id) {
        Department department = departmentService.get(id);
        ModelAndView modelAndView = new ModelAndView("updateDepartment");
        modelAndView.addObject("department", department);
        modelAndView.addObject("employees", employeeService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/doUpdateDepartment", method = RequestMethod.POST)
    public String doUpdateDepartment(HttpServletRequest request) {
        Department department = new Department();
        int id = Integer.parseInt(request.getParameter("ID"));
        Department oldDepartment = departmentService.get(id);
        department.setId(oldDepartment.getId());
        department.setName(request.getParameter("name"));
        if (request.getParameter("boss") != null) {
            int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
            Employee boss = employeeService.get(bossID);
            department.setDepartmentBoss(boss);
        } else {
            department.setDepartmentBoss(oldDepartment.getDepartmentBoss());
        }
        departmentService.update(department);
        return "redirect:/showDepartments";
    }
}
