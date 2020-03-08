package chattyer.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chattyer.nlp.wit.ImmutableWitContext;
import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.DefaultWitClient;
import chattyer.nlp.wit.client.WitClient;
import chattyer.persistence.repositories.ChatbotRepository;
import okhttp3.OkHttpClient;

@Configuration
public class ApplicationConfiguration {

    private static final String WIT_API_VERSION = "20200512";
    private static final String ENV_BASE_APP_ID = "CHATTYER_WIT_BASE_APP_ID";
    private static final String ENV_BASE_APP_TOKEN = "CHATTYER_WIT_BASE_TOKEN";

    @Bean
    public WitContext witContext(ChatbotRepository chatbotRepository) {
        return ImmutableWitContext.builder()
                                  .httpClient(new OkHttpClient().newBuilder()
                                                                .retryOnConnectionFailure(true)
                                                                .build())
                                  .tokenProvider(new DefaultTokenProvider(chatbotRepository,
                                                                          getBaseAppIdFromEnv(),
                                                                          getBaseAppTokenFromEnv()))
                                  .witApiVersion(WIT_API_VERSION)
                                  .build();
    }

    private String getBaseAppIdFromEnv() {
        String envBaseAppId = System.getenv(ENV_BASE_APP_ID);
        if (envBaseAppId == null) {
            throw new IllegalStateException("Environment variable CHATTYER_WIT_BASE_APP_ID is not defined!");
        }
        return envBaseAppId;
    }

    private String getBaseAppTokenFromEnv() {
        String envBaseAppToken = System.getenv(ENV_BASE_APP_TOKEN);
        if (envBaseAppToken == null) {
            throw new IllegalStateException("Environment variable CHATTYER_WIT_BASE_TOKEN is not defined!");
        }
        return envBaseAppToken;
    }

    @Bean
    public WitClient witClient(WitContext witContext) {
        return new DefaultWitClient(witContext);
    }

}
