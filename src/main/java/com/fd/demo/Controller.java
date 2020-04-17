package com.fd.demo;

import com.fd.demo.config.JmsConfig;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zxq
 * @date ：Created in 2020/4/16 14:49
 */
@RestController
public class Controller {

    @Autowired
    private Producer producer;

    private List<String> mesList;

    /**
     * 初始化消息
     */
    public Controller() {
        mesList = new ArrayList<>();
        mesList.add("小火龍");
        mesList.add("皮卡丘");
        mesList.add("卡比兽");
        mesList.add("快龙");
        mesList.add("美纳斯");
    }

    @GetMapping("/text/rocketmq")
    public Object callback() throws Exception {
        int i = 0;
        for (String s : mesList) {
            //创建生产信息
            Message message = new Message(JmsConfig.TOPIC, "test_tag", (i++ + "poke:" + s).getBytes());
            //发送
            SendResult sendResult = producer.getProducer().send(message);
            System.out.printf("输出生产者信息=%s \n", sendResult);
        }
        return "成功";
    }
}
