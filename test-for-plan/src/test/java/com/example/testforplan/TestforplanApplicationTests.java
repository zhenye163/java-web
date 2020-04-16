package com.example.testforplan;

import com.netopstec.plan.PlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TestforplanApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PlanService planService;


	@Test
	public void testForPlan() {
		String plan = planService.formatPlanList();
		System.out.println(plan);
		Date now = new Date();
		System.out.println("现在是：" + now);
		String doing = planService.doing(now);
		System.out.println(doing);
		String nextTodo = planService.nextTodo(now);
		System.out.println(nextTodo);
	}
}
