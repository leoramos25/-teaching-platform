package com.devsuperior.dslearnbds.config;

import com.devsuperior.dslearnbds.components.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private static final String AUTHORIZED_GRANT_TYPES = "password";
    
    private static final String[] SCOPES = {"read", "write"};
    
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;
    
    @Value("${jwt.duration}")
    private Integer tokenDuration;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtTokenStore tokenStore;
    
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenEnhancer tokenEnhancer;
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .secret(passwordEncoder.encode(clientSecret))
                .scopes(SCOPES)
                .authorizedGrantTypes(AUTHORIZED_GRANT_TYPES)
                .accessTokenValiditySeconds(tokenDuration);
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        var tokenChain = new TokenEnhancerChain();
        tokenChain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));
        
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .accessTokenConverter(accessTokenConverter)
                .tokenEnhancer(tokenChain);
    }
}
