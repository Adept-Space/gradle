/*
 * Copyright 2017 the original author or authors.
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


package org.gradle.java.compile

import org.gradle.integtests.fixtures.AvailableJavaHomes
import org.gradle.util.TextUtil
import spock.lang.IgnoreIf

@IgnoreIf({ !AvailableJavaHomes.differentJdk.getExecutable("javac").exists() })
class CommandLineJavaCompilerIntegrationTest extends JavaCompilerIntegrationSpec {

    def compilerConfiguration() {
        def jdk = AvailableJavaHomes.jdk9
        def javaHome = TextUtil.escapeString(jdk.javaHome.absolutePath)

        """
compileJava.options.with {
    fork = true
    forkOptions.javaHome = file("$javaHome")
    compilerArgs << '-Xlint:-options' // ignore the missing bootstrap class path
    sourceCompatibility = JavaVersion.${jdk.javaVersion.name()}
    targetCompatibility = JavaVersion.${jdk.javaVersion.name()}
}
"""
    }

    def logStatement() {
        "Compiling with Java command line compiler"
    }
}
