package com.getjavajob.training.web06.ui;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.EntityType;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import com.getjavajob.training.web06.ui.xmlserializer.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
    public ModelAndView showEmployees() {
        logger.debug("Start showEmployees method");
        List<Employee> employees = employeeService.getAll();
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/showEmployee", method = RequestMethod.GET)
    public ModelAndView showEmployee(@RequestParam("ID") int id) {
        Employee employee = employeeService.get(id);
        ClassLoader classLoader = getClass().getClassLoader();
        String base34Photo = new String();
        if (employee.getPhoto() == null) {
            File file = new File(classLoader.getResource("avatar.jpg").getFile());
            try {
                byte[] array = Files.readAllBytes(file.toPath());
                base34Photo = Base64.getEncoder().encodeToString(array);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            byte[] photo = employee.getPhoto();
            if (photo.length > 0) {
                base34Photo = Base64.getEncoder().encodeToString(photo);
            }
        }
        ModelAndView modelAndView = new ModelAndView("employee");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("photo", base34Photo);
        return modelAndView;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public ModelAndView addEmployee() {
        logger.debug("Start addEmployee method");
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        modelAndView.addObject("departments", departmentService.getAll());
        modelAndView.addObject("employees", employeeService.getAll());
        modelAndView.addObject("addresses", employeeService.getAllAddresses());
        modelAndView.addObject("phones", employeeService.getAllPhones());
        return modelAndView;
    }

    @RequestMapping(value = "/toXmlEmployee", method = RequestMethod.GET)
    public String toXmlEmployee() {
        List<Employee> employees = employeeService.getAll();
        Serializer serializer = new Serializer();
     //   File file = new File("c:\\XML/employee.xml");
        ClassLoader loader = EmployeeController.class.getClassLoader();
        File file = new File(loader.getResource("employees.xml").getFile());
        try {
            serializer.toXML(employees, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/showEmployees";
    }

    @RequestMapping(value = "/getFromXmlEmployees", method = RequestMethod.GET)
    public ModelAndView getFromXmlEmployees() throws FileNotFoundException {
        Serializer serializer = new Serializer();
       // File file = new File("c:\\XML/employee.xml");
        ClassLoader loader = EmployeeController.class.getClassLoader();
        File file = new File(loader.getResource("employees.xml").getFile());
        List<Employee> employees=serializer.fromXML(file);
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/doAddEmployee", method = RequestMethod.POST)
    public String doAddEmployee(HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setPhoto(null);
        employee.setName(request.getParameter("name"));
        String date = request.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setBirthday(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setIcq(request.getParameter("ICQ"));
        employee.setSkype(request.getParameter("skype"));
        employee.setEmail(request.getParameter("email"));
        int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
        Employee boss = employeeService.get(bossID);
        employee.setBoss(boss);
        employee.setDepartment(departmentService.getAll().get(Integer.parseInt(request.getParameter("department"))));
        employee.setAddresses(makeAddress(request.getParameterValues("mytext2[]"), request.getParameterValues("Type2[]")));
        String[] phones = request.getParameterValues("mytext[]");
        String[] phonesTypes = request.getParameterValues("Type[]");
        employee.setPhones(makePhones(phones, phonesTypes));
        employeeService.add(employee);
        return "redirect:/showEmployees";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam("ID") int id) {
        employeeService.delete(id);
        return "redirect:/showEmployees";
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public ModelAndView showUpdateEmployee(@RequestParam("ID") int id) {
        Employee employee = employeeService.get(id);
        ModelAndView modelAndView = new ModelAndView("updateEmployee");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("departments", departmentService.getAll());
        modelAndView.addObject("employees", employeeService.getAll());
        modelAndView.addObject("addresses", employeeService.getAllAddresses());
        modelAndView.addObject("phones", employeeService.getAllPhones());
        return modelAndView;
    }

    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public String upload(MultipartHttpServletRequest request) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());
        int id = Integer.parseInt(request.getParameter("ID"));
        boolean deletePhoto = Boolean.parseBoolean(request.getParameter("deletePhoto"));
        Employee employee = employeeService.get(id);
        if (!mpf.isEmpty()) {
            try {
                if (!deletePhoto) {
                    employee.setPhoto(mpf.getBytes());
                } else {
                    employee.setPhoto(null);
                }
                employeeService.update(employee);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            employee.setPhoto(null);
            employeeService.update(employee);
        }
        return "redirect:/showEmployee?ID=" + id;
    }

    @RequestMapping(value = "/doUpdateEmployee", method = RequestMethod.POST)
    public String doUpdateEmployee(HttpServletRequest request) {
        Employee employee = new Employee();
        int id = Integer.parseInt(request.getParameter("ID"));
        Employee oldGay = employeeService.get(id);
        employee.setId(oldGay.getId());
        employee.setName(request.getParameter("name"));
        String date = request.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setBirthday(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setIcq(request.getParameter("ICQ"));
        employee.setSkype(request.getParameter("skype"));
        employee.setEmail(request.getParameter("email"));

        if (request.getParameter("boss") != null) {
            int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
            Employee boss = employeeService.get(bossID);
            employee.setBoss(boss);
        } else {
            employee.setBoss(oldGay.getBoss());
        }

        if (request.getParameter("department") != null) {
            employee.setDepartment(departmentService.getAll().get(Integer.parseInt(request.getParameter("department"))));
        } else {
            employee.setDepartment(oldGay.getDepartment());
        }

        if (request.getParameterValues("addresses[]") != null) {
            employee.setAddresses(makeAddress(request.getParameterValues("mytext2[]"), request.getParameterValues("Type2[]")));
        } else {
            employee.setAddresses(oldGay.getAddresses());
        }

        if (request.getParameterValues("phones[]") != null) {
            String[] phones = request.getParameterValues("mytext[]");
            String[] phonesTypes = request.getParameterValues("Type[]");
            employee.setPhones(makePhones(phones, phonesTypes));
        } else {
            employee.setPhones(oldGay.getPhones());
        }
        employeeService.update(employee);
        return "redirect:/showEmployees";
    }

    private ArrayList<Address> makeAddress(String[] addreses, String[] parameterValues) {
        ArrayList<Address> result = new ArrayList<>();
        for (int i = 0; i < addreses.length; i++) {
            String[] addresline = addreses[i].split(" ");
            Address address = new Address();
            address.setPostal(Integer.parseInt(addresline[0]));
            address.setCity(addresline[1]);
            address.setStreet(addresline[2]);
            address.setApartment(Integer.parseInt(addresline[3]));
            List<Address> addresses = employeeService.getAllAddresses();
            for (Address dbAddress : addresses) {
                if (dbAddress.getPostal() == address.getPostal() || dbAddress.getCity().equals(address.getCity()) ||
                        dbAddress.getStreet().equals(address.getStreet()) || dbAddress.getApartment() == address.getApartment()) {
                    address.setId(dbAddress.getId());
                }
            }
            if (parameterValues[i].equals("job")) {
                address.setAddressType(EntityType.job);
            } else {
                address.setAddressType(EntityType.home);
            }
            result.add(address);
        }
        return result;
    }

    private List<Phone> makePhones(String[] phones, String[] phonesTypes) {
        List<Phone> employeePhones = new ArrayList<>();
        for (int i = 0; i < phones.length; i++) {
            Phone phone = new Phone();
            phone.setNumber(phones[i]);
            if (phonesTypes[i].equals("job")) {
                phone.setEntityType(EntityType.job);
            } else {
                phone.setEntityType(EntityType.home);
            }
            List<Phone> dbPhones = employeeService.getAllPhones();
            for (Phone dbPhone : dbPhones) {
                if (dbPhone.getNumber().equals(phone.getNumber())) {
                    phone.setId(dbPhone.getId());
                }
            }
            employeePhones.add(phone);
        }
        return employeePhones;
    }
}
