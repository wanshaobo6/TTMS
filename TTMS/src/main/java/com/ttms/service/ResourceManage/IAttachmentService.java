package com.ttms.service.ResourceManage;

import com.ttms.Entity.ResoAttachment;

import java.util.List;

public interface IAttachmentService {
    List<ResoAttachment> getAttachmentsByPid(int pid);

    Void addAttachment(int pid, String fileName, String fileUrl, String attachementName , int userId);
}