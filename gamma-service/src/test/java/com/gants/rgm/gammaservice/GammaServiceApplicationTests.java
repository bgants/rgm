package com.gants.rgm.gammaservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GammaServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private Sender sender;

	@Autowired
	private Receiver receiver;

	@Test
	public void testReceive() throws Exception {
		sender.send("Hello Spring JMS ActiveMQ!");

		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}
}
