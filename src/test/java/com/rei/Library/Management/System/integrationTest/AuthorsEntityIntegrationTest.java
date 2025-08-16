package com.rei.Library.Management.System.integrationTest;

import com.rei.Library.Management.System.TestDataUtil;
import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
@ActiveProfiles
public class AuthorsEntityIntegrationTest {

    @Autowired
    private AuthorRepository underTest;


    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        AuthorEntity authorA = TestDataUtil.createAuthorA();
        underTest.save(authorA);
        Optional<AuthorEntity> result = underTest.findById(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }



}

