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
                "            text-align: center;\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #4caf50;\n" +
                "            padding: 10px 0;\n" +
                "            color: #ffffff;\n" +
                "            font-size: 20px;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "        .otp-box {\n" +
                "            font-size: 32px;\n" +
                "            font-weight: bold;\n" +
                "            color: #4caf50;\n" +
                "            margin: 20px auto;\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #f9f9f9;\n" +
                "            border-radius: 5px;\n" +
                "            border: 1px solid #dddddd;\n" +
                "        }\n" +
                "        .message {\n" +
                "            font-size: 16px;\n" +
                "            color: #555555;\n" +
                "            margin: 20px 0;\n" +
                "            line-height: 1.5;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            margin-top: 20px;\n" +
                "            font-size: 12px;\n" +
                "            color: #999999;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <div class=\"header\">Your OTP Code</div>\n" +
                "        <div class=\"message\">\n" +
                "            <p>Hello <strong>" + name + "</strong>,</p>\n" +
                "            <p>We have received a request to verify your email address. Your OTP code is:</p>\n" +
                "        </div>\n" +
                "        <div class=\"otp-box\">" + otp + "</div>\n" +
                "        <div class=\"message\">\n" +
                "            <p>This OTP code is valid for <strong>10 minutes</strong>. If you did not request this, please ignore this email.</p>\n" +
                "            <p>Thank you for using our service!</p>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            © 2024 <strong>Your Company Name</strong>. All rights reserved.\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
