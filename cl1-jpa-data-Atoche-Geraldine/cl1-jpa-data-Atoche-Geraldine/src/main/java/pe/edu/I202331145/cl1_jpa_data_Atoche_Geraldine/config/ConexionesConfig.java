package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Value("${DB_SAKILA_URL}")
    private String dbSakilaUrl;
    @Value("${DB_SAKILA_USER}")
    private String dbSakilaUser;
    @Value("${DB_SAKILA_PASS}")
    private String dbSakilaPass;
    @Value("${DB_SAKILA_DRIVER}")
    private String dbSakilaDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(System.getenv("DB_WORLD_URL"));
        config.setUsername(System.getenv("DB_WORLD_USER"));
        config.setPassword(System.getenv("DB_WORLD_PASS"));
        config.setDriverClassName(System.getenv("DB_WORLD_DRIVER"));

        /**
         * Configurar propiedades del pool de HikariCP
         * - MaximumPoolSize: Máximo # de conexiones del pool.
         * - MinimumIdle: Mínimo # de conexiones inactivas del pool.
         * - IdleTimeout: Tiempo máximo de espera para
         *      eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera
         *      para conectarse a la BD.
         */
        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000); // 4 minutos en milisegundos
        config.setConnectionTimeout(45000); // 45 segundos en milisegundos

        return new HikariDataSource(config);

    }
}