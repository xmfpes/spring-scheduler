package com.kyunam.springscheduler;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyunam.springscheduler.domain.Member;
import com.kyunam.springscheduler.domain.MemberRepository;
import com.kyunam.springscheduler.domain.MemberRole;


import groovy.util.logging.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class UserTests {
	private static final Logger logger = LoggerFactory.getLogger(UserTests.class);
	@Autowired
	private MemberRepository repo;
	@Test
	public void testInsert() {
		for(int i=0; i<=100; i++) {
			Member user = new Member();
			user.setUname("kyu" + i);
			user.setUemail("user" + i);
			user.setUid("user" + i);
			user.setUpw("pass" + i);
			MemberRole role = new MemberRole();
			if(i<=80) {
				role.setRoleName("BASIC");
			}else if(i<=90) {
				role.setRoleName("MANAGER");
			}else {
				role.setRoleName("ADMIN");
			}
			user.setRoles(Arrays.asList(role));
			logger.info("logger : " + Arrays.asList(role));
			repo.save(user);
		}
		
	}
	
}
