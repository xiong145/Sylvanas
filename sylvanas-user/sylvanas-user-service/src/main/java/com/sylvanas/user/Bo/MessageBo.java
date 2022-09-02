package com.sylvanas.user.Bo;

import lombok.Data;

import java.util.Date;

/**
 * @author xiong
 */
@Data
public class MessageBo {

    private Long id;

    private String msg;

    private Date sendTime;
}
