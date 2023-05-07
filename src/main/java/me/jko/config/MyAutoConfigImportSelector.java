package me.jko.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "me.jko.config.autoconfig.DispatcherServletConfig",
                "me.jko.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
