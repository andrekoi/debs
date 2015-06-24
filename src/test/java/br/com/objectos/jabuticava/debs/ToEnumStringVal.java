/*
 * Copyright 2015 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.jabuticava.debs;

import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.RecordKey;

import com.google.common.base.Function;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ToEnumStringVal implements Function<Record, String> {

  private final RecordKey<? extends Enum<?>> key;

  public ToEnumStringVal(RecordKey<? extends Enum<?>> key) {
    this.key = key;
  }

  @Override
  public String apply(Record input) {
    Enum<?> enumVal = input.get(key);
    return enumVal != null ? enumVal.name() : null;
  }

}