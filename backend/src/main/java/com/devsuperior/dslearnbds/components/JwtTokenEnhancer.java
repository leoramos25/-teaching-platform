package com.devsuperior.dslearnbds.components;

import com.devsuperior.dslearnbds.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class JwtTokenEnhancer implements TokenEnhancer {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        var user = userRepository.findByEmail(authentication.getName());
        
        Map<String, Object> map = new HashMap<>();
        map.put("userName", user.getName());
        map.put("userId", user.getId());
        
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);
        
        return accessToken;
    }
}
