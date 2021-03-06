/*
 * Copyright (C) 2013 Google, Inc.
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test;

import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import javax.inject.Inject;
import javax.inject.Scope;
import javax.inject.Singleton;

import static java.lang.annotation.RetentionPolicy.RUNTIME;;

class TestApp {

  @Singleton
  @CustomScope
  static class InjectableClass {
    @Inject
    String string;
  }

  @Module(injects = InjectableClass.class)
  static class TestModule {
    @Singleton
    @CustomScope
    @Provides
    String string() {
      return "string";
    }
  }

  @Scope
  @Retention(value = RUNTIME)
  public @interface CustomScope {
  }
}
