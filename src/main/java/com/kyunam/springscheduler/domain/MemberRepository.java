package com.kyunam.springscheduler.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends CrudRepository<Member, Long> {
	public Member findOneByUid(@Param("uid") String uid);
}
