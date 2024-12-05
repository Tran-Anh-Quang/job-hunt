package com.job_portal.utilities;

public class MailBodyContentUtilities {
    public static String getMailBodyContent(String otp, String name) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>OTP Verification</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 50px auto;\n" +
                "            background-color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        .header {\n" +
                "            text-align: center;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            color: #4caf50;\n" +
                "            font-size: 24px;\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        .otp-box {\n" +
                "            text-align: center;\n" +
                "            font-size: 24px;\n" +
                "            font-weight: bold;\n" +
                "            color: #333333;\n" +
                "            padding: 10px;\n" +
                "            background-color: #f9f9f9;\n" +
                "            border: 1px dashed #cccccc;\n" +
                "            margin: 20px 0;\n" +
                "            border-radius: 5px;\n" +
                "            display: inline-block;\n" +
                "        }\n" +
                "        .message {\n" +
                "            font-size: 16px;\n" +
                "            line-height: 1.5;\n" +
                "            color: #555555;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            font-size: 12px;\n" +
                "            color: #999999;\n" +
                "        }\n" +
                "        .footer a {\n" +
                "            color: #4caf50;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <div class=\"header\">\n" +
                "            <h1>OTP Verification</h1>\n" +
                "        </div>\n" +
                "        <div class=\"message\">\n" +
                "            <p>Hi <strong>" + name + "</strong>,</p>\n" +
                "            <p>We received a request to verify your email address. Please use the OTP below to complete the verification process:</p>\n" +
                "        </div>\n" +
                "        <div class=\"otp-box\">\n" +
                            otp + "\n" +
                "        </div>\n" +
                "        <div class=\"message\">\n" +
                "            <p>This OTP is valid for the next <strong>10 minutes</strong>. If you did not request this, please ignore this email.</p>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Thank you,<br>The Job Hunt Team</p>\n" +
                "            <p>If you have any questions, please contact us at <a href=\"mailto:support@jobhunt.com\">support@jobhunt.com</a>.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
