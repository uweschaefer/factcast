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
package org.factcast.grpc.api.conv;

import java.util.Arrays;

import com.google.common.base.Joiner;

import lombok.Value;
import lombok.experimental.Wither;

@Value(staticConstructor = "of")
@Wither
public class ProtocolVersion {
    int major;

    int minor;

    int patch;

    public boolean isCompatibleTo(ProtocolVersion other) {
        if (major != other.major)
            return false;
        if (minor > other.minor)
            return false;
        // patch level must be irrelevant
        return true;
    }

    @Override
    public String toString() {
        return Joiner.on(".").join(Arrays.asList(major, minor, patch));
    }
}
