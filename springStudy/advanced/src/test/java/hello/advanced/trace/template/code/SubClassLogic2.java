package hello.advanced.trace.template.code;

import hello.advanced.trace.template.AbstractTemplateT;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplateT {
    @Override
    protected void call() {
      log.info("비즈니스 로직2 실행");
    }
}