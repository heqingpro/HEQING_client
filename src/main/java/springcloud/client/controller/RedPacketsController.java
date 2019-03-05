package springcloud.client.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springcloud.client.dao.PersonResposity;
import springcloud.client.entity.Person;
import springcloud.client.service.RedPacketsService;

@RestController
@RequestMapping("/test")
public class RedPacketsController {
    @Autowired
    RedPacketsService redPacketsService;

    @Autowired
    PersonResposity resposity;

    @RequestMapping("/add")
    public String insert(){
        redPacketsService.inserService();
        return "成功";
    }
    @RequestMapping("/find")
    @ResponseBody
    public String queryRedPackets(){
        return redPacketsService.queryRedPackets();
    }

    @RequestMapping("/findbyJPA")
    @ResponseBody
    public String findByJPA(){
        Gson gson = new Gson();
        Person person = new Person();
        person.setName("hezhn");
        resposity.save(person);
        return "chengg";
    }
}
