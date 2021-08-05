package app.web.pavelk.database7.component;

import app.web.pavelk.database7.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class ScheduledCom1 {

    private final BookRepo bookRepo;

    @Scheduled(fixedDelay = 1000)
    public void scheduledCom1() {
        System.out.println(bookRepo.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"))).getContent());
    }

}
