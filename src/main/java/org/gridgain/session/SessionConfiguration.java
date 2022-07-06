package org.gridgain.session;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spring.sessions.EnableIgniteHttpSession;
import org.apache.ignite.spring.sessions.SpringSessionIgnite;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableIgniteHttpSession
public class SessionConfiguration {

    @Bean
    @SpringSessionIgnite
    public Ignite ignite() {
        IgniteConfiguration cfg = new IgniteConfiguration();

        cfg.setDiscoverySpi(new TcpDiscoverySpi().setLocalAddress("127.0.0.1").setLocalPortRange(10).setLocalPort(47500));

        Ignite ignite = Ignition.start(cfg);

        return ignite;
    }
}
