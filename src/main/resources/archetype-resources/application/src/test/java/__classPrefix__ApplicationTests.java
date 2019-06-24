package ${package};

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@Rollback(false) // 默认会将测试过程中产生的数据提交到DB
public class ${classPrefix}ApplicationTests extends AbstractTransactionalTestNGSpringContextTests {

    @Test
    public void testLoad() throws Exception {
        System.out.println("Load done!");
    }

}