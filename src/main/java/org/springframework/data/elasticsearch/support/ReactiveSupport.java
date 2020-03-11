/*
 * Copyright 2020 the original author or authors.
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
package org.springframework.data.elasticsearch.support;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.data.repository.util.ClassUtils;

/**
 * @author Peter-Josef Meisch
 * @since 4.0
 */
public final class ReactiveSupport {
	private ReactiveSupport() {}

	/**
	 * @return true if project reactor is on the classpath
	 */
	public static boolean isReactorAvailable() {
		AtomicBoolean available = new AtomicBoolean(false);
		ClassUtils.ifPresent("reactor.core.publisher.Flux", null, aClass -> {
			available.set(true);
		});
		return available.get();
	}
}