/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.trade.store.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.test.cib.trade.store","com.test.cib.commons"})
@EntityScan(basePackages = {"com.test.cib.trade.store.data.entity"} )
@EnableJpaRepositories(basePackages = {"com.test.cib.trade.store.repository"})
public class TradeStoreApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(TradeStoreApplication.class, args);

	}
}