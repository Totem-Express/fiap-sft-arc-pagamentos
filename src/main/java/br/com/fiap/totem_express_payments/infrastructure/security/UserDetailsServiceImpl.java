package br.com.fiap.totem_express_payments.infrastructure.security;

import br.com.fiap.totem_express.application.user.UserGateway;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserGateway gateway;

    public UserDetailsServiceImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return gateway
                .findById(id)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDetails loadUserById(String id) throws UsernameNotFoundException {
        return gateway.findById(id).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
