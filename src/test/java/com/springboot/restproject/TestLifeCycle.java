package com.springboot.restproject;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("## BeforeAll Annotation Call ##");
        System.out.println();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("## AfterAll Annotation Call ##");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("## BeforeEach Annotation Call ##" );
        System.out.println();
    }

    @AfterEach
    void afterEach(){
        System.out.println("## AFterEach Annotation Call ##");
        System.out.println();
    }

    @Test
    void test1(){
        System.out.println("## test1 start ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2(){
        System.out.printf("## test2 start ##");
        System.out.println();
    }

    @Test
    @Disabled
    void test3(){
        System.out.printf("## test3 start ##");
        System.out.println();
    }
}
