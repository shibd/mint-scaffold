package ${package}.service;

import ${package}.${classPrefix}ApplicationTests;
import ${package}.service.kafka.XXXReceiver;
import ${package}.service.kafka.XXXSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

/**
 * @Author: baozi
 * @Date: 2019/7/9 17:24
 * @Description:
 */
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = "${xxx.topic}")
@TestPropertySource(properties = {"kafka.enable=true"})
public class XXXKafkaTest extends ${classPrefix}ApplicationTests {

    @Autowired
    private XXXReceiver receiver;

    @Autowired
    private XXXSender sender;

    @Test
    public void testReceive() throws Exception {
        sender.send("Hello Spring Kafka!");

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(receiver.getLatch().getCount(), 0);
    }


    /**
     * 建议这种测试
     *
     * @throws Exception
     */
    @Test
    public void mockTestReceive() throws Exception {
        receiver.receive("Hello Mock Test");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(receiver.getLatch().getCount(), 0);
    }
}
