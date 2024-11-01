/*
 * Copyright 2024-2024 the original author or authors.
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
package org.springframework.grpc.client;

import java.util.List;

import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.NettyChannelBuilder;

public class NettyGrpcChannelFactory extends DefaultGrpcChannelFactory {

	public NettyGrpcChannelFactory(List<GrpcChannelConfigurer> configurers) {
		super(configurers);
	}

	protected ManagedChannelBuilder<?> newChannel(String path) {
		if (path.startsWith("unix:")) {
			return super.newChannel(path);
		}
		return NettyChannelBuilder.forTarget(path);
	}

}
