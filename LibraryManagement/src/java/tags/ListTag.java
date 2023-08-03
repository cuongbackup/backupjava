/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package tags;

import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Admin
 */
public class ListTag extends SimpleTagSupport {

    private int page;
    private int pagesize;
    private String title;
    private String headerRow;
    private ArrayList<?> list;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        PageContext p=(PageContext)this.getJspContext();
        p.getRequest().setAttribute("title",title);
        p.getRequest().setAttribute("page",page);
        p.getRequest().setAttribute("pagesize",pagesize);
        p.getRequest().setAttribute("headerRow",headerRow);
        p.getRequest().setAttribute("list",list);
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            p.getRequest().getRequestDispatcher("listdummyBook.jsp").include(p.getRequest(),p.getResponse());
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new JspException("Error in ListTag tag", ex);
        }
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHeaderRow(String headerRow) {
        this.headerRow = headerRow;
    }

    public void setList(ArrayList<?> list) {
        this.list = list;
    }
    
}
