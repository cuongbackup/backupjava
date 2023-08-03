/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Ly Quynh Tran
 */
public class CurrentDateTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        Date currentDate = new Date();
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        String currentDateFormat = shortDate.format(currentDate);
        try {
            JspWriter out = pageContext.getOut();
            out.println(currentDateFormat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}
