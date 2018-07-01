package org.steadytown.web

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class)
@SpringBootTest
class WebApplicationTests(@Autowired val client: MemberService) {

	@Test
	fun contextLoads() {
		val p = client.find("John").iterator().next();
		assertEquals("John", p.firstName);
	}

}
