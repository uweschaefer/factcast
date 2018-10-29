/**
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
package org.factcast.spring;

import org.factcast.core.FactCast;
import org.factcast.core.store.FactStore;
import org.factcast.spring.client.cache.CachingFactCastConfiguration;
import org.factcast.spring.client.cache.infinispan.FactCastInfinispanConfiguration;
import org.factcast.spring.store.inmem.InMemFactStoreConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lombok.Generated;

@Configuration
@Generated
@Import({ InMemFactStoreConfiguration.class, CachingFactCastConfiguration.class,
        FactCastInfinispanConfiguration.class })
public class AutoConfiguration {

    @Bean
    public FactCast factCast(FactStore store) {
        return FactCast.from(store);
    }
}
