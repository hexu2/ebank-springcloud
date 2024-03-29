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

package com.hexu.ebank.springintegration.applications.cafeAnnotation.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import com.hexu.ebank.springintegration.applications.cafeAnnotation.entity.*;

import java.util.List;

/**
 * @author Mark Fisher
 */
@MessageEndpoint
public class OrderSplitter {

	@Splitter(inputChannel="orders", outputChannel="drinks")
	public List<OrderItem> split(Order order) {
		return order.getItems();
	}

}
