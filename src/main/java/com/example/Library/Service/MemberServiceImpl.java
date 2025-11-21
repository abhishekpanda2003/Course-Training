package com.example.Library.Service;

import com.example.Library.DTO.MemberReqDTO;
import com.example.Library.Entity.Member;
import com.example.Library.Exception.ResourceAlreadyExists;
import com.example.Library.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;
    private ModelMapper modelMapper;

    @Override
    public String addMember(MemberReqDTO memberReqDTO)
    {
        if (!memberRepository.existsByEmail(memberReqDTO.getEmail()))
        {
            Member transientE = modelMapper.map(memberReqDTO, Member.class);
            Member persistenE = memberRepository.save(transientE);

            return "Member added || Member id :: " + persistenE.getMemberId();
        }
        else throw new ResourceAlreadyExists("Resource Already Exists by the email");
    }

}

