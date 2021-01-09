package com.gants.rgm.betaservice;

import com.gants.rgm.betaservice.enums.BlogPostType;
import com.gants.rgm.betaservice.models.BlogPost;
import com.gants.rgm.betaservice.models.Tuple;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
@SpringBootApplication
public class BetaServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BetaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<BlogPost> post = Arrays.asList(
			  new BlogPost("Nutz", "Richard Gay", BlogPostType.REVIEW , 25),
			  new BlogPost("Running All Out", "Billy Wanger", BlogPostType.REVIEW , 15),
				new BlogPost("How to Catch a Bird", "Simon Williams", BlogPostType.REVIEW , 15),
				new BlogPost("Media & Science", "Jane Chen", BlogPostType.GUIDE , 25),
				new BlogPost("Car Times", "Steven Nunn", BlogPostType.GUIDE , 35),
				new BlogPost("Running All Out", "Billy Wanger", BlogPostType.REVIEW , 115),
				new BlogPost("How to Catch a Fish", "Simon Williams", BlogPostType.REVIEW , 75),
				new BlogPost("Math & Science", "Jackie Peterson", BlogPostType.GUIDE , 26),
				new BlogPost("Global Markets", "Gloria Manning", BlogPostType.NEWS , 235),
				new BlogPost("Economic Chances", "Washington Aminston", BlogPostType.NEWS , 15),
				new BlogPost("Rods & Reels", "Lefty Stank", BlogPostType.REVIEW , 15),
				new BlogPost("Banks and Checks", "Susan Hendricks", BlogPostType.GUIDE , 265)
		);

		Map<BlogPostType,List<BlogPost>> postTypeListMap = post.stream().collect(groupingBy(BlogPost::getType));
		log.info(String.valueOf(postTypeListMap));

		Map<Tuple, List<BlogPost>> blogPostTypeListMap = post.stream().
				collect(groupingBy(p -> new Tuple(p.getType(), p.getAuthor())));
		log.info(String.valueOf(blogPostTypeListMap));

	}
}
