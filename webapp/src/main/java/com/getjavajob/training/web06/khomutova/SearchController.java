package com.getjavajob.training.web06.khomutova;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
    public ModelAndView doSearch(@RequestParam("search") String search) {
       List<Employee> result=employeeService.searchEmployee(search);
        ModelAndView modelAndView=new ModelAndView("search");
        modelAndView.addObject("employees", result);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @RequestMapping("/getEmployees")
    @ResponseBody
    public List<Employee> getEmployees(final @RequestParam("filter") String filter) {
        List<Employee> emps = employeeService.getAll();
        CollectionUtils.filter(emps, new Predicate<Employee>() {

            @Override
            public boolean evaluate(Employee employee) {
                return employee.getName().contains(filter) || employee.getEmail().contains(filter) || employee.getSkype().contains(filter);
            }
        });
        System.out.println(emps.size());
        for (Employee employee: emps){
            employee.setBoss(null);
            employee.setPhones(null);
            employee.setAddresses(null);
            employee.setDepartment(null);
        }
        return emps;
    }
}
