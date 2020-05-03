/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hexu.ebank.springintegration.applications.cafeAnnotation;

import com.hexu.ebank.springintegration.applications.cafeAnnotation.entity.DrinkType;
import com.hexu.ebank.springintegration.applications.cafeAnnotation.entity.Order;
import com.hexu.ebank.springintegration.applications.cafeAnnotation.service.Cafe;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Provides the 'main' method for running the Cafe Demo application. When an
 * order is placed, the Cafe will send that order to the "orders" channel.
 * The channels are defined within the configuration file ("cafeDemo.xml"),
 * and the relevant components are configured with annotations (such as the
 * OrderSplitter, DrinkRouter, and Barista classes).
 *
 * @author Mark Fisher
 * @author Marius Bogoevici
 */
public class CafeAnnotationDemoApp {

	public static void main(String[] args) {
		AbstractApplicationContext context =
			new ClassPathXmlApplicationContext("/META-INF/spring/integration/cafeAnnotation/spring-integration-cafeAnnotationDemo-context.xml", CafeAnnotationDemoApp.class);


		Cafe cafe = (Cafe) context.getBean("cafe");
		for (int i = 1; i <= 100; i++) {
			Order order = new Order(i);
			order.addItem(DrinkType.LATTE, 2, false);
			order.addItem(DrinkType.MOCHA, 3, true);
			cafe.placeOrder(order);
		}
		context.close();
	}
}
