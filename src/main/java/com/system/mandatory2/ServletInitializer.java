package com.system.mandatory2;

        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by gerli on 01/12/2017.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Mandatory2Application.class);
    }

}

