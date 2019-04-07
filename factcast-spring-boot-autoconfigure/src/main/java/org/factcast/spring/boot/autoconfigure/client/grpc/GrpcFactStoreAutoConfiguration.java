/*
 * Copyright © 2018 Mercateo AG (http://www.mercateo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.factcast.spring.boot.autoconfigure.client.grpc;

import org.factcast.client.grpc.GrpcFactStore;
import org.factcast.core.store.FactStore;
import org.factcast.spring.boot.autoconfigure.store.inmem.InMemFactStoreAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.devh.boot.grpc.client.channelfactory.GrpcChannelFactory;

/**
 * Provides a GrpcFactStore as a FactStore implementation.
 *
 * @author uwe.schaefer@mercateo.com
 */

@Configuration
@ConditionalOnClass(GrpcFactStore.class)
@AutoConfigureAfter(InMemFactStoreAutoConfiguration.class)
public class GrpcFactStoreAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(FactStore.class)
    public FactStore factStore(GrpcChannelFactory af) {
        return new GrpcFactStore(af);
    }
}
