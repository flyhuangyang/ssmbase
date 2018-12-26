package com.ssm;

import com.ssm.domain.ColorEnum;
import sun.security.util.Length;

import javax.persistence.criteria.From;
import java.util.*;

public class test {

    public static void main(String[] args) {
        ColorEnum colorEnum = ColorEnum.K;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.toString());

      switch (colorEnum){
          case K:
              System.out.println("xss");
              break;
          case Y:
              System.out.println("dd");
              break;
      }

    }

}
