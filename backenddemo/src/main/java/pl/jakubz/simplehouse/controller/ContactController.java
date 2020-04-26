package pl.jakubz.simplehouse.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakubz.simplehouse.entity.Message;
import pl.jakubz.simplehouse.service.MessageService;

@Controller
public class ContactController {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    MessageService messageService;

    public ContactController() {
    }

    @GetMapping({"/contact"})
    public String showContact(Model model) {
        Message message = new Message();
        model.addAttribute("messageToDb", message);
        return "contact";
    }

    @PostMapping({"/sendMessage"})
    public String saveMessage(@Valid @ModelAttribute("messageToDb") Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        } else {
            message.setRead(false);
            this.logger.info(message.toString());
            this.messageService.saveMessage(message);
            return "redirect:/contact?sent=1";
        }
    }

    @GetMapping({"/seeMessages"})
    public String showMessages(Model model, @RequestParam(required = false,name = "read") Integer read) {
        List messages;
        if (read != null) {
            boolean booleanRead = read == 1;
            messages = this.messageService.findByRead(booleanRead);
        } else {
            messages = this.messageService.findAll();
        }

        model.addAttribute("messages", messages);
        return "comments-list";
    }

    @GetMapping({"/deleteMessage"})
    public String deleteMessage(@RequestParam("id") int id) {
        this.messageService.deleteMessage(id);
        return "redirect:/seeMessages";
    }

    @GetMapping({"/markAsRead"})
    public String markMessageAsRead(@RequestParam("id") int id) {
        Message message = this.messageService.getMessage(id);
        message.setRead(true);
        this.messageService.saveMessage(message);
        return "redirect:/seeMessages";
    }
}
