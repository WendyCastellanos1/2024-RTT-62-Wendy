package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Product;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public ModelAndView index(){
        // this function is for the home page of the website which is express as just a plain slash "/"
       ModelAndView response = new ModelAndView("index");

        // by default the logging level is set to info so the debug message will not be printed in the terminal
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");
        // now, prohibited, forbidden    System.out.println("This is forbidden at all times)

       response.addObject("message", "We sell model cars, boats, and other items.");
       return response;
    }

    @GetMapping("/about")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        ModelAndView response = new ModelAndView("about");
        return response;
    }

    @GetMapping("/homework")
    public ModelAndView homework(@RequestParam(required=false) String topic) {  // required=false allows object to be null, still render web page without error, just w/o data

        ModelAndView response = new ModelAndView("homework");
        response.addObject("message",  topic);
        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer employeeId) {
        // this page is for another page of the website which is expessed as "/page-url"
        ModelAndView response = new ModelAndView("file-upload");
        response.addObject("employeeIdKey", employeeId);

        return response;
    }

    @PostMapping("/file-upload")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer employeeId) {        // ????????????????
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView modelAndView = new ModelAndView("redirect:/employee/" + employeeId);
        // file-upload?=employeeI

        log.debug("The file name is: " + file.getOriginalFilename());
        log.debug("The file size is: " + file.getSize());
        log.debug("The file content type is: " + file.getContentType());

        // Homework
        // use the original file name and get  a substring of the last index of .  to the end of the string
        // then restrict based on "jpg" or "png"
        // use the model to put an error message on the server

        
        String saveFilename = "./src/main/webapp/pub/images/" + file.getOriginalFilename();
        
        // this Files.copy is a utility that will read the stream one chunk at a time and write it to a file.
        // first argument is the input stream to read from the uploaded file
        // 1st arg: input stream to read from the uploaded file
        // 2nd arg: the filename where we want to write the file
        // 3rd arg says to overwrite if existing
        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e){
            log.error ("unable to finish reading file", e);
        }

        //we can load the record from the database based on the incoming employee ID
        Employee employee = employeeDAO.findById(employeeId);

        // this is the URL to get the image
        String url = "/pub/images/" + file.getOriginalFilename();
        employee.setProfileImageUrl(url);

        employeeDAO.save(employee);

        return modelAndView;
    }

}
