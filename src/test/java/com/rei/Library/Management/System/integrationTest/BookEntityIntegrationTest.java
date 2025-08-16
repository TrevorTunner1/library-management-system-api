package com.rei.Library.Management.System.integrationTest;

import com.rei.Library.Management.System.TestDataUtil;
import com.rei.Library.Management.System.entity.BookEntity;
import com.rei.Library.Management.System.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityIntegrationTest {

    @Autowired
    private BooksRepository underTest;

    @Test
    public void testThatBooksCanBeSavedAndReturnRecalled(){
        BookEntity savedBook = TestDataUtil.createBookA();
        underTest.save(savedBook);
        Optional<BookEntity> result = underTest.findById(savedBook.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);
    }


}
