package com.example.eurosupply.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class MonitoringController {
  private final Counter testRequests;

  public MonitoringController(MeterRegistry registry) {
    this.testRequests = Counter.builder("demo_test_requests_total")
        .description("Nombre d'appels à l'endpoint de test")
        .register(registry);
  }

  @GetMapping("/test-monitoring")
  public String testMonitoring() {
    testRequests.increment();
    return "Monitoring OK";
  }
}