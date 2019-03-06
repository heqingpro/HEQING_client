package springcloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springcloud.client.model.BaseDataModel.ResponseDataModel;
import springcloud.client.service.RedPacketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/grep")
    @ResponseBody
    public ResponseDataModel grepRedPacket(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer userid){
        return redPacketService.grepRedPacket(userid);
    }
}
