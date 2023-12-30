package com.dev.pms.domain.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GroupAim {

    PROJECT("프로젝트"),
    STUDY("스터디"),
    CONTEST("공모전"),
    OTHER("기타");

    private final String title;
}
