package springcloud.client.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.client.dao.RedPacketsDao;
import springcloud.client.entity.RedPackets;

import java.util.HashMap;

@Service
public class RedPacketsService {
    @Autowired
    private RedPacketsDao redPacketsDao;

    @Transactional
    public void inserService(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "ces");
        map.put("count", 20000);
        redPacketsDao.insertRedPackets(map);
    }

    @Transactional
    public String queryRedPackets(){
        RedPackets redPackets =redPacketsDao.findAll("1");
        Gson gson =new Gson();
        return gson.toJson(redPackets);
    }
}
