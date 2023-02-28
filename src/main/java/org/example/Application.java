package org.example;

import io.quarkus.runtime.Startup;
import org.example.dao.FooDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Startup
@Singleton
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @Inject
    FooDao fooDao;

    @PostConstruct
    public void init() {
        LOG.info("START");
        fooDao.getAll().forEach(foo -> {
            LOG.info("Foo: {}", foo);
        });
        LOG.info("STOP");
    }

}
