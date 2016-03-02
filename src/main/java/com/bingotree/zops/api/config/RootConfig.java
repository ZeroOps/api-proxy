package com.bingotree.zops.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.bingotree.zops.api.ops"})
public class RootConfig {
}