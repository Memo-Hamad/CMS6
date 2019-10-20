package main.jpa.service;


import io.helidon.config.Config;
import io.helidon.microprofile.config.MpConfig;
import io.helidon.microprofile.server.Server;
import org.jboss.weld.util.cache.ComputingCache;
import org.jboss.weld.util.cache.ComputingCacheBuilder;
import org.jboss.weld.util.collections.ImmutableSet;
import org.jboss.weld.util.reflection.Reflections;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
//import org.jboss.weld.environment.se.StartMain;

//import javax.enterprise.inject.se.SeContainer;

public class Main {
    private Main() {

    }


    public static void main(String[] args) {
        // Used for dependency injection

        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();

        Server server = Server.builder()
                .addApplication(JpaDemoApp.class)
                .cdiContainer( cdiContainer)

                // using a customized helidon config instance (in this case the default...)
                .config(MpConfig.builder().config(Config.create()).build())
                .host("localhost")
                // use 0 for a random free port
                .port(9090)
                .build();

        server.start();

        String endpoint = "http://" + server.host() + ":" + server.port();
      //  System.out.println("Hello     " + endpoint + "/hello");
        System.out.println("API       " + endpoint + "/api/Payment");
        //System.out.println("Metrics   " + endpoint + "/metrics");
        //System.out.println("Heatlh    " + endpoint + "/health");

     /*   Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();

        Server server = Server.builder()
                .addApplication(JpaDemoApp.class)
                .cdiContainer(cdiContainer)
                .config(MpConfig.builder().config(Config.create()).build())
        .host("localhost")
       .port(9090)

                .build();

        server.start();

        String endpoint = "http://" + server.host() + ":" + server.port();
       System.out.println("API" + endpoint + "/api/Payment/");
*/
    }




}

