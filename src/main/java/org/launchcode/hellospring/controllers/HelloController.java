package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    /*@GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello,Spring!";
    }
    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String coder) {
        return "Hello, " + coder + "!";
    }*/

    @GetMapping
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select  name ='language' >" +
                        "<option value ='english'>English</option>" +
                        "<option value ='german'>German</option>" +
                        "<option value ='spanish'>Spanish</option>" +
                        "<option value ='italian'>Italian</option>" +
                        "<option value ='french'>French</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return "<html>" +
                "<head>" +
                "<h1>" +
                createMessage(name, language)+
                "</h1>" +
                "</head>" +
                "</html>";

    }

    public static String createMessage(String name, String lang) {
        String greeting = "";

        if (lang.equals("english")) {
            greeting = "Hello";
        }
        else if (lang.equals("french")) {
            greeting = "Bonjour";
        }
        else if (lang.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (lang.equals("spanish")) {
            greeting = "Hola";
        }
        else if (lang.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + name;
    }

}
