package chattyer.web.config;

import chattyer.nlp.wit.TokenProvider;
import chattyer.persistence.models.Chatbot;
import chattyer.persistence.repositories.ChatbotRepository;
import chattyer.web.exceptions.WitApplicationNotFoundException;
import chattyer.web.messages.Messages;

public class DefaultTokenProvider implements TokenProvider {

    private final String baseAppId;
    private final String baseToken;
    private ChatbotRepository chatbotRepository;

    public DefaultTokenProvider(ChatbotRepository chatbotRepository, String baseAppId, String baseToken) {
        this.chatbotRepository = chatbotRepository;
        this.baseAppId = baseAppId;
        this.baseToken = baseToken;
    }

    @Override
    public String getToken(String appId) {
        if (appId == null || appId.equals(baseAppId)) {
            return baseToken;
        }
        Chatbot chatbot = chatbotRepository.findByWitApplication_Id(appId)
                                           .orElseThrow(() -> new WitApplicationNotFoundException(Messages.WIT_APPLICATION_WITH_ID_0_NOT_FOUND,
                                                                                                  appId));
        return chatbot.getWitApplication()
                      .getAccessToken();
    }

}
