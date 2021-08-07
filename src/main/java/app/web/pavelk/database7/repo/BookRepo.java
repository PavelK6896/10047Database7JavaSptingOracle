package app.web.pavelk.database7.repo;


import app.web.pavelk.database7.schema.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<Book> findAll(Pageable pageable);

}
