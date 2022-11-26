package com.security.oauth2.springsecurityoauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yml에 매핑된 정보는 OAuth2ClientProperties << 이 클래스에 다 매핑된다.
 * 그 후 OAuth2ClientRegistrationRepositoryConfiguration << 이 클래스에서 첫번쨰 클래스를 불러온다.
 * 그 후DefaultAuthorizationCodeTokenResponseClient 에서 다 보내준다.
 */
@RestController
public class IndexController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/")
    public String index() {
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("keycloack");

        String clientId = clientRegistration.getClientId();
        System.out.println("clientId = " + clientId);

        String redirectUri = clientRegistration.getRedirectUri();
        System.out.println("redirectUri = " + redirectUri);

        return "index";
    }
}
