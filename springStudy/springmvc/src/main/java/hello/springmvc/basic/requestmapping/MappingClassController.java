package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MappingClassController {

    @PostMapping("/api/test")
    public Map<String, Object> test(@RequestBody Map<String, Object> body) {
        body.put("code", 200);
        System.out.println(body.toString());
        return body;
    }

    @GetMapping("/mapping/users")
    public String user() {
        return "get users";
    }

    @PostMapping("/mapping/users")
    public String addUser() {
        return "Post user";
    }

    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }

    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }

    @DeleteMapping("/mapping/users/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }
}
