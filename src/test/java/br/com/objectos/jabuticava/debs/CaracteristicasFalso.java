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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import com.google.common.base.Throwables;
import com.google.common.io.Files;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CaracteristicasFalso {

  public static final String CARACTERISTICAS_20130424 =
      gunzipAndToString("/caracteristicas_e.asp.gz");

  public static final String CARACTERISTICAS_20131206 =
      gunzipAndToString("/caracteristicas_20131206.asp.gz");

  private CaracteristicasFalso() {
  }

  private static String gunzipAndToString(String resourceName) {
    try {
      File file = gunzip(CaracteristicasFalso.class, resourceName);
      return Files.toString(file, Caracteristica.CHARSET);
    } catch (IOException e) {
      return "";
    }
  }

  private static File gunzip(Class<?> contextClass, String resourceName) {
    try {
      File file = File.createTempFile("way-io-", ".fak");

      URL url = getUrl(contextClass, resourceName);
      InputStream input = Resources.asByteSource(url).openStream();
      GZIPInputStream gzip = new GZIPInputStream(input);
      org.testng.reporters.Files.copyFile(gzip, file);

      return file;
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

  private static URL getUrl(Class<?> contextClass, String fileName) {
    URL url = Resources.getResource(contextClass, fileName);
    return url;
  }

}