package br.com.lucro.manager.util;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class CdiContext {

    public static final CdiContext INSTANCE = new CdiContext();

    private final Weld weld;
    private final WeldContainer container;

    private CdiContext() {
        this.weld = new Weld();
        this.container = weld.initialize();
        /*
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                shutdown();
            }
        });
        */
    }

    public <T> T getBean(Class<T> type) {
        return container.instance().select(type).get();
    }
    
    public void shutdown(){    	
    	weld.shutdown();
    }
}