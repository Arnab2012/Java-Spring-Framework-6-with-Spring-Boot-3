package com.arnab.Spring6_SpringBootWeb;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//    usage of ModelAttribute
    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }
    @RequestMapping("/")
    public String home(){
        return "index";
    }

//    Using HttpServletRequest and HttpSession

//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session){
//        int num1=Integer.parseInt(req.getParameter("number1"));
//        int num2=Integer.parseInt(req.getParameter("number2"));
//
//        int result=num1+num2;
//        session.setAttribute("result",result);
//        System.out.println(result);
//        return "result.jsp";
//    }

//    Using ModelAndView

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("number1") int number1,@RequestParam("number2") int number2, ModelAndView mv){
        int result=number1+number2;
//        session.setAttribute("result",result);

//        model.addAttribute("result",result);
        mv.addObject("result",result);
        mv.setViewName("result");
        return mv;
    }

// For a Particular class

//    @RequestMapping("addStudent")
    public ModelAndView addStudent(@RequestParam("sid") int sid,@RequestParam("sname") String sname,ModelAndView mv){
        Student st=new Student();
        st.setSid(sid);
        st.setSname(sname);

        mv.addObject("st",st);
        mv.setViewName("result");
        return mv;
    }

//    Using Model Attribute

    @RequestMapping("addStudent")
    public String addStudent(@ModelAttribute Student student){
        return "result";
    }
}
