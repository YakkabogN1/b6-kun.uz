package uz.antisocial.kun.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.antisocial.kun.uz.dto.MessageDTO;
import uz.antisocial.kun.uz.service.EmailSendingService;

@RestController
@RequestMapping("/mail-send")
public class EmailController {

    @Autowired
    private EmailSendingService emailSendingService;

    @PostMapping("/simple")
    public String sendEmail(@RequestBody MessageDTO dto) {
        return emailSendingService.sendSimpleMessage(dto);
    }
}