package real.rft.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import real.rft.domain.RftUser;
import real.rft.repository.RftUserRepository;

@Service
public class RftUserDetailsService implements UserDetailsService {

    private RftUserRepository rftUserRepository;

    public RftUserDetailsService(RftUserRepository rftUserRepository) {
        this.rftUserRepository = rftUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RftUser rftUser = rftUserRepository.findByUsername(username);
        if (rftUser == null) throw new UsernameNotFoundException("User not found");
        return rftUser;
    }

    // helps keep the database transaction in sync with the JPA persistence context
    @Transactional
    public RftUser loadUserById(Long id) {
        RftUser rftUser = rftUserRepository.getById(id);
        if (rftUser == null) throw new UsernameNotFoundException("User not found");
        return rftUser;
    }
}
