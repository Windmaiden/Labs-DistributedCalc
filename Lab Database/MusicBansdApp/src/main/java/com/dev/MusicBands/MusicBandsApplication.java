package com.dev.MusicBands;

import com.dev.MusicBands.service.AdminService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import javax.swing.JFrame;
import java.awt.EventQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
@Import(value=AdminFrame.class)
public class MusicBandsApplication extends JFrame {

    @Autowired AdminService adminService;
    
    public MusicBandsApplication() {
       // initUI();
    }
    

    PlayFrame main;
    public static void main(String[] args) {
        
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MusicBandsApplication.class)
                .headless(false).run(args);
                EventQueue.invokeLater(() -> {
            JFrame ex = ctx.getBean(PlayFrame.class);
            ex.setVisible(true);
        });
    }


}
