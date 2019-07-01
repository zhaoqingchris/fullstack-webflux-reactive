package com.pccw.reactiveweb.controller;

import com.pccw.reactiveweb.domain.Port;
import com.pccw.reactiveweb.repository.PortMongoBlockingRepository;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {

    private static final Logger log = LoggerFactory.getLogger(PortController.class);

    private static final int DELAY_PER_ITEM_MS = 100;

    private PortMongoBlockingRepository portMongoBlockingRepository;

    public PortController(final PortMongoBlockingRepository portMongoBlockingRepository) {
        this.portMongoBlockingRepository = portMongoBlockingRepository;
    }

    @GetMapping("/ports")
    public Iterable<Port> getAllPorts() throws Exception {
        log.info("Blocking Call, current Thread {} at {}", Thread.currentThread().getName(), LocalDateTime.now());
        Thread.sleep(DELAY_PER_ITEM_MS * portMongoBlockingRepository.count());
        return portMongoBlockingRepository.findAll();
    }
}
