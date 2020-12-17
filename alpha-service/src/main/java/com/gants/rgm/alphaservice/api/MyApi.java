package com.gants.rgm.alphaservice.api;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyApi {
  public int f(int x) {
    try {
      log.info("Function f(x) is doing some work");
      Thread.sleep((long)(Math.random() * 10000));
      log.info("Function f(x) is done with work");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return (int) (10);
  }

  public int g(int x) {
    try {
      log.info("Function g(x) is doing some work");
      Thread.sleep((long)(Math.random() * 10000));
      log.info("Function g(x) is done with work");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return (int) (5);
  }

  public int[] bubbleSort(int arr[]) {
    int n =  arr.length;
    int temp = 0;
    for (int i = 0; i < n; i++) {
      for(int j = 1; j < (n - i); j++) {
        if(arr[j - 1] > arr[j]) {
            temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
        }
      }
    }

    return arr;
  }

}
