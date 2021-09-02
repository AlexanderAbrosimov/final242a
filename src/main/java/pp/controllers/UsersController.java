package pp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pp.model.User;
import pp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String getInfoOnlyForAdmin(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @GetMapping("/user")
    public String getInfoForUser() {
        return "user";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.show(id));
//        return "show";
//    }

//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new";
//    }

//    @PostMapping()
//    public String create(@ModelAttribute("user") @Valid User user,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "new";
//        }
//
//        userService.save(user);
//        return "redirect:/admin";
//    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.show(id));
//        return "edit";
//    }

//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, BindingResult bindingResult,
//                         @PathVariable("id") int id) {
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        }

//        userService.update(id, user);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.delete(id);
//        return "redirect:/admin";
//    }

}


