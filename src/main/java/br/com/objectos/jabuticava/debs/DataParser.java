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

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.objectos.comuns.io.csv.LocalDateCsvConverter;

import com.google.common.base.Strings;
import com.google.common.io.CharSource;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class DataParser {

  private static final Pattern REGEX = Pattern.compile("([0-9]{2}/[0-9]{2}/[0-9]{4})");

  private final String text;

  public DataParser(String text) {
    this.text = text;
  }

  public LocalDate get() {
    LocalDate res = null;

    try {
      CharSource charSource = CharSource.wrap(text);
      String line = charSource.readFirstLine();
      line = Strings.nullToEmpty(line);
      Matcher matcher = REGEX.matcher(line);
      if (matcher.find()) {
        String data = matcher.group(0);
        res = new LocalDateCsvConverter("dd/MM/yyyy").convert(data);
      }
    } catch (IOException e) {
    }

    return res;
  }

}