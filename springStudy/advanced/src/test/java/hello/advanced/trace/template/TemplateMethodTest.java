package hello.advanced.trace.template;

import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직1 실행");
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직2 실행");
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 템플릿 메서스 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplateT template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplateT template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplateT template1 = new AbstractTemplateT() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
    }

    // my test

    @Test
    void myTemplateMethodPattern() {
        proccess1();
        proccess2();
    }

    private void proccess1() {
        // 고정로직 //
        long start = System.currentTimeMillis();

        // 비지니스 로직 //
        System.out.println("TemplateMethodTest.proccess1");

        // 고정로직 //
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("result = " + result);
    }

    private void proccess2() {
        // 고정로직 //
        long start = System.currentTimeMillis();

        // 비지니스 로직 //
        System.out.println("TemplateMethodTest.proccess2");

        // 고정로직 //
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("result = " + result);
    }
}
