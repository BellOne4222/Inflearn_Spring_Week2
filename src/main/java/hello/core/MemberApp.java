package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 회원 가입

        Member findMember = memberService.findMember(1L); // 가입 되어있는지 확인
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
        // new member = memberA
        // findMember = memberA
    }
}
