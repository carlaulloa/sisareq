package pe.edu.unmsm.sistemas.sisareq.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pe.edu.unmsm.sistemas.sisareq.configuration.security.SecurityConfiguration;

@Configuration
@Import(value = {ServConfig.class,SecurityConfiguration.class})
public class ProyectoConfig {

}