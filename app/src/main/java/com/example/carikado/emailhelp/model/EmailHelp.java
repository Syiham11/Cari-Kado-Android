package com.example.carikado.emailhelp.model;

import java.io.Serializable;

/**
 * Merupakan model untuk mengirim bantuan user menggunakan email
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public class EmailHelp implements Serializable {

    private String mEmailSubject;
    private String mEmailContent;

    public EmailHelp() {

    }

    public EmailHelp(String emailSubject, String emailContent) {
        mEmailSubject = emailSubject;
        mEmailContent = emailContent;
    }

    public String getEmailSubject() {
        return mEmailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        mEmailSubject = emailSubject;
    }

    public String getEmailContent() {
        return mEmailContent;
    }

    public void setEmailContent(String emailContent) {
        mEmailContent = emailContent;
    }
}
