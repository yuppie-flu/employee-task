package com.takeaway.employee;

import com.google.common.collect.ImmutableSet;
import com.takeaway.employee.web.dto.EmployeeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeRestIntegrationTest {
    private static final String API_PREFIX = "/api/v1";

    private static final String EMAIL = "test@gmail.com";
    private static final String FIRST_NAME = "Name";
    private static final String LAST_NAME = "Surname";
    private static final LocalDate BIRTHDAY = LocalDate.of(1995, 2, 28);
    private static final Set<String> HOBBIES = ImmutableSet.of("swimming", "music", "tv");

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void createAndReadTest() {
        // setup
        EmployeeDto dto = new EmployeeDto(null, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, HOBBIES);
        EmployeeDto createRespDto = restTemplate.postForObject(API_PREFIX + "/employee", dto, EmployeeDto.class);

        // when
        EmployeeDto readResponse = restTemplate.getForObject(API_PREFIX + "/employee/" + createRespDto.getId(), EmployeeDto.class);

        // then
        assertThat(readResponse.getId()).isEqualTo(createRespDto.getId());
        assertThat(readResponse.getEmail()).isEqualTo(EMAIL);
        assertThat(readResponse.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(readResponse.getLastName()).isEqualTo(LAST_NAME);
        assertThat(readResponse.getBirthday()).isEqualTo(BIRTHDAY);
        assertThat(readResponse.getHobbies()).isEqualTo(HOBBIES);
    }
}
