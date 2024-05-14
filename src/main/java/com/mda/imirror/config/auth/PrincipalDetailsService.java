package com.mda.imirror.config.auth;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.exception.NotFoundUserException;
import com.mda.imirror.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberName(username)
                .orElseThrow(NotFoundUserException::new);
        return new PrincipalDetails(member);
    }
}
