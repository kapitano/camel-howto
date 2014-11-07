/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kevinearls;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.spi.UriParam;

/**
 * Represents a HelloWorld endpoint.
 */
public class HowtoEndpoint extends DefaultEndpoint {
    @UriParam
    private String foo;
    @UriParam
    private String stuff;


    public HowtoEndpoint(String uri, HowtoComponent component) {
        super(uri, component);
    }

    public Producer createProducer() throws Exception {
        return new HowtoProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new HowtoConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        System.out.println(">>>> FOO set to " + foo);
        this.foo = foo;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        System.out.println(">>>> STUFF set to " + stuff);
        this.stuff = stuff;
    }
}
