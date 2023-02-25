package com.study.studyjavaspringboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * エラーレスポンスモデル
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorResponseModel extends ResponseCommonModel {
    /** エラーコード */
    private String errorCode;
    /** エラーメッセージ */
    private String errorMessage;
}
