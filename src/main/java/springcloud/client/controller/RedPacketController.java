package springcloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springcloud.client.service.RedPacketService;

@RestController
@RequestMapping("/redPacket")
public class RedPacketController {

    @Autowired
    RedPacketService redPacketService;

    @RequestMapping("/add")
    @ResponseBody
    public String addUserRedPacket(){
        return redPacketService.addUserRedPacket();
    }
}
