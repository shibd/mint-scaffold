package ${package}.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: baozi
 * @Date: 2019/7/9 17:01
 * @Description:
 */
@Slf4j
@Component
@ConditionalOnProperty(value = "kafka.enable", havingValue = "true")
public class XXXReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(groupId = "${xxx.group}", topics = "${xxx.topic}")
    public void receive(String payload) {
        log.info("received payload='{}'", payload);
        latch.countDown();
    }
}
