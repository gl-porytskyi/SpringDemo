package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        annotationConfigApplicationContext.registerShutdownHook();

        InfoService infoService = annotationConfigApplicationContext.getBean(InfoService.class);
        System.out.println("=======================================");
        System.out.println(infoService.getInfo());
        System.out.println("=======================================");
        System.out.println(infoService.getInfo());
        System.out.println("=======================================");
    }
}
