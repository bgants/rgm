package com.gants.rgm.betaservice.models;

import com.gants.rgm.betaservice.enums.BlogPostType;

public class Tuple {
  BlogPostType type;
  String author;

  public Tuple(BlogPostType type, String author) {
    this.type = type;
    this.author = author;
  }
}
