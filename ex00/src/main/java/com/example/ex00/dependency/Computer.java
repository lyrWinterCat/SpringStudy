package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component //해당 객체를 Spring에서 관리하도록 설정
@Data //lombok 객체에 대한 getter/setter 자동생성 > outline에서 확인
public class Computer {}
