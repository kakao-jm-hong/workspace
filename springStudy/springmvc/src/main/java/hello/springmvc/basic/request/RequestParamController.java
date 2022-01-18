package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-parma-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-parma-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-parma-v3")
    public String requestParmaV3(@RequestParam String username, @RequestParam int age) {
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-parma-v4")
    public String requestParmaV4(String username, int age) {
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-parma-required")
    public String requestParmaRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-parma-default")
    public String requestParmaDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) {
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-parma-map")
    public String requestParmaMap(@RequestParam Map<String, Object> paramMap) {
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setAge(age);
        helloData.setUsername(username);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(@ModelAttribute HelloData helloData) {
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v3")
    public String modelAttributeV3(HelloData helloData) {
        return "ok";
    }

}
