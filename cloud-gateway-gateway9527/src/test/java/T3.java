import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class T3 {
    @Test
    public void testTime(){
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime);
//        2021-03-10T23:41:18.037+08:00[Asia/Shanghai]
    }
}
