package com.smbt.pickod.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@NoArgsConstructor
public class MsgWriteMailDTO {
    private Long msgId;
    private Long memberNum;
    private Long msgSender;
    private Long msgRecipient;
    private Long statusId;
    private Long msgRead;
    private String msgBox;
    private String msgContent;
    private LocalDateTime msgTrashedDate;
    private LocalDateTime msgSentTime;

}
