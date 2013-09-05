package org.solrsystem.ingest.vaadin;/*
 * Created with IntelliJ IDEA.
 * User: gus
 * Date: 9/2/13
 * Time: 8:21 PM
 */

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.vaadin.ui.UI;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.solrsystem.ingest.IngestUI;
import org.solrsystem.ingest.shiro.IngestShiroModule;

import java.util.HashMap;
import java.util.Map;


public class VaadinModule extends ServletModule {
  @Override
  protected void configureServlets() {
    install(new IngestShiroModule());
    Map<String, String> params = new HashMap<>();
    params.put("UI", "org.solrsystem.ingest.IngestUI");
    serve("/*").with(IngestServlet.class, params);
  }

  @Provides
  UsernamePasswordToken provideToken() {
    return new UsernamePasswordToken();
  }

  @Provides
  private Class<? extends UI> provideUIClass() {
    return IngestUI.class;
  }

}
