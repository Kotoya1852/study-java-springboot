package com.study.studyjavaspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.study.studyjavaspringboot.model.ErrorResponseModel;
import com.study.studyjavaspringboot.model.LoginParamModel;
import com.study.studyjavaspringboot.model.ResponseCommonModel;
import com.study.studyjavaspringboot.model.User;

/**
 * ログインAPIコントローラ
 */
@RestController
public class LoginController {
    

    /**
     * ログインAPI（Post）
     * 
     * @param loginParam ログインパラメータ（リクエストボディ）
     * @return ユーザ情報
     */
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("/login")
    public ResponseCommonModel postLogin(@RequestBody LoginParamModel loginParam) {
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();

        // usernameとpasswordが一致しているかチェック
        User user = null;
        switch (username) {
            case "testuser1":
                if (password.equals("password1")) {
                    user = testUserCreate(username);
                }
                break;
            case "testuser2":
                if (password.equals("password2")) {
                    user = testUserCreate(username);
                }
                break;
        }

        // Switch式
        // user = switch (username) {
        //     case "testuser1", "testuser2", "testuser3" -> new User("GUEST", "guest@example.com");
        //     case "testuser4" -> new User("testuser4", "testuser4@example.com");
        //     default -> new User("unknown", "unknown@example.com");
        // };

        if (user == null) {
            // ユーザが入っていない場合エラー
            ErrorResponseModel error = new ErrorResponseModel();
            error.setErrorCode("E00000");
            error.setErrorMessage("Error: ユーザー名とパスワードが一致しません");
            return error;
        }

        return user;
    }

    private User testUserCreate(String username) {
        User user = new User();
        user.setUsername(username);
        user.setMailAddress(username.concat("@example.com"));
        return user;
    }
}
