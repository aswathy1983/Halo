package tests.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class Sample {
	
	public static void main (String args[]) {
	
	String chk="";
	
	String messagenm ="<html xmlns=http://www.w3.org/1999/xhtml\n" + 
			"xmlns:o=urn:schemas-microsoft-com:office:office\n" + 
			"xmlns:v=urn:schemas-microsoft-com:vml><head> <meta charset=UTF-8>\n" + 
			"<meta content=\"IE=edge\" http-equiv=X-UA-Compatible> <meta\n" + 
			"content=\"width=device-width,initial-scale=1\" name=viewport>\n" + 
			"<title>*|MC:SUBJECT|*</title> <style>p{margin: 10px 0; padding:\n" + 
			"0}table{border-collapse: collapse}.icons-row td{padding: 9px 15px;}h1,\n" + 
			"h2, h3, h4, h5, h6{display: block; margin: 0; padding: 0}a img,\n" + 
			"img{border: 0; height: auto; outline: 0; text-decoration:\n" + 
			"none}#bodyCell, #bodyTable, body{height: 100%; margin: 0; padding: 0;\n" + 
			"width: 100%}.mcnPreviewText{display: none !important}#outlook\n" + 
			"a{padding: 0}img{-ms-interpolation-mode:\n" + 
			"bicubic}table{mso-table-lspace: 0; mso-table-rspace:\n" + 
			"0}.ReadMsgBody{width: 100%}.ExternalClass{width: 100%}a, blockquote,\n" + 
			"li, p, td{mso-line-height-rule: exactly}a[href^=sms],\n" + 
			"a[href^=tel]{color: inherit; cursor: default; text-decoration: none}a,\n" + 
			"blockquote, body, li, p, table, td{-ms-text-size-adjust: 100%;\n" + 
			"-webkit-text-size-adjust: 100%}.ExternalClass, .ExternalClass div,\n" + 
			".ExternalClass font, .ExternalClass p, .ExternalClass span,\n" + 
			".ExternalClass td{line-height: 100%}a[x-apple-data-detectors]{color:\n" + 
			"inherit !important; text-decoration: none !important; font-size:\n" + 
			"inherit !important; font-family: inherit !important; font-weight:\n" + 
			"inherit !important; line-height: inherit !important}#bodyCell{padding:\n" + 
			"10px}.templateContainer{max-width: 600px\n" + 
			"!important}a.mcnButton{display: block}.mcnImage,\n" + 
			".mcnRetinaImage{vertical-align: bottom}.mcnTextContent{word-break:\n" + 
			"break-word}.mcnTextContent img{height: auto\n" + 
			"!important}.mcnDividerBlock{table-layout: fixed !important}#bodyTable,\n" + 
			"body{background-color: #fafafa}#bodyCell{border-top:\n" + 
			"0}.templateContainer{border: 0}h1{color: #202020; font-family:\n" + 
			"Helvetica; font-size: 26px; font-style: normal; font-weight: 700;\n" + 
			"line-height: 125%; letter-spacing: normal; text-align: left}h2{color:\n" + 
			"#202020; font-family: Helvetica; font-size: 22px; font-style: normal;\n" + 
			"font-weight: 700; line-height: 125%; letter-spacing: normal;\n" + 
			"text-align: left}h3{color: #202020; font-family: Helvetica; font-size:\n" + 
			"20px; font-style: normal; font-weight: 700; line-height: 125%;\n" + 
			"letter-spacing: normal; text-align: left}h4{color: #202020;\n" + 
			"font-family: Helvetica; font-size: 18px; font-style: normal;\n" + 
			"font-weight: 700; line-height: 125%; letter-spacing: normal;\n" + 
			"text-align: left}#templatePreheader{background-color: #fafafa;\n" + 
			"background-image: none; background-repeat: no-repeat;\n" + 
			"background-position: center; background-size: cover; border-top: 0;\n" + 
			"border-bottom: 0; padding-top: 9px; padding-bottom:\n" + 
			"9px}#templatePreheader .mcnTextContent, #templatePreheader\n" + 
			".mcnTextContent p{color: #656565; font-family: Helvetica; font-size:\n" + 
			"12px; line-height: 150%; text-align: left}#templatePreheader\n" + 
			".mcnTextContent a, #templatePreheader .mcnTextContent p a{color:\n" + 
			"#656565; font-weight: 400; text-decoration:\n" + 
			"underline}#templateHeader{background-color: #fff; background-image:\n" + 
			"none; background-repeat: no-repeat; background-position: center;\n" + 
			"background-size: cover; border-top: 0; border-bottom: 0; padding-top:\n" + 
			"9px; padding-bottom: 0}#templateHeader .mcnTextContent,\n" + 
			"#templateHeader .mcnTextContent p{color: #202020; font-family:\n" + 
			"Helvetica; font-size: 16px; line-height: 150%; text-align:\n" + 
			"left}#templateHeader .mcnTextContent a, #templateHeader\n" + 
			".mcnTextContent p a{color: #007c89; font-weight: 400; text-decoration:\n" + 
			"underline}#templateBody{background-color: #fff; background-image:\n" + 
			"none; background-repeat: no-repeat; background-position: center;\n" + 
			"background-size: cover; border-top: 0; border-bottom: 2px solid\n" + 
			"#eaeaea; padding-top: 0; padding-bottom: 9px}#templateBody\n" + 
			".mcnTextContent, #templateBody .mcnTextContent p{color: #202020;\n" + 
			"font-family: Helvetica; font-size: 16px; line-height: 150%;\n" + 
			"text-align: left}#templateBody .mcnTextContent a, #templateBody\n" + 
			".mcnTextContent p a{color: #007c89; font-weight: 400; text-decoration:\n" + 
			"underline}#templateFooter{background-color: #6d6868; background-image:\n" + 
			"none; background-repeat: no-repeat; background-position: center;\n" + 
			"background-size: cover; border-top: 0; border-bottom: 0; padding-top:\n" + 
			"9px; padding-bottom: 9px}#templateFooter .mcnTextContent,\n" + 
			"#templateFooter .mcnTextContent p{color: #656565; font-family:\n" + 
			"Helvetica; font-size: 12px; line-height: 150%; text-align:\n" + 
			"center}#templateFooter .mcnTextContent a, #templateFooter\n" + 
			".mcnTextContent p a{color: #656565; font-weight: 400; text-decoration:\n" + 
			"underline}@media screen and\n" + 
			"(min-width:768px){.templateContainer{width: 600px !important}}@media\n" + 
			"screen and (max-width:480px){a, blockquote, body, li, p, table,\n" + 
			"td{-webkit-text-size-adjust: none !important}}@media screen and\n" + 
			"(max-width:480px){body{width: 100% !important; min-width: 100%\n" + 
			"!important}}@media screen and (max-width:480px){#bodyCell{padding-top:\n" + 
			"10px !important}}@media screen and\n" + 
			"(max-width:480px){.mcnRetinaImage{max-width: 100% !important}}@media\n" + 
			"screen and (max-width:480px){.mcnImage{width: 100% !important}}@media\n" + 
			"screen and (max-width:480px){.mcnBoxedTextContentContainer,\n" + 
			".mcnCaptionBottomContent, .mcnCaptionLeftImageContentContainer,\n" + 
			".mcnCaptionLeftTextContentContainer,\n" + 
			".mcnCaptionRightImageContentContainer,\n" + 
			".mcnCaptionRightTextContentContainer, .mcnCaptionTopContent,\n" + 
			".mcnCartContainer, .mcnImageCardLeftImageContentContainer,\n" + 
			".mcnImageCardLeftTextContentContainer,\n" + 
			".mcnImageCardRightImageContentContainer,\n" + 
			".mcnImageCardRightTextContentContainer,\n" + 
			".mcnImageGroupContentContainer, .mcnRecContentContainer,\n" + 
			".mcnTextContentContainer{max-width: 100% !important; width: 100%\n" + 
			"!important}}@media screen and\n" + 
			"(max-width:480px){.mcnBoxedTextContentContainer{min-width: 100%\n" + 
			"!important}}@media screen and\n" + 
			"(max-width:480px){.mcnImageGroupContent{padding: 9px\n" + 
			"!important}}@media screen and\n" + 
			"(max-width:480px){.mcnCaptionLeftContentOuter .mcnTextContent,\n" + 
			".mcnCaptionRightContentOuter .mcnTextContent{padding-top: 9px\n" + 
			"!important}}@media screen and (max-width:480px){.mcnCaptionBlockInner\n" + 
			".mcnCaptionTopContent:last-child .mcnTextContent,\n" + 
			".mcnCaptionBottomContent:last-child .mcnCaptionBottomImageContent,\n" + 
			".mcnImageCardTopImageContent{padding-top: 18px !important}}@media\n" + 
			"screen and (max-width:480px){.mcnImageCardBottomImageContent{padding-bottom:\n" + 
			"9px !important}}@media screen and\n" + 
			"(max-width:480px){.mcnImageGroupBlockInner{padding-top: 0 !important;\n" + 
			"padding-bottom: 0 !important}}@media screen and\n" + 
			"(max-width:480px){.mcnImageGroupBlockOuter{padding-top: 9px\n" + 
			"!important; padding-bottom: 9px !important}}@media screen and\n" + 
			"(max-width:480px){.mcnBoxedTextContentColumn,\n" + 
			".mcnTextContent{padding-right: 18px !important; padding-left: 18px\n" + 
			"!important}}@media screen and\n" + 
			"(max-width:480px){.mcnImageCardLeftImageContent,\n" + 
			".mcnImageCardRightImageContent{padding-right: 18px !important;\n" + 
			"padding-bottom: 0 !important; padding-left: 18px !important}}@media\n" + 
			"screen and (max-width:480px){.mcpreview-image-uploader{display: none\n" + 
			"!important; width: 100% !important}}@media screen and\n" + 
			"(max-width:480px){h1{font-size: 22px !important; line-height: 125%\n" + 
			"!important}}@media screen and (max-width:480px){h2{font-size: 20px\n" + 
			"!important; line-height: 125% !important}}@media screen and\n" + 
			"(max-width:480px){h3{font-size: 18px !important; line-height: 125%\n" + 
			"!important}}@media screen and (max-width:480px){h4{font-size: 16px\n" + 
			"!important; line-height: 150% !important}}@media screen and\n" + 
			"(max-width:480px){.mcnBoxedTextContentContainer .mcnTextContent,\n" + 
			".mcnBoxedTextContentContainer .mcnTextContent p{font-size: 14px\n" + 
			"!important; line-height: 150% !important}}@media screen and\n" + 
			"(max-width:480px){#templatePreheader{display: block !important}}@media\n" + 
			"screen and (max-width:480px){#templatePreheader .mcnTextContent,\n" + 
			"#templatePreheader .mcnTextContent p{font-size: 14px !important;\n" + 
			"line-height: 150% !important}}@media screen and\n" + 
			"(max-width:480px){#templateHeader .mcnTextContent, #templateHeader\n" + 
			".mcnTextContent p{font-size: 16px !important; line-height: 150%\n" + 
			"!important}}@media screen and (max-width:480px){#templateBody\n" + 
			".mcnTextContent, #templateBody .mcnTextContent p{font-size: 16px\n" + 
			"!important; line-height: 150% !important}}@media screen and\n" + 
			"(max-width:480px){#templateFooter .mcnTextContent, #templateFooter\n" + 
			".mcnTextContent p{font-size: 14px !important; line-height: 150%\n" + 
			"!important}}</style></head><body> <span class=\"mcnPreviewText\"\n" + 
			"style=\"color: transparent; display: none; height: 0; max-height: 0;\n" + 
			"max-width: 0; opacity: 0; overflow: hidden; mso-hide: all; visibility:\n" + 
			"hidden; width: 0;\">Your verification code is 059789.<br/>This code\n" + 
			"expires in 24 hours. If it expires, please request a new verification\n" + 
			"code.<br/><br/>This is an automated message.  We will not contact you\n" + 
			"directly to request any personal information.</span> <center> <table\n" + 
			"border=0 cellpadding=0 cellspacing=0 width=100% align=center\n" + 
			"height=100% id=bodyTable> <tr> <td valign=top align=center\n" + 
			"id=bodyCell> <table border=0 cellpadding=0 cellspacing=0 width=100%\n" + 
			"class=templateContainer> <tr> <td valign=top id=templatePreheader>\n" + 
			"<table border=0 cellpadding=0 cellspacing=0 width=100%\n" + 
			"class=mcnImageBlock style=min-width:100%> <tbody\n" + 
			"class=mcnImageBlockOuter> <tr> <td valign=top style=padding:9px\n" + 
			"class=mcnImageBlockInner> <table border=0 cellpadding=0 cellspacing=0\n" + 
			"width=100% class=mcnImageContentContainer style=min-width:100%\n" + 
			"align=left> <tr> <td valign=top\n" + 
			"style=padding-right:9px;padding-left:9px;padding-top:0;padding-bottom:0;text-align:center\n" + 
			"class=mcnImageContent> <a\n" + 
			"href=\"https://goconcourse.com/#/home?brand=kwikset\" target=_blank><img\n" + 
			"src=https://gallery.mailchimp.com/c6910d296240365e10f7e18b3/images/335fc388-c24e-4438-a57c-4bac8ce3b1f6.png\n" + 
			"style=max-width:200px;padding-bottom:0;display:inline!important;vertical-align:bottom\n" + 
			"width=200 align=center alt=\"\" class=mcnImage></a> </table> </table>\n" + 
			"<table border=0 cellpadding=0 cellspacing=0 width=100%\n" + 
			"class=mcnTextBlock style=min-width:100%> <tbody\n" + 
			"class=mcnTextBlockOuter> <tr> <td valign=top style=padding-top:9px\n" + 
			"class=mcnTextBlockInner> <table border=0 cellpadding=0 cellspacing=0\n" + 
			"width=100% class=mcnTextContentContainer\n" + 
			"style=max-width:100%;min-width:100% align=left> <tr> <td valign=top\n" + 
			"style=padding-top:0;padding-right:18px;padding-bottom:9px;padding-left:18px\n" + 
			"class=mcnTextContent> <div style=text-align:center><span\n" + 
			"style=color:#000><span style=font-size:16px><a\n" + 
			"href=\"https://goconcourse.com/#/home?brand=kwikset\"\n" + 
			"target=_blank>Visit Site</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a\n" + 
			"href=\"https://www.kwikset.com/App.aspx#products\"\n" + 
			"target=_blank>Support</a></span></span> </div></table> </table> <tr>\n" + 
			"<td valign=top id=templateBody> <table border=0 cellpadding=0\n" + 
			"cellspacing=0 width=100% class=mcnTextBlock style=min-width:100%>\n" + 
			"<tbody class=mcnTextBlockOuter> <tr> <td valign=top\n" + 
			"style=padding-top:9px class=mcnTextBlockInner> <table border=0\n" + 
			"cellpadding=0 cellspacing=0 width=100% class=mcnTextContentContainer\n" + 
			"style=max-width:100%;min-width:100% align=left> <tr> <td valign=top\n" + 
			"style=padding-top:0;padding-right:18px;padding-bottom:9px;padding-left:18px\n" + 
			"class=mcnTextContent> <p>Your verification code is 059789.<br/>This\n" + 
			"code expires in 24 hours. If it expires, please request a new\n" + 
			"verification code.<br/><br/>This is an automated message.  We will not\n" + 
			"contact you directly to request any personal information.</p></table>\n" + 
			"</table> <tr> <td valign=top id=templateFooter> <table border=0\n" + 
			"cellpadding=0 cellspacing=0 width=100% class=mcnFollowBlock\n" + 
			"style=min-width:100%> <tbody class=mcnFollowBlockOuter> <tr> <td\n" + 
			"valign=top style=padding:9px class=mcnFollowBlockInner align=center>\n" + 
			"<table border=0 cellpadding=0 cellspacing=0 width=100%\n" + 
			"class=mcnFollowContentContainer style=min-width:100%> <tr> <td\n" + 
			"style=padding-left:9px;padding-right:9px align=center> <table border=0\n" + 
			"cellpadding=0 cellspacing=0 width=100% class=mcnFollowContent\n" + 
			"style=min-width:100%> <tr> <td valign=top\n" + 
			"style=padding-top:9px;padding-right:9px;padding-left:9px align=center>\n" + 
			"<table border=0 cellpadding=0 cellspacing=0 align=center> <tr\n" + 
			"class=icons-row> <td valign=top align=center> <a\n" + 
			"href=https://twitter.com/kwiksetcorp target=_blank><img\n" + 
			"src=https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-twitter-48.png\n" + 
			"style=display:block width=24 height=24></a> </td><td valign=top\n" + 
			"align=center> <a href=https://www.facebook.com/kwiksetlocks\n" + 
			"target=_blank><img\n" + 
			"src=https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-facebook-48.png\n" + 
			"style=display:block width=24 height=24></a> </td><td valign=top\n" + 
			"align=center> <a href=https://www.youtube.com/user/kwiksetsmartkey\n" + 
			"target=_blank><img\n" + 
			"src=https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-youtube-48.png\n" + 
			"style=display:block width=24 height=24></a> </td><td valign=top\n" + 
			"align=center> <a href=https://www.pinterest.com/kwikset/\n" + 
			"target=_blank><img\n" + 
			"src=https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-pinterest-48.png\n" + 
			"style=display:block width=24 height=24></a> </td><td valign=top\n" + 
			"align=center> <a href=https://www.instagram.com/kwikset/\n" + 
			"target=_blank><img\n" + 
			"src=https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-instagram-48.png\n" + 
			"style=display:block width=24 height=24></a> </td></table> </table>\n" + 
			"</table> </table> <table border=0 cellpadding=0 cellspacing=0\n" + 
			"width=100% class=mcnDividerBlock style=min-width:100%> <tbody\n" + 
			"class=mcnDividerBlockOuter> <tr> <td\n" + 
			"style=\"min-width:100%;padding:10px 18px 25px\"\n" + 
			"class=mcnDividerBlockInner> <table border=0 cellpadding=0\n" + 
			"cellspacing=0 width=100% class=mcnDividerContent\n" + 
			"style=\"min-width:100%;border-top:2px solid #eee\"> <tr>\n" + 
			"<td><span></span> </table> </table> <table border=0 cellpadding=0\n" + 
			"cellspacing=0 width=100% class=mcnTextBlock style=min-width:100%>\n" + 
			"<tbody class=mcnTextBlockOuter> <tr> <td valign=top\n" + 
			"style=padding-top:9px class=mcnTextBlockInner> <table border=0\n" + 
			"cellpadding=0 cellspacing=0 width=100% class=mcnTextContentContainer\n" + 
			"style=max-width:100%;min-width:100% align=left> <tr> <td valign=top\n" + 
			"style=padding-top:0;padding-right:18px;padding-bottom:9px;padding-left:18px\n" + 
			"class=mcnTextContent><span\n" + 
			"style=color:#fff><em>Copyright&nbsp;&copy;&nbsp;2019 Spectrum Brands,\n" + 
			"HHI,</em><em>&nbsp;All rights reserved.</em><br>You are receiving this\n" + 
			"email because you have a GoConcourse account.<br><br><strong>Our\n" + 
			"mailing address is:</strong><br>Spectrum Brands, HHI<br>19701 Da\n" + 
			"Vinci<br>Foothill Ranch, CA 92610</span> </table> </table> </table>\n" + 
			"</table> </center></body></html>";
	   
    //String s1 = messagenm.substring(messagenm.indexOf(">Your verification code is")+1);
    String s1 = messagenm.substring(messagenm.indexOf("Your verification code is")+1);
 
    s1.trim();
   System.out.println("prnt s1 as...  "+s1);
    Pattern p = Pattern.compile("our verification code is\\s+([0-9]{6})");
    Matcher n = p.matcher(s1);
   
    if (n.find()) {
    chk = n.group(1);
            System.out.println("---------------chk=       "+chk);
        }
}
}