package com.andrew.tag;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrew on 30.04.2017.
 */
public class TodayTag extends TagSupport {

    private static final Logger LOG = Logger.getLogger(TodayTag.class);

    private String mFormat;

    public void setFormat(String pFormat) {
        mFormat = pFormat;
    }


    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            Date today = new Date();
            SimpleDateFormat dateFormatter = new SimpleDateFormat(mFormat);
            out.print(dateFormatter.format(today));

        } catch(IOException e) {
            LOG.error("IOException");
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }


}
