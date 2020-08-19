/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.tasks.compile;

import org.gradle.api.tasks.compile.CompileOptions;
import org.gradle.jvm.toolchain.internal.JavaToolchain;

public class DefaultJavaCompileSpecFactory extends AbstractJavaCompileSpecFactory<DefaultJavaCompileSpec> {
    public DefaultJavaCompileSpecFactory(CompileOptions compileOptions, JavaToolchain toolchain) {
        super(compileOptions, toolchain);
    }

    @Override
    protected DefaultJavaCompileSpec getCommandLineSpec() {
        return new DefaultCommandLineJavaSpec();
    }

    @Override
    protected DefaultJavaCompileSpec getForkingSpec() {
        return new DefaultForkingJavaCompileSpec();
    }

    @Override
    protected DefaultJavaCompileSpec getDefaultSpec() {
        return new DefaultJavaCompileSpec();
    }

    private static class DefaultCommandLineJavaSpec extends DefaultJavaCompileSpec implements CommandLineJavaCompileSpec {
    }

    private static class DefaultForkingJavaCompileSpec extends DefaultJavaCompileSpec implements ForkingJavaCompileSpec {
    }
}
