/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package tags;

import java.io.StringWriter;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import model.User;

/**
 *
 * @author Admin
 */
public class LoginTagHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        User user=(User)this.getJspContext().findAttribute("USER");
        try {
            if(user!=null) out.write("<B>"+user.getFullName()+"</B>");
            JspFragment f = getJspBody();
            if (f != null) {
                StringWriter sw = new StringWriter();
                f.invoke(sw);
                String bodyContent = sw.toString();
                String modifiedBody ="<B>"+bodyContent+"</B>";
                out.write(modifiedBody);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in LoginTagHandler tag", ex);
        }
    }
    
}
