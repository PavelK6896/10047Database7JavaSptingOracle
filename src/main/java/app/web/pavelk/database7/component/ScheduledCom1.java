package app.web.pavelk.database7.component;

import app.web.pavelk.database7.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class ScheduledCom1 {

    private final BookRepo bookRepo;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedDelay = 1000)
    public void scheduledCom1() {
        simpMessagingTemplate.convertAndSend("/topic/messages",
                bookRepo.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id")))
                        .getContent().toString());
    }

}
