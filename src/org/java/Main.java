/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author f1cmpica-1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        circleDAOimpl c = (circleDAOimpl) context.getBean("circleDAO");

        Circle cir = context.getBean("cir", Circle.class);

        while (true) {
            try {
                System.out.println("------------- Menu --------------");
                System.out.println("---------------------------------");
                System.out.println("1.) CREATE circle TABLE.....");
                System.out.println("2.) INSERT record.....");
                System.out.println("3.) DISPLAY for ID.....");
                System.out.println("4.) DISPLAY ALL.....");
                System.out.println("5.) EXIT.....");
                System.out.println("---------------------------------");
                System.out.print("Enter your Choice .:");
                int ch = Integer.parseInt(br.readLine());
                switch (ch) {
                    case 1:
                        c.createCircle();
                        break;
                    case 2:
                        System.out.print("Enter Circle ID :");
                        int id = Integer.parseInt(br.readLine());

                        System.out.print("Enter Circle NAME :");
                        String nm = br.readLine();

                        cir.setC_id(id);
                        cir.setC_name(nm);

                        c.insertCircle();
                        break;
                    case 3:
                        System.out.print("Enter Circle ID :");
                        int id1 = Integer.parseInt(br.readLine());

                        c.getCircleForID(id1);
                        break;
                    case 4:
                        c.getCircle();
                        break;
                    case 5:
                        exit(0);
                    default:
                        System.out.println("Invalid Choice......");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
