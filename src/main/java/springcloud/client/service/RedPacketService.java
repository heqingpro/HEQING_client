package springcloud.client.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.client.dao.RedPacketMapper;
import springcloud.client.dao.UserRedPacketMapper;
import springcloud.client.entity.RedPacket;
import springcloud.client.entity.UserRedPacket;
import springcloud.client.model.BaseDataModel.ResponseDataModel;
import springcloud.client.util.RedisUtil;

import java.math.BigDecimal;

/**
 * @program: HEQING_client
 * @description:
 * @author: hezy
 * @create: 2019-03-11 16:33
 **/
@Service
public class RedPacketService {

    @Autowired
    private RedPacketMapper redPacketMapper;

    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    @Autowired
    RedisUtil redisUtil;

    @Transactional(rollbackFor = Exception.class)
    public String addUserRedPacket(){
        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setUserId(1);
        userRedPacket.setRedPacketId(1);
        userRedPacketMapper.insert(userRedPacket);
        Gson gson = new Gson();
        return gson.toJson(userRedPacket);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseDataModel grepRedPacket(Integer userId,Integer id){
        RedPacket redPacket = redPacketMapper.selectByPrimaryKey(id);
        int stock = redPacket.getStock();
        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setRedPacketId(stock);
        userRedPacket.setAmount(new BigDecimal(redPacket.getUnitAmount()));
        userRedPacket.setUserId(userId);
        //红包个数减一
        if(stock>0) {
            redPacket.setStock(stock-1);
            redPacketMapper.updateByPrimaryKey(redPacket);
            userRedPacket.setRedPacket(id);
            userRedPacketMapper.insert(userRedPacket);
        }
        return new ResponseDataModel(true,"抢红包成功");
    }

    /**
     * 乐观锁抢红包
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDataModel grepRedPacketByLock(Integer userId, Integer id){
        RedPacket redPacket = redPacketMapper.selectByPrimaryKey(id);
        int stock = redPacket.getStock();
        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setRedPacketId(stock);
        userRedPacket.setAmount(new BigDecimal(redPacket.getUnitAmount()));
        userRedPacket.setUserId(userId);
        if(stock>0) {
            redPacket.setStock(stock-1);
            int num = redPacketMapper.updateByLock(redPacket);
            userRedPacket.setRedPacket(id);
            if(num>0){
                userRedPacketMapper.insert(userRedPacket);
            }
        }
        return  new ResponseDataModel(true,"抢红包成功");
    }

    /**
     * grep red packet by redis
     * @param userId
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDataModel grepByRedis(Integer userId,Integer id){
        redisUtil.set("redPacket","success add to redis");
        return new ResponseDataModel(true,"");
    }

}
