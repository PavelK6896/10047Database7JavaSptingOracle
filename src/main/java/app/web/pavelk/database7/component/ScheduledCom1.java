package app.web.pavelk.database7.component;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledCom1 {

    @Scheduled(fixedDelay = 1000)
    public void scheduledCom1() {
        System.out.println("scheduledCom1");
    }

}
