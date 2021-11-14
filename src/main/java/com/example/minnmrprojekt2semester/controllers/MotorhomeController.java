package com.example.minnmrprojekt2semester.controllers;
import com.example.minnmrprojekt2semester.model.Booking;
import com.example.minnmrprojekt2semester.model.Customer;
import com.example.minnmrprojekt2semester.model.Employee;
import com.example.minnmrprojekt2semester.model.Motorhome;
import com.example.minnmrprojekt2semester.repository.BookingRepository;
import com.example.minnmrprojekt2semester.repository.CustomerRepository;
import com.example.minnmrprojekt2semester.repository.EmployeeRepository;
import com.example.minnmrprojekt2semester.repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class MotorhomeController {
    @Autowired
    MotorhomeRepository motorhomeRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
//-------------------------------------------------------------------------------------------------------------------
    private int temporaryId = 0;
//-------------------------------------------------FORSIDE-----------------------------------------------------------
    @GetMapping("/")
        public String index() {
            return "index";
        }
//-------------------------------------------------------------------------------------------------------------------
    @GetMapping("/get_all_motorhomes")
    public String getAllMotorhomes (Model model) {
        List<Motorhome> motorhomes = motorhomeRepository.readAllMotorhomes();
        for (Motorhome motorhome:motorhomes) {
        }
        Model motorhome_list = model.addAttribute("motorhome_list", motorhomes);
        return "all_motorhomes";
    }

    @GetMapping("/get_all_employees")
    public String getAllEmployees (Model model) {
        List<Employee> employees = employeeRepository.readAllEmployees();
        for (Employee employee:employees) { //TOM FORLOOP!!
        }
        model.addAttribute("employee_list", employees);
        return "all_employees";
    }

    @GetMapping("/get_all_customers")
    public String getAllCustomer (Model model) {
        List<Customer> customers = customerRepository.getAllCustomers();
        for (Customer customer:customers) { //TOM FORLOOP!!
        }
        model.addAttribute("customer_list", customers);
        return "all_customers";
    }

    @GetMapping("/get_all_bookings")
    public String getAllBookings (Model model) {
        List<Booking> bookings = bookingRepository.readAllBookings();
        for (Booking booking:bookings) { //TOM FORLOOP!!
        }
        model.addAttribute("booking_list", bookings);
        return "all_bookings";
    }
//--------------------------------------------------------------------------------------------------------------------
    @GetMapping("/find_customer_by_id")
    public String findCustomerById () {
        return "find_customer_by_id";
    }

    @PostMapping("/direct_customer_by_id")
    public String directCustomerByiD (@RequestParam(name = "customer_ID")int id) { //anmode om input fra bruger/browser den gældende parameter (id)
        return "redirect:/customer/" + id;
    }

    @GetMapping("/customer/{id}")
    public String customerById (@PathVariable("id") int id, Model model) { //Pathvariable binder sig til den gældende input
        Customer customer = customerRepository.readOneCustomer(id);
        model.addAttribute("one_customer", customer);
        temporaryId = id;
        return "customer_by_id";
    }

    @GetMapping("/update_customer")
    public String updateCustomer (Model model) {
        model.addAttribute("customer_id", temporaryId);
        return "update_customer";
    }

    @PostMapping("/direct_update_customer")
    public String directUpdateCustomer (@RequestParam(name = "customer_name")String name,
                                        @RequestParam(name = "customer_mail")String mail,
                                        @RequestParam(name = "customer_phone")String phone,
                                        RedirectAttributes attributes) {

        attributes.addAttribute("customer_name", name);
        attributes.addAttribute("customer_mail", mail);
        attributes.addAttribute("customer_phone", phone);
        customerRepository.updateCustomer(new Customer(name, mail, phone), temporaryId);
        return "redirect:/customer_updated/" + temporaryId;
    }

    @GetMapping("/customer_updated/{id}")
    public String updatedCustomer (@PathVariable("id") int id,
                                   @RequestParam(name = "customer_name")String name,
                                   @RequestParam(name = "customer_mail")String mail,
                                   @RequestParam(name = "customer_phone")String phone,
                                   Model model) {

        model.addAttribute("customer_name",name);
        model.addAttribute("customer_mail",mail);
        model.addAttribute("customer_phone",phone);
        return  "customer_is_updated";
    }

    @GetMapping("/find_motorhome_by_id")
    public String findMotorhomeById () {
        return "find_motorhome_by_id";
    }

    @PostMapping("/direct_motorhome_by_id")
    public String directMotorhomeByiD (@RequestParam(name = "motorhome_ID")int id) { //anmode om input fra bruger/browser den gældende parameter (id)
        return "redirect:/motorhome/" + id;
    }

    @GetMapping("/motorhome/{id}")
    public String MotorhomeById (@PathVariable("id") int id, Model model) { //Pathvariable binder sig til den gældende input
        Motorhome motorhome = motorhomeRepository.readOneMotorhome(id);
        model.addAttribute("one_motorhome", motorhome);
        temporaryId = id;
        return "motorhome_by_id";
    }

    @GetMapping("/update_motorhome")
    public String updateMotorhome (Model model) {
        model.addAttribute("motorhome_id", temporaryId);
        return "update_motorhome";
    }

    @PostMapping("/direct_update_motorhome")
    public String directUpdateMotorhome (@RequestParam(name = "is_available")boolean is_available,
                                         @RequestParam(name = "price_per_day")int price_per_day,
                                         @RequestParam(name = "season")String season,
                                         @RequestParam(name = "size_category")String size_category,
                                         @RequestParam(name = "brand_name")String brand_name,
                                         @RequestParam(name = "model_name")String model_name,
                                        RedirectAttributes attributes) {

        attributes.addAttribute("is_available", is_available);
        attributes.addAttribute("price_per_day", price_per_day);
        attributes.addAttribute("season", season);
        attributes.addAttribute("size_category", size_category);
        attributes.addAttribute("brand_name", brand_name);
        attributes.addAttribute("model_name", model_name);
        motorhomeRepository.updateMotorhome(new Motorhome(is_available, price_per_day, season, size_category, brand_name, model_name ),
                temporaryId);
        return "redirect:/motorhome_updated/" + temporaryId;
    }

    @GetMapping("/motorhome_updated/{id}")
    public String updatedMotorhome (@PathVariable("id") int id,
                                    @RequestParam(name = "is_available")boolean is_available,
                                    @RequestParam(name = "price_per_day")int price_per_day,
                                    @RequestParam(name = "season")String season,
                                    @RequestParam(name = "size_category")String size_category,
                                    @RequestParam(name = "brand_name")String brand_name,
                                    @RequestParam(name = "model_name")String model_name,
                                   Model model) {

        model.addAttribute("is_available", is_available);
        model.addAttribute("price_per_day", price_per_day);
        model.addAttribute("season", season);
        model.addAttribute("size_category", size_category);
        model.addAttribute("brand_name", brand_name);
        model.addAttribute("model_name", model_name);
        return  "customer_is_updated";
    }

    @GetMapping("/find_employee_by_id")
    public String findEmployeeById () {
        return "find_employee_by_id";
    }

    @PostMapping("/direct_employee_by_id")
    public String directEmployeeByiD (@RequestParam(name = "employee_ID")int id) { //anmode om input fra bruger/browser den gældende parameter (id)
        return "redirect:/employee/" + id;
    }

    @GetMapping("/employee/{id}")
    public String EmployeeById (@PathVariable("id") int id, Model model) { //Pathvariable binder sig til den gældende input
        Employee employee = employeeRepository.readOneEmployee(id);
        model.addAttribute("one_employee", employee);
        temporaryId = id;
        return "employee_by_id";
    }

    @GetMapping("/update_employee")
    public String updateEmployee (Model model) {

        model.addAttribute("employee_id", temporaryId);
        return "update_employee";
    }

    @PostMapping("/direct_update_employee")
    public String directUpdateEmployee  (@RequestParam(name = "jobtitle")String jobtitle,
                                         @RequestParam(name = "employee_name")String employee_name,
                                         RedirectAttributes attributes) {

        attributes.addAttribute("jobtitle", jobtitle);
        attributes.addAttribute("employee_name", employee_name);
        employeeRepository.updateEmployee(new Employee(temporaryId, jobtitle, employee_name));
        return "redirect:/employee_updated/" + temporaryId;
    }

    @GetMapping("/employee_updated/{id}")
    public String updatedEmployee (@PathVariable("id") int id,
                                   @RequestParam(name = "jobtitle")String jobtitle,
                                   @RequestParam(name = "employee_name")String employee_name,
                                   Model model) {

        model.addAttribute("jobtitle",jobtitle);
        model.addAttribute("employee_name",employee_name);
        return  "employee_is_updated";
    }


}


