package com.gants.rgm.alphaservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Slf4j
@SpringBootApplication
public class AlphaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaServiceApplication.class, args);
	}

	@Component
	class DemoUserSrvc implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			log.info("Start " + this.getClass().getCanonicalName() );

			Runnable r = () -> {
				String name = Thread.currentThread().getName();
				while (!Thread.interrupted()) {
					System.out.println(name + " working " + ID.getId());
				}
			};

			Thread th1 = new Thread(r, "TH1");
			Thread th2 = new Thread(r, "TH2");
			th1.start();
			th2.start();

			Thread.sleep(5000);

			log.info("INTERRUPT");
			th1.interrupt();
			th2.interrupt();
		}
	}
}//end Application
