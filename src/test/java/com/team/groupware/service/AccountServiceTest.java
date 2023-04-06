package com.team.groupware.service;

import com.team.groupware.dto.CreateEmployDTO;
import com.team.groupware.entity.Employ;
import com.team.groupware.repository.DepartmentRepository;
import com.team.groupware.repository.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class AccountServiceTest {

  @Autowired
  AccountService accountService;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  DepartmentRepository departmentRepository;
  @Autowired
  JobRepository jobRepository;
  @Autowired
  private MockMvc mockMvc;

  public Employ createEmploy() {
    CreateEmployDTO createEmployDTO = new CreateEmployDTO();
    createEmployDTO.setEmpId("1123232");
    createEmployDTO.setPassword("1234");
    createEmployDTO.setName("민재홍");
    createEmployDTO.setEmail("jaehong@groupware.com");
    createEmployDTO.setPhone("01089293589");
    createEmployDTO.setPostcode("18410");
    createEmployDTO.setAddress("경기도 화성시 병점2로 35");
    createEmployDTO.setDetailAddress("112동 502호");
    createEmployDTO.setDeptNo(30);
    createEmployDTO.setJobNo(4);
    return Employ.createEmploy(createEmployDTO, passwordEncoder);
  }

  @Test
  @DisplayName("회원가입 테스트")
  public void saveEmployTest() {
    Employ employ = createEmploy();
    Employ savedEmploy = accountService.saveEmploy(employ);

    // Employ테이블에 데이터를 비교해서 회원가입이 정상적으로 되는지 확인
    assertEquals(employ.getEmpId(), savedEmploy.getEmpId());
    assertEquals(employ.getPassword(), savedEmploy.getPassword());
    assertEquals(employ.getName(), savedEmploy.getName());
    assertEquals(employ.getEmail(), savedEmploy.getEmail());
    assertEquals(employ.getPhone(), savedEmploy.getPhone());
    assertEquals(employ.getPostcode(), savedEmploy.getPostcode());
    assertEquals(employ.getAddress(), savedEmploy.getAddress());
    assertEquals(employ.getDetailAddress(), savedEmploy.getDetailAddress());
    assertEquals(departmentRepository.findByDeptNo(30), savedEmploy.getDeptNo());
    assertEquals(jobRepository.findByJobNo(4), savedEmploy.getJobNo());
  }

  public Employ createEmploy(String empId, String password) {
    CreateEmployDTO createEmployDTO = new CreateEmployDTO();
    createEmployDTO.setEmpId(empId);
    createEmployDTO.setPassword(password);
    createEmployDTO.setName("민재홍");
    createEmployDTO.setEmail("jaehong@groupware.com");
    createEmployDTO.setPhone("01089293589");
    createEmployDTO.setPostcode("18410");
    createEmployDTO.setAddress("경기도 화성시 병점2로 35");
    createEmployDTO.setDetailAddress("112동 502호");
    createEmployDTO.setDeptNo(30);
    createEmployDTO.setJobNo(4);
    return Employ.createEmploy(createEmployDTO, passwordEncoder);
  }

  @Test
  @DisplayName("로그인 테스트")
  public void loginTest() throws Exception{
    String empId = "112233";
    String password = "1234";
    this.createEmploy(empId, password);
    mockMvc.perform(formLogin().userParameter("empId")
            .loginProcessingUrl("/account/login")
            .user(empId).password(password))
            .andExpect(SecurityMockMvcResultMatchers.authenticated());
  }

}