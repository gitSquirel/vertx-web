/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.web.templ.thymeleaf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Vertx;
import io.vertx.ext.web.common.template.TemplateEngine;
import io.vertx.ext.web.templ.thymeleaf.impl.ThymeleafTemplateEngineImpl;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * A template engine that uses the Thymeleaf library.
 * The {@link #unwrap()} shall return an object of class {@link org.thymeleaf.TemplateEngine}
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface ThymeleafTemplateEngine extends TemplateEngine {
  TemplateMode DEFAULT_TEMPLATE_MODE = TemplateMode.HTML;

  /**
   * Create a template engine using defaults, read template file use utf-8 charset
   *
   * @return the engine
   */
  static ThymeleafTemplateEngine create(Vertx vertx) {
    return new ThymeleafTemplateEngineImpl(vertx, StandardCharsets.UTF_8);
  }

  static ThymeleafTemplateEngine create(Vertx vertx, String charset) {
    return new ThymeleafTemplateEngineImpl(vertx, Charset.forName(charset));
  }
  /**
   * @deprecated see {@link #unwrap()}
   * Set the mode for the engine
   *
   * @param mode the mode
   * @return a reference to this for fluency
   */
  @Fluent
  @Deprecated
  ThymeleafTemplateEngine setMode(TemplateMode mode);

  /**
   * @deprecated see {@link #unwrap()}
   * Get a reference to the internal Thymeleaf TemplateEngine object so it
   * can be configured.
   *
   * @return a reference to the internal Thymeleaf TemplateEngine instance.
   */
  @GenIgnore
  @Deprecated
  org.thymeleaf.TemplateEngine getThymeleafTemplateEngine();
}
