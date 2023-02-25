package com.study.studyjavaspringboot.model;

import lombok.Data;

/**
 * ログインAPI用リクエストモデル（POST）
 */
@Data
public class LoginParamModel {
    /** ユーサ名 */
    private String username;
    /** パスワード */
    private String password;
}
