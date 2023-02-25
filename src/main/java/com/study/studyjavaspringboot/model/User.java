package com.study.studyjavaspringboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザモデル
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends ResponseCommonModel {

    public User() {
        return;
    }

    public User(String username, String mailAddress) {
        this.username = username;
        this.mailAddress = mailAddress;
    }

    /** ユーザ名 */
    private String username;
    /** メールアドレス */
    private String mailAddress;
}
