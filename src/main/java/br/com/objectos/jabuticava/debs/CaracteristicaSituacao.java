/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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

import br.com.objectos.comuns.io.csv.AbstractCsvConverter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum CaracteristicaSituacao {

  REGISTRADO,

  EXCLUIDO;

  static final Converter CONVERTER = new Converter();

  static class Converter extends AbstractCsvConverter<CaracteristicaSituacao> {
    @Override
    protected CaracteristicaSituacao convert(String text) {
      CaracteristicaSituacao res = REGISTRADO;

      if ("Excluído".equals(text)) {
        res = EXCLUIDO;
      }

      return res;
    }
  }

}